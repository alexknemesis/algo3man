/**
 * 
 */
package grupo9.algo3man.test;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaVioleta;
import grupo9.algo3man.modelo.Juego;
import junit.framework.TestCase;

/**
 * @author cripton
 *
 */
public class FantasmaVioletaTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	private Juego juego;
	private FantasmaVioleta fantasma;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = (FantasmaVioleta) this.juego.getFantasmas().get(3);
		assertTrue(this.fantasma instanceof FantasmaVioleta);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.FantasmaVioleta#determinarSiguienteDireccion()}.
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

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#cazarAlPacman()}.
	 */
	public void testCazarAlPacman() {
		this.fantasma.cazarAlPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.CAZANDO);
		this.fantasma.vivir();
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#huirDelPacman()}.
	 */
	public void testHuirDelPacman() {
		this.fantasma.huirDelPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.HUYENDO);
		this.fantasma.vivir();

	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#dispersarse()}.
	 */
	public void testDispersarse() {
		this.fantasma.dispersarse();
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
		this.fantasma.vivir();
	}

}
