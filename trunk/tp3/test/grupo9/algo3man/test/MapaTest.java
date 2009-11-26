package grupo9.algo3man.test;


import grupo9.algo3man.modelo.Celda;
import grupo9.algo3man.modelo.CeldaPared;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.Mapa;
import grupo9.algo3man.modelo.RangoException;
import grupo9.algo3man.modelo.RestarPuntoException;

import java.awt.Point;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MapaTest extends TestCase {
	
	Mapa mapa;
	Mapa mapaTrucho;
	Juego juego;
	Celda miCelda;
	
	protected void setUp() throws Exception {
		super.setUp();
		this.juego = new Juego();
		this.mapa = new Mapa(2,4,this.juego,new Point(10,10), new Point(6,10), new Point(7,10));
		
		Point punto = new Point(1,1);
		this.miCelda = new CeldaPared(this.mapa,punto);
		
		this.mapa.agregar(punto, this.miCelda);
	}

	public void testMapa_Fail() {
		
		try{
			this.mapaTrucho = new Mapa(-1,-1,this.juego,new Point(10,10), new Point(6,10), new Point(7,10));
			fail("Deberia mandar excepcion pero no lo hizo");
		}catch (RangoException e){
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testMapa_Ok() {
		
		try{
			this.mapaTrucho = new Mapa(4,4,this.juego,new Point(10,10), new Point(6,10), new Point(7,10));
			Assert.assertEquals(true, true);
			
		}catch (RangoException e){
			fail("No deber�a mandar excepcion pero lo hizo");
			
		}
		
	}

	public void testRestarPunto_Ok() {
		this.mapa.restarPunto();
		Assert.assertEquals(this.mapa.getPuntos(), 15);
		
		
	}
	
	public void testRestarPunto_Fail() {
		
		this.mapaTrucho = new Mapa(1,1,this.juego,new Point(10,10), new Point(6,10), new Point(7,10));
		this.mapaTrucho.restarPunto();
		try{
			this.mapaTrucho.restarPunto();
			fail("Deberia mandar excepcion pero no lo hizo");
		}catch(RestarPuntoException e){
			Assert.assertEquals(true, true);
		}
		
	}

	public void testAgregar_Ok() {
		Point punto = new Point(2,2);
		Celda celda = new CeldaPared(this.mapa,punto);
		
		try{
			this.mapa.agregar(punto, celda);
			
			Assert.assertEquals(true, true);
		}catch(RangoException e){
			fail("No Deberia mandar excepcion pero lo hizo");
		}
		
	}
	
	public void testAgregar_Fail() {
		Point punto = new Point(4,4);
		Celda celda = new CeldaPared(mapa, punto);
		
		try{
			this.mapa.agregar(punto, celda);
			fail("Deberia mandar excepcion pero lo hizo");
			
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
	
	public void testGetCelda_Fail_Param(){
		
		Point punto = new Point(1,1);
		
		try{
			Celda otraCelda = this.mapa.getCelda(punto);
			fail("Deberia mandar excepcion pero no lo hizo");
			
			
		}catch (RangoException e){
			Assert.assertEquals(true, true);
			
		}
	}
	
	public void testgetCelda_Ok(){
			Point punto = new Point(1,1);
			Celda otraCelda = this.mapa.getCelda(punto);
			Assert.assertEquals(otraCelda,this.miCelda );
			
		
	}
	
	

}
