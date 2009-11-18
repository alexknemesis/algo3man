package modelo;

public class Pacman extends Personaje {

	public Pacman(int x, int y, int velocidad, Juego juego) {
		super(x, y, velocidad, juego);
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
}
