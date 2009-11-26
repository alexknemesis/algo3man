package grupo9.algo3man.modelo;

import java.awt.Point;
import java.util.ArrayList;



public class Juego {
	
	final private int VIDAS_INICIALES = 3;
	final private int NIVEL_INICIAL = 0;
	final private int VELOCIDAD_INICIAL = 1;
	final private int PUNTOS_NIVEL_GANADO = 1000;
	
	private int nivel;
	private int puntaje;
	private int vidas;
	private Mapa mapa;
	private Pacman pacman;
	private ArrayList fantasmas;
	private Point dimensionesMapa;
	
	
	public Juego(){
		this.nivel = NIVEL_INICIAL;
		this.puntaje = 0;
		this.vidas = VIDAS_INICIALES;
		
		this.mapa = FabricaDeMapas.obtenerMapa(this.nivel, this);
		
		//TODO setear posicion inicial de los fantasmas y el pacman desde el mapa.
		this.fantasmas = new ArrayList();
		this.fantasmas.add(new FantasmaRojo(new Point(0,0), VELOCIDAD_INICIAL,Fantasma.DERECHA, this));
		this.fantasmas.add(new FantasmaCeleste(new Point(0,0), VELOCIDAD_INICIAL,Fantasma.DERECHA, this));
		this.fantasmas.add(new FantasmaNaranja(new Point(0,0), VELOCIDAD_INICIAL,Fantasma.DERECHA, this));
		this.fantasmas.add(new FantasmaVioleta(new Point(0,0), VELOCIDAD_INICIAL,Fantasma.DERECHA, this));
		
		this.pacman = new Pacman(new Point(0,0), VELOCIDAD_INICIAL,Pacman.IZQUIERDA, this);
		
		//Para saber el tamaño del mapa
		this.dimensionesMapa = new Point(this.mapa.getColumnas(), this.mapa.getFilas());
	}
	
	public void avanzarNivel(){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.nivel++;
		this.reiniciarPersonajes();
		this.sumarPuntos(PUNTOS_NIVEL_GANADO);
	}
	
	public void sumarPuntos(int puntos){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.puntaje += puntos;
	}
	
	public void restarVida(){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.vidas--;
		this.reiniciarPersonajes();
	}
	
	public void reiniciarPersonajes(){
		this.pacman.reiniciar();
		for(int i=0; i< this.fantasmas.size(); i++){
			((Fantasma)(this.fantasmas.get(i))).reiniciar();
		}
	}
	
	public Celda getCelda(int x, int y){
		return this.getCelda(new Point(x, y));
	}
	
	public Celda getCelda(Point punto){
		return this.mapa.getCelda(punto);
	}
	
	public boolean isGameOver(){
		if(this.vidas == 0)
			return true;
		return false;
	}
	
	public int getNivel(){
		return this.nivel;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	public Pacman getPacman(){
		return this.pacman;
	}
	
	public int getVidas(){
		return this.vidas;
	}
	
	public ArrayList getFantasmas(){
		return this.fantasmas;
	}
	public Point getDimensiones(){
		return this.dimensionesMapa;
	}



	

}
