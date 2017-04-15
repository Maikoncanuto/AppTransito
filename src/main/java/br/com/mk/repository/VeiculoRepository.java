package br.com.mk.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.mk.model.Veiculo;

public class VeiculoRepository {

	@Inject
	private EntityManager manager;

	public void incluir(Veiculo tipo) {
		this.manager.persist(tipo);
	}

	public void altera(Veiculo tipo) {
		this.manager.merge(tipo);
	}

	public Veiculo busca(Integer id) {
		return this.manager.find(Veiculo.class, id);
	}

	public List<Veiculo> lista() {
		return this.manager.createQuery("select t from Veiculo t", Veiculo.class).getResultList();
	}
	
	public void remover(Veiculo veiculos){
		manager.remove(veiculos);
	}
	
	public void remover(Integer id){
		manager.remove(this.busca(id));
	}
}
