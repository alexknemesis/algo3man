package grupo9.algo3man.modelo;

import java.awt.Point;
import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.modelo.FantasmaCeleste;
import grupo9.algo3man.modelo.FantasmaVioleta;
import grupo9.algo3man.modelo.FantasmaRojo;
import grupo9.algo3man.modelo.FantasmaNaranja;

public class Mapa {
		final private int VELOCIDAD_INICIAL = 1;
		
		private Matriz matriz;
		private Juego juego;
		private Point iniPacman;
		private Point iniFantasmas;
		private Pacman pacman;
		private ListaFantasma fantasmas;
		private int puntosSinComer;
		private int puntajePremio;
		private Point posPreferidaRojo;
		private Point posPreferidaCeleste;
		private Point posPreferidaNaranja;
		private Point posFreferidaVioleta;
		
		public Mapa(int N,int M, Juego juego2,Point pacman,Point fantasmas ,int puntos){
			if(N<=0 | M<=0){
				throw new RangoException();
			}
			
			this.juego = juego2;
			this.puntosSinComer = puntos;
			this.matriz = new Matriz(N,M);
			this.iniFantasmas = fantasmas;
			this.iniPacman = pacman;
			this.fantasmas = new ListaFantasma();
			
		}
		
		public void crearPersonajes(){
			this.pacman = new Pacman(this.iniPacman, VELOCIDAD_INICIAL,Pacman.IZQUIERDA, this.juego);
			
			this.fantasmas.add(new FantasmaCeleste(this.iniFantasmas, this.getCelda(this.posPreferidaCeleste), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			this.fantasmas.add(new FantasmaRojo(this.iniFantasmas, this.getCelda(this.posPreferidaRojo), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			this.fantasmas.add(new FantasmaNaranja(this.iniFantasmas, this.getCelda(this.posPreferidaNaranja), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			this.fantasmas.add(new FantasmaVioleta(this.iniFantasmas, this.getCelda(this.posFreferidaVioleta), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			
		}
		
		public Pacman getPacman(){
			return this.pacman;
		}
		public ListaFantasma getFantasmas(){
			return this.fantasmas;
		}
		
		public void restarPunto(){
			if (this.puntosSinComer == 0){
				throw new RestarPuntoException();
			}
			this.puntosSinComer = this.puntosSinComer -1;
			if(this.puntosSinComer == 0)
				this.juego.avanzarNivel();
		}

		public void agregar(Point punto, Celda celda) {
			
			try{
				this.matriz.agregar(celda, punto.x, punto.y);
			}catch (RangoException e){
				throw new RangoException();
			}
		}

		public int getPuntos() {		
			return this.puntosSinComer;
		}

		public Celda getCelda(Point punto) {
			Celda celda = null;
			try{
				celda = this.matriz.getCelda(punto.x, punto.y);
			}catch (RangoException e){
				throw new RangoException();
			}catch (NullPointerException e){
				System.out.println("hola");
			}
			
			return celda;
		}

		public int getN() {
			
			return this.matriz.getFilas();
		}

		public int getM() {
			
			return this.matriz.getColumnas();
		}

		public Juego getJuego() {
			return this.juego;
			
		}
		
		public void setPuntajePremio(int puntos) {
			this.puntajePremio = puntos;
			
		}

		public int getPuntajePremio() {
			
			return this.puntajePremio;
		}

		public Point getPosicionInicialFantasmas() {
			
			return this.iniFantasmas;
		}

		public Point getPosicionInicialPacman() {
			
			return this.iniPacman;
		}

		public void setPosPreferidaRojo(Point posPreferidaRojo) {
			this.posPreferidaRojo = posPreferidaRojo;
		}

		public Point getPosPreferidaRojo() {
			return posPreferidaRojo;
		}

		public void setPosPreferidaCeleste(Point posPreferidaCeleste) {
			this.posPreferidaCeleste = posPreferidaCeleste;
		}

		public Point getPosPreferidaCeleste() {
			return posPreferidaCeleste;
		}

		public void setPosPreferidaNaranja(Point posPreferidaNaranja) {
			this.posPreferidaNaranja = posPreferidaNaranja;
		}

		public Point getPosPreferidaNaranja() {
			return posPreferidaNaranja;
		}

		public void setPosFreferidaVioleta(Point posFreferidaVioleta) {
			this.posFreferidaVioleta = posFreferidaVioleta;
		}

		public Point getPosFreferidaVioleta() {
			return posFreferidaVioleta;
		}

}
