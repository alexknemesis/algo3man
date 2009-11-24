package grupo9.algo3man.modelo;

import java.awt.Point;

/**
 * @author cripton
 * El fantasma naranja (Clyde) es el indeciso, cuando está a menor distancia que
 * (6) casillas (radiales) su objetivo es su celda preferida, si está a más de 
 * (6) su objetivo es el Pacman.
 */
public class FantasmaNaranja extends Fantasma {

	public FantasmaNaranja(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
		
	}

	public void morir() {
		// TODO Auto-generated method stub
		
	}

	protected int determinarSiguienteDireccion() {
		// TODO 

		int irA=0;
		switch (estado){
			case DISPERSO:
				irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			case HUYENDO:
				irA = direccionParaMaximaDistanciaA(juego.getPacman());
				break;
			case CAZANDO:
				if (juego.getPacman().getDistancia(this.posicion) > 6)
					irA = direccionParaMinimaDistanciaA(juego.getPacman());
				else
					irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
}
