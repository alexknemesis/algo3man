package grupo9.algo3man.modelo;

import grupo9.algo3man.titiritero.ControladorJuego;
import grupo9.algo3man.vista.VistaPacman;

import java.awt.Point;

public class Juego {
	
	final private int VIDAS_INICIALES = 3;
	final private int NIVEL_INICIAL = 0;
	final private int PUNTOS_NIVEL_GANADO = 1000;
	
	private int nivel;
	private int puntaje;
	private int vidas;
	private Mapa mapa;
	private ControladorJuego controlador;
	
	public Juego(){
		this.nivel = NIVEL_INICIAL;
		this.puntaje = 0;
		this.vidas = VIDAS_INICIALES;
		
		this.mapa = FabricaDeMapas.obtenerMapa(this.nivel, this);
		this.controlador = new ControladorJuego();
		this.controlador.agregarObjetoVivo(this.getPacman());
		
		ListaFantasma fantasmas = this.getFantasmas();
		for(int i=0; i<fantasmas.size(); i++){
			this.controlador.agregarObjetoVivo(fantasmas.get(i));
		}
		
		this.controlador.agregarDibujable(new VistaPacman(this.getPacman()));
		
		//TODO agregar vistas de fantasmas
		
		this.controlador.comenzarJuego();
	}
	
	public void avanzarNivel(){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.nivel++;
		this.sumarPuntos(PUNTOS_NIVEL_GANADO);
		
		// TODO cambiar mapa
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
		this.mapa.getPacman().reiniciar();
		for(int i=0; i< this.mapa.getFantasmas().size(); i++){
			((Fantasma)(this.mapa.getFantasmas().get(i))).reiniciar();
		}
	}

	public Celda getCelda(Point punto){
		Celda celdaTrucha = null;
		try{
			celdaTrucha = this.mapa.getCelda(punto);
		}catch(RangoException e){
			
		}
		return celdaTrucha;
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
	
	public Pacman getPacman(){
		return this.mapa.getPacman();
	}
	public ListaFantasma getFantasmas(){
		return this.mapa.getFantasmas();
	}
	public Point getDimensiones(){
		return new Point(this.mapa.getN(), this.mapa.getM());
	}

	public Mapa getMapa() { // Para que? Deberia ser transparente.
		return this.mapa;
	}

}
