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

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#cazarAlPacman()}.
	 */
	public void testCazarAlPacman() {
		this.fantasma.cazarAlPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.CAZANDO);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#huirDelPacman()}.
	 */
	public void testHuirDelPacman() {
		this.fantasma.huirDelPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.HUYENDO);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#dispersarse()}.
	 */
	public void testDispersarse() {
		this.fantasma.dispersarse();
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();

	}

}
