/**
 * 
 */
package grupo9.algo3man.test;

import java.awt.Point;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaCeleste;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;
import junit.framework.Assert;
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
		this.fantasma = (FantasmaCeleste) this.juego.getFantasmas().get(0);
		this.pacman = juego.getPacman();
		//assertTrue(this.fantasma instanceof FantasmaCeleste);
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.FantasmaCeleste#determinarSiguienteDireccion()}.
	 */
	/**public void testDeterminarSiguienteDireccion() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link grupo9.algo3man.modelo.Fantasma#vivir()}.
	 */
	/**public void testVivir() {
		fail("Not yet implemented ");
	}*/
	
	public void testEstaEnModoDisperso(){
		Assert.assertEquals(Fantasma.DISPERSO, this.fantasma.getEstado());
	}
	
	public void testEstaEnModoCazando(){
		for (int i=0; i < 60+1; i++){ // 60 es tics para salir del modo disperso
			this.fantasma.vivir();
		}
		Assert.assertEquals(Fantasma.CAZANDO, this.fantasma.getEstado());
	}
	
	public void testEstaEnModoHuyendo(){
		this.pacman.setPosicion(new Point(2,3));
		this.pacman.vivir();
		this.fantasma.vivir();
		assertEquals(Fantasma.HUYENDO, this.fantasma.getEstado());
	
	}
	
	public void testEstaEnModoDispersoYSeDirijeASuPosicionPreferida(){
		for (int i=0; i < 10; i++){ 
			//System.out.println(this.fantasma.getPosicion());
			this.fantasma.vivir();
		}
		Assert.assertEquals(new Point(15,2), this.fantasma.getPosicion());
		
	}
	
	public void testEstaEnModoCazandoYSeComeAlPacman(){
		this.pacman.setPosicion(new Point(12,5));
		for (int i=0; i < 60+1; i++){ // 60 es tics para salir del modo disperso
			this.fantasma.vivir();
		}
		System.out.println(this.fantasma.getPosicion());
		
		for (int i=0; i < 9; i++){ // 60 es tics para salir del modo disperso
			this.fantasma.vivir();
		}
		
		System.out.println(this.fantasma.getPosicion());
		Assert.assertEquals(2, this.juego.getVidas());
	}

	public void testSeMueveYMataAlPacman(){
		
			this.fantasma.setPosicion(new Point(7,9));
			this.pacman.vivir();
			for (int i=0; i < 60+1; i++){ // 60 es tics para salir del modo disperso
				this.fantasma.vivir();
			}
					
			/*this.fantasma.vivir();
			System.out.println(this.fantasma.getPosicion());
			this.fantasma.vivir();
			System.out.println(this.fantasma.getPosicion());
			this.fantasma.vivir();
			System.out.println(this.fantasma.getPosicion());
			Assert.assertEquals(this.juego.getVidas(), 2);
		
		
		/*this.fantasma.setPosicion(new Point(5,5));
		
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
	*/
	}


	/**public void testFantasmaCeleste() {
		fail("Not yet implemented");
	}*/

}
