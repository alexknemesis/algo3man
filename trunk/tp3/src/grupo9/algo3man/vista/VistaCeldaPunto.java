package grupo9.algo3man.vista;

import grupo9.algo3man.modelo.CeldaPunto;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Imagen;

public class VistaCeldaPunto extends Imagen implements Dibujable {
	private CeldaPunto celda;
	private boolean celdaComida;
	private SonidoThread sonidoComida;
	private SonidoThread sonidoComidaPoderosa;
	private boolean daPoder;

	public VistaCeldaPunto(int ancho, int alto, CeldaPunto celda) {
		super();
		celdaComida = false;

		this.setPosicionable(celda);
		daPoder = this.celda.daPoder();
		if(daPoder)
			this.setNombreArchivoImagen("imagenes/puntoGrande.png");
		else
			this.setNombreArchivoImagen("imagenes/puntoChico.png");

	}

	public void dibujar(SuperficieDeDibujo superfice) {
		
		if (!celdaComida){
			if(this.celda.isComido()){
				this.setNombreArchivoImagen("imagenes/Vacio.png");
				celdaComida = true;
				if (daPoder){
					sonidoComidaPoderosa = new SonidoThread("sonidos/pac_powerup.wav");
					sonidoComidaPoderosa.start();
				}else{
					sonidoComida = new SonidoThread("sonidos/pac_chomp.wav");
					sonidoComida.start();
				}
			}
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



	
