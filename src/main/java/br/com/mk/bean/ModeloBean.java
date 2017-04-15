package br.com.mk.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.model.Modelo;
import br.com.mk.service.ModeloService;
import br.com.mk.util.FacesUtil;

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
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (RuntimeException e) {
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.modelo = new Modelo();
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
