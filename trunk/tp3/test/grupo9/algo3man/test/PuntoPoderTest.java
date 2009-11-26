package grupo9.algo3man.test;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.Juego;
import junit.framework.Assert;
import junit.framework.TestCase;

public class PuntoPoderTest extends TestCase {

	private Juego juego;

	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
	}

	public void testTransitar() {
		
		
		this.juego.getCelda(13, 2).transitar();
		Fantasma f1 = (Fantasma) this.juego.getFantasmas().get(0);
		Fantasma f2 = (Fantasma) this.juego.getFantasmas().get(1);
		Fantasma f3 = (Fantasma) this.juego.getFantasmas().get(2);
		Assert.assertEquals(this.juego.getPuntaje(), 50);
		Assert.assertEquals(this.juego.getPacman().getEstado(), 2);
		Assert.assertEquals(f1.getEstado(), 3);
		Assert.assertEquals(f2.getEstado(), 3);
		Assert.assertEquals(f3.getEstado(), 3);
		
	}

}
