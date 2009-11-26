package grupo9.algo3man.test;

import java.awt.Point;

import grupo9.algo3man.modelo.Celda;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Premio;
import junit.framework.Assert;
import junit.framework.TestCase;

public class PremioTest extends TestCase {

	private Juego juego;
	private Celda miCelda;

	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.miCelda = new Premio(this.juego.getMapa(),new Point(9,12));
	}

	public void testTransitar() {
		this.miCelda.transitar();
		
		Assert.assertEquals(this.juego.getPuntaje(), 200);
	}

}
