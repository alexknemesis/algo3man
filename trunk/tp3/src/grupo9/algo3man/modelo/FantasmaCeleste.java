package grupo9.algo3man.modelo;

import java.awt.Point;


/**
 * @author grupo9
 * El fantasma celeste (Inky) es el más impredecible, su estrategia consiste en
 * tratar de ir dos celdas adelante del pacman moviéndose paralelamente para 
 * luego ir en su direccion e intentar atraparlo.
 * Es el tercero en ir a cazar al pacman(pasar a modo CAZANDO)
 */
public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(Point posicionInicial, Point posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
		this.ticsParaSalirDeDisperso = TICS_ANTES_DE_CAZAR * 3;
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
				//TODO implementar estrategia de caza del fantasma celeste
				irA = direccionParaMinimaDistanciaA(pacman);
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
	protected Celda determinarCeldaObjetivo(){
		Point posiNuevaCelda;
		
		
		return null;
	}
}