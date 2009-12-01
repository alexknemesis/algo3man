package grupo9.algo3man.modelo;

import java.awt.Point;

public class Mapa {
	
		private Matriz matriz;
		private Juego juego;
		private Point iniPacman;
		private Point iniFantasmas;
		private Point iniFanRojo;
		private int puntosSinComer;
		private int puntajePremio;//TODO El puntaje de los premios se setea segï¿½n el nivel
		
		
		public Mapa(int N,int M, Juego juego2,Point pac, Point rojo,Point fan,int puntos){
			if(N<=0 | M<=0){
				throw new RangoException();//TODO agregué que setee la cantidad de puntos
			}
			
			this.juego = juego2;
			this.puntosSinComer = puntos;
			this.matriz = new Matriz(N,M);
			this.iniFanRojo = rojo;
			this.iniFantasmas = fan;
			this.iniPacman = pac;
			
			
		}
		



		public void restarPunto(){
			if (this.puntosSinComer == 0){
				throw new RestarPuntoException();
			}
			this.puntosSinComer = this.puntosSinComer -1;
	
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
			Celda celda;
			try{
				celda =this.matriz.getCelda(punto.x, punto.y);
			}catch (RangoException e){
				throw new RangoException();
			}
			
			return celda;
		}



		public int getFilas() {
			
			return this.matriz.getFilas();
		}



		public int getColumnas() {
			
			return this.matriz.getColumnas();
		}




		public Juego getJuego() { //TODO Obtiene el juego
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




		public Point getPosicionInicialFantasmaRojo() {
			
			return this.iniFanRojo;
		}
		
	
}
