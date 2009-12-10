package grupo9.algo3man.test;

import java.awt.Point;

import grupo9.algo3man.modelo.Celda;
import grupo9.algo3man.modelo.CeldaPared;
import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaCeleste;
import grupo9.algo3man.modelo.FantasmaRojo;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;
import grupo9.algo3man.modelo.Personaje;
import junit.framework.TestCase;

public class FantasmaTest extends TestCase {

	private Juego juego;
	private FantasmaCeleste fantasma;
	private Pacman pacman;

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = (FantasmaCeleste) this.juego.getFantasmas().get(0);
		this.pacman = juego.getPacman();

	}

	public void testReiniciar() {
		
		this.fantasma.setPosicion(new Point(1,1));
		this.fantasma.reiniciar();
		assertEquals(this.fantasma.getPosicionInicial(), this.fantasma.getPosicion());
		assertEquals(Fantasma.DISPERSO, fantasma.getEstado());
	}

	public void testMorir() {
		this.fantasma.morir();
		assertEquals(this.fantasma.getPosicionInicial(), this.fantasma.getPosicion());
		assertEquals(Fantasma.DISPERSO, fantasma.getEstado());
		
	}

	public void testVivir() {
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
		this.pacman.vivir();
		for (int i=0; i < 59; i++){ // 60 es tics para salir del modo disperso
			this.fantasma.vivir();
			assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
			
		}
		this.fantasma.vivir();
		assertTrue(this.fantasma.getEstado() == Fantasma.CAZANDO);

		
	}

	public void testCazarAlPacman() {
		//TODO this.fantasma.cazarAlPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
		this.pacman.vivir();
		for (int i=0; i < 60; i++){ // 60 es tics para salir del modo disperso
			this.fantasma.vivir();
		}
		System.out.println(this.fantasma.getEstado());
		assertTrue(this.fantasma.getEstado() == Fantasma.CAZANDO);

	}

	public void testHuirDelPacman() {
		/*El Pacman es puesto deliveradamente encima de un punto de poder lo que
		 * hace que el fantasma intente huir de el
		 */
		this.pacman.setPosicion(new Point(2,13));
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
		this.pacman.vivir();
		this.fantasma.vivir();
		System.out.println(this.fantasma.getEstado());
		assertTrue(this.fantasma.getEstado() == Fantasma.HUYENDO);
	}

	public void testDispersarse() {
		//El fantasma debe comenzar disperso
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
	}

	public void testFantasma() {
		Celda celdaPreferida;
		celdaPreferida = new CeldaPared(null, null);
		Fantasma fantasmita = new FantasmaRojo(new Point(1,1),celdaPreferida , 3, Personaje.ARRIBA, this.juego);
		assertEquals(new Point(1,1), fantasmita.getPosicion());
		assertEquals(new Point(1,1), fantasmita.getPosicionInicial());
		assertEquals(3, fantasmita.getVelocidad());
		assertEquals(Personaje.ARRIBA, fantasmita.getDireccion());
		assertEquals(this.juego, fantasmita.getJuego());
		
	}
	
	public void testEstarEnLaMismaCeldaConElPacmanDisperso(){

		this.pacman.setPosicion(this.fantasma.getPosicion());
		this.fantasma.vivir();
		assertEquals(this.pacman.getPosicionInicial(),this.pacman.getPosicion());
	}

}