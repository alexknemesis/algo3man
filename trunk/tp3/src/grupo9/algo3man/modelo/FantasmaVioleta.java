package grupo9.algo3man.modelo;

import java.awt.Point;

/**
 * @author cripton
 * El fantasma violeta (Pinky) es el emboscador, su objetivo está en 4 casillas
 * adelante de la dirección del pacman.
 */
public class FantasmaVioleta extends Fantasma {

	public FantasmaVioleta(Point posicionInicial, Point posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
	}


	protected int determinarSiguienteDireccion() {
		// TODO 

		int irA=0;
		switch (estado){
			case DISPERSO:
				irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			case HUYENDO:
				irA = direccionParaMaximaDistanciaA(pacman);
				break;
			case CAZANDO:
				//TODO implementar estrategia de caza del fantasma violeta
				irA = direccionParaMinimaDistanciaA(pacman);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
}
