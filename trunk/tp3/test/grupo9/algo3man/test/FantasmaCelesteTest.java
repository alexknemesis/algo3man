/**
 * 
 */
package grupo9.algo3man.test;

import java.awt.Point;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaCeleste;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.modelo.Personaje;
import junit.framework.TestCase;

/**
 * @author cripton
 *
 */
public class FantasmaCelesteTest extends TestCase {

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	private Juego juego;
	private FantasmaCeleste fantasma;
	private Pacman pacman;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = (FantasmaCeleste) this.juego.getFantasmas().get(1);
		this.pacman = juego.getPacman();
		assertTrue(this.fantasma instanceof FantasmaCeleste);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.FantasmaCeleste#determinarSiguienteDireccion()}.
	 */
	public void testDeterminarSiguienteDireccion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#vivir()}.
	 */
	public void testVivir() {
		fail("Not yet implemented ");
	}

	public void testMataAlPacman(){
		this.fantasma.setPosicion(new Point(5,5));
		
		this.fantasma.setDireccion(Personaje.DERECHA);
		
		this.pacman.setPosicion(new Point(5,7));
		//this.pacman.setVictima(); Hay un problema en setVictima no se como cambia la l�gica al cambiarle la visibilidad
		this.pacman.setDireccion(Personaje.IZQUIERDA);

		this.fantasma.vivir();
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();
		System.out.println(this.fantasma.getPosicion());
		
		assertEquals(((Fantasma) this.juego.getFantasmas().get(1)).getPosicion(), ((Fantasma) this.juego.getFantasmas().get(1)).getPosicionInicial());		
	}


	public void testFantasmaCeleste() {
		fail("Not yet implemented");
	}

}
