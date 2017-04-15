package br.com.mk.util;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mk.model.Agente;
import br.com.mk.model.LocalInfracao;
import br.com.mk.model.TipoInfracao;
import br.com.mk.service.AgenteService;
import br.com.mk.service.LocalInfracaoService;
import br.com.mk.service.TipoService;
import org.primefaces.model.chart.PieChartModel;

@Named("ChartView")
@SessionScoped
public class ChartsBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoService service;
	
	@Inject
	private LocalInfracaoService local;
	
	@Inject
	private AgenteService agente;
	
	private PieChartModel pieModel1;
	private PieChartModel pieModel2;
	private PieChartModel pieModel3;
	private PieChartModel pieModel4;
	
	public PieChartModel getPieModel3() {
		return pieModel3;
	}

	public void setPieModel3(PieChartModel pieModel3) {
		this.pieModel3 = pieModel3;
	}

	public PieChartModel getPieModel4() {
		return pieModel4;
	}

	public void setPieModel4(PieChartModel pieModel4) {
		this.pieModel4 = pieModel4;
	}

	@PostConstruct
	public void init(){
		pieModel1 = new PieChartModel();
		pieModel2 = new PieChartModel();
	}
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}
	
	
	public PieChartModel getPieModel2() {
        return pieModel2;
    }

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}
	
	
	public PieChartModel mostrarGraficos1(){
		pieModel1 = new PieChartModel();
        
	      
        for(TipoInfracao tipo : service.lista()){
        	pieModel1.set(tipo.getDescricaoTipoInfracao(), tipo.getValor());
        }
        
        
        pieModel1.setTitle("GRÁFICO DE INFRAÇÕES: MAIORES VELOCIDADES");
        pieModel1.setLegendPosition("w");
        
        return pieModel1;
	}
	
	public PieChartModel mostrarGraficos2(){
		pieModel2 = new PieChartModel();
	      
        for(LocalInfracao m : local.lista()){
        	pieModel2.set(m.getDescricaoLocalInfracao(), m.getVelocidadePermitida());
        }
        
        pieModel2.setTitle("GRÁFICO LOCAIS DE INFRAÇÕES: LOCAIS VELOCIDADES");
        pieModel2.setLegendPosition("w");
        
        return pieModel2;
	}
     
	public PieChartModel mostrarGraficos3(){
		pieModel3 = new PieChartModel();
	      
        for(Agente m : agente.lista()){
        	pieModel3.set(m.getNome(), m.getTempoServico());
        }
        
        pieModel3.setTitle("GRÁFICO AGENTES: AGENTE POR TEMPO DE SERVIÇO");
        pieModel3.setLegendPosition("w");
        
        return pieModel3;
	}
 

     
}