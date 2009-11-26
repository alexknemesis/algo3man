package grupo9.algo3man.test;


import grupo9.algo3man.modelo.Fantasma;
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
	
	public void testMoverVivir(){
		this.pacman.setPosicion(new Point(3,3));
		this.pacman.moverArriba();
		this.pacman.vivir();
		assertEquals(new Point(3,2), this.pacman.getPosicion());
	}
	
	public void testMataFantasma(){
		this.pacman.setVictimario();
		((Fantasma) this.juego.getFantasmas().get(0)).setPosicion(new Point(3,2));
		this.pacman.setPosicion(new Point(3,2));
		this.pacman.vivir();
		assertEquals(((Fantasma) this.juego.getFantasmas().get(0)).getPosicion(), ((Fantasma) this.juego.getFantasmas().get(0)).getPosicionInicial());		
	}
	
	public void testComePuntoPoder(){
		this.pacman.moverAbajo();
		this.pacman.setPosicion(new Point(3,2));
		this.pacman.vivir();
		assertEquals(this.pacman.getEstado(), this.pacman.VICTIMARIO);
	}
	
	public void testMorir(){
		this.pacman.morir();
		assertEquals(2,this.juego.getVidas());
		assertEquals(this.pacman.getPosicion(), this.pacman.getPosicionInicial());
	}

}
