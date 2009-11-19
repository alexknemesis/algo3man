package pruebas;

import junit.framework.Assert;
import junit.framework.TestCase;
import modelo.Celda;
import modelo.CeldaPared;
import modelo.Matriz;
import modelo.RangoException;

public class MatrizTest extends TestCase {
	
	Matriz miMatriz;
	Matriz miMatrizOtra;
	Celda micelda;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.miMatriz = new Matriz(2,2);
		this.micelda = new CeldaPared();
		this.miMatriz.agregar(this.micelda,1,1);
	}
	
	public void testMatriz_Fail() {
		try{
			this.miMatrizOtra = new Matriz(-1,-1);
			fail("Deberia mandar excepcion pero no lo hizo");
		}catch (RangoException e){
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testMatriz_Ok() {
		try{
			this.miMatrizOtra = new Matriz(4,4);
			Assert.assertEquals(true, true);
			
		}catch (RangoException e){
			fail("No deberia mandar excepcion pero lo hizo");
			
		}
		
	}
	
	public void testAgregar_Ok() {
		Celda celda = new CeldaPared();
		
		try{
			this.miMatriz.agregar(this.micelda,1,2);
			Assert.assertEquals(true, true);
		}catch(RangoException e){
			fail("No deberia mandar excepcion pero lo hizo");
		}
		
	}
	
	public void testAgregar_Fail() {
		Celda celda = new CeldaPared();
		
		try{
			this.miMatriz.agregar(this.micelda,4,4);
			fail("Deberia mandar excepcion pero no lo hizo");
			
		}catch(RangoException e){
			
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testGetFilas(){
		Assert.assertEquals(this.miMatriz.getFilas(), 2);
		
	}
	
	public void testGetColumnas(){
		Assert.assertEquals(this.miMatriz.getColumnas(), 2);
		
	}
	

	
	public void testgetCelda_Fail_Param(){
		
		
		try{
			Celda otraCelda = this.miMatriz.getCelda(-1,-1);
			fail("deberia mandar excepcionn pero no lo hizo");
			
			
		}catch (RangoException e){
			Assert.assertEquals(true, true);
			
		}
	}
	
	public void testgetCelda_Ok(){
		
			Celda otraCelda = this.miMatriz.getCelda(1,1);
			Assert.assertEquals(otraCelda, this.micelda);
			
		
	}
	

	
	

}
