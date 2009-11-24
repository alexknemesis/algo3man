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
	}
	
	public int getEstado(){
		return this.estado;
	}
		
	public Fantasma(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
	}
	
	protected int direccionParaMinimaDistanciaA(Objetivo objetivo){
		int direccionAMinimaDistancia;
		double distanciaMinima;
		Celda [] celdasAlrededor;
			
		//Inicializo la variable con la máxima distancia que puede existir en el juego
		distanciaMinima = juego.getDimensiones().distance(new Point(0,0));

		direccionAMinimaDistancia = -1;
		
		celdasAlrededor = new Celda[4];
		
		celdasAlrededor[ARRIBA] = juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[ABAJO] = juego.getCelda(this.posicion.x,this.posicion.y + 1);
		celdasAlrededor[IZQUIERDA] = juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[DERECHA] = juego.getCelda(this.posicion.x,this.posicion.y + 1);
		
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
		distanciaMaxima = juego.getDimensiones().distance(new Point(0,0));

		direccionAMaximaDistancia = -1;
		
		celdasAlrededor = new Celda[4];
		
		celdasAlrededor[ARRIBA] = juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[ABAJO] = juego.getCelda(this.posicion.x,this.posicion.y + 1);
		celdasAlrededor[IZQUIERDA] = juego.getCelda(this.posicion.x,this.posicion.y - 1);
		celdasAlrededor[DERECHA] = juego.getCelda(this.posicion.x,this.posicion.y + 1);
		
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
