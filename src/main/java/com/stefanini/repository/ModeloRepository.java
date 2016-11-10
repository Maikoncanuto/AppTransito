package com.stefanini.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.model.Modelo;

public class ModeloRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Modelo tipo) {
		this.manager.persist(tipo);
	}

	public void altera(Modelo tipo) {
		this.manager.merge(tipo);
	}

	public Modelo busca(Integer id) {
		return this.manager.find(Modelo.class, id);
	}

	public List<Modelo> lista() {
		return this.manager.createQuery("select t from Modelo t", Modelo.class).getResultList();
	}
	
	public void remover(Modelo modelo){
		this.manager.remove(modelo);
	}
	
	public void remover(Integer id){
		this.manager.remove(this.busca(id));
	}
}
