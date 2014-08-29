package br.edu.ifsul.scientia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarPergunta extends Activity implements OnClickListener{
EditText enunciado;
EditText resposta;
EditText incorreta2;
EditText incorreta3;
EditText incorreta4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela_cadastro_pergunta);
		enunciado = (EditText) findViewById(R.id.edtEnunciado);
		resposta = (EditText) findViewById(R.id.edtRcorreta);
		incorreta2 =(EditText) findViewById(R.id.edtRincoreta2);
		incorreta3 = (EditText) findViewById(R.id.edtRincorreta3);
		incorreta4 = (EditText) findViewById(R.id.edtRincorreta4);
		Button btgeraPergunta= (Button) findViewById(R.id.btCadastrar);
		
		btgeraPergunta.setOnClickListener(this); 
	}
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Pergunta pergunta = new Pergunta();
				int pegaIdCategoria = 1;
				pergunta.setIdCategoria(pegaIdCategoria);
				pergunta.setEnunciado(enunciado.getText().toString());
				pergunta.setResposta(resposta.getText().toString());
				pergunta.setAlternativa2(incorreta2.getText().toString());
				pergunta.setAlternativa3(incorreta3.getText().toString());
				pergunta.setAlternativa4(incorreta4.getText().toString());
				
				
				DbHelper dbHelper = new DbHelper(this);
				dbHelper.insertPergunta(pergunta);
				Toast.makeText(this, "pergunta cadastrada com sucesso!", Toast.LENGTH_LONG).show();
				
				
				finish();
			}
		;
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
