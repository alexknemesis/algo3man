package grupo9.algo3man.modelo;

import java.awt.Point;

public abstract class CeldaPunto extends CeldaTransitable {
	
	boolean comido;
	public CeldaPunto(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		this.comido = false;
		
	}

	protected abstract void comer();
	//Cambia el estado comido a true y resta un punto en el mapa
				
	

}
