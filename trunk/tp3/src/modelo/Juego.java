package modelo;

import java.awt.Point;
import java.util.ArrayList;

public class Juego {
	
	final vidasIniciales = 3;
	final nivelInicial = 1;
	
	private int nivel;
	private int puntaje;
	private int vidas;
	private Mapa mapa;
	private Pacman pacman;
	private ArrayList fantasmas;
	
	public Juego(){
		this.nivel = nivelInicial;
		this.puntaje = 0;
		this.vidas = vidasIniciales;
		
		this.mapa = FabricaDeMapas.obtenerMapa();
		
		this.fantasmas = new ArrayList();
		this.fantasmas.add(new FantasmaRojo());
		// TODO agregar fantasmas
		
		this.pacman = new Pacman();
	}
	
	public void avanzarNivel(){
		if(this.isGameOver())
			throw new Exception();
		
		this.nivel++;
		// TODO que pasa cuando se avanza un nivel?
	}
	
	public void sumarPuntos(puntos){
		if(this.isGameOver())
			throw new Exception();
		
		this.puntaje += puntos;
	}
	
	public void restarVida(){
		if(this.isGameOver())
			throw new Exception();
		
		this.vidas--;
	}
	
	public Celda getCelda(Point punto){
		return null;
		
	}
	
	public bool isGameOver(){
		if(this.vidas == 0)
			return true;
		return false;
	}

}
