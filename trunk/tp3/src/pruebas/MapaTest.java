package pruebas;

import java.awt.Point;

import modelo.Celda;
import modelo.CeldaPared;
import modelo.Juego;
import modelo.Mapa;
import modelo.MapaConstruirException;
import modelo.RangoException;
import modelo.RestarPuntoException;
import junit.framework.Assert;
import junit.framework.TestCase;

public class MapaTest extends TestCase {
	
	Mapa mapa;
	Mapa mapaTrucho;
	Juego juego;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.mapa = new Mapa(2,4,this.juego);
		
		Point punto = new Point(1,1);
		Celda celda = new CeldaPared();
		this.mapa.agregar(punto, celda);
	}

	public void testMapa_Fail() {
		try{
			this.mapaTrucho = new Mapa(-1,-1,this.juego);
			fail("Deber�a mandar excepci�n pero no lo hizo");
		}catch (MapaConstruirException e){
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testMapa_Ok() {
		try{
			this.mapaTrucho = new Mapa(4,4,this.juego);
			Assert.assertEquals(true, true);
			
		}catch (MapaConstruirException e){
			fail("No deber�a mandar excepci�n pero no lo hizo");
			
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
			fail("Deber�a mandar excepci�n pero no lo hizo");
		}catch(RestarPuntoException e){
			Assert.assertEquals(true, true);
		}
		
	}

	public void testAgregar_Ok() {
		Celda celda = new CeldaPared();
		Point punto = new Point(2,2);
		try{
			this.mapa.agregar(punto, celda);
			
			Assert.assertEquals(true, true);
		}catch(RangoException e){
			fail("No Deber�a mandar excepci�n pero no lo hizo");
		}
		
	}
	
	public void testAgregar_Fail() {
		Celda celda = new CeldaPared();
		Point punto = new Point(4,4);
		try{
			this.mapa.agregar(punto, celda);
			fail("Deber�a mandar excepci�n pero no lo hizo");
			
		}catch(RangoException e){
			
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testGetFilas(){
		Assert.assertEquals(this.mapa.getFilas(), 2);
		
	}
	
	public void testGetColumnas(){
		Assert.assertEquals(this.mapa.getColumnas(), 2);
		
	}
	
	public void testgetCelda_Ok(){
		Point punto = new Point(1,1);
		
		try{
			this.mapa.getCelda(punto);
			Assert.assertEquals(true, true);
			
		}catch (RangoException e){
			fail("No deber�a mandar excepci�n pero no lo hizo");
			
		}
	}
	
	public void testgetCelda_Fail(){
		Point punto = new Point(5,5);
		
		try{
			this.mapa.getCelda(punto);
			fail("No deber�a mandar excepci�n pero no lo hizo");
			
			
		}catch (RangoException e){
			Assert.assertEquals(true, true);
			
		}
	}

}
