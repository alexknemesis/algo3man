package modelo;

import java.awt.Point;

public class FantasmaCeleste extends Fantasma {

	public FantasmaCeleste(Point punto, Point velocidad, Juego juego) {
		super(punto, velocidad, juego);
	}

	public void vivir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int determinarSiguienteDireccion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}

}
