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
		
		mapa = new Mapa(17,19, juego, new Point(9,9), new Point(6,9),104);
		//TODO Agregué la cantidad de puntos para comer
		mapa.setPuntajePremio(200);
		
		// TODO agrego las celdas desde (0,0) hasta (0,18)
		for (j=0;j<18;j++){
			punto = new Point(0,j);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego las celdas desde (16,0) hasta (16,18)
		for (j=0;j<18;j++){
			punto = new Point(16,j);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO  agrego las celdas desde (1,0) hasta (15,0)
		for (i=1;i<15;i++){
			punto = new Point(i,0);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// TODO agrego las celdas desde (1,18) hasta (15,18)
		
		for (i=1;i<15;i++){
			punto = new Point(i,18);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego las celdas desde (1,1) hasta (1,17)
		for (j=1;j<17;j++){
			punto = new Point(1,j);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		// TODO agrego las celdas desde (15,1) hasta (15,17)
		for (j=1;j<17;j++){
			punto = new Point(15,j);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego las celdas desde (2,1) hasta (14,1)
		for (i=2;i<14;i++){
			punto = new Point(i,1);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego las celdas desde (2,17) hasta (14,17)
		
		for (i=2;i<14;i++){
			punto = new Point(i,17);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//	TODO agrego las celdas desde (2,2) hasta (2,16)
		for (j=2;j<16;j++){
			punto = new Point(2,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// TODO agrego las celdas desde (14,2) hasta (14,16)
		for (j=2;j<16;j++){
			punto = new Point(14,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// TODO agrego las celdas desde (4,2) hasta (12,2)
		for (i=4;i<12;i++){
			punto = new Point(i,2);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		// TODO agrego las celdas desde (4,16) hasta (12,16)
		
		for (i=4;i<12;i++){
			punto = new Point(i,16);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego en la posicion (3,2)
		punto = new Point(3,2);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego en la posicion (3,16)
		punto = new Point(3,16);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego en la posicion (13,2)
		punto = new Point(13,2);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego en la posicion (13,16)
		punto = new Point(13,16);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (3,3) hasta (3,4)
		for (j=3;j<4;j++){
			punto = new Point(3,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		
		//TODO agrego punto ordinario posicion (3,5)
		
		punto = new Point(3,5);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (3,6) hasta (3,7)
		for (j=6;j<7;j++){
			punto = new Point(3,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//TODO agrego punto ordinario posicion (3,8)
		
		punto = new Point(3,8);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		//TODO agrego pared posicion (3,9)
		
		punto = new Point(3,9);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego punto ordinario posicion (3,10)
		
		punto = new Point(3,10);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (3,11) hasta (3,12)
		for (j=11;j<12;j++){
			punto = new Point(3,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//TODO agrego punto ordinario posicion (3,13)
		
		punto = new Point(3,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (3,14) hasta (3,15)
		for (j=14;j<15;j++){
			punto = new Point(3,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
			
		
		//TODO agrego las celdas desde (4,3) hasta (4,4)
		for (j=3;j<4;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		
		//TODO agrego punto ordinario posicion (4,5)
		
		punto = new Point(4,5);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (4,6) hasta (7,7)
		for (j=6;j<7;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//TODO agrego punto ordinario posicion (4,8)
		
		punto = new Point(4,8);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		//TODO agrego pared posicion (4,9)
		
		punto = new Point(5,10);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego punto ordinario posicion (4,10)
		
		punto = new Point(4,10);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (4,11) hasta (4,12)
		for (j=11;j<12;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//TODO agrego punto ordinario posicion (4,15)
		
		punto = new Point(4,15);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (4,14) hasta (4,15)
		for (j=14;j<15;j++){
			punto = new Point(4,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (5,3) hasta (5,15)
		for (j=3;j<15;j++){
			punto = new Point(5,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		
		//TODO agrego las celdas desde (6,3) hasta (6,5)
		for (j=3;j<5;j++){
			punto = new Point(6,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (6,6)
		
		punto = new Point(6,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (6,7) hasta (6,8)
		for (j=7;j<8;j++){
			punto = new Point(6,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego puerta posicion (6,9)
		
		punto = new Point(6,9);
		celda = new CeldaPuerta(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		//TODO agrego las celdas desde (6,10) hasta (6,11)
		for (j=10;j<11;j++){
			punto = new Point(6,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego punto ordinario posicion (6,12)
		
		punto = new Point(6,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (6,13) hasta (6,15)
		for (j=13;j<15;j++){
			punto = new Point(6,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (7,3) hasta (7,5)
		for (j=3;j<5;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego punto ordinario posicion (7,6)
		
		punto = new Point(7,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		
		//TODO agrego las celdas desde (7,7) hasta (7,11)
		for (j=7;j<11;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
	
		//TODO agrego punto ordinario posicion (7,12)
		
		punto = new Point(7,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (7,13) hasta (7,15)
		for (j=13;j<15;j++){
			punto = new Point(7,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (8,3) hasta (8,5)
		for (j=3;j<5;j++){
			punto = new Point(8,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego punto ordinario posicion (8,6)
		
		punto = new Point(8,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (8,7) hasta (8,11)
		for (j=7;j<11;j++){
			punto = new Point(8,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego punto ordinario posicion (8,12)
		
		punto = new Point(8,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (8,13) hasta (8,15)
		for (j=13;j<15;j++){
			punto = new Point(8,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		
		
		//TODO agrego las celdas desde (9,3) hasta (9,15)
		for (j=3;j<15;j++){
			punto = new Point(9,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
	
		
		//TODO agrego las celdas desde (10,3) hasta (10,5)
		for (j=3;j<5;j++){
			punto = new Point(10,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (10,6)
		
		punto = new Point(10,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (10,6) hasta (10,11)
		for (j=6;j<16;j++){
			punto = new Point(10,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (10,12)
		
		punto = new Point(10,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (10,13) hasta (10,15)
		for (j=13;j<15;j++){
			punto = new Point(10,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (11,3) hasta (11,5)
		for (j=4;j<6;j++){
			punto = new Point(12,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (11,6) hasta (11,8)
		for (j=6;j<8;j++){
			punto = new Point(11,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego pared posicion (11,9)
		
		punto = new Point(11,9);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (11,10) hasta (11,12)
		for (j=10;j<12;j++){
			punto = new Point(11,j);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego las celdas desde (11,13) hasta (11,15)
		for (j=14;j<16;j++){
			punto = new Point(12,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (12,3) hasta (12,7)
		for (j=3;j<7;j++){
			punto = new Point(12,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (12,8)
		
		punto = new Point(12,8);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego pared posicion (12,9)
		
		punto = new Point(12,9);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego punto ordinario posicion (12,10)
		
		punto = new Point(12,10);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (12,11) hasta (12,15)
		for (j=11;j<15;j++){
			punto = new Point(12,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (13,3) hasta (13,7)
		for (j=3;j<7;j++){
			punto = new Point(13,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (13,8)
		
		punto = new Point(13,8);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego pared posicion (13,9)
		
		punto = new Point(13,9);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//TODO agrego punto ordinario posicion (13,10)
		
		punto = new Point(13,10);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (13,11) hasta (13,15)
		for (j=11;j<15;j++){
			punto = new Point(13,j);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		mapa.crearPersonajes();
		
		return mapa;
	}



	private static Mapa crearMapa1(Juego juego){
		
		return null;
		
	}

}
