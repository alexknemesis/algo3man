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
		this.pacman.setVelocidad(1);
		this.pacman.setDireccion(3);
		
	}
	
	public void testMoverVivir(){
		this.pacman.setPosicion(new Point(6,9));
		this.pacman.moverArriba();
		this.pacman.vivir();
		assertEquals(new Point(6,8), this.pacman.getPosicion());
	}
	
	public void testMataFantasma(){
		Fantasma fantasma1 = this.juego.getFantasmas().get(0);
		fantasma1.setPosicion(new Point(2,3));
		fantasma1.setVelocidad(1);
		this.pacman.setPosicion(new Point(2,3));
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
		this.pacman.setPosicion(new Point(7,2));
		this.pacman.morir();
		assertEquals(2,this.juego.getVidas());
		assertEquals(this.pacman.getPosicion(), this.pacman.getPosicionInicial());
	}
	
	public void testPacmanNoSeMuevePorPared(){
		this.pacman.setDireccion(Pacman.ARRIBA);
		this.pacman.vivir();
		Assert.assertEquals(this.pacman.getPosicion().x, 10);
		Assert.assertEquals(this.pacman.getPosicion().y, 9);
		
	}
	
	public void testPacmanVaDeVictimarioAVictima(){
		this.pacman.setPosicion(new Point(2,3));
		this.pacman.vivir();
		for (int i=0; i < 10; i++){ 
			this.pacman.vivir();
		}
		Assert.assertEquals(Pacman.VICTIMA, this.pacman.getEstado());
	}
	
	public void testComePuntoOrdinario(){
			this.pacman.vivir();
			Assert.assertEquals(10, this.juego.getPuntaje());
			Assert.assertEquals(103, this.juego.getMapa().getPuntos());
	}
	
	

}
