package grupo9.algo3man.test;

import grupo9.algo3man.modelo.Juego;
import junit.framework.Assert;
import junit.framework.TestCase;

public class PuntoOrdinarioTest extends TestCase {

	private Juego juego;
	

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		
	}

	public void testTransitar() {
		this.juego.getCelda(9, 9).transitar();
		Assert.assertEquals(this.juego.getPuntaje(), 10);

	}

}
