package com.stefanini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localinfracao", catalog = "hackaton")
public class LocalInfracao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idLocalInfracao", unique = true, nullable = false)
	private Integer id;
	private String descricaoLocalInfracao;
	private Double velocidadePermitida;

	public LocalInfracao() {
	}

	public LocalInfracao(String descricaoLocalInfracao, Double velocidadePermitida) {
		this.descricaoLocalInfracao = descricaoLocalInfracao;
		this.velocidadePermitida = velocidadePermitida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "descricaoLocalInfracao", length = 100)
	public String getDescricaoLocalInfracao() {
		return this.descricaoLocalInfracao;
	}

	public void setDescricaoLocalInfracao(String descricaoLocalInfracao) {
		this.descricaoLocalInfracao = descricaoLocalInfracao;
	}

	@Column(name = "velocidadePermitida", precision = 22, scale = 0)
	public Double getVelocidadePermitida() {
		return this.velocidadePermitida;
	}

	public void setVelocidadePermitida(Double velocidadePermitida) {
		this.velocidadePermitida = velocidadePermitida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalInfracao other = (LocalInfracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
