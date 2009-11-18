package modelo;

import java.awt.Point;

public abstract class Fantasma extends Personaje {

	public Fantasma(Point punto, Point velocidad, Juego juego) {
		super(punto, velocidad, juego);	
	}
	
}
