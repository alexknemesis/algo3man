package grupo9.algo3man.modelo;

import java.awt.Point;

public class PuntoOrdinario extends CeldaPunto {
	
	final private int PUNTAJE_ORDINARIO = 10;
	public PuntoOrdinario(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	protected void comer() {
		this.comido = true;
		this.mapa.restarPunto();
		
	}

	public boolean esTransitable() {
		return true;
	}

	public boolean daPoder() {
		return false;
	}

	public int daPuntos() {
		return this.PUNTAJE_ORDINARIO;
	}

	
}
