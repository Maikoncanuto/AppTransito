package com.stefanini.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Proprietario;
import com.stefanini.model.Telefone;
import com.stefanini.service.ProprietarioService;
import com.stefanini.util.FacesUtil;

@Named("proprietarioMB")
@SessionScoped
public class ProprietarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProprietarioService proprietarioService;
	
	@Inject
	private Proprietario proprietario;
	
	@Inject
	private Telefone telefone;

	public void salvar() {
		try {
			proprietarioService.incluir(proprietario);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (Exception e) {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.adicionarTelefone(telefone);
		}
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}