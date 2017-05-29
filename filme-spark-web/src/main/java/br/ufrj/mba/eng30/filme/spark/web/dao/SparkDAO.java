package br.ufrj.mba.eng30.filme.spark.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufrj.mba.eng30.filme.spark.web.model.Filme;

@Repository
public class SparkDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Filme> getFilmesRentaveis() {
		String hql = "SELECT new br.ufrj.mba.eng30.filme.spark.web.model.Filme(titulo, ano, arrecadacaoLocal, urlImdb) "
				+ "FROM Filme ORDER BY RAND()";
		return (List<Filme>)entityManager.createQuery(hql).getResultList();
	}
	
}
