package br.edu.ifsul.scientia;

public class Pergunta {
private int idPergunta;
private int idCategoria;
private String enunciado;
private String resposta;
private String alternativa2;
private String alternativa3;
private String alternativa4;
//declaração dos atributos
public Pergunta(){
	//criação do construtor vazio
}

public Pergunta(int idPergunta, int idCategoria, String enunciado,String resposta,String alternativa1,String alternativa2,String alternativa3,String alternativa4){
this.idPergunta= idPergunta;
this.idCategoria= idCategoria;
this.enunciado= enunciado;
this.resposta= resposta;
this.alternativa2= alternativa2;
this.alternativa3= alternativa3;
this.alternativa4= alternativa4;
//criação do construtor passando por parametro os atributos
}

//criação dos getters and setters

public int getIdPergunta() {
	return idPergunta;
}
public void setIdPergunta(int idPergunta) {
	this.idPergunta = idPergunta;
}
public int getIdCategoria() {
	return idCategoria;
}
public void setIdCategoria(int idCategoria) {
	this.idCategoria = idCategoria;
}
public String getEnunciado() {
	return enunciado;
}
public void setEnunciado(String enunciado) {
	this.enunciado = enunciado;
}
public String getResposta() {
	return resposta;
}
public void setResposta(String resposta) {
	this.resposta = resposta;
}
public String getAlternativa2() {
	return alternativa2;
}
public void setAlternativa2(String alternativa2) {
	this.alternativa2 = alternativa2;
}
public String getAlternativa3() {
	return alternativa3;
}
public void setAlternativa3(String alternativa3) {
	this.alternativa3 = alternativa3;
}
public String getAlternativa4() {
	return alternativa4;
}
public void setAlternativa4(String alternativa4) {
	this.alternativa4 = alternativa4;
}



}
