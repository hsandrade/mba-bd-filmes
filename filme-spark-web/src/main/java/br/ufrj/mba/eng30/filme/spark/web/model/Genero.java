package br.ufrj.mba.eng30.filme.spark.web.model;

import com.google.gson.annotations.SerializedName;

public class Genero {

	@SerializedName("genre")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
