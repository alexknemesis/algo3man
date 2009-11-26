package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaPuerta extends CeldaTransitable {//TODO Es transitable una única vez cuando salen los fantasmas de las casitas
	
	
	
	public CeldaPuerta(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	public void transitar() {//TODO No hace nada porque aunque transita no es transitable 
		
		
		
	}

	public boolean esTransitable() {
		
		
		
		return false;
	}

	

}
