package pruebas;

import junit.framework.TestCase;

import modelo.Celda;
import modelo.Juego;

public class JuegoTest extends TestCase {

	protected Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.juego = new Juego();
		
	}
	
	public void testConstructor(){
		assertEquals(this.juego.getPuntaje(),0);
		assertEquals(this.juego.getNivel(),1);
		assertEquals(this.juego.getVidas(),3);
	}
	
	public Celda testGetCelda(){
		Celda celda = this.juego.getCelda(0,0);
	}
	
	public void restarVida(){
		try{
			this.juego.restarVida();
		} catch(Exception e){
			fail("Tiro excepcion al restar una vida.");
		}
		
		assertEquals(this.juego.getVidas(),2);
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
		} catch (Exception e){
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
		} catch (Exception e){
			fail("Tiro excepcion al querer avanzar un nivel.");
		}
		assertEquals(this.juego.getNivel(),2);
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
}
