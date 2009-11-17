package modelo;

import java.awt.Point;

public abstract class Personaje {
	private Juego juego;
	private Point posicion;
	private int velocidad;
	
	public Personaje(int x, int y, int velocidad, Juego juego){
		if(x < 0 || y < 0 || velocidad < 0)
			throw new IllegalArgumentException();
		
		this.velocidad = velocidad;
		this.juego = juego;
		
	}
	
	abstract public void morir();
	abstract public void vivir();
}
