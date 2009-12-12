package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaPuerta extends CeldaTransitable {
	
	
	
	public CeldaPuerta(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	public boolean esTransitable() {
		return false;
	}

	public boolean daPoder() {
		return false;
	}

	public int daPuntos() {
		return 0;
	}

	

}
