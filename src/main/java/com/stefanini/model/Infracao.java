package com.stefanini.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "infracoes", catalog = "hackaton")
public class Infracao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idInfracao", unique = true, nullable = false)
	private Integer idInfracao;

	@ManyToOne
	@JoinColumn(name = "idAgente")
	private Agente agente;

	@ManyToOne
	@JoinColumn(name = "idLocalInfracao")
	private LocalInfracao localInfracao;

	@ManyToOne
	@JoinColumn(name = "idTipoInfracao")
	private TipoInfracao tipoinfracao;

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	private Integer velocidade;

	public Integer getIdInfracao() {
		return this.idInfracao;
	}

	public void setIdInfracao(Integer idInfracao) {
		this.idInfracao = idInfracao;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public LocalInfracao getLocalInfracao() {
		return localInfracao;
	}

	public void setLocalInfracao(LocalInfracao localInfracao) {
		this.localInfracao = localInfracao;
	}

	public TipoInfracao getTipoinfracao() {
		return tipoinfracao;
	}

	public void setTipoinfracao(TipoInfracao tipoinfracao) {
		this.tipoinfracao = tipoinfracao;
	}

	@Column(name = "velocidade")
	public Integer getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
