package grupo9.algo3man.vista;

import java.awt.Point;

import grupo9.algo3man.titiritero.Posicionable;


/*
 * Transforma puntos en puntos-pixel
 */
public class PuntoPosicionable implements Posicionable {

	private Point punto;
	private static final int TRANSX = 30;
	private static final int TRANSY = 30;
	
	public PuntoPosicionable(Point punto){
		this.punto = punto;
	}
	
	public int getX() {
		return (int) (this.punto.getX()*TRANSX);
	}

	public int getY() {
		return (int) (this.punto.getY()*TRANSY);
	}

}
