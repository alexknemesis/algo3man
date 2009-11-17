package pruebas;

import junit.framework.TestCase;
import modelo.Pacman;
import modelo.Juego;

public class PacmanTest extends TestCase {

	protected Pacman pacman;
	protected Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.pacman = new Pacman(0, 0, 10, this.juego);
	}
	
	public void testMorir(){
		this.pacman.morir();
		
	}

}
