package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;

@Path("/agente")
@RequestScoped
public class AgenteController {
	
		@Inject
		private AgenteService agenteService;
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Agente> getAgentes() {
	 		return agenteService.lista();
	    }
	 	
	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void salvarAgente(Agente agente){
	 		System.out.println(agente.getNome());	
	 		agenteService.incluir(agente);
	 	}
	 	
	 	@DELETE
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public String excluirAgente(Agente agente){
	 		agenteService.remover(agente);
	 		
	 		return "REGISTRO REMOVIDO COM SUCESSO";
	 	}
	 	
}
