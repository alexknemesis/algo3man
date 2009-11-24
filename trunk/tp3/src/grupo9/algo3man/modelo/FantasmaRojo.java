package grupo9.algo3man.modelo;

import java.awt.Point;



/**
 * @author cripton
 * El fantasma rojo es el más agresivo y a su vez el más simple, simplemente va 
 * hacia la dirección que lo acerca más al pacman.
 */
public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(Point posicionInicial, int velocidad, int direccion, Juego juego) {
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
				irA = direccionParaMaximaDistanciaA(this.pacman);
				break;
			case CAZANDO:
				irA = direccionParaMinimaDistanciaA(this.pacman);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}

}
