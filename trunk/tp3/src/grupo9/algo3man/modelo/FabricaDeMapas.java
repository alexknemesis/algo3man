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
		int x,y;
		
		//(x,y) x columnas, y filas
		
		mapa = new Mapa(19,17, juego, new Point(9,9), new Point(9,6),104);
		
		mapa.setPuntajePremio(200);
		
		// agrego las celdas desde (0,0) hasta (18,0)
		for (x=0;x<18;x++){
			punto = new Point(x,0);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (0,16) hasta (18,16)
		for (x=0;x<18;x++){
			punto = new Point(x,16);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (0,1) hasta (0,15)
		for (y=1;y<15;y++){
			punto = new Point(0,y);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (18,1) hasta (18,15)
		for (y=1;y<15;y++){
			punto = new Point(18,y);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (1,1) hasta (17,1)
		for (x=1;x<17;x++){
			punto = new Point(x,1);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (15,1) hasta (15,17)
		for (y=1;y<17;y++){
			punto = new Point(15,y);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (1,2) hasta (1,14)
		for (y=2;y<14;y++){
			punto = new Point(1,y);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (17,2) hasta (17,14)
		for (y=2;y<14;y++){
			punto = new Point(17,y);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (2,2) hasta (16,2)
		for (x=2;x<16;x++){
			punto = new Point(x,2);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (2,14) hasta (16,14)
		for (x=2;x<16;x++){
			punto = new Point(x,14);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (2,4) hasta (2,12)
		for (y=4;y<12;x++){
			punto = new Point(2,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (16,4) hasta (16,12)
		for (y=4;y<12;y++){
			punto = new Point(16,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego en la posicion (2,3) punto poder
		punto = new Point(2,3);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (16,3) punto poder
		punto = new Point(16,3);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (2,13) punto poder
		punto = new Point(2,13);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego en la posicion (16,13)
		punto = new Point(16,13);
		celda = new PuntoPoder(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas pared desde (3,3) hasta (4,3)
		for (x=3;x<4;y++){
			punto = new Point(x,3);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (5,3)
		punto = new Point(5,3);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas pared desde (6,3) hasta (7,3)
		for (x=6;x<7;y++){
			punto = new Point(x,3);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (8,3)
		punto = new Point(8,3);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (9,3)
		punto = new Point(9,3);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (10,3)
		punto = new Point(10,3);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (3,11) hasta (3,12)
		for (y=11;y<12;y++){
			punto = new Point(3,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//TODO agrego punto ordinario posicion (3,13)
		
		punto = new Point(3,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (3,14) hasta (3,15)
		for (y=14;y<15;y++){
			punto = new Point(3,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
			
		
		//TODO agrego las celdas desde (4,3) hasta (4,4)
		for (y=3;y<4;y++){
			punto = new Point(4,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		
		//TODO agrego punto ordinario posicion (4,5)
		
		punto = new Point(4,5);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (4,6) hasta (7,7)
		for (y=6;y<7;y++){
			punto = new Point(4,y);
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
		for (y=11;y<12;y++){
			punto = new Point(4,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
				
		//TODO agrego punto ordinario posicion (4,15)
		
		punto = new Point(4,15);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (4,14) hasta (4,15)
		for (y=14;y<15;y++){
			punto = new Point(4,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (5,3) hasta (5,15)
		for (y=3;y<15;y++){
			punto = new Point(5,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		
		//TODO agrego las celdas desde (6,3) hasta (6,5)
		for (y=3;y<5;y++){
			punto = new Point(6,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (6,6)
		
		punto = new Point(6,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (6,7) hasta (6,8)
		for (y=7;y<8;y++){
			punto = new Point(6,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego puerta posicion (6,9)
		
		punto = new Point(6,9);
		celda = new CeldaPuerta(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		//TODO agrego las celdas desde (6,10) hasta (6,11)
		for (y=10;y<11;y++){
			punto = new Point(6,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego punto ordinario posicion (6,12)
		
		punto = new Point(6,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (6,13) hasta (6,15)
		for (y=13;y<15;y++){
			punto = new Point(6,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (7,3) hasta (7,5)
		for (y=3;y<5;y++){
			punto = new Point(7,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego punto ordinario posicion (7,6)
		
		punto = new Point(7,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		
		
		//TODO agrego las celdas desde (7,7) hasta (7,11)
		for (y=7;y<11;y++){
			punto = new Point(7,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
	
		//TODO agrego punto ordinario posicion (7,12)
		
		punto = new Point(7,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (7,13) hasta (7,15)
		for (y=13;y<15;y++){
			punto = new Point(7,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (8,3) hasta (8,5)
		for (y=3;y<5;y++){
			punto = new Point(8,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego punto ordinario posicion (8,6)
		
		punto = new Point(8,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (8,7) hasta (8,11)
		for (y=7;y<11;y++){
			punto = new Point(8,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego punto ordinario posicion (8,12)
		
		punto = new Point(8,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (8,13) hasta (8,15)
		for (y=13;y<15;y++){
			punto = new Point(8,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		
		
		//TODO agrego las celdas desde (9,3) hasta (9,15)
		for (y=3;y<15;y++){
			punto = new Point(9,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
	
		
		//TODO agrego las celdas desde (10,3) hasta (10,5)
		for (y=3;y<5;y++){
			punto = new Point(10,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (10,6)
		
		punto = new Point(10,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (10,6) hasta (10,11)
		for (y=6;y<16;y++){
			punto = new Point(10,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego punto ordinario posicion (10,12)
		
		punto = new Point(10,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (10,13) hasta (10,15)
		for (y=13;y<15;y++){
			punto = new Point(10,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (11,3) hasta (11,5)
		for (y=4;y<6;y++){
			punto = new Point(12,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (11,6) hasta (11,8)
		for (y=6;y<8;y++){
			punto = new Point(11,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//TODO agrego pared posicion (11,9)
		
		punto = new Point(11,9);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//TODO agrego las celdas desde (11,10) hasta (11,12)
		for (y=10;y<12;y++){
			punto = new Point(11,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		
		//TODO agrego las celdas desde (11,13) hasta (11,15)
		for (y=14;y<16;y++){
			punto = new Point(12,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (12,3) hasta (12,7)
		for (y=3;y<7;y++){
			punto = new Point(12,y);
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
		for (y=11;y<15;y++){
			punto = new Point(12,y);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//TODO agrego las celdas desde (13,3) hasta (13,7)
		for (y=3;y<7;y++){
			punto = new Point(13,y);
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
		for (y=11;y<15;y++){
			punto = new Point(13,y);
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
