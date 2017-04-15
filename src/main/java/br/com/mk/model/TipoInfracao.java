package br.com.mk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoinfracao", catalog = "hackaton")
public class TipoInfracao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTipoInfracao", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "descricaoTipoInfracao", length = 50, nullable = false)
	private String descricaoTipoInfracao;
	
	@Column(name = "valor", precision = 22, scale = 0, nullable = false)
	private Double valor;

	public TipoInfracao() {
	}

	public TipoInfracao(String descricaoTipoInfracao, Double valor) {
		this.descricaoTipoInfracao = descricaoTipoInfracao;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoTipoInfracao() {
		return this.descricaoTipoInfracao;
	}

	public void setDescricaoTipoInfracao(String descricaoTipoInfracao) {
		this.descricaoTipoInfracao = descricaoTipoInfracao;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		TipoInfracao other = (TipoInfracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
