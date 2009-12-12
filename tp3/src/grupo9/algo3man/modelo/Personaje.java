package grupo9.algo3man.modelo;

import java.awt.Point;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.titiritero.ObjetoVivo;
import grupo9.algo3man.titiritero.Posicionable;

public abstract class Personaje implements Objetivo, ObjetoVivo, Posicionable {
	public static final int ARRIBA = 0; 
	public static final int ABAJO = 1; 
	public static final int DERECHA = 2; 
	public static final int IZQUIERDA = 3; 

	protected int direccion;
	protected String estado;
	protected Juego juego;
	protected Point posicion;
	protected Point posicionInicial;

	/* Cuenta las ejecuciones del vivir en contadorDeTics hasta igualar la 
	 * velocidad.
 	 */

	protected int velocidad;
	protected int contadorDeTics; 
	
	public Personaje(Point posicionInicial, int velocidad, int direccionInicial, Juego juego){
		
		if(posicionInicial.getX() < 0 || posicionInicial.getY() < 0)
			throw new IllegalArgumentException();
		this.setVelocidad(velocidad);
		this.juego = juego;
		this.posicion = new Point(posicionInicial);
		this.posicionInicial = new Point(posicionInicial);
		this.direccion = direccionInicial;
	}
	
	protected void moverseEnDireccionActual() {
		Point proximoLugar = new Point(this.posicion);
		
		switch (direccion){
		case ARRIBA:
			proximoLugar.y -= 1;
			;break;
		case ABAJO:
			proximoLugar.y += 1;			
			;break;
		case DERECHA:   
			proximoLugar.x += 1;
			;break;
		case IZQUIERDA:   
			proximoLugar.x -= 1;
			;break;
		}

		if(this.getJuego().getCelda(proximoLugar)!= null)
			if (this.getJuego().getCelda(proximoLugar).esTransitable())
				this.posicion.setLocation(proximoLugar);
	}
	
	public Juego getJuego(){
		return this.juego;
	}
	
	public int getVelocidad(){
		return this.velocidad;
	}
		
	public void setVelocidad(int velocidad){
		if (velocidad <= 0)
			throw new IllegalArgumentException();
		this.contadorDeTics=0;
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