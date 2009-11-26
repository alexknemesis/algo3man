package grupo9.algo3man.modelo;

public class Matriz {
	
	private Celda matriz[][];
	
	public Matriz(int N,int M){
		matriz = new Celda[N][M];
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
		if ((i >this.getFilas()) | (i < this.getFilas())| (j >this.getColumnas()) | (j < this.getColumnas())){
			throw new RangoException();
		}
		
		return this.matriz[i][j];
	}
	
	

}
