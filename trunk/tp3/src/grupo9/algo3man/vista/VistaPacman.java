package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Circulo;

public class VistaPacman extends Circulo implements Dibujable{
	private Pacman pacman;
	final private static int RADIO = 3;
	
	public VistaPacman(Pacman pacman){
		super(RADIO);
		this.setColor(Color.YELLOW);
		this.pacman = pacman;
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		// TODO posicion
		
	}

	@Override
	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub
		
	}
}
