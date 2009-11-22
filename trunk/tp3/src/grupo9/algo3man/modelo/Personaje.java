package grupo9.algo3man.modelo;

import java.awt.Point;
import grupo9.algo3man.modelo.Juego;

public abstract class Personaje implements Objetivo {
	protected static final int ARRIBA = 1; 
	protected static final int ABAJO = 2; 
	protected static final int DERECHA = 3; 
	protected static final int IZQUIERDA = 4; 

	protected int direccion;
	protected String estado;
	protected Juego juego;
	protected Point posicion;
	protected Point posicionInicial;
	protected Point velocidad;

	
	protected void moverseEnDireccionActual() {
		switch (direccion){
		case ARRIBA:
			posicion.y -= velocidad.y;
			;break;
		case ABAJO:
			posicion.y += velocidad.y;			
			;break;
		case DERECHA:   
			posicion.x += velocidad.x;
			;break;
		case IZQUIERDA:   
			posicion.x -= velocidad.x;
			;break;
		}
		// TODO Auto-generated method stub
	}

	
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

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	abstract public void morir();
	abstract public void vivir();
}