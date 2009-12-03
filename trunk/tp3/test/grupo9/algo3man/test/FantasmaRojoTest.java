/**
 * 
 */
package grupo9.algo3man.test;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaRojo;
import grupo9.algo3man.modelo.Juego;
import junit.framework.TestCase;

/**
 * @author cripton
 *
 */
public class FantasmaRojoTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	private Juego juego;
	private FantasmaRojo fantasma;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = (FantasmaRojo) this.juego.getFantasmas().get(0);
		assertTrue(this.fantasma instanceof FantasmaRojo);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.FantasmaRojo#determinarSiguienteDireccion()}.
	 */
	public void testDeterminarSiguienteDireccion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#vivir()}.
	 */
	public void testVivir() {
		fail("Not yet implemented");
	}


}
