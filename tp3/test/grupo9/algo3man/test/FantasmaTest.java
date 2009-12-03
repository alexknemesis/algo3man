package grupo9.algo3man.test;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaCeleste;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;
import junit.framework.TestCase;

public class FantasmaTest extends TestCase {

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

	public void testReiniciar() {
		fail("Not yet implemented");
	}

	public void testMorir() {
		fail("Not yet implemented");
	}

	public void testVivir() {
		fail("Not yet implemented");
	}

	public void testCazarAlPacman() {
		//TODO this.fantasma.cazarAlPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.CAZANDO);
	}

	public void testHuirDelPacman() {
		//TODO this.fantasma.huirDelPacman();
		assertTrue(this.fantasma.getEstado() == Fantasma.HUYENDO);
	}

	public void testDispersarse() {
		//TODO this.fantasma.dispersarse();
		assertTrue(this.fantasma.getEstado() == Fantasma.DISPERSO);
	}

	public void testGetEstado() {
		fail("Not yet implemented");
	}

	public void testFantasma() {
		fail("Not yet implemented");
	}

}