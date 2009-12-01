package grupo9.algo3man.modelo;

import java.awt.Point;

/**
 * @author cripton
 * El fantasma naranja (Clyde) es el indeciso, cuando está a menor distancia que
 * (6) casillas (radiales) su objetivo es su celda preferida, si está a más de 
 * (6) su objetivo es el Pacman.
 */
public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(Point posicionInicial, Point posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
		
	}

	protected int determinarSiguienteDireccion() {
		
		int irA=0;
		switch (estado){
			case DISPERSO:
				irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			case HUYENDO:
				irA = direccionParaMaximaDistanciaA(pacman);
				break;
			case CAZANDO:
				if (pacman.getDistancia(this.posicion) > 6)
					irA = direccionParaMinimaDistanciaA(pacman);
				else
					irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
}
