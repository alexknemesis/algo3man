
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
		this.pacman.setVelocidad(1);
		this.pacman.setDireccion(3);
		this.fantasma.setVelocidad(1);
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
		this.pacman.setPosicion(new Point(14,6)); //posicion imposible de llegar
		
		for (int i=0; i < 80+1; i++){ // 80 es tics para salir del modo disperso
			this.fantasma.vivir();
		}
		for (int i=0; i < 80+1; i++){ // 80 es tics para volver a disperso
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

	public void testEstaEnModoDispersoYSeDirijeASuPosicionPreferida(){
		for (int i=0; i < 24; i++){ 
			//System.out.println(this.fantasma.getPosicion());
			this.fantasma.vivir();
		}
		Assert.assertEquals(new Point(2,11), this.fantasma.getPosicion());
		
	}
	
	public void testEstaEnModoDispersoSeComeAlPacmanYComeVida(){
		this.pacman.setPosicion(new Point(6,5));
		for (int i=0; i < 4; i++){ 
			this.fantasma.vivir();
		}
		//System.out.println(this.fantasma.getPosicion());
		
		
		Assert.assertEquals(2, this.juego.getVidas());
		Assert.assertEquals(this.fantasma.getPosicionInicial(), this.fantasma.getPosicion());
	}
	
	public void testEstaEnModoCazandoSeComeAlPacmanYComeVida(){
		this.pacman.setPosicion(new Point(9,14));
		for (int i=0; i < 80+1; i++){ 
			this.fantasma.vivir();
		}
		System.out.println(this.fantasma.getPosicion());
		this.fantasma.vivir();
		
		System.out.println(this.fantasma.getPosicion());
		Assert.assertEquals(2, this.juego.getVidas());
		Assert.assertEquals(this.fantasma.getPosicionInicial(), this.fantasma.getPosicion());
		Assert.assertEquals(this.pacman.getPosicionInicial(), this.pacman.getPosicion());
		
	}
	


}
