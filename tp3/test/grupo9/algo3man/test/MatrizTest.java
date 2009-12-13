package grupo9.algo3man.test;


import grupo9.algo3man.modelo.Celda;
import grupo9.algo3man.modelo.CeldaPared;
import grupo9.algo3man.modelo.Matriz;
import grupo9.algo3man.modelo.RangoException;
import junit.framework.Assert;
import junit.framework.TestCase;

public class MatrizTest extends TestCase {
	
	Matriz miMatriz;
	Matriz miMatrizOtra;
	Celda micelda;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.miMatriz = new Matriz(2,2);
		this.micelda = new CeldaPared(null, null);
		this.miMatriz.agregar(this.micelda,0,0);
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
		Celda celda = new CeldaPared(null, null);
		
		try{
			this.miMatriz.agregar(this.micelda,0,1);
			Assert.assertEquals(true, true);
		}catch(RangoException e){
			fail("No deberia mandar excepcion pero lo hizo");
		}
		
	}
	
	public void testAgregar_Fail() {
		Celda celda = new CeldaPared(null, null);
		
		try{
			this.miMatriz.agregar(this.micelda,4,4);
			fail("Deberia mandar excepcion pero no lo hizo");
			
		}catch(RangoException e){
			
			Assert.assertEquals(true, true);
		}
		
	}
	
	public void testGetFilas(){
		this.miMatrizOtra = new Matriz(19,17);
		Assert.assertEquals(this.miMatrizOtra.getFilas(),19);
		
	}
	
	public void testGetColumnas(){
		this.miMatrizOtra = new Matriz(19,17);
		Assert.assertEquals(this.miMatrizOtra.getColumnas(),17);
		
	}
	
	public void testGetCeldaCasiEnlosBordes(){
		this.miMatrizOtra = new Matriz(19,17);
		
		try{
			Celda otraCelda = this.miMatrizOtra.getCelda(19,1);
			fail("deberia mandar excepcionn pero no lo hizo");
			
			
		}catch (RangoException e){
			Assert.assertEquals(true, true);
			
		}
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
		
			Celda otraCelda = this.miMatriz.getCelda(0,0);
			Assert.assertEquals(otraCelda, this.micelda);
			
		
	}
	

	
	

}
