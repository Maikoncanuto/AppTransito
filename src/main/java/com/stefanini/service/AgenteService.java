package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import com.stefanini.model.Agente;
import com.stefanini.repository.AgenteRepository;

@Stateless
public class AgenteService {

	@Inject
	private AgenteRepository agenteRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Agente agente) {
		agenteRepository.incluir(agente);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Agente> lista() {
		return agenteRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Agente buscar(Integer id) {
		return agenteRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterar(Agente agente){
		this.agenteRepository.altera(agente);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Agente agente){
		this.agenteRepository.remover(agente);
	}

}
