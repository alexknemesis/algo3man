package grupo9.algo3man.controlador;

import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscuchadorDeTeclado implements KeyListener{
	Juego juego;
	public EscuchadorDeTeclado(Juego juego) {
		this.juego = juego;
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (juego !=null){
			switch (e.getKeyCode())	{
			case KeyEvent.VK_UP:
				juego.getPacman().moverArriba();

				break;
			case KeyEvent.VK_DOWN:
				juego.getPacman().moverAbajo();

				break;
			case KeyEvent.VK_LEFT:
				juego.getPacman().moverIzquierda();

				break;
			case KeyEvent.VK_RIGHT:
				juego.getPacman().moverDerecha();

				break;
			}
		}


	}

	public void keyReleased(KeyEvent arg0) {
		// No hace nada

	}

	public void keyTyped(KeyEvent arg0) {
		// No hace nada

	}
}
