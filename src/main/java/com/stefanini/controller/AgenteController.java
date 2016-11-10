package com.stefanini.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;
import com.stefanini.service.AgenteService;

@Path("/agente")
@RequestScoped
public class AgenteController {
	
		private AgenteService agenteService = new AgenteService();
	
	 	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List<Agente> getAgentes() {
	 		return agenteService.lista();
	    }

	 	@POST
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void salvarAgente(Agente agente){
	 		agenteService.incluir(agente);
	 	}
	 	
	 	@DELETE
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public void excluirAgente(Agente agente){
	 		agenteService.remover(agente);
	 	}
	 	
	 	@DELETE
	 	@Path("/{id}")
	 	@Consumes(MediaType.APPLICATION_JSON)
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public String excluirAgente(@PathParam("id") Integer id){
	 		agenteService.buscar(id);
	 		return new String("REMOVIDO COM SUCESSO");
	 	}
	 	
	 	
	 	
	 	
	 	
}
