package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaPuerta extends CeldaTransitable {//TODO Es transitable una �nica vez cuando salen los fantasmas de las casitas
	
	
	
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
