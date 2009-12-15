package grupo9.algo3man.vista;

import grupo9.algo3man.modelo.Fantasma;
import grupo9.algo3man.modelo.Personaje;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.Dibujable;
import grupo9.algo3man.titiritero.Posicionable;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;
import grupo9.algo3man.titiritero.vista.Imagen;

public class VistaFantasmaCeleste extends Imagen implements Dibujable {
	private Fantasma fantasma;

	public VistaFantasmaCeleste(Fantasma fantasma){
		super();
		this.setPosicionable(fantasma);

		this.fantasma = fantasma;
		this.setNombreArchivoImagen("imagenes/FantasmaCelesteAbajo.png");
	}

	public void dibujar(SuperficieDeDibujo superfice) {

		if(this.fantasma.getEstado() != Fantasma.HUYENDO){

			switch (this.fantasma.getDireccion()){
			case Personaje.ABAJO:
				this.setNombreArchivoImagen("imagenes/FantasmaCelesteAbajo.png");
				break;
			case Personaje.ARRIBA:
				this.setNombreArchivoImagen("imagenes/FantasmaCelesteArriba.png");
				break;
			case Personaje.IZQUIERDA:
				this.setNombreArchivoImagen("imagenes/FantasmaCelesteIzquierda.png");
				break;
			case Personaje.DERECHA:
				this.setNombreArchivoImagen("imagenes/FantasmaCelesteDerecha.png");
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
