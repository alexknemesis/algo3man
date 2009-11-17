package modelo;

import java.awt.Point;
import java.util.Dictionary;

public class Mapa {
	
		private Dictionary matriz;
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
			
			
		}
		
		
		
		public void restarPunto(){
			if (this.puntosSinComer == 0){
				throw new RestarPuntoException();
			}
			this.puntosSinComer = this.puntosSinComer -1;
	
		}



		public void agregar(Point punto, Celda celda) {
			
			
		}



		public int getPuntos() {
			
			return this.puntosSinComer;
		}



		public Point getCelda(Point punto) {
			
			return null;
		}



		public int getFilas() {
			
			return this.N;
		}



		public int getColumnas() {
			
			return M;
		}
}
