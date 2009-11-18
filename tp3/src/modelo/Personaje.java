package modelo;

import java.awt.Point;
import modelo.Juego;

public abstract class Personaje {
	private Juego juego;
	private Point posicion;
	private Point posicionInicial;
	private Point velocidad;
	
	public Personaje(Point punto, Point velocidad, Juego juego){
		if(punto.getX() < 0 || punto.getY() < 0)
			throw new IllegalArgumentException();
		
		this.setVelocidad(velocidad);
		this.juego = juego;
		this.posicion = new Point(punto);
		this.posicionInicial = new Point(this.posicion);
	}
	
	public Juego getJuego(){
		return this.juego;
	}
	
	public double getVelocidadX(){
		return this.velocidad.getX();
	}
	
	public double getVelocidadY(){
		return this.velocidad.getY();
	}
	
	public void setVelocidad(Point velocidad){
		this.velocidad.setLocation(velocidad);
	}
	
	public Point getPosicionInicial(){
		return this.posicionInicial;
	}
	
	public Point getPosicion(){
		return this.posicion;
	}
	
	public void setPosicion(Point punto){
		this.posicion.setLocation(punto);
	}
	
	public void reiniciar(){
		this.setPosicion(this.posicionInicial);
	}
	
	abstract public void morir();
	abstract public void vivir();
}
