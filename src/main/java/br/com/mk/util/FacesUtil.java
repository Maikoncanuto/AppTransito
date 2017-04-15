package br.com.mk.util;

import javax.faces.application.FacesMessage;


public class FacesUtil {

    public static void sucesso(String mensagem) {
        FacesProducer.getContext().addMessage(null,  getMensagem(FacesMessage.SEVERITY_INFO, mensagem));
    }

    public static void aviso(String mensagem) {
        FacesProducer.getContext().addMessage(null,  getMensagem(FacesMessage.SEVERITY_WARN, mensagem));
    }

    public static void error(String mensagem){
        FacesProducer.getContext().addMessage(null,  getMensagem(FacesMessage.SEVERITY_ERROR, mensagem));
    }

    public static void fatal(String mensagem){
        FacesProducer.getContext().addMessage(null,  getMensagem(FacesMessage.SEVERITY_FATAL, mensagem));
    }

    private static FacesMessage getMensagem(FacesMessage.Severity level, String mensagem){
        return new FacesMessage(level, mensagem, null);
    }
}
