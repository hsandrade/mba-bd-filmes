package br.ufrj.mba.eng30.filme.spark.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.SerializedName;

/**
 * Classe principal do Filme.
 * 
 * @author Henrique
 *
 */
@Entity
@Table(name="topFilme")
public class Filme {

	@Id
	@Column(name="movie_title")
	@SerializedName("movie_title")
	private String titulo;
	
	@Column(name="title_year")
	@SerializedName("title_year")
	private Integer ano;
	
	@Column(name="genres")
	@SerializedName("genres")
	private String generos;
	
	@Column(name="gross")
	@SerializedName("gross")
	private Long arrecadacaoLocal;
	
	@Column(name="num_voted_users")
	@SerializedName("num_voted_users")
	private Long qtdVotos;
	
	@Column(name="imdb_score")
	@SerializedName("imdb_score")
	private Float mediaVotos;	
	
	@Column(name="movie_imdb_link")
	@SerializedName("movie_imdb_link")
	private String urlImdb;	

	public Filme(){}
	
	public Filme(String titulo, Integer ano, Long arrecadacaoLocal, String urlImdb) {
		this.titulo = titulo;
		this.ano = ano;
		this.arrecadacaoLocal = arrecadacaoLocal;
		this.urlImdb = urlImdb;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return (ano == null) ? 0 : ano;
	}

	public void setAno(Integer ano) {
		this.ano = (ano == null) ? 0 : ano;
	}

	public String getGeneros() {
		if (generos != null) {
			return generos.replaceAll("\\|", ", ");
		}
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public long getArrecadacaoLocal() {
		return (arrecadacaoLocal == null) ? 0 : arrecadacaoLocal;
	}

	public void setArrecadacaoLocal(Long arrecadacaoLocal) {
		this.arrecadacaoLocal = (arrecadacaoLocal == null) ? 0 : arrecadacaoLocal;
	}

	public long getQtdVotos() {
		return (qtdVotos == null) ? 0 : qtdVotos;
	}

	public void setQtdVotos(Long qtdVotos) {
		this.qtdVotos = (qtdVotos == null) ? 0 : qtdVotos;
	}

	public float getMediaVotos() {
		return (mediaVotos == null) ? 0 : mediaVotos;
	}

	public void setMediaVotos(Float mediaVotos) {
		this.mediaVotos = (mediaVotos == null) ? 0 : mediaVotos;
	}

	public String getUrlImdb() {
		return urlImdb;
	}

	public void setUrlImdb(String urlImdb) {
		this.urlImdb = urlImdb;
	}

}
