package grupo9.algo3man.modelo;

import java.awt.Point;
import java.util.ArrayList;

public class Pacman extends Personaje {
	public static final int VICTIMA = 1; 
	public static final int VICTIMARIO = 2; 
	
	private int estado;

	public Pacman(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
		this.estado = VICTIMA;
	}
	
	public void reiniciar(){
		this.setPosicion(this.posicionInicial);
		this.setVictima();
	}

	public void morir() {
		this.getJuego().restarVida();
	}

	public void vivir() {
		// TODO Esto es una versión primitiva de la implementación del contador
		// de tics, pero igual no creo que tenga mucha más vuelta..
		
		this.checkFantasmaEnCelda();
		
		this.contadorDeTics++;
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			
			this.moverseEnDireccionActual();
			
			this.juego.getCelda(this.getPosicion()).comer();
			int puntos = this.juego.getCelda(this.getPosicion()).daPuntos();
			this.juego.sumarPuntos(puntos);
			
			
			if(this.juego.getCelda(this.getPosicion()).daPoder()){
				this.setVictimario();
				//TODO alterar fantasmas
			}
			
			this.checkFantasmaEnCelda();
		}
	}
	
	private void checkFantasmaEnCelda(){
		ListaFantasma fantasmas = this.juego.getFantasmas();
		for(int i=0; i< fantasmas.size(); i++){
			if(((Fantasma)(fantasmas.get(i))).getPosicion().equals(this.getPosicion()) && (this.estado == VICTIMARIO))
				((Fantasma)(fantasmas.get(i))).morir();
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
	
	private void setVictimario(){
		this.estado = VICTIMARIO;
	}
	private void setVictima(){
		this.estado = VICTIMA;
	}

	public double getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getEstado() {
		return this.estado;
	}
}
