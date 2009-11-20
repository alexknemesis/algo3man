package pruebas;

import java.awt.Point;

import junit.framework.TestCase;
import modelo.Juego;
import modelo.Pacman;

public class PacmanTest extends TestCase {

	protected Pacman pacman;
	protected Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.pacman = new Pacman(new Point(0,0), new Point(10,0), this.juego);
	}
	
	public void testVivir(){
		
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
