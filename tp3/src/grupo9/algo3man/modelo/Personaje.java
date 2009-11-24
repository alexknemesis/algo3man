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
	protected int velocidad;

	
	protected void moverseEnDireccionActual() {
		switch (direccion){
		case ARRIBA:
			posicion.y -= 1;
			;break;
		case ABAJO:
			posicion.y += 1;			
			;break;
		case DERECHA:   
			posicion.x += 1;
			;break;
		case IZQUIERDA:   
			posicion.x -= 1;
			;break;
		}
		// TODO Auto-generated method stub
	}

	
	public Personaje(Point posicionInicial, int velocidad, int direccionInicial, Juego juego){
		
		if(posicionInicial.getX() < 0 || posicionInicial.getY() < 0)
			throw new IllegalArgumentException();
		if (velocidad <= 0)
			throw new IllegalArgumentException();
		
		this.setVelocidad(velocidad);
		this.juego = juego;
		this.posicion = new Point(posicionInicial);
		this.posicionInicial = new Point(this.posicionInicial);
		this.direccion = direccionInicial;
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

	public double getDistancia(Point posicion) {
		return posicion.distance(this.posicion);
	}

	abstract public void morir();
	abstract public void vivir();
}