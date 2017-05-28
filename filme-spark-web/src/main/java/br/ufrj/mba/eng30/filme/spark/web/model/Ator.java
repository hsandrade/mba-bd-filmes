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
	
	

}
