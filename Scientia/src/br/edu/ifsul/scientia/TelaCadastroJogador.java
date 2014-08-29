package br.edu.ifsul.scientia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroJogador extends Activity implements OnClickListener {

	EditText nome;
	EditText email;
	EditText senha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(br.edu.ifsul.scientia.R.layout.tela_cadastro_jogador);;
		nome=(EditText) findViewById(R.id.editTextNome);
		email=(EditText) findViewById(R.id.editTextEmail);
		senha=(EditText) findViewById(R.id.editTextSenha);
		Button btcadastro = (Button)findViewById(R.id.btCadastrar);
		btcadastro.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Jogador jogador= new Jogador();
		int scoreInicial=0;
		jogador.setNome(nome.getText().toString());
		jogador.setEmail(email.getText().toString());
		jogador.setSenha(senha.getText().toString());
		jogador.setScore(scoreInicial);
		
		DbHelper dbHelper = new DbHelper(this);
		dbHelper.insertJogador(jogador);
		Toast.makeText(this, "cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show();
		
		
		finish();
	}
	
	
	
	
}
