package grupo9.algo3man.modelo;



import java.awt.Point;

import grupo9.algo3man.modelo.Objetivo;

	public abstract class Celda implements Objetivo{
		
		Mapa mapa;
		protected Point posicion;
	
	public Celda(Mapa mapa,Point posicion){
		this.mapa = mapa;
		this.posicion = posicion;
	}
		
	public double getDistancia(Point posicion) {
		return this.posicion.distance(posicion);
	}

	public Point getPosicion() {
		return posicion;
	}

	public abstract boolean esTransitable();

	public abstract boolean daPoder();
	public abstract int daPuntos();
	
	public void comer(){
		
	}

}
