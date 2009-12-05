package grupo9.algo3man.test;


import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;

import java.awt.Point;

import junit.framework.Assert;
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
		this.pacman.setPosicion(new Point(6,9));
		this.pacman.moverArriba();
		this.pacman.vivir();
		assertEquals(new Point(6,8), this.pacman.getPosicion());
	}
	
	public void testMataFantasma(){
		this.pacman.moverDerecha();
		this.pacman.setPosicion(new Point(3,1));
		this.pacman.vivir();
		Fantasma fantasma1 = this.juego.getFantasmas().get(0);
		fantasma1.setPosicion(new Point(3,2));		
		this.pacman.setPosicion(new Point(3,2));
		this.pacman.vivir();
		assertEquals(fantasma1.getPosicion(), fantasma1.getPosicionInicial());		
	}
	
	public void testComePuntoPoder(){
		this.pacman.moverDerecha();
		this.pacman.setPosicion(new Point(2,3));
		this.pacman.vivir();
		assertEquals(this.pacman.getEstado(), Pacman.VICTIMARIO);
	}
	
	public void testMorir(){
		this.pacman.morir();
		assertEquals(2,this.juego.getVidas());
		assertEquals(this.pacman.getPosicion(), this.pacman.getPosicionInicial());
	}
	
	public void testPacmanNoSeMuevePorPared(){
		this.pacman.moverArriba();
		this.pacman.vivir();
		Assert.assertEquals(this.pacman.getPosicion().x, 9);
		Assert.assertEquals(this.pacman.getPosicion().y, 9);
		
	}
	
	

}
