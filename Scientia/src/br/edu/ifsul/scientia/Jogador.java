package br.edu.ifsul.scientia;

import java.util.List;

public class Jogador {
	private int idUser;
	private String nome;
	private String email;
	private String senha;
	private int score;
	private List<Jogador>amigos;
	
	public  static int  verPontuacao(int score){
		return score;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Jogador> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Jogador> amigos) {
		this.amigos = amigos;
	}
	
	
}
