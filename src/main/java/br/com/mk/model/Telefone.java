package br.com.mk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TelefonePK id = new TelefonePK();
	
	@Column(length = 20)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;

	public Telefone() {
	}

	public TelefonePK getId() {
		return this.id;
	}

	public void setId(TelefonePK id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}
