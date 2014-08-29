package br.edu.ifsul.scientia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLogin extends Activity implements OnClickListener{
	EditText email;
	EditText senha;
	Button logar;
	Button cadastrar;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tela_login);
	email = (EditText) findViewById(R.id.edtEmail);
	senha = (EditText) findViewById(R.id.edtSenha);
	logar = (Button) findViewById(R.id.btLoga);
	logar.setOnClickListener(this);
	cadastrar = (Button)findViewById(R.id.btVaiTelaCadastro);
	cadastrar.setOnClickListener(this);
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	//switch(v.getId()) {
	int pegaidEvento=v.getId();//testa qual botão foi clicado
    //case R.id.btLoga://se foi botao de login
      if (pegaidEvento==R.id.btVaiTelaCadastro){
    	Intent trocarTela= new Intent(TelaLogin.this,TelaPrincipal.class);
    	String pegaNome=null;
    	DbHelper banco = new DbHelper(this);
    	boolean verificaLogin = banco.validarLogin(email.getText().toString(),senha.getText().toString());
    	
    	if(verificaLogin==true){
    		trocarTela.putExtra("nome", pegaNome);
    		 startActivity(trocarTela);
    	}else{
    		Toast.makeText(this,"usuario ou senha inválido!",Toast.LENGTH_SHORT).show();
    	}
      //break;
      }
      if(pegaidEvento==R.id.btLoga){
    //case R.id.btCadastrar:
       //it was the second button
    	Intent trocarTela2= new Intent(TelaLogin.this,TelaCadastroJogador.class);
    	startActivity(trocarTela2);
      //break;
  //}
      }
}

}
