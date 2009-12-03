package grupo9.algo3man.modelo;

import java.awt.Point;
import java.util.ArrayList;

public class PuntoPoder extends CeldaPunto {
	
	final private int PUNTAJE_PODER = 50;
	public PuntoPoder(Mapa mapa, Point posicion) {
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
		return true;
	}

	public int daPuntos() {
		return this.PUNTAJE_PODER;
	}

	

}
