package com.stefanini.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import com.stefanini.model.Modelo;
import com.stefanini.repository.ModeloRepository;

@Stateless
public class ModeloService {

	@Inject
	private ModeloRepository modeloRepository;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void incluir(Modelo modelo) {
		modeloRepository.incluir(modelo);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Modelo> lista() {
		return modeloRepository.lista();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Modelo buscar(Integer id) {
		return modeloRepository.busca(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void altera(Modelo modelo){
		this.modeloRepository.altera(modelo);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Modelo modelo){
		this.modeloRepository.remover(modelo);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void remover(Integer id){
		this.modeloRepository.remover(id);
	}

}
