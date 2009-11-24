package grupo9.algo3man.modelo;



import java.awt.Point;
import grupo9.algo3man.modelo.Objetivo;

	public abstract class Celda implements Objetivo{
		protected Point posicion;

	
	/*public Celda(Mapa mapa){
		
	}*/
		
	public double getDistancia(Point posicion) {
		return this.posicion.distance(posicion);
	}
	
	public abstract boolean esTransitable();

}
