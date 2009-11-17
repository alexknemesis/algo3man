package modelo;
import java.awt.Point;
import java.util.Comparator;




public class Comparador implements Comparator{

	public int compare(Object arg0, Object arg1) {
		
		long norma1,norma2;
		
		if (!(arg0 instanceof Point)|| !(arg1 instanceof Point)){
			throw new ClassCastException();
		}
		
		Point clave1 = (Point) arg0;
		Point clave2 = (Point) arg1;
		
		norma1=Math.round(Math.sqrt(Math.pow(clave1.x,2)+ Math.pow(clave1.y,2)));
		norma2=Math.round(Math.sqrt(Math.pow(clave2.x,2)+ Math.pow(clave2.y,2)));
		
		
		if (norma1==norma2 ){
			return 0;
		}else if(norma1<norma2){
			return -1;
		}else return 1;
		
	}
}
