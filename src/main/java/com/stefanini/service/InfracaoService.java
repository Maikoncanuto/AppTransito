package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.Infracao;
import com.stefanini.repository.InfracaoRepository;

@Stateless
public class InfracaoService {

	@Inject
	private InfracaoRepository infracaoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Infracao infracao) {
		infracaoRepository.incluir(infracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Infracao infracoes){
		this.infracaoRepository.remover(infracoes);
	}
	
	public List<Infracao> listarInfracoes(){
		return this.infracaoRepository.lista();
	}
	
	public Infracao buscar(Integer id){
		return this.infracaoRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void altera(Infracao infracoes){
		this.infracaoRepository.altera(infracoes);
	}
	
}
