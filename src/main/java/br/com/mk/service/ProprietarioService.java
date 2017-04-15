package br.com.mk.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.mk.model.Proprietario;
import br.com.mk.repository.ProprietarioRepository;

@Stateless
public class ProprietarioService implements Serializable{

	@Inject
	private ProprietarioRepository proprietarioRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Proprietario p) {
		proprietarioRepository.incluir(p);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Proprietario> lista() {
		return proprietarioRepository.lista();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void alterar(Proprietario proprietario){
		this.proprietarioRepository.altera(proprietario);
	}
	
	public Proprietario buscar(Integer id){
		return this.proprietarioRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Proprietario proprietario){
		this.proprietarioRepository.remover(proprietario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Integer id){
		this.proprietarioRepository.remover(id);
	}
}
