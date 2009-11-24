package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaPared extends Celda {

	public CeldaPared(Mapa mapa,Point posicion) {
		
		super(mapa, posicion);
		
	}

	public boolean esTransitable() {
		
		return false;
	}

	
	


}
