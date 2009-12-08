package grupo9.algo3man.vista;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;

public class VistaFantasmaNaranja implements Dibujable {
	private Fantasma fantasma;
	
	public VistaFantasmaNaranja(Fantasma fantasma){
		this.fantasma = fantasma;
	}

	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Posicionable getPosicionable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosicionable(Posicionable posicionable) {
		// TODO Auto-generated method stub
		
	}
}
