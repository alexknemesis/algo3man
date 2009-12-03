package grupo9.algo3man.modelo;

import java.awt.Point;

public class PuntoOrdinario extends CeldaPunto {
	
	final private int PUNTAJE = 10;
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
		if(this.isComido())
			return false;
		else
			return true;
	}

	public int daPuntos() {
		if(this.isComido())
			return 0;
		else
			return this.PUNTAJE;
	}
	
}
