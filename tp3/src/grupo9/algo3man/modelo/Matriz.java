package grupo9.algo3man.modelo;

public class Matriz {
	
	private Celda matriz[][];
	
	public Matriz(int N,int M){
		if (N<0 || M<0){
			throw new RangoException();
		}
		
		this.matriz = new Celda[N][M];
	}

	public void agregar(Celda micelda, int i, int j)  {
		
		
		if ((i >this.getFilas()) || (j > this.getColumnas())){

		
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
		if ((i >=this.getFilas()) || (i < 0) || (j >=this.getColumnas()) || (j < 0)){
			throw new RangoException();
		}
		
		return this.matriz[i][j];
	}
	
	

}
