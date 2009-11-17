package modelo;

import java.awt.Point;
import modelo.Juego;

public abstract class Personaje {
	private Juego juego;
	private Point posicion;
	private Point posicionInicial;
	private int velocidad;
	
	public Personaje(int x, int y, int velocidad, Juego juego){
		if(x < 0 || y < 0 || velocidad < 0)
			throw new IllegalArgumentException();
		
		this.setVelocidad(velocidad);
		this.juego = juego;
		this.setPosicion(x, y);
		this.posicionInicial = this.posicion;
	}
	
	public Juego getJuego(){
		return this.juego;
	}
	
	public int getVelocidad(){
		return this.velocidad;
	}
	
	public void setVelocidad(int velocidad){
		this.velocidad = velocidad;
	}
	
	public Point getPosicionInicial(){
		return this.posicionInicial;
	}
	
	public Point getPosicion(){
		return this.posicion;
	}
	
	public void setPosicion(Point punto){
		this.posicion = punto;
	}
	
	public void setPosicion(int x, int y){
		
	}
	
	public void reiniciar(){
		this.posicion = this.posicionInicial;
	}
	
	abstract public void morir();
	abstract public void vivir();
}
