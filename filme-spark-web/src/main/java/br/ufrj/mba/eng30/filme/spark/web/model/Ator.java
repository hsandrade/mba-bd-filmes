package br.ufrj.mba.eng30.filme.spark.web.model;

import com.google.gson.annotations.SerializedName;

/**
 * Classe principal do Filme.
 *  
 * @author Luiz Eduardo
 *
 */
public class Ator {
	@SerializedName("actor_name")
	private String nome;
	@SerializedName("gross")
	private long arrecadacaoLocal;
	@SerializedName("qtd_movies")
	private int qtdFilmes;	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getArrecadacaoLocal() {
		return arrecadacaoLocal;
	}

	public void setArrecadacaoLocal(long arrecadacaoLocal) {
		this.arrecadacaoLocal = arrecadacaoLocal;
	}

	public int getQtdFilmes() {
		return qtdFilmes;
	}

	public void setQtdFilmes(int qtdFilmes) {
		this.qtdFilmes = qtdFilmes;
	}

}
