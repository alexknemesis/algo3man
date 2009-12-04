/**
 * 
 */
package grupo9.algo3man.test;

import java.awt.Point;

import grupo9.algo3man.modelo.CeldaPared;
import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaRojo;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Mapa;
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
	private Fantasma fantasma;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = this.juego.getFantasmas().get(0);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.FantasmaRojo#determinarSiguienteDireccion()}.
	 */
	public void testConstructor(){
		assertNotNull(fantasma);
	}
	
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
