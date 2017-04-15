package br.com.mk.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacesProducer {

	public static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext(){
		return getContext().getExternalContext();
	}

	public static HttpServletRequest getHttpServletRequest(){
		return ((HttpServletRequest)getExternalContext().getRequest());
	}

	public static HttpServletResponse getHttpServletResponse(){
		return ((HttpServletResponse)getExternalContext().getResponse());
	}
}
