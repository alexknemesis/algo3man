package grupo9.algo3man.modelo;

import java.awt.Point;

public class Premio extends CeldaPunto {
	
	public Premio(Mapa mapa, Point posicion) {
		super(mapa, posicion);
		
	}

	protected void comer() {
		this.comido = true;
		this.mapa.restarPunto();
		
	}

	public void transitar() {
		this.comer();
		this.mapa.getJuego().sumarPuntos(this.mapa.getPuntajePremio());
		
	}

	public boolean esTransitable() {
		
		return true;
	}

	public boolean daPoder() {
		// TODO Auto-generated method stub
		return false;
	}

	public int daPuntos() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
