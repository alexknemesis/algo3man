package modelo;

import java.util.ArrayList;



public class Juego {
	
	final private int VIDAS_INICIALES = 3;
	final private int NIVEL_INICIAL = 1;
	
	private int nivel;
	private int puntaje;
	private int vidas;
	private Mapa mapa;
	private Pacman pacman;
	private ArrayList fantasmas;
	
	public Juego(){
		this.nivel = NIVEL_INICIAL;
		this.puntaje = 0;
		this.vidas = VIDAS_INICIALES;
		
		this.mapa = FabricaDeMapas.obtenerMapa(1);
		
		this.fantasmas = new ArrayList<Fantasma>();
		this.fantasmas.add(new FantasmaRojo());
		// TODO agregar fantasmas
		
		this.pacman = new Pacman(0, 0, 10, this);
	}
	
	public void avanzarNivel(){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.nivel++;
		// TODO que pasa cuando se avanza un nivel?
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
	}
	
	public Celda getCelda(int x, int y){
		return null;
		
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
	
	public int getVidas(){
		return this.vidas;
	}

}
