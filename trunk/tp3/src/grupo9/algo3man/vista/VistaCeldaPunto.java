package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.CeldaPunto;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Cuadrado;

public class VistaCeldaPunto extends Cuadrado implements Dibujable {

	private CeldaPunto celda;
	
	public VistaCeldaPunto(int ancho, int alto, CeldaPunto celda) {
		super(ancho, alto);
		this.setColor(Color.BLACK);
		this.setPosicionable(celda);
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
		if(this.celda.isComido())
			this.setColor(Color.BLACK);
		else{
			if(this.celda.daPoder())
				this.setColor(Color.MAGENTA);
			else
				this.setColor(Color.ORANGE);				
		}
		super.dibujar(superfice);
	}

	public Posicionable getPosicionable() {
		return new PuntoPosicionable(this.celda.getPosicion());
	}

	public void setPosicionable(Posicionable posicionable) {
		this.celda = (CeldaPunto) posicionable;
	}

}
