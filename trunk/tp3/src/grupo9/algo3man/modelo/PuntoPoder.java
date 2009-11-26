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

	public void transitar() {
		this.comer();
		this.mapa.getJuego().sumarPuntos(this.PUNTAJE_PODER);
		this.mapa.getJuego().getPacman().setVictimario();
		ArrayList fantasmas = this.mapa.getJuego().getFantasmas();
		for(int i=0; i < fantasmas.size(); i++){
			((Fantasma) fantasmas.get(i)).huirDelPacman();
		}
		
		// TODO implementar timer para volver a la normalidad
	}

	public boolean esTransitable() {
		
		return true;
	}

	

}
