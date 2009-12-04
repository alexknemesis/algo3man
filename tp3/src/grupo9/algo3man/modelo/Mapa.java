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
			
			this.fantasmas.add(new FantasmaCeleste(this.iniFantasmas, this.getCelda(new Point (1,1)), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			this.fantasmas.add(new FantasmaRojo(this.iniFantasmas, this.getCelda(new Point (1,1)), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			this.fantasmas.add(new FantasmaNaranja(this.iniFantasmas, this.getCelda(new Point (1,1)), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			this.fantasmas.add(new FantasmaVioleta(this.iniFantasmas, this.getCelda(new Point (1,1)), VELOCIDAD_INICIAL,Fantasma.DERECHA, this.juego));
			// TODO cambiar posicion preferida
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

		public int getFilas() {
			
			return this.matriz.getFilas();
		}

		public int getColumnas() {
			
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

}
