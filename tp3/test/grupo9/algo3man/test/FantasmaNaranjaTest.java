
package grupo9.algo3man.test;

import java.awt.Point;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.FantasmaNaranja;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Pacman;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * @author Lucas Robles
 *
 */
public class FantasmaNaranjaTest extends TestCase {

	
	private Juego juego;
	private FantasmaNaranja fantasma;
	private Pacman pacman;
	

	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		this.fantasma = (FantasmaNaranja) this.juego.getFantasmas().get(2);
		this.pacman = juego.getPacman();
	}
	
	public void testMorir() {
		this.fantasma.morir();
		assertEquals(this.fantasma.getPosicionInicial(), this.fantasma.getPosicion());
		assertEquals(Fantasma.DISPERSO, fantasma.getEstado());
	}
	
	public void testEstaEnModoDisperso(){
		Assert.assertEquals(Fantasma.DISPERSO, this.fantasma.getEstado());
	}
	
	public void testEstaEnModoCazando(){
		for (int i=0; i < 80+1; i++){ // 80 es los tics para salir del modo disperso
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
	
	public void testEstabaEnModoCazandoYVuelveAlEstadoDisperso(){
		this.pacman.setPosicion(new Point(14,6)); //posición imposible de llegar
		
		for (int i=0; i < 80+1; i++){ // 60 es tics para salir del modo disperso
			this.fantasma.vivir();
		}
		for (int i=0; i < 80+1; i++){ // 60 es tics para volver a disperso
			this.fantasma.vivir();
		}
		Assert.assertEquals(Fantasma.DISPERSO, this.fantasma.getEstado());
		
	}
	
	public void testEstabaHuyendoYVuelveADisperso(){
		this.pacman.setPosicion(new Point(2,3));
		this.pacman.vivir();
		this.fantasma.vivir();
		for (int i=0; i < 10; i++){ 
			this.pacman.vivir();
		}
		this.fantasma.vivir();
		Assert.assertEquals(Fantasma.DISPERSO, this.fantasma.getEstado());
		
	}

	


}
