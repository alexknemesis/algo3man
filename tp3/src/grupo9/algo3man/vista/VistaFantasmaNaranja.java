package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Circulo;

public class VistaFantasmaNaranja extends Circulo implements Dibujable {
	private Fantasma fantasma;
	final private static int RADIO = 3;
	
	public VistaFantasmaNaranja(Fantasma fantasma){
		super(RADIO);
		this.fantasma = fantasma;
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		if(this.fantasma.getEstado() == Fantasma.HUYENDO)
			this.setColor(Color.ORANGE);
		else
			this.setColor(Color.BLUE);
		
		//TODO definir posicion
		
	}

	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub
		
	}
}
