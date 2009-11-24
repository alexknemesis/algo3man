package grupo9.algo3man.modelo;

import java.awt.Point;


public abstract class Fantasma extends Personaje {
	
	private Celda celdaActual;

	public void vivir(){
		
		if(juego.getCelda(this.posicion) == this.celdaActual){
			moverseEnDireccionActual();
			//TODO Comerse o ser comido por el pacman de acuerdo al estado
		}else{
			direccion = determinarSiguienteDireccion();
			moverseEnDireccionActual();
			celdaActual = juego.getCelda(this.posicion);
		}
	}
		
	public Fantasma(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);	
	}

	protected abstract int determinarSiguienteDireccion();
	
}
