package grupo9.algo3man.vista;

import grupo9.algo3man.modelo.CeldaPunto;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Imagen;

public class VistaCeldaPunto extends Imagen implements Dibujable {
	private CeldaPunto celda;

	public VistaCeldaPunto(int ancho, int alto, CeldaPunto celda) {
		super();


		this.setPosicionable(celda);
		this.setNombreArchivoImagen("imagenes/FantasmaCelesteAbajo.png");
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		
		if(this.celda.isComido())
			this.setNombreArchivoImagen("imagenes/Vacio.png");
		else{
			if(this.celda.daPoder())
				this.setNombreArchivoImagen("imagenes/puntoGrande.png");
			else
				this.setNombreArchivoImagen("imagenes/puntoChico.png");
		}

		super.dibujar(superfice);
	}

	public Posicionable getPosicionable() {
		return new PuntoPosicionable(this.celda.getPosicion());
	}

	public void setPosicionable(Posicionable posicionable) {
		this.celda = (CeldaPunto) posicionable;
	}
}



	
