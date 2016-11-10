package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Modelo;
import com.stefanini.model.Proprietario;
import com.stefanini.model.Veiculo;
import com.stefanini.service.ModeloService;
import com.stefanini.service.ProprietarioService;
import com.stefanini.service.VeiculoService;
import com.stefanini.util.FacesUtil;

@Named("veiculoMB")
@SessionScoped
public class VeiculoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Veiculo veiculo;
	
	@Inject
	private ProprietarioService proprietarioService;
	
	@Inject
	private VeiculoService veiculoService;
	
	@Inject
	private ModeloService modeloService;
	
	private Integer proprietarioID;
	
	private Integer modeloID;

	public void cadastrar() {
		try {
			veiculo.setProprietario(proprietarioService.buscar(proprietarioID));
			veiculo.setModelo(modeloService.buscar(modeloID));
			veiculoService.incluir(veiculo);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.veiculo = null;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Proprietario> getProprietarios() {
		return proprietarioService.lista();
	}

	public List<Modelo> getModelos() {
		return modeloService.lista();
	}

	public Integer getProprietarioID() {
		return proprietarioID;
	}

	public void setProprietarioID(Integer proprietarioID) {
		this.proprietarioID = proprietarioID;
	}

	public Integer getModeloID() {
		return modeloID;
	}

	public void setModeloID(Integer modeloID) {
		this.modeloID = modeloID;
	}


}
