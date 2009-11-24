package grupo9.algo3man.modelo;

import java.awt.Point;

public class Mapa {
	
		private Matriz matriz;
		private Juego juego;
		private int puntosSinComer;
		private int puntajePremio;//El puntaje de los premios se setea según el nivel
		
		
		public Mapa(int N,int M, Juego juego2){
			if(N<=0 | M<=0){
				throw new RangoException();
			}
			
			this.juego = juego2;
			this.puntosSinComer = (N*M);
			this.matriz = new Matriz(N,M);
			
			
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




		public Juego getJuego() {
			return this.juego;
			
		}
		
		public void setPuntajePremio(int puntos) {
			this.puntajePremio = puntos;
			
		}




		public int getPuntajePremio() {
			
			return this.puntajePremio;
		}
}
