package modelo;

public abstract class FabricaDeMapas {
	
	protected Mapa mapa; 
	
	public FabricaDeMapas(){
		mapa = new Mapa();
		
	}
	
	

	public abstract Mapa crearMapa();

}
