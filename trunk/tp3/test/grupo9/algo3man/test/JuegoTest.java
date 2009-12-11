package grupo9.algo3man.test;


import grupo9.algo3man.modelo.Celda;
import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.GameOverException;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.ListaFantasma;

import java.awt.Point;

import junit.framework.Assert;
import junit.framework.TestCase;

public class JuegoTest extends TestCase {

	protected Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		
	}
	
	public void testConstructor(){
		assertEquals(this.juego.getPuntaje(),0);
		assertEquals(this.juego.getNivel(),0);
		assertEquals(this.juego.getVidas(),3);
	}
	
	public void testRestarVida(){
		try{
			this.juego.restarVida();
		} catch(GameOverException e){
			fail("Tiro excepcion al restar una vida.");
		}
		
		assertEquals(this.juego.getVidas(),2);			
	}
	
	public void testReiniciarPersonajes(){
		this.juego.getPacman().setPosicion(new Point(0,5));
		ListaFantasma fantasmas = this.juego.getFantasmas();
		for(int i=0; i< fantasmas.size(); i++){
			((Fantasma)(fantasmas.get(i))).setPosicion(new Point(0,6));
		}
		
		this.juego.reiniciarPersonajes();
		
		for(int i=0; i< fantasmas.size(); i++){
			assertEquals(((Fantasma)(fantasmas.get(i))).getPosicion(), ((Fantasma)(fantasmas.get(i))).getPosicionInicial());
		}
		
		assertEquals(this.juego.getPacman().getPosicion(), this.juego.getPacman().getPosicionInicial());
	}

	public void restarVidaFinal(){
		this.juego.restarVida();
		this.juego.restarVida();
		this.juego.restarVida();
		assertEquals(this.juego.getVidas(),0);
		
		try{
			this.juego.restarVida();
			fail("No tira excepcion al querer restar una vida cuando no hay mas.");
		} catch (Exception e){
			assertTrue(true);
		}	
	}
	
	public void testIsGameOver(){
		assertFalse(this.juego.isGameOver());
		this.juego.restarVida();
		this.juego.restarVida();
		this.juego.restarVida();
		assertTrue(this.juego.isGameOver());
	}
	
	public void testSumarPuntos(){
		try{
			this.juego.sumarPuntos(500);
		} catch (GameOverException e){
			fail("Tiro excepcion al querer sumar puntos.");
		}
		assertEquals(this.juego.getPuntaje(),500);
	}
	
	public void testSumarPuntosEnGameOver(){
		this.juego.restarVida();
		this.juego.restarVida();
		this.juego.restarVida();
		
		try{
			this.juego.sumarPuntos(500);
			fail("No tiro excepcion al sumar puntos en Game Over.");
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}
	
	public void testAvanzarNivel(){
		try{
			this.juego.avanzarNivel();
		} catch (GameOverException e){
			fail("Tiro excepcion al querer avanzar un nivel.");
		}
		assertEquals(this.juego.getNivel(),1);
	}
	
	public void testAvanzarNivelEnGameOver(){
		this.juego.restarVida();
		this.juego.restarVida();
		this.juego.restarVida();
		
		try{
			this.juego.avanzarNivel();
			fail("No tiro excepcion al querer avanzar un nivel en Game Over.");
		} catch (Exception e){
			assertTrue(true);
		}
	}
	
	public void testComprobarCelda(){
		Celda celda = this.juego.getCelda(new Point(15,13));
		if (celda == null){
			fail("es null");
		}else Assert.assertEquals(true, true);
		
		
	}
}
