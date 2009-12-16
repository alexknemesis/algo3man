package grupo9.algo3man.modelo;

import java.awt.Point;

public class Pacman extends Personaje {
	public static final int VICTIMA = 1; 
	public static final int VICTIMARIO = 2; 
	protected static final int TICS_PARA_VOLVER_A_VICTIMA = 10; 
	
	private int direccionFutura;
	private int estado;
	protected int ticsParaCambiarDeEstado;

	public Pacman(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
		this.estado = VICTIMA;
		this.ticsParaCambiarDeEstado = 0;
		this.direccionFutura = this.direccion;
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
		/*ACTUALIZACI�N 12/12 LUCAS: El pacman tiene un tic para que de VICTIMARIO vuelva a VICTIMA 
		 * sino iba a estar siempre en VICTIMA.
		 * 
		 */
		
		
		this.contadorDeTics++;
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			
			if (this.getEstado()==VICTIMARIO){
				if (this.ticsParaCambiarDeEstado < TICS_PARA_VOLVER_A_VICTIMA){
					this.ticsParaCambiarDeEstado++;
				}
				if (this.ticsParaCambiarDeEstado >= TICS_PARA_VOLVER_A_VICTIMA){
					this.setVictima();
				}
			}
			
			this.checkDireccion();
			this.moverseEnDireccionActual();
			
			
			int puntos = this.juego.getCelda(this.getPosicion()).daPuntos();
			this.juego.sumarPuntos(puntos);
			
			
			if(this.juego.getCelda(this.getPosicion()).daPoder()){
				this.setVictimario();
				/*
				 * ACTUALIZACI�N 12/12 LUCAS: El pacman no cambia el estado de los fantasmas, ellos lo 
				 * chequean en su vivir
				 */
			}
			//Deber�a estar aca est� l�nea porque si com�s primero no da puntos ni cambia el estado en caso de ser PuntoPoder
			this.juego.getCelda(this.getPosicion()).comer();
			
			this.checkFantasmaEnCelda();
		}
	}
	
	private void checkDireccion() {
		Point proximoLugar = new Point(this.posicion);
		
		switch (direccionFutura){
		case ARRIBA:
			proximoLugar.y -= 1;
			break;
		case ABAJO:
			proximoLugar.y += 1;			
			break;
		case DERECHA:   
			proximoLugar.x += 1;
			break;
		case IZQUIERDA:   
			proximoLugar.x -= 1;
			break;
		}

		if(this.getJuego().getCelda(proximoLugar)!= null){
			if (this.getJuego().getCelda(proximoLugar).esTransitable())
				this.direccion = this.direccionFutura;
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
		this.setDireccionFutura(DERECHA);
	}
	
	public void moverIzquierda(){
		this.setDireccionFutura(IZQUIERDA);
	}
	
	public void moverAbajo(){
		this.setDireccionFutura(ABAJO);
	}
	public void moverArriba(){
		this.setDireccionFutura(ARRIBA);
	}
	
	public void setDireccionFutura(int direccion){
		this.direccionFutura = direccion;
	}
	
	private void setVictimario(){
		this.estado = VICTIMARIO;
		this.ticsParaCambiarDeEstado = 0;
	}
	private void setVictima(){
		this.estado = VICTIMA;
	}

	public double getDistancia(Point posicion) {
		
		return 0;
	}

	public int getEstado() {
		return this.estado;
	}
	
	public void setVelocidad(int vel){
		this.velocidad = vel;
	}
}
