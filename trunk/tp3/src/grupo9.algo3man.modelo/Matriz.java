package modelo;

public class Matriz {
	
	private Celda matriz[][];
	
	public Matriz(int N,int M){
		matriz = new Celda[N][M];
	}

	public void agregar(Celda micelda, int i, int j)  {
		if ((i >this.matriz.length) && (j > this.matriz[0].length)){
			throw new RangoException();
		}
		
		this.matriz[i][j]=micelda;
		
	}

	public int getFilas() {
		
		return this.matriz.length;
	}

	public int getColumnas() {
		
		return this.matriz[0].length;
	}

	public Celda getCelda(int i, int j) {
		if ((i >this.matriz.length) | (i < this.matriz.length)| (j >this.matriz.length) | (j < this.matriz.length)){
			throw new RangoException();
		}
		
		return this.matriz[i][j];
	}
	
	

}
