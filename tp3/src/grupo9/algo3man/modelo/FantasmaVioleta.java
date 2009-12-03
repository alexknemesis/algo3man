package grupo9.algo3man.modelo;

import java.awt.Point;

/**
 * @author cripton
 * El fantasma violeta (Pinky) es el emboscador, su objetivo está en 4 casillas
 * adelante de la dirección del pacman.
 * Es el segundo en ir a cazar al pacman(pasar a modo CAZANDO)
 */
public class FantasmaVioleta extends Fantasma {

	public FantasmaVioleta(Point posicionInicial, Point posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
		this.ticsParaSalirDeDisperso = TICS_ANTES_DE_CAZAR * 2;
	}


	protected int determinarSiguienteDireccion() {

		int irA=0;
		switch (estado){
			case DISPERSO:
				irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			case HUYENDO:
				irA = direccionParaMaximaDistanciaA(this.pacman);
				break;
			case CAZANDO:
				irA = direccionParaMinimaDistanciaA(determinarObjetivo());
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}

	protected Objetivo determinarObjetivo(){
		Point posiNuevaCelda;
		Celda celdaObjetivo;
		
		posiNuevaCelda=new Point(pacman.getPosicion());
		
		switch (pacman.getDireccion()){
			case Pacman.ABAJO:
				posiNuevaCelda= new Point(this.pacman.getPosicion().x, this.pacman.getPosicion().y + 4);
				
				break;
			case Pacman.ARRIBA:
				posiNuevaCelda= new Point(this.pacman.getPosicion().x, this.pacman.getPosicion().y - 4);
				
				break;
			case Pacman.IZQUIERDA:
				posiNuevaCelda= new Point(this.pacman.getPosicion().x - 4, this.pacman.getPosicion().y);
				
				break;
			case Pacman.DERECHA:
				posiNuevaCelda= new Point(this.pacman.getPosicion().x + 4, this.pacman.getPosicion().y);
				
				break;
		}

		// Me quedo con la celda que encontré, si se va del mapa me quedo con la posición del pacman
		try{ 
			celdaObjetivo = this.juego.getCelda(posiNuevaCelda);
		}catch(RangoException re){
			celdaObjetivo = this.juego.getCelda(this.pacman.getPosicion());
		}
		return celdaObjetivo;
	}

}