package br.com.mk.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.model.Agente;
import br.com.mk.service.AgenteService;
import br.com.mk.util.FacesProducer;
import br.com.mk.util.FacesUtil;

@Named("agenteMB")
@SessionScoped
public class AgenteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Agente agente;
	
	@Inject
	private AgenteService agenteService;

	//Métodos do bean
	public void incluir() {
		try {
			agenteService.incluir(agente);
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");
			FacesProducer.getExternalContext().invalidateSession();
		} catch (RuntimeException e) {
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.agente = new Agente();
	}
	
	public void alterar(){
		try{
			agenteService.alterar(agente);
			FacesUtil.sucesso("REGISTRO ALTERADO COM SUCESSO");
			this.agente = new Agente();
		}catch (RuntimeException e) {
			FacesUtil.error("PROBLEMA AO ALTERAR REGISTRO");
		}
	}

	public void excluir(Agente agente){
		try{
			agenteService.remover(agente);
			FacesUtil.sucesso("REGISTRO REMOVIDO COM SUCESSO");
		}catch (Exception e) {
			FacesUtil.error("PROBLEMA AO REMOVER REGISTRO");
		}
	}

	public List<Agente> agentes(){
		return agenteService.lista();
	}
	
	//Getters and Setters
	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}
}
