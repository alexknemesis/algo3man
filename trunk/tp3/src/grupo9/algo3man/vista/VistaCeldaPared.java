package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.CeldaPared;
import grupo9.algo3man.modelo.CeldaPunto;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Cuadrado;

public class VistaCeldaPared extends Cuadrado implements Dibujable {
	
	private CeldaPared celda;
	
	public VistaCeldaPared(int ancho, int alto, CeldaPared celda) {
		super(ancho, alto);
		this.setColor(Color.RED);
		this.setPosicionable(celda);
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		
	}

	public Posicionable getPosicionable() {
		return this.celda;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.celda = (CeldaPared) posicionable;
	}
	
}
