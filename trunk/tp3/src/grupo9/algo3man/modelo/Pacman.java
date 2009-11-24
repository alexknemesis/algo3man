package grupo9.algo3man.modelo;

import java.awt.Point;

public class Pacman extends Personaje {

	public Pacman(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
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

	public double getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}
}
