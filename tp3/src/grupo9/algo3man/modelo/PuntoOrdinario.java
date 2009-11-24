package grupo9.algo3man.modelo;

import java.awt.Point;

public class PuntoOrdinario extends CeldaPunto {
	
	final private int PUNTAJE_ORDINARIO = 10;
	public PuntoOrdinario(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	public void comer() {
		this.comido = true;
		this.mapa.restarPunto();
		
	}

	public void transitar() {
		this.comer();
		this.mapa.getJuego().sumarPuntos(this.PUNTAJE_ORDINARIO);
		
	}

	public boolean esTransitable() {
		
		return true;
	}

	
}
