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
		mapa.setPosFreferidaVioleta(new Point(3,3));
		mapa.setPosPreferidaCeleste(new Point(15,3));
		mapa.setPosPreferidaNaranja(new Point(4,11));
		mapa.setPosPreferidaRojo(new Point(14,11));
		mapa.setPuntajePremio(200);
		
		// agrego las celdas desde (0,0) hasta (18,0)
		for (x=0;x<18+1;x++){
			punto = new Point(x,0);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (0,16) hasta (18,16)
		for (x=0;x<18+1;x++){
			punto = new Point(x,16);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (0,1) hasta (0,15)
		for (y=1;y<15+1;y++){
			punto = new Point(0,y);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (18,1) hasta (18,15)
		for (y=1;y<15+1;y++){
			punto = new Point(18,y);
			celda = new CeldaVacia(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (1,1) hasta (17,1)
		for (x=1;x<17+1;x++){
			punto = new Point(x,1);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (1,15) hasta (17,15)
		for (x=1;x<17+1;x++){
			punto = new Point(x,15);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (1,2) hasta (1,14)
		for (y=2;y<14+1;y++){
			punto = new Point(1,y);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (17,2) hasta (17,14)
		for (y=2;y<14+1;y++){
			punto = new Point(17,y);
			celda = new CeldaPared(mapa,punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (2,2) hasta (16,2)
		for (x=2;x<16+1;x++){
			punto = new Point(x,2);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (2,14) hasta (16,14)
		for (x=2;x<16+1;x++){
			punto = new Point(x,14);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (2,4) hasta (2,12)
		for (y=4;y<12+1;y++){
			punto = new Point(2,y);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas punto ordinario desde (16,4) hasta (16,12)
		for (y=4;y<12+1;y++){
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
		for (x=3;x<4+1;x++){
			punto = new Point(x,3);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (5,3)
		punto = new Point(5,3);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas pared desde (6,3) hasta (7,3)
		for (x=6;x<7+1;x++){
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
		
		
		//agrego las celdas pared desde (11,3) hasta (12,3)
		for (x=11;x<12+1;x++){
			punto = new Point(x,3);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (13,3)
		punto = new Point(13,3);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas pared desde (14,3) hasta (15,3)
		for (x=14;x<15+1;x++){
			punto = new Point(x,3);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (3,4) hasta (4,4)
		for (x=3;x<4+1;x++){
			punto = new Point(x,4);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (5,4)
		punto = new Point(5,4);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (6,4) hasta (7,4)
		for (x=6;x<7+1;x++){
			punto = new Point(x,4);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (8,4)
		punto = new Point(8,4);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (9,4)
		punto = new Point(9,4);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (10,4)
		punto = new Point(10,4);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (11,4) hasta (12,4)
		for (x=11;x<12+1;x++){
			punto = new Point(x,4);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (13,4)
		punto = new Point(13,4);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (14,4) hasta (15,4)
		for (x=14;x<15+1;x++){
			punto = new Point(x,4);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego los puntos ordinarios desde (3,5) hasta (15,5)
		for (x=3;x<15+1;x++){
			punto = new Point(x,5);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (3,6) hasta (5,6)
		for (x=3;x<5+1;x++){
			punto = new Point(x,6);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (6,6)
		punto = new Point(6,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (7,6) hasta (8,6)
		for (x=7;x<8+1;x++){
			punto = new Point(x,6);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego puerta posicion (9,6)
		punto = new Point(9,6);
		celda = new CeldaPuerta(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (10,6) hasta (11,6)
		for (x=10;x<11;x++){
			punto = new Point(x,6);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (12,6)
		punto = new Point(12,6);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (13,6) hasta (15,6)
		for (x=13;x<15+1;x++){
			punto = new Point(x,6);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas pared desde (3,7) hasta (5,7)
		for (x=3;x<5+1;x++){
			punto = new Point(x,7);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (6,7)
		punto = new Point(6,7);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas pared desde (7,7) hasta (11,7)
		for (x=7;x<11+1;x++){
			punto = new Point(x,7);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (12,7)
		punto = new Point(12,7);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (13,7) hasta (15,7)
		for (x=13;x<15+1;x++){
			punto = new Point(x,7);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (3,8) hasta (5,8)
		for (x=3;x<5+1;x++){
			punto = new Point(x,8);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (6,8)
		punto = new Point(6,8);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (7,8) hasta (11,8)
		for (x=7;x<11+1;x++){
			punto = new Point(x,8);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (12,8)
		punto = new Point(12,8);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (13,8) hasta (15,8)
		for (x=13;x<15+1;x++){
			punto = new Point(x,8);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (3,9) hasta (15,9)
		for (x=3;x<15+1;x++){
			punto = new Point(x,9);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (3,10) hasta (5,10)
		for (x=3;x<5+1;x++){
			punto = new Point(x,10);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (6,10)
		punto = new Point(6,10);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (7,10) hasta (11,10)
		for (x=7;x<11+1;x++){
			punto = new Point(x,10);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (12,10)
		punto = new Point(12,10);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (13,10) hasta (15,10)
		for (x=13;x<15+1;x++){
			punto = new Point(x,10);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		
		//agrego las celdas desde (3,11) hasta (5,11)
		for (x=3;x<5+1;x++){
			punto = new Point(x,11);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (6,11) hasta (8,11)
		for (x=6;x<8+1;x++){
			punto = new Point(x,11);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego pared posicion (9,11)
		punto = new Point(9,11);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego las celdas desde (10,11) hasta (12,11)
		for (x=10;x<12+1;x++){
			punto = new Point(x,11);
			celda = new PuntoOrdinario(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (13,11) hasta (15,11)
		for (x=13;x<15+1;x++){
			punto = new Point(x,11);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (3,12) hasta (7,12)
		for (x=3;x<7+1;x++){
			punto = new Point(x,12);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (8,12)
		punto = new Point(8,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (9,12)
		punto = new Point(9,12);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (10,12)
		punto = new Point(10,12);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (11,12) hasta (15,12)
		for (x=11;x<15+1;x++){
			punto = new Point(x,12);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego las celdas desde (3,13) hasta (7,13)
		for (x=3;x<7+1;x++){
			punto = new Point(x,13);
			celda = new CeldaPared(mapa, punto);
			mapa.agregar(punto, celda);
		}
		
		//agrego punto ordinario posicion (8,13)
		punto = new Point(8,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego pared posicion (9,13)
		punto = new Point(9,13);
		celda = new CeldaPared(mapa, punto);
		mapa.agregar(punto, celda);
		
		//agrego punto ordinario posicion (10,13)
		punto = new Point(10,13);
		celda = new PuntoOrdinario(mapa, punto);
		mapa.agregar(punto, celda);
		
		
		//agrego las celdas desde (11,13) hasta (15,13)
		for (x=11;x<15+1;x++){
			punto = new Point(x,13);
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
