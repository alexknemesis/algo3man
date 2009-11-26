package grupo9.algo3man.modelo;

import java.awt.Point;

public class FabricaDeMapas { //crea los mapas
	
	public static Mapa obtenerMapa(int num, Juego juego){
		switch(num){
		case 0: return crearMapa0(juego);
		case 1: return crearMapa1(juego);
		default: return null;
		}
		
		
		
		
	}
	


	private static Mapa crearMapa0(Juego juego) {
		Celda celda;
		Mapa mapa;
		Point punto;
		int i,j;
		
		//(i,j) i filas, j columnas
		
		mapa = new Mapa(17,19, juego);
		mapa.setPuntajePremio(200);
		
		
		
		
		
		// agrego las celdas desde (1,1) hasta (1,19)
		for (j=1;j<19;j++){
			punto = new Point(1,j);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (17,1) hasta (17,19)
		for (j=1;j<19;j++){
			punto = new Point(17,j);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (2,1) hasta (16,1)
		for (i=2;i<16;i++){
			punto = new Point(i,1);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (2,19) hasta (16,19)
		
		for (i=2;i<16;i++){
			punto = new Point(i,19);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego las celdas desde (2,2) hasta (2,18)
		for (j=2;j<18;j++){
			punto = new Point(2,j);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (16,2) hasta (16,18)
		for (j=2;j<18;j++){
			punto = new Point(16,j);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (3,2) hasta (15,2)
		for (i=3;i<15;i++){
			punto = new Point(i,2);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (3,18) hasta (15,18)
		
		for (i=3;i<15;i++){
			punto = new Point(i,18);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego las celdas desde (3,3) hasta (3,17)
		for (j=3;j<17;j++){
			punto = new Point(3,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (15,3) hasta (15,17)
		for (j=3;j<17;j++){
			punto = new Point(15,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (5,3) hasta (13,3)
		for (i=5;i<13;i++){
			punto = new Point(i,3);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// agrego las celdas desde (5,17) hasta (13,17)
		
		for (i=5;i<13;i++){
			punto = new Point(i,17);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego en la posicion (4,3)
		punto = new Point(4,3);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (4,17)
		punto = new Point(4,17);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (14,3)
		punto = new Point(14,3);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (14,17)
		punto = new Point(14,17);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (4,4) hasta (4,5)
		for (j=4;j<5;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		
		//agrego punto ordinario posicion (4,6)
		
		punto = new Point(4,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (4,7) hasta (4,8)
		for (j=7;j<8;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//agrego punto ordinario posicion (4,9)
		
		punto = new Point(4,9);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		//agrego pared posicion (4,10)
		
		punto = new Point(4,10);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (4,11)
		
		punto = new Point(4,11);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (4,12) hasta (4,13)
		for (j=12;j<13;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//agrego punto ordinario posicion (4,14)
		
		punto = new Point(4,14);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (4,15) hasta (4,16)
		for (j=15;j<16;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
			
		
		//agrego las celdas desde (5,4) hasta (5,5)
		for (j=4;j<5;j++){
			punto = new Point(5,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		
		//agrego punto ordinario posicion (5,6)
		
		punto = new Point(5,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (5,7) hasta (8,8)
		for (j=7;j<8;j++){
			punto = new Point(5,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//agrego punto ordinario posicion (5,9)
		
		punto = new Point(5,9);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		//agrego pared posicion (5,10)
		
		punto = new Point(5,10);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (5,11)
		
		punto = new Point(5,11);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (5,12) hasta (5,13)
		for (j=12;j<13;j++){
			punto = new Point(5,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//agrego punto ordinario posicion (5,14)
		
		punto = new Point(5,14);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (5,15) hasta (5,16)
		for (j=15;j<16;j++){
			punto = new Point(5,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (6,4) hasta (6,16)
		for (j=4;j<16;j++){
			punto = new Point(6,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (7,4) hasta (7,6)
		for (j=4;j<6;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (7,7)
		
		punto = new Point(7,7);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (7,8) hasta (7,9)
		for (j=8;j<9;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego puerta posicion (7,10)
		
		punto = new Point(7,10);
		celda = new CeldaPuerta(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (7,11) hasta (7,12)
		for (j=11;j<12;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego punto ordinario posicion (7,13)
		
		punto = new Point(7,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (7,14) hasta (7,16)
		for (j=14;j<16;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (8,4) hasta (8,6)
		for (j=4;j<6;j++){
			punto = new Point(8,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego punto ordinario posicion (8,7)
		
		punto = new Point(8,7);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (8,8)
		
		punto = new Point(8,8);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (8,8) hasta (8,11)
		for (j=8;j<11;j++){
			punto = new Point(8,j);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego pared posicion (8,12)
		
		punto = new Point(8,12);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (8,13)
		
		punto = new Point(8,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (8,14) hasta (8,16)
		for (j=14;j<16;j++){
			punto = new Point(8,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (9,4) hasta (9,6)
		for (j=4;j<6;j++){
			punto = new Point(9,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego punto ordinario posicion (9,7)
		
		punto = new Point(9,7);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (9,8) hasta (9,12)
		for (j=8;j<12;j++){
			punto = new Point(9,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego punto ordinario posicion (9,13)
		
		punto = new Point(9,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (9,14) hasta (9,16)
		for (j=14;j<16;j++){
			punto = new Point(9,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		
		
		//agrego las celdas desde (10,4) hasta (10,16)
		for (j=4;j<16;j++){
			punto = new Point(10,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (11,4) hasta (11,6)
		for (j=4;j<6;j++){
			punto = new Point(11,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (11,7)
		
		punto = new Point(11,7);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (11,7) hasta (11,12)
		for (j=7;j<12;j++){
			punto = new Point(11,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (11,13)
		
		punto = new Point(11,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (11,14) hasta (11,16)
		for (j=14;j<16;j++){
			punto = new Point(11,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (12,4) hasta (12,6)
		for (j=4;j<6;j++){
			punto = new Point(12,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (12,7) hasta (12,9)
		for (j=7;j<9;j++){
			punto = new Point(12,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego pared posicion (12,10)
		
		punto = new Point(12,10);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (12,11) hasta (12,13)
		for (j=11;j<13;j++){
			punto = new Point(12,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//agrego las celdas desde (12,14) hasta (12,16)
		for (j=14;j<16;j++){
			punto = new Point(12,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (13,4) hasta (13,8)
		for (j=4;j<8;j++){
			punto = new Point(13,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (13,9)
		
		punto = new Point(13,9);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (13,10)
		
		punto = new Point(13,10);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (13,11)
		
		punto = new Point(13,11);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (13,12) hasta (13,16)
		for (j=12;j<16;j++){
			punto = new Point(13,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (14,4) hasta (14,8)
		for (j=4;j<8;j++){
			punto = new Point(14,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (14,9)
		
		punto = new Point(14,9);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (14,10)
		
		punto = new Point(14,10);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (14,11)
		
		punto = new Point(14,11);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (14,12) hasta (14,16)
		for (j=12;j<16;j++){
			punto = new Point(14,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		return mapa;
	}



	private static Mapa crearMapa1(Juego juego){
		
		return null;
		
	}

}
