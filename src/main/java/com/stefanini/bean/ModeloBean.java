package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.service.ModeloService;
import com.stefanini.util.FacesUtil;

@Named("modeloMB")
@SessionScoped
public class ModeloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloService modeloService;
	
	@Inject
	private Modelo modelo;

	public void cadastrar() {
		try {
			modeloService.incluir(modelo);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (Exception e) {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.modelo = null;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public List<Modelo> modelos(){
		return this.modeloService.lista();
	}
	


}
