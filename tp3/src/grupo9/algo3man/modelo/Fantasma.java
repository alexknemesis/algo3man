package grupo9.algo3man.modelo;

import java.awt.Point;


public abstract class Fantasma extends Personaje {
	public static final int CAZANDO = 1; 
	public static final int DISPERSO = 2; 
	public static final int HUYENDO = 3; 
	
	protected Objetivo objetivoActual;
	protected Objetivo celdaPreferida;
	
	protected int estado;
	
	
	public void vivir() {
		// TODO Esto es una versión primitiva de la implementación del contador
		// de tics, pero igual no creo que tenga mucha más vuelta..
		
		this.contadorDeTics++;
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			//TODO Comerse o ser comido por el pacman de acuerdo al estado

			this.direccion = determinarSiguienteDireccion();
			this.moverseEnDireccionActual();
			//TODO Comerse o ser comido por el pacman de acuerdo al estado

		}

	}
	
	// Seteo de las distintas estrategias del Pacman
	public void cazarAlPacman(){
		this.estado = CAZANDO;
	}

	public void huirDelPacman(){
		this.estado = HUYENDO;
	}
	
	public void dispersarse(){
		this.estado = DISPERSO;
		this.objetivoActual= celdaPreferida;
	}
	
	public int getEstado(){
		return this.estado;
	}
		
	public Fantasma(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
	}
	
	protected int direccionParaMinimaDistanciaA(Objetivo objetivo){
		//TODO
		return 0;
	}

	protected int direccionParaMaximaDistanciaA(Objetivo objetivo){
		//TODO
		return 0;
	}
	
	protected abstract int determinarSiguienteDireccion();
	
}
