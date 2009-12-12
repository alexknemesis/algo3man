package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaVacia extends CeldaPunto {

	public CeldaVacia(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	public boolean daPoder() {
		return false;
	}

	public int daPuntos() {
		return 0;
	}

	@Override
	public boolean isComido() {
		return true;
	}

	@Override
	protected void comer() {
		
	}

}
