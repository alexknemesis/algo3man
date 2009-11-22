package grupo9.algo3man.modelo;

import java.awt.Point;


/**
 * @author grupo9
 * Este tipo de fantasma se mueve siempre a la derecha.
 *
 */
public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(Point punto, Point velocidad, Juego juego) {
		super(punto, velocidad, juego);
	}

	public void vivir() {
		// TODO Auto-generated method stub

	}

	public void morir() {
		// TODO Auto-generated method stub
		
	}

	protected int determinarSiguienteDireccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
