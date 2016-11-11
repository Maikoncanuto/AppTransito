package com.stefanini.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

import com.stefanini.model.LocalInfracao;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.util.FacesUtil;

@Named("localinfracaoMB")
@RequestScoped
public class LocalInfracaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private MapModel emptyModel;
	
	private String title;
	
	private Double lat;
	
	private Double lng;
	
	@Inject
	private LocalInfracaoService service;
	
	@Inject
	private LocalInfracao local;

	@PostConstruct
	public void init() {
		emptyModel = new DefaultMapModel();
	}
	
	public void cadastrar() {
		try {
			local.setLagitude(lat);
			local.setLongitude(lng);		
			System.out.println(lat);
			System.out.println(lng);
			service.incluir(local);
			FacesUtil.getContext().getExternalContext().invalidateSession();
			FacesUtil.exibeSucesso("REGISTRO INSERIDO COM SUCESSO");
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.exibeErro("PROBLEMA AO INSERIR REGISTRO.");
		}
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}


	public MapModel getEmptyModel() {
		return emptyModel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public void addMarker() {
		new LatLng(lat, lng);

	}

	public List<LocalInfracao> locais(){
		return service.lista();
	}
}
