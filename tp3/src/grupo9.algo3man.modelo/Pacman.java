package modelo;

import java.awt.Point;

public class Pacman extends Personaje {

	public Pacman(Point punto, Point velocidad, Juego juego) {
		super(punto, velocidad, juego);
		// TODO Auto-generated constructor stub
	}

	public void morir() {
		this.getJuego().restarVida();
		this.reiniciar();
	}

	public void vivir() {
		// TODO Auto-generated method stub
		moverseEnDireccionActual();

	}
	
	public void moverDerecha(){
		this.setDireccion(DERECHA);
	}
	
	public void moverIzquierda(){
		this.setDireccion(IZQUIERDA);
	}
	
	public void moverAbajo(){
		this.setDireccion(ABAJO);
	}
	public void moverArriba(){
		this.setDireccion(ARRIBA);
	}

	public int getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}
}
