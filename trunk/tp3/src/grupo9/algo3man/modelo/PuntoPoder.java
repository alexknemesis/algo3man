package grupo9.algo3man.modelo;

import java.awt.Point;

public class PuntoPoder extends CeldaPunto {
	
	final private int PUNTAJE = 50;
	public PuntoPoder(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	protected void comer() {
		if (!this.comido){
			this.comido = true;
			this.mapa.restarPunto();
		}
	}

	public boolean esTransitable() {
		return true;
	}
	
	public boolean daPoder() {
		if(this.comido)
			return false;
		else
			return true;
	}

	public int daPuntos() {
		if(this.comido)
			return 0;
		else
			return this.PUNTAJE;
	}

	

}
