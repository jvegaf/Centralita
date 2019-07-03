package main;

public class LlamadaProvincial extends Llamada{
	
	private int franjaHoraria;
	private Double costeLlamada;
	
	/**
	 * Getters & setters
	 */
	
	public int getFranjaHoraria() {
		return this.franjaHoraria;
	}
	
	public void setFranjaHoraria(int franja) {
		this.franjaHoraria = franja;
	}
	
	/**
	 * Constructor
	 */
	
	public LlamadaProvincial(String numOr, String numDes, int durac, int franjaHoraria) {
		super.setNumeroOrigen(numOr);
		super.setNumeroDestino(numDes);
		super.setDuracion(durac);
		this.franjaHoraria = franjaHoraria;
		this.costeLlamada = this.costeAbs();
	}

	/**
	 * metodos
	 */
	
	private Double getPrecioPorFranja(int franja) {
		switch (franja) {
			case 1:
				return 0.20d;
			case 2:
				return 0.25d;
			case 3:
				return 0.30d;
		}
		return null;
	}

	@Override
	public Double costeAbs() {
		
		return this.getDuracion() * this.getPrecioPorFranja(this.getFranjaHoraria());
	}

}
