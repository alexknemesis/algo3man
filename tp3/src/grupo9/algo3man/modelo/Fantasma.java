package grupo9.algo3man.modelo;

import java.awt.Point;


public abstract class Fantasma extends Personaje {
	public static final int CAZANDO = 1; 
	public static final int DISPERSO = 2; 
	public static final int HUYENDO = 3; 
	
	protected static final int TICS_ANTES_DE_CAZAR = 20; 
	
	protected Objetivo objetivoActual;
	protected Objetivo celdaPreferida;
	//protected Pacman pacman;
	
	protected int estado;
	protected int ticsParaSalirDeDisperso;
	protected int contadorTicsParaSalirDeDisperso;
	
	public Fantasma(Point posicionInicial, Celda celdaPreferida, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
		this.celdaPreferida = celdaPreferida;
		this.dispersarse();
	}
	
	public void morir(){
		this.reiniciar();
	}
	
	public void vivir() {
		
		this.checkPacmanEnCelda();
		
		/* ACTUALIZACION: El fantasma sabe cuando cambia de estado, empezando en
		 * modo DISPERSO
		 */
		
		if (this.contadorTicsParaSalirDeDisperso < this.ticsParaSalirDeDisperso){
			this.contadorTicsParaSalirDeDisperso++;
		}

		// Esto es una versión primitiva de la implementación del contador
		// de tics, pero igual no creo que tenga mucha más vuelta..

		this.contadorDeTics++;
		
		if (this.contadorDeTics == this.velocidad){
			this.contadorDeTics = 0;
			
			/*ACTUALIZACION: El fantasma setea su propio estado de acuerdo al
			 * estado del Pacman.
			 */
			determinarEstado();
			
			this.direccion = determinarSiguienteDireccion();	
			this.moverseEnDireccionActual();
			
			this.checkPacmanEnCelda();
			
		}

	}
	
	private void determinarEstado() {
		//Cambia el estado solo si salió del modo disperso
		if(this.contadorTicsParaSalirDeDisperso == this.ticsParaSalirDeDisperso){
			if (juego.getPacman().getEstado() == Pacman.VICTIMA){ 
				this.cazarAlPacman();
			}else{
				this.huirDelPacman();
			}
		}
	}

	private void checkPacmanEnCelda(){
		Point posicionPacman = this.juego.getPacman().getPosicion();
		if(this.getPosicion().equals(posicionPacman)){
			if(this.estado != HUYENDO)
				this.juego.getPacman().morir();
		}
	}
	
	public void reiniciar(){
		this.setPosicion(this.posicionInicial);
		this.dispersarse();
	}
	
	// Seteo de las distintas estrategias del Pacman
	/* ACTUALIZACION: nadie le dice al fantasma lo que tiene que hacer!
	 * (paso métodos de caza a protected)
	 */
	protected void cazarAlPacman(){
		this.estado = CAZANDO;
	}

	protected void huirDelPacman(){
		this.estado = HUYENDO;
	}
	
	protected void dispersarse(){
		this.estado = DISPERSO;
		this.contadorTicsParaSalirDeDisperso = 0;
	}
	
	public int getEstado(){
		return this.estado;
	}
		
	protected int direccionParaMinimaDistanciaA(Objetivo objetivo){
		int direccionAMinimaDistancia;
		double distanciaMinima;
		Celda [] celdasAlrededor;
			
		//Inicializo la variable con la máxima distancia que puede existir en el juego
		distanciaMinima = this.juego.getDimensiones().distance(new Point(0,0));

		direccionAMinimaDistancia = -1;
		
		celdasAlrededor = new Celda[4];
		
		celdasAlrededor[ARRIBA] = this.juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[ABAJO] = this.juego.getCelda(this.posicion.x,this.posicion.y + 1);
		celdasAlrededor[IZQUIERDA] = this.juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[DERECHA] = this.juego.getCelda(this.posicion.x,this.posicion.y + 1);
		
		//Descarto moverme hacia atrás
		celdasAlrededor[direccionContraria(this.direccion)]= null;
		
		for (int i = 0; i<4; i++){
			if(celdasAlrededor[i] != null)
				if(celdasAlrededor[i].esTransitable())
					if (objetivo.getDistancia(celdasAlrededor[i].getPosicion()) < distanciaMinima){
						distanciaMinima =objetivo.getDistancia(celdasAlrededor[i].getPosicion());
						direccionAMinimaDistancia = i;
					}
		}
		
		if (direccionAMinimaDistancia != -1){
			return direccionAMinimaDistancia; //Encontró una dirección nueva
		}
		return direccionContraria(this.direccion); //Encontró una pared y debe dar vuelta
	}
	
	private int direccionContraria(int direccion){
		int irA=0;
		
		switch (this.direccion){
			case ARRIBA: irA = ABAJO;break;
			case ABAJO: irA = ARRIBA;break;
			case IZQUIERDA: irA = DERECHA;break;
			case DERECHA: irA = IZQUIERDA;break;
		}
		return irA;
		
	}
	
	protected int direccionParaMaximaDistanciaA(Objetivo objetivo){
		int direccionAMaximaDistancia;
		double distanciaMaxima;
		Celda [] celdasAlrededor;
			
		//Inicializo la variable con la máxima distancia que puede existir en el juego
		distanciaMaxima = this.juego.getDimensiones().distance(new Point(0,0));

		direccionAMaximaDistancia = -1;
		
		celdasAlrededor = new Celda[4];
		
		celdasAlrededor[ARRIBA] = this.juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[ABAJO] = this.juego.getCelda(this.posicion.x,this.posicion.y + 1);
		celdasAlrededor[IZQUIERDA] = this.juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[DERECHA] = this.juego.getCelda(this.posicion.x,this.posicion.y + 1);
		
		//Descarto moverme hacia atrás
		celdasAlrededor[direccionContraria(this.direccion)]= null;
		
		for (int i = 0; i<4; i++){
			if(celdasAlrededor[i] != null)
				if(celdasAlrededor[i].esTransitable())
					if (objetivo.getDistancia(celdasAlrededor[i].getPosicion()) > distanciaMaxima){
						distanciaMaxima =objetivo.getDistancia(celdasAlrededor[i].getPosicion());
						direccionAMaximaDistancia = i;
					}
		}
		
		if (direccionAMaximaDistancia != -1){
			return direccionAMaximaDistancia; //Encontró una dirección nueva
		}
		return direccionContraria(this.direccion); //Encontró una pared y debe dar vuelta
	}
	
	protected abstract int determinarSiguienteDireccion();
	
}