package grupo9.algo3man.modelo;



import java.awt.Point;
import grupo9.algo3man.modelo.Objetivo;

	public abstract class Celda implements Objetivo{
	
	/*public Celda(Mapa mapa){
		
	}*/
		
	public int getDistancia(Point posicion) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public abstract boolean esTransitable();

}
