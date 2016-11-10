package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.stefanini.model.TipoInfracao;
import com.stefanini.repository.TipoRepository;

@Stateless
public class TipoService {

	@Inject
	private TipoRepository tipoInfracaoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(TipoInfracao t) {
		tipoInfracaoRepository.incluir(t);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<TipoInfracao> lista() {
		return tipoInfracaoRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TipoInfracao buscar(Integer id) {
		return tipoInfracaoRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterar(TipoInfracao localInfracao){
		this.tipoInfracaoRepository.altera(localInfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(TipoInfracao tipoInfracao){
		this.tipoInfracaoRepository.remover(tipoInfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Integer id){
		this.tipoInfracaoRepository.remover(id);
	}

}
