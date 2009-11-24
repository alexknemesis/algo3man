package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaVacia extends CeldaTransitable {

	

	public CeldaVacia(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	public boolean esTransitable() {
		
		return false;
	}

	public void transitar() {
		
		
	}

}
