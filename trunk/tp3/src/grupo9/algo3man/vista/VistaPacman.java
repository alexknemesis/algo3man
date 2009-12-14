package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.vista.Circulo;

public class VistaPacman extends Circulo implements Dibujable{
	private Pacman pacman;
	final private static int RADIO = 30;
	
	public VistaPacman(Pacman pacman){
		super(RADIO);
		this.setColor(Color.YELLOW);
		this.setPosicionable(pacman);
	}

	@Override
	public Posicionable getPosicionable() {
		return new PuntoPosicionable(this.pacman.getPosicion());
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.pacman = (Pacman) posicionable;
	}
}
