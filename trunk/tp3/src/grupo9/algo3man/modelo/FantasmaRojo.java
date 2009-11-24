package grupo9.algo3man.modelo;

import java.awt.Point;



/**
 * @author cripton
 *
 */
public class FantasmaRojo extends Fantasma {

	public FantasmaRojo(Point posicionInicial, int velocidad, int direccion, Juego juego) {
		super(posicionInicial, velocidad, direccion, juego);
	}

	public void morir() {
		// TODO Auto-generated method stub

	}

	protected int determinarSiguienteDireccion() {
		// TODO Auto-generated method stub
		return 0;
	}

}
