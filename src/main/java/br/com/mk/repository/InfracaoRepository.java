package br.com.mk.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.mk.model.Infracao;

public class InfracaoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Infracao infra) {
		this.manager.persist(infra);
	}

	public void altera(Infracao infra) {
		this.manager.merge(infra);
	}

	public Infracao busca(Integer id) {
		return this.manager.find(Infracao.class, id);
	}

	public List<Infracao> lista() {
		return this.manager.createQuery("select l from Infracao l", Infracao.class).getResultList();
	}
	
	public void remover(Infracao infracoes){
		this.manager.remove(infracoes);
	}
	
	public void remover(Integer id){
		this.manager.remove(this.busca(id));
	}

}
