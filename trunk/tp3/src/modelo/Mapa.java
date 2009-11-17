package modelo;

import java.awt.Point;
import java.util.TreeMap;

public class Mapa {
	
		private TreeMap matriz;
		private Juego juego;
		private int puntosSinComer;
		private int N;
		private int M;
		
		public Mapa(int N,int M, Juego juego2){
			if(N<=0 | M<=0){
				throw new MapaConstruirException();
			}
			this.N = N;
			this.M = M;
			this.juego = juego2;
			this.puntosSinComer = (N*M);
			this.matriz = new TreeMap(new Comparador());
			
			
		}
		
		
		
		public void restarPunto(){
			if (this.puntosSinComer == 0){
				throw new RestarPuntoException();
			}
			this.puntosSinComer = this.puntosSinComer -1;
	
		}



		public void agregar(Point punto, Celda celda) {
			if(punto.x > N | punto.y > M){
				throw new RangoException();
			}
			this.matriz.put(punto, celda);
			
		}



		public int getPuntos() {
			
			return this.puntosSinComer;
		}



		public Celda getCelda(Point punto) {
			if(punto.x > N | punto.y > M){
				throw new RangoException();
			}
			return (Celda) this.matriz.get(punto);
		}



		public int getFilas() {
			
			return this.N;
		}



		public int getColumnas() {
			
			return M;
		}
}
