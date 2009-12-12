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

	public FantasmaCeleste(Point posicionInicial, Celda posicionPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, posicionPreferida, velocidad, direccion, juego);
		this.ticsParaCambiarDeEstado = TICS_ANTES_DE_CAZAR * 3;
	}

	protected int determinarSiguienteDireccion() {
		// TODO 

		int irA=0;
		switch (estado){
			case DISPERSO:
				irA = direccionParaMinimaDistanciaA(this.celdaPreferida);
				break;
			case HUYENDO:
				irA = direccionParaMaximaDistanciaA(this.juego.getPacman());
				break;
			case CAZANDO:
				irA = direccionParaMinimaDistanciaA(determinarCeldaObjetivo());
				break;
			default: throw new IllegalArgumentException();
		
		}
		return irA;
	}
	protected Celda determinarCeldaObjetivo(){
		Point posiNuevaCelda;
		Celda celdaObjetivo;
		
		Pacman pacman = juego.getPacman();
		
		posiNuevaCelda=new Point(pacman.getPosicion());
		
		switch (pacman.getDireccion()){
			case Pacman.ABAJO:
				posiNuevaCelda= new Point(this.getPosicion().x, pacman.getPosicion().y + 2);
				
				break;
			case Pacman.ARRIBA:
				posiNuevaCelda= new Point(this.getPosicion().x, pacman.getPosicion().y - 2);
				
				break;
			case Pacman.IZQUIERDA:
				posiNuevaCelda= new Point(pacman.getPosicion().x - 2, this.getPosicion().y);
				
				break;
			case Pacman.DERECHA:
				posiNuevaCelda= new Point(pacman.getPosicion().x + 2, this.getPosicion().y);
				
				break;
		}

		// Me quedo con la celda que encontré, si se va del mapa me quedo con la posición del pacman
		try{ 
			celdaObjetivo = this.juego.getCelda(posiNuevaCelda);
		}catch(RangoException re){
			celdaObjetivo = this.juego.getCelda(pacman.getPosicion());
		}
		return celdaObjetivo;
	}
	
}