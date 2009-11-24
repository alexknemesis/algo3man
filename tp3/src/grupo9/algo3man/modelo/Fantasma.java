package grupo9.algo3man.modelo;

import java.awt.Point;


public abstract class Fantasma extends Personaje {
	
	private Celda celdaActual;

	public void vivir() {
		// TODO Esto es una versión primitiva de la implementación del contador
		// de tics, pero igual no creo que tenga mucha más vuelta..
		
		this.contadorDeTics++;
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			//TODO Comerse o ser comido por el pacman de acuerdo al estado

			this.direccion = determinarSiguienteDireccion();
			this.moverseEnDireccionActual();
			//TODO Comerse o ser comido por el pacman de acuerdo al estado

		}

	}

		
	public Fantasma(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);	
	}

	protected abstract int determinarSiguienteDireccion();
	
}
