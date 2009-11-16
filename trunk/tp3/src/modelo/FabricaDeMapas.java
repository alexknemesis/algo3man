package modelo;

import java.awt.Point;

public class FabricaDeMapas {
	
	public static Mapa obtenerMapa(int num){
		switch(num){
		case 1: return crearMapa1();
		default: return null;
		}
		
		
		
		
	}
	
	
	

	private static Mapa crearMapa1(){
		Celda celda;
		Mapa mapa;
		Point punto;
		
		mapa = new Mapa();
		
		celda = new CeldaPared();
		
		punto = new Point(1,1);
		mapa.agregar(punto,celda);
		
		punto = new Point(1,2);
		mapa.agregar(punto,celda);
		
		punto = new Point(1,3);
		mapa.agregar(punto,celda);
		
		
		
		
		
		return null;
		
	}

}
