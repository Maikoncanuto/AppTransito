package br.com.mk.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.service.TipoService;
import br.com.mk.util.FacesUtil;
import br.com.mk.model.TipoInfracao;

@Named("tipoinfracaoMB")
@RequestScoped
public class TipoInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoInfracao tipo;
	
	@Inject
	private TipoService tipoService;

	public TipoInfracao getTipo() {
		return tipo;
	}

	public void setTipo(TipoInfracao tipo) {
		this.tipo = tipo;
	}

	public void cadastrar() {
		try {
			tipoService.incluir(tipo);
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (RuntimeException e) {
			e.printStackTrace();
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
		}
		
		this.tipo = new TipoInfracao();
	}
	
	public List<TipoInfracao> tiposInfracoes(){
		return tipoService.lista();
	}
}
