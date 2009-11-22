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
		
		//(i,j) i filas, j columnas
		
		mapa = new Mapa(17,19, null);
		
		
		
		celda = new CeldaVacia();
		
		// agrego las celdas desde (1,1) hasta (1,19)
		for (j=1;j<19;j++){
			punto = new Point(1,j);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (17,1) hasta (17,19)
		for (j=1;j<19;j++){
			punto = new Point(17,j);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (2,1) hasta (16,1)
		for (i=2;i<16;i++){
			punto = new Point(i,1);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (2,19) hasta (16,19)
		
		for (i=2;i<16;i++){
			punto = new Point(i,19);
			mapa.agregar(punto, celda);
		}
		
		celda = new CeldaPared();
		
		//agrego las celdas desde (2,2) hasta (2,18)
		for (j=2;j<18;j++){
			punto = new Point(2,j);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (16,2) hasta (16,18)
		for (j=2;j<18;j++){
			punto = new Point(16,j);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (3,2) hasta (15,2)
		for (i=3;i<15;i++){
			punto = new Point(i,2);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (3,18) hasta (15,18)
		
		for (i=3;i<15;i++){
			punto = new Point(i,18);
			mapa.agregar(punto, celda);
		}
		
		celda = new PuntoOrdinario();
		
		//agrego las celdas desde (3,3) hasta (3,17)
		for (j=3;j<17;j++){
			punto = new Point(3,j);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (15,3) hasta (15,17)
		for (j=3;j<17;j++){
			punto = new Point(15,j);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (5,3) hasta (13,3)
		for (i=5;i<13;i++){
			punto = new Point(i,3);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (5,17) hasta (13,17)
		
		for (i=5;i<13;i++){
			punto = new Point(i,17);
			mapa.agregar(punto, celda);
		}
		
		celda = new PuntoPoder();
		
		//agrego en la posicion (4,3)
		punto = new Point(4,3);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (4,17)
		punto = new Point(4,17);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (14,3)
		punto = new Point(14,3);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (14,17)
		punto = new Point(14,17);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,4)
		celda = new CeldaPared();
		punto = new Point(4,4);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,5)
		celda = new CeldaPared();
		punto = new Point(4,5);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (4,6)
		celda = new PuntoOrdinario();
		punto = new Point(4,6);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,7)
		celda = new CeldaPared();
		punto = new Point(4,7);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,8)
		celda = new CeldaPared();
		punto = new Point(4,8);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (4,9)
		celda = new PuntoOrdinario();
		punto = new Point(4,9);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,10)
		celda = new CeldaPared();
		punto = new Point(4,10);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (4,11)
		celda = new PuntoOrdinario();
		punto = new Point(4,11);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,12)
		celda = new CeldaPared();
		punto = new Point(4,12);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,13)
		celda = new CeldaPared();
		punto = new Point(4,13);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (4,14)
		celda = new PuntoOrdinario();
		punto = new Point(4,14);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,15)
		celda = new CeldaPared();
		punto = new Point(4,15);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (4,16)
		celda = new CeldaPared();
		punto = new Point(4,16);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,4)
		celda = new CeldaPared();
		punto = new Point(5,4);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,5)
		celda = new CeldaPared();
		punto = new Point(5,5);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (5,6)
		celda = new PuntoOrdinario();
		punto = new Point(5,6);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,7)
		celda = new CeldaPared();
		punto = new Point(5,7);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,8)
		celda = new CeldaPared();
		punto = new Point(5,8);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (5,9)
		celda = new PuntoOrdinario();
		punto = new Point(5,9);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,10)
		celda = new CeldaPared();
		punto = new Point(5,10);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (5,11)
		celda = new PuntoOrdinario();
		punto = new Point(5,11);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,12)
		celda = new CeldaPared();
		punto = new Point(5,12);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,13)
		celda = new CeldaPared();
		punto = new Point(5,13);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (5,14)
		celda = new PuntoOrdinario();
		punto = new Point(5,14);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,15)
		celda = new CeldaPared();
		punto = new Point(5,15);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (5,16)
		celda = new CeldaPared();
		punto = new Point(5,16);
		mapa.agregar(punto, celda);
		
		celda = new PuntoOrdinario();
		//agrego las celdas desde (6,4) hasta (6,16)
		for (j=4;j<16;j++){
			punto = new Point(6,j);
			mapa.agregar(punto, celda);
		}
		
		//agrego pared posicion (7,4)
		celda = new CeldaPared();
		punto = new Point(7,4);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (7,5)
		celda = new CeldaPared();
		punto = new Point(7,5);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (7,6)
		celda = new CeldaPared();
		punto = new Point(7,6);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (7,7)
		celda = new PuntoOrdinario();
		punto = new Point(7,7);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (7,8)
		celda = new CeldaPared();
		punto = new Point(7,8);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (7,9)
		celda = new CeldaPared();
		punto = new Point(7,9);
		mapa.agregar(punto, celda);
		
		
		
		
		return mapa;
	}



	private static Mapa crearMapa1(){
		
		return null;
		
	}

}
