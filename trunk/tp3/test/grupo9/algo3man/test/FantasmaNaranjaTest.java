/**
 * 
 */
package grupo9.algo3man.test;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaNaranja;
import grupo9.algo3man.modelo.Juego;
import junit.framework.TestCase;

/**
 * @author cripton
 *
 */
public class FantasmaNaranjaTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	private Juego juego;
	private FantasmaNaranja fantasma;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = (FantasmaNaranja) this.juego.getFantasmas().get(2);
		assertTrue(this.fantasma instanceof FantasmaNaranja);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.FantasmaNaranja#determinarSiguienteDireccion()}.
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
