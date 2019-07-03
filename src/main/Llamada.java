package main;

public abstract class Llamada {

	private String numeroOrigen;
	private String numeroDestino;
	private int duracion;
	protected abstract Double costeAbs();
	
	/**
	 * Getters & setters
	 */
	
	protected String getNumeroOrigen() {
		return numeroOrigen;
	}
	protected void setNumeroOrigen(String numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}
	protected String getNumeroDestino() {
		return numeroDestino;
	}
	protected void setNumeroDestino(String numeroDestino) {
		this.numeroDestino = numeroDestino;
	}
	protected int getDuracion() {
		return duracion;
	}
	protected void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	

	
	
	
	
	
}
