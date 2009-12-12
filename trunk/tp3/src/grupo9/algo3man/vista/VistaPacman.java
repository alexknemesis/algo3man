package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Circulo;

public class VistaPacman extends Circulo implements Dibujable{
	private Posicionable pacman;
	final private static int RADIO = 3;
	
	public VistaPacman(Pacman pacman){
		super(RADIO);
		this.setColor(Color.YELLOW);
		this.setPosicionable(this.pacman);
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		
	}

	@Override
	public Posicionable getPosicionable() {
		return this.pacman;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		this.pacman = posicionable;
	}
}
