package modelo;

import java.awt.Point;


public abstract class Fantasma extends Personaje {
	
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
		
	public Fantasma(Point punto, Point velocidad, Juego juego) {
		super(punto, velocidad, juego);	
	}

	protected abstract int determinarSiguienteDireccion();
	
}
