package grupo9.algo3man.vista;

import java.awt.Color;

import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Circulo;

public class VistaPacman extends Circulo implements Dibujable{
	private Pacman pacman;
	private Algo3Man algo3man;
	final private static int RADIO = 30;
	
	public VistaPacman(Pacman pacman, Algo3Man ventana){
		super(RADIO);
		this.setColor(Color.YELLOW);
		this.setPosicionable(pacman);
		this.setVentanaPrincipal(ventana);
	}
	
	public void setVentanaPrincipal(Algo3Man ventana){
		this.algo3man = ventana;
	}
	
	public void dibujar(SuperficieDeDibujo superfice){
		super.dibujar(superfice);
		int vidas = this.pacman.getJuego().getVidas();
		this.algo3man.printVidas(vidas);
		int nivel = this.pacman.getJuego().getNivel();
		this.algo3man.printNivel(nivel);
		int puntos = this.pacman.getJuego().getPuntaje();
		this.algo3man.printPuntos(puntos);
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
