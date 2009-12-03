package grupo9.algo3man.modelo;

import java.awt.Point;



/**
 * @author cripton
 * El fantasma rojo (Blinky) es el más agresivo y a su vez el más simple, simplemente va 
 * hacia la dirección que lo acerca más al pacman.
 * Es el primero en ir a cazar al pacman(pasar a modo CAZANDO)
 */
public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(Point posicionInicial, Point posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
		this.ticsParaSalirDeDisperso = TICS_ANTES_DE_CAZAR * 1;
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
				irA = direccionParaMinimaDistanciaA(pacman);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}

}