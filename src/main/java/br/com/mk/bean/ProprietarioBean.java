package br.com.mk.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.model.Proprietario;
import br.com.mk.service.ProprietarioService;
import br.com.mk.util.FacesUtil;
import br.com.mk.model.Telefone;

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
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (RuntimeException e) {
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.proprietario = new Proprietario();
		this.telefone = new Telefone();
	}

	public void salvarTelefone() {
		if (this.proprietario != null) {
			this.proprietario.adicionarTelefone(telefone);
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");
		}else{
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
			this.telefone = new Telefone();
		}

	}
	
	public void excluir(Proprietario proprietario){
		try{
			proprietarioService.remover(proprietario);
			FacesUtil.sucesso("REGISTRO REMOVIDO COM SUCESSO");
		}catch(RuntimeException e){
			FacesUtil.error("PROBLEMA AO REMOVER REGISTRO");
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
	
	public List<Proprietario> proprietarios(){
		return proprietarioService.lista();
	}
}