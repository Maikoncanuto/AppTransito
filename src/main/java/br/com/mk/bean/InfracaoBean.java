package br.com.mk.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.model.LocalInfracao;
import br.com.mk.model.Veiculo;
import br.com.mk.service.InfracaoService;
import br.com.mk.service.TipoService;
import br.com.mk.util.FacesUtil;
import br.com.mk.model.Agente;
import br.com.mk.model.Infracao;
import br.com.mk.model.TipoInfracao;
import br.com.mk.service.AgenteService;
import br.com.mk.service.LocalInfracaoService;
import br.com.mk.service.VeiculoService;

@Named("infracaoMB")
@SessionScoped
public class InfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Infracao infracao;

	@Inject
	private InfracaoService infracaoService;

	@Inject
	private TipoService tipoService;

	@Inject
	private AgenteService agenteService;

	@Inject
	private LocalInfracaoService localService;

	@Inject
	private VeiculoService veiculoService;

	private Integer agenteId;
	private Integer localId;
	private Integer tipoId;
	private Integer veiculoId;

	public void cadastrar() {
		try {
			infracao.setTipoinfracao(tipoService.buscar(tipoId));
			infracao.setLocalInfracao(localService.buscar(localId));
			infracao.setAgente(agenteService.buscar(agenteId));
			infracao.setVeiculo(veiculoService.buscar(veiculoId));
			infracaoService.incluir(infracao);
			FacesUtil.sucesso("REGISTRO INSERIDO COM SUCESSO");

			agenteId = -1;
			localId = -1;
			tipoId = -1;
			veiculoId = -1;
		} catch (RuntimeException e) {
			FacesUtil.error("PROBLEMA AO INSERIR REGISTRO");
		}

		this.infracao = new Infracao();
	}

	public List<Infracao> infracoes() {
		return infracaoService.listarInfracoes();
	}

	public List<TipoInfracao> tipos() {
		return this.tipoService.lista();
	}

	public List<LocalInfracao> locais() {
		return this.localService.lista();
	}

	public List<Agente> agentes() {
		return this.agenteService.lista();
	}

	public List<Veiculo> veiculos() {
		return this.veiculoService.lista();
	}

	public Integer getAgenteId() {
		return agenteId;
	}

	public void setAgenteId(Integer agenteId) {
		this.agenteId = agenteId;
	}

	public Integer getLocalId() {
		return localId;
	}

	public void setLocalId(Integer localId) {
		this.localId = localId;
	}

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

}
