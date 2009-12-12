package grupo9.algo3man.modelo;

import java.awt.Point;

public class Pacman extends Personaje {
	public static final int VICTIMA = 1; 
	public static final int VICTIMARIO = 2; 
	protected static final int TICS_PARA_VOLVER_A_VICTIMA = 10; 
	
	private int estado;
	protected int ticsParaCambiarDeEstado;

	public Pacman(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
		this.estado = VICTIMA;
		this.ticsParaCambiarDeEstado = 0;
	}
	
	public void reiniciar(){
		this.setPosicion(this.posicionInicial);
		this.setVictima();
	}

	public void morir() {
		this.getJuego().restarVida();
	}

	public void vivir() {
		
		
		this.checkFantasmaEnCelda();
		/*ACTUALIZACIÓN 12/12 LUCAS: El pacman tiene un tic para que de VICTIMARIO vuelva a VICTIMA 
		 * sino iba a estar siempre en VICTIMA.
		 * 
		 */
		if (this.getEstado()==VICTIMARIO){
			if (this.ticsParaCambiarDeEstado < TICS_PARA_VOLVER_A_VICTIMA){
				this.ticsParaCambiarDeEstado++;
			}
			if (this.ticsParaCambiarDeEstado >= TICS_PARA_VOLVER_A_VICTIMA){
				this.setVictima();
			}
		}
		
		
		this.contadorDeTics++;
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			
			this.moverseEnDireccionActual();
			
			
			int puntos = this.juego.getCelda(this.getPosicion()).daPuntos();
			this.juego.sumarPuntos(puntos);
			
			
			if(this.juego.getCelda(this.getPosicion()).daPoder()){
				this.setVictimario();
				/*
				 * ACTUALIZACIÓN 12/12 LUCAS: El pacman no cambia el estado de los fantasmas, ellos lo 
				 * chequean en su vivir
				 */
			}
			//Debería estar aca está línea porque si comés primero no da puntos ni cambia el estado en caso de ser PuntoPoder
			this.juego.getCelda(this.getPosicion()).comer();
			
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
		this.ticsParaCambiarDeEstado = 0;
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
