package main;

import java.util.ArrayList;

public class Centralita {

	private ArrayList<Llamada> registro;
	private int contadorProvinciales = 0;
	private int contadorLocales = 0;
	private Double costeTotalLlamadas = 0d;
	private Double costeTotalLocales = 0d;
	private Double costeTotalProvinciales = 0d;
	private Double costeUltimaLlamada = 0d;
	
	public Centralita() {
		this.registro = new ArrayList<Llamada>();
	}
	
	public void agregarLlamada(Llamada llam) {
		if (llam instanceof LlamadaLocal) {
			this.contadorLocales++;
			this.costeTotalLocales+=this.getCosteTotal();
		}else {
			this.contadorProvinciales++;
			this.costeTotalProvinciales+=this.getCosteTotal();
		}
		this.registro.add(llam);
		this.costeTotalLlamadas+=llam.costeAbs();
		this.costeUltimaLlamada = llam.costeAbs();
	}
	
	//dar el numero de llamadas
	public int getNumeroLlamadas() {
		return this.contadorProvinciales + this.contadorLocales;
	}
	//dar el numero de las llamadas locales
	public int getNumeroLlamLocales() {
		return this.contadorLocales;
	}
	//dar el numero de las llamadas provinciales
	public int getNumeroLlamProvinciales() {
		return this.contadorProvinciales;
	}
	//buscar una llamada por numero entrante
	public Llamada getLlamadaPorOrigen(String numeroEntrante) {
		for (Llamada llamada : registro) {
			if(llamada.getNumeroOrigen() == numeroEntrante) {
				return llamada;
			}
		}
		return null;
	}
	//buscar una llamada por numero saliente
	public Llamada getLlamadaPorDestino(String numeroDestino) {
		for (Llamada llamada : registro) {
			if(llamada.getNumeroDestino() == numeroDestino) {
				return llamada;
			}
		}
		return null;
	}
	
	
	//dar el coste de total
	public Double getCosteTotal() {
		return costeTotalLlamadas;
	}
	
	//dar el coste de las locales
	public Double costeLocales() {
		return this.costeTotalLocales;
	}
	
	public Double getCosteUltimaLlamada() {
		return this.costeUltimaLlamada;
	}
	
	//dar el coste de las provinciales
	
	
	//dar el coste la franja 1
	
	//dar el coste la franja 2
	
	//dar el coste la franja 3
}
