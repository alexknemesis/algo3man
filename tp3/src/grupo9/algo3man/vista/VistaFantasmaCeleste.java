package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Circulo;

public class VistaFantasmaCeleste extends Circulo implements Dibujable {
	private Fantasma fantasma;
	
	final private static int RADIO = 30;
	
	public VistaFantasmaCeleste(Fantasma fantasma){
		super(RADIO);
		this.setPosicionable(fantasma);
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		if(this.fantasma.getEstado() == Fantasma.HUYENDO)
			this.setColor(Color.CYAN);
		else
			this.setColor(Color.BLUE);
		
		super.dibujar(superfice);
	}

	public Posicionable getPosicionable() {
		return this.fantasma;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.fantasma = (Fantasma) posicionable;
	}
}
