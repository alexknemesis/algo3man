package grupo9.algo3man.modelo;

import java.awt.Point;

public class Pacman extends Personaje {

	public Pacman(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
		// TODO Auto-generated constructor stub
	}

	public void morir() {
		this.getJuego().restarVida();
	}

	public void vivir() {
		// TODO Esto es una versión primitiva de la implementación del contador
		// de tics, pero igual no creo que tenga mucha más vuelta..
		
		this.contadorDeTics++;
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			this.moverseEnDireccionActual();
		}

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
