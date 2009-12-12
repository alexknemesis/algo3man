package grupo9.algo3man.modelo;

import java.awt.Point;

/**
 * @author cripton
 * El fantasma naranja (Clyde) es el indeciso, cuando está a menor distancia que
 * (6) casillas (radiales) su objetivo es su celda preferida, si está a más de 
 * (6) su objetivo es el Pacman.
 * Es el último en ir a cazar al pacman(pasar a modo CAZANDO)
 */
public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(Point posicionInicial, Celda posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
		this.ticsParaCambiarDeEstado = TICS_ANTES_DE_CAZAR * 4;
	}

	protected int determinarSiguienteDireccion() {
		Pacman pacman = juego.getPacman();
		int irA=0;
		switch (estado){
			case DISPERSO:
				irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			case HUYENDO:
				irA = direccionParaMaximaDistanciaA(pacman);
				break;
			case CAZANDO:
				if (this.getDistancia(pacman.getPosicion()) < 6)
					irA = direccionParaMinimaDistanciaA(pacman);
				else
					irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
}