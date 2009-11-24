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
		
		this.pacman = new Pacman(new Point(0,0), 1, Pacman.IZQUIERDA, this.juego);
	}
	
	public void testVivir(){
		this.pacman.vivir();
		
	}
	
	public void testMorir(){
		this.pacman.morir();
		assertEquals(2,this.juego.getVidas());
	}
	
	public void testMoverDerecha(){
		
	}
	
	public void testMoverIzquierda(){
		
	}
	
	public void testMoverAtras(){
		
	}

}
