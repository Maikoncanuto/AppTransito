package br.com.mk.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.mk.model.LocalInfracao;
import br.com.mk.repository.LocalInfracaoRepository;

@Stateless
public class LocalInfracaoService implements Serializable{

	@Inject
	private LocalInfracaoRepository localinfracaoRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(LocalInfracao local) {
		localinfracaoRepository.incluir(local);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<LocalInfracao> lista() {
		return localinfracaoRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public LocalInfracao buscar(Integer id) {
		return localinfracaoRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterar(LocalInfracao localInfracao){
		this.localinfracaoRepository.altera(localInfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(LocalInfracao localinfracao){
		this.localinfracaoRepository.remover(localinfracao);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Integer id){
		this.localinfracaoRepository.remover(id);
	}
}
