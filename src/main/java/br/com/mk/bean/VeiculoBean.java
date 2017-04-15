package br.com.mk.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.model.Modelo;
import br.com.mk.model.Proprietario;
import br.com.mk.model.Veiculo;
import br.com.mk.service.ModeloService;
import br.com.mk.service.ProprietarioService;
import br.com.mk.service.VeiculoService;
import br.com.mk.util.FacesUtil;

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
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");
			
			proprietarioID = -1;
			modeloID = -1;
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.veiculo = new Veiculo();
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
	
	public List<Veiculo> veiculos(){
		return veiculoService.lista();
	}
}
