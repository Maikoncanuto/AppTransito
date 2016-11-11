package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;
import com.stefanini.util.FacesUtil;

@Named("agenteMB")
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Agente agente;
	
	@Inject
	private AgenteService agenteService;


	public void incluir() {
		try {
			agenteService.incluir(agente);
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
			FacesUtil.getContext().getExternalContext().invalidateSession();
		} catch (Exception e) {
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.agente = new Agente();
	}

	//Metodos Getters and Setters
	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public List<Agente> agentes(){
		return agenteService.lista();
	}
	
}
