package grupo9.algo3man.test;


import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;

import java.awt.Point;

import junit.framework.TestCase;

public class PacmanTest extends TestCase {

	protected Pacman pacman;
	protected Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		
		this.pacman = this.juego.getPacman();
	}
	
	public void testVivir(){
		this.pacman.vivir();
		assertEquals(new Point(4,5), this.pacman.getPosicion());
		this.pacman.vivir();
		assertEquals(new Point(3,5), this.pacman.getPosicion());
		
	}
	
	public void testMorir(){
		this.pacman.morir();
		assertEquals(2,this.juego.getVidas());
	}

}
