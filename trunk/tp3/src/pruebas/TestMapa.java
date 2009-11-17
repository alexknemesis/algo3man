package pruebas;

import java.awt.Point;

import modelo.Celda;
import modelo.CeldaPared;
import modelo.Juego;
import modelo.Mapa;
import modelo.MapaConstruirException;
import modelo.RestarPuntoException;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TestMapa extends TestCase {
	
	Mapa mapa;
	Mapa mapaTrucho;
	Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.mapa = new Mapa(2,2,this.juego);
	}

	public void testMapa_Fail() {
		try{
			this.mapaTrucho = new Mapa(-1,-1,this.juego);
			fail("Debería mandar excepción pero no lo hizo");
		}catch (MapaConstruirException e){
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testMapa_Ok() {
		try{
			this.mapaTrucho = new Mapa(4,4,this.juego);
			Assert.assertEquals(true, true);
			
		}catch (MapaConstruirException e){
			fail("No debería mandar excepción pero no lo hizo");
			
		}
		
	}

	public void testRestarPunto_Ok() {
		this.mapa.restarPunto();
		Assert.assertEquals(this.mapa.getPuntos(), 15);
		
		
	}
	
	public void testRestarPunto_Fail() {
		this.mapaTrucho = new Mapa(1,1,this.juego);
		this.mapaTrucho.restarPunto();
		try{
			this.mapaTrucho.restarPunto();
			fail("Debería mandar excepción pero no lo hizo");
		}catch(RestarPuntoException e){
			Assert.assertEquals(true, true);
		}
		
	}

	public void testAgregar_Ok() {
		Celda celda = new CeldaPared();
		Point punto = new Point(1,1);
		this.mapa.agregar(punto, celda);
		Point celda2 = this.mapa.getCelda(punto);
		Assert.assertEquals(celda, celda2);
		
	}
	
	public void testGetFilas(){
		Assert.assertEquals(this.mapa.getFilas(), 2);
		
	}
	
	public void testGetColumnas(){
		Assert.assertEquals(this.mapa.getColumnas(), 2);
		
	}

}
