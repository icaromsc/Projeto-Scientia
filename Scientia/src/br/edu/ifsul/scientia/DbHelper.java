package br.edu.ifsul.scientia;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

	private static final String NOME_BASE = "projetoTcc";
	private static final int VERSAO_BASE = 6;

	public DbHelper(Context context) {
		super(context, NOME_BASE, null, VERSAO_BASE);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// criação das tabelas no sqlite
		String createTabelaPergunta = "CREATE TABLE pergunta("
				+ "idPergunta INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "idCategoria INTEGER ," + "enunciado varchar(120) ,"
				+ "resposta varchar(30) ," + "alternativa2 varchar(30) ,"
				+ "alternativa3 varchar(30) ," + "alternativa4 varchar(30) "
				+ ")";

		// String CreateTabelaCategoria="CREATE TABLE categoria("
		// +"idCategoria INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
		// +"nome varchar(50) NOT NULL"
		// +")";
		//
		String CreateTabelaJogador = "CREATE TABLE jogador("
				+ "idUser INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "idAmigo INTEGER," + "nome varchar(100) ,"
				+ "email varchar(50) ," + "senha varchar(30) ,"
				+ "score INTEGER " + ")";
		// String CreateTabelaAmigos="CREATE TABLE amigos("
		// +"idUser INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
		// +"nome varchar(50) NOT NULL,"
		// +"score INTEGER NOT NULL"
		// +")";

		String insereAdministrador = "INSERT INTO jogador ("
				+ "nome, email,senha) VALUES "
				+ "('administrador', 'admin@admin', 'admin123');";
		db.execSQL(createTabelaPergunta);
		// db.execSQL(CreateTabelaCategoria);
		db.execSQL(CreateTabelaJogador);
		// db.execSQL(CreateTabelaAmigos);
		db.execSQL(insereAdministrador);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String DropTabelaPergunta = "DROP TABLE pergunta";
		// String DropTabelaCategoria = "DROP TABLE categoria";
		String DropTabelaJogador = "DROP TABLE jogador";
		// String DropTabelaAmigos = "DROP TABLE amigos";
		db.execSQL(DropTabelaPergunta);
		// db.execSQL(DropTabelaCategoria);
		// db.execSQL(DropTabelaJogador);
		// db.execSQL(DropTabelaAmigos);
		//
		onCreate(db);
	}

	public void insertPergunta(Pergunta pergunta) {

		SQLiteDatabase db = getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("idCategoria", pergunta.getIdPergunta());
		cv.put("enunciado", pergunta.getEnunciado());
		cv.put("resposta", pergunta.getResposta());
		cv.put("alternativa2", pergunta.getAlternativa2());
		cv.put("alternativa3", pergunta.getAlternativa3());
		cv.put("alternativa4", pergunta.getAlternativa4());

		db.insert("pergunta", null, cv);

		db.close();
	}
	public void insertJogador(Jogador jogador){
		
		SQLiteDatabase db = getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("nome", jogador.getNome());
		cv.put("email",jogador.getEmail());
		cv.put("senha", jogador.getSenha());
		cv.put("score", jogador.getScore());
		db.insert("jogador", null, cv);
	}

	public List<Pergunta> selectAllPergunta() {
		SQLiteDatabase db = getReadableDatabase();
		List<Pergunta> listPerguntas = new ArrayList<Pergunta>();

		String sqlSelectTodasPerguntas = "SELECT enunciado FROM pergunta";

		Cursor row = db.rawQuery(sqlSelectTodasPerguntas, null);

		if (row.moveToFirst()) {
			do {
				Pergunta pergunta = new Pergunta();
				pergunta.setIdPergunta(row.getInt(0));
				pergunta.setEnunciado(row.getString(1));

				listPerguntas.add(pergunta);

			} while (row.moveToNext());
		}

		db.close();

		return listPerguntas;
	}

	public boolean sqlTestaLogin(String email, String senha) {
		SQLiteDatabase db = getReadableDatabase();
		boolean ok = false;
		String query = "SELECT senha from jogador WHERE email='" + email + "'";
		Cursor c = db.rawQuery(query, null);
		int colSenha = c.getColumnIndex("senha");
		if (c.moveToFirst()) {
			String temp = c.getString(colSenha);
			ok = senha.equals(temp) ? true : false;
		}
		
		db.close();
		c.close();
		return ok;
	}
	public boolean validarLogin(String email, String senha){
		SQLiteDatabase db = getReadableDatabase();
		String query = "SELECT idUSer,nome FROM jogador WHERE email="+"'"+email+"'"+"AND senha="+"'"+senha+"'";
		Cursor c = db.rawQuery(query, null); 
		if (c.moveToFirst()) {
			return true;
		}else{
			return false;
		}
		
	}

}
