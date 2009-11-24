package grupo9.algo3man.modelo;

import java.awt.Point;

public class PuntoPoder extends CeldaPunto {
	
	final private int PUNTAJE_PODER = 50;
	public PuntoPoder(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	protected void comer() {
		this.comido = true;
		this.mapa.restarPunto();
		
		
	}

	public void transitar() {
		this.comer();
		this.mapa.getJuego().sumarPuntos(this.PUNTAJE_PODER);
		
	}

	public boolean esTransitable() {
		
		return true;
	}

	

}
