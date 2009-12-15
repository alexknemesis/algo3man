package grupo9.algo3man.vista;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.Personaje;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Imagen;

public class VistaFantasmaNaranja extends Imagen implements Dibujable {
	private Fantasma fantasma;

	public VistaFantasmaNaranja(Fantasma fantasma){
		super();
		this.setPosicionable(fantasma);

		this.fantasma = fantasma;
		this.setNombreArchivoImagen("imagenes/FantasmaNaranjaAbajo.png");
	}

	public void dibujar(SuperficieDeDibujo superfice) {

		if(this.fantasma.getEstado() != Fantasma.HUYENDO){

			switch (this.fantasma.getDireccion()){
			case Personaje.ABAJO:
				this.setNombreArchivoImagen("imagenes/FantasmaNaranjaAbajo.png");
				break;
			case Personaje.ARRIBA:
				this.setNombreArchivoImagen("imagenes/FantasmaNaranjaArriba.png");
				break;
			case Personaje.IZQUIERDA:
				this.setNombreArchivoImagen("imagenes/FantasmaNaranjaIzquierda.png");
				break;
			case Personaje.DERECHA:
				this.setNombreArchivoImagen("imagenes/FantasmaNaranjaDerecha.png");
				break;
			}

		}else
			this.setNombreArchivoImagen("imagenes/FantasmaAsustado.png");
		this.setPosicionable(fantasma);
		super.dibujar(superfice);
	}

	public Posicionable getPosicionable() {
		return new PuntoPosicionable(this.fantasma.getPosicion());
	}

	public void setPosicionable(Posicionable posicionable) {

		this.fantasma = (Fantasma) posicionable;
	}
}
