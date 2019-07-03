package main;

public class LlamadaLocal extends Llamada {

	
	private Double costeLlamada;
	
	/**
	 * Constructor
	 */
	
	public LlamadaLocal(String numOr, String numDes, int durac) {
		super.setNumeroOrigen(numOr);
		super.setNumeroDestino(numDes);
		super.setDuracion(durac);
		this.costeLlamada = this.costeAbs();
	}
	
	@Override
	protected Double costeAbs() {
		// TODO Auto-generated method stub
		return 0.15 * this.getDuracion();
	}

}
