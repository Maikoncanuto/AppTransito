package com.stefanini.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modelo", catalog = "hackaton")
public class Modelo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idModelo;
	
	private String descricaoModelo;
	
	private String categoria;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idModelo", unique = true, nullable = false)
	public Integer getIdModelo() {
		return this.idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	@Column(name = "descricaoModelo", length = 50)
	public String getDescricaoModelo() {
		return this.descricaoModelo;
	}

	public void setDescricaoModelo(String descricaoModelo) {
		this.descricaoModelo = descricaoModelo;
	}

}
