package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaPuerta extends CeldaTransitable {
	
	boolean transitable;
	
	public CeldaPuerta(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		this.transitable = true;
		
	}

	public void transitar() {
		
		
	}

	public boolean esTransitable() {
		
		return this.transitable;
	}

	

}
