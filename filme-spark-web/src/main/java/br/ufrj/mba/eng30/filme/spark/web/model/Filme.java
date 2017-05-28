package br.ufrj.mba.eng30.filme.spark.web.model;

import com.google.gson.annotations.SerializedName;

/**
 * Classe principal do Filme.
 * 
 * @author Henrique
 *
 */
public class Filme {

	@SerializedName("movie_title")
	private String titulo;
	@SerializedName("title_year")
	private int ano;
	@SerializedName("genres")
	private String generos;
	@SerializedName("gross")
	private long arrecadacaoLocal;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public long getArrecadacaoLocal() {
		return arrecadacaoLocal;
	}

	public void setArrecadacaoLocal(long arrecadacaoLocal) {
		this.arrecadacaoLocal = arrecadacaoLocal;
	}

}