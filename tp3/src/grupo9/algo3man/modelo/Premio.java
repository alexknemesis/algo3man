package grupo9.algo3man.modelo;

import java.awt.Point;

public class Premio extends CeldaPunto {
	
	final private int PUNTAJE = 100;
	public Premio(Mapa mapa, Point posicion) {
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
		return false;
	}

	public int daPuntos() {
		if(this.comido)
			return 0;
		else
			return this.PUNTAJE;
	}

	
	
	

}
