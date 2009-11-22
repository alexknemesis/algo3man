package grupo9.algo3man.modelo;

import java.awt.Point;

public class FabricaDeMapas {
	
	public static Mapa obtenerMapa(int num){
		switch(num){
		case 0: return crearMapa0();
		case 1: return crearMapa1();
		default: return null;
		}
		
		
		
		
	}
	


	private static Mapa crearMapa0() {
		Celda celda;
		Mapa mapa;
		Point punto;
		int i,j;
	
		
		mapa = new Mapa(17,19, null);
		
		celda = new CeldaVacia();
		for (j=1;j<19;j++){
			punto = new Point(1,j);
			mapa.agregar(punto, celda);
		}
		
		for (j=1;j<19;j++){
			punto = new Point(17,j);
			mapa.agregar(punto, celda);
		}
		
		for (i=1;i<17;i++){
			punto = new Point(i,1);
			mapa.agregar(punto, celda);
		}
		
		for (i=1;i<17;i++){
			punto = new Point(i,19);
			mapa.agregar(punto, celda);
		}
		
		
		
		return mapa;
	}



	private static Mapa crearMapa1(){
		
		return null;
		
	}

}
