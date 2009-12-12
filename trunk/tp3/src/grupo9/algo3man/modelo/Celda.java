package grupo9.algo3man.modelo;



import java.awt.Point;

import grupo9.algo3man.modelo.Objetivo;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.vista.PuntoPosicionable;

	public abstract class Celda implements Objetivo, Posicionable{
		
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
	
	public int getX(){
		PuntoPosicionable posicionable = new PuntoPosicionable(this.posicion);
		return posicionable.getX();
	}
	public int getY(){
		PuntoPosicionable posicionable = new PuntoPosicionable(this.posicion);
		return posicionable.getY();
	}

	public abstract boolean esTransitable();

	public abstract boolean daPoder();
	public abstract int daPuntos();
	
	protected void comer(){
		
	}

}
