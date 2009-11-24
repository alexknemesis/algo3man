package grupo9.algo3man.modelo;

import java.awt.Point;

public class CeldaPuerta extends CeldaTransitable {
	
	boolean transitable;
	final private int MAXIMO_DEJAR_PASAR= 3;
	int cantQuePaso; //TODO Cuenta la cantidad de fantasmas que pasaron
	
	public CeldaPuerta(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		this.transitable = true;
		this.cantQuePaso = 0;
	}

	public void transitar() {//TODO si los fantasmas que pasaron por la puerta son tres 
		this.cantQuePaso++;
		if (this.cantQuePaso == this.MAXIMO_DEJAR_PASAR){
			this.transitable = false;
		}
		
	}

	public boolean esTransitable() {
		
		return this.transitable;
	}

	

}
