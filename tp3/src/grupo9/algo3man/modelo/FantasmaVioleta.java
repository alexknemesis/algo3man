package grupo9.algo3man.modelo;

import java.awt.Point;

public class FantasmaVioleta extends Fantasma {

	public FantasmaVioleta(Point posicionInicial, int velocidad, int direccion, Juego juego) {
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
				//TODO implementar estrategia de caza del fantasma violeta
				irA = direccionParaMinimaDistanciaA(juego.getPacman());
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
}
