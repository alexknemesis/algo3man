package modelo;

import java.awt.Point;

public class Pacman extends Personaje {

	public Pacman(Point punto, Point velocidad, Juego juego) {
		super(punto, velocidad, juego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void morir() {
		this.getJuego().restarVida();
		this.reiniciar();
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub

	}
	
	public void moverDerecha(){
		
	}
	
	public void moverIzquierda(){
		
	}
	
	public void moverAtras(){
		
	}

	@Override
	public int getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}
}
