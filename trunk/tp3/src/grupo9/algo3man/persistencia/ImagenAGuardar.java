package grupo9.algo3man.persistencia;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;


public class ImagenAGuardar implements Cloneable{
	ImageIcon imagen;
	String nombreArchivoImagen;
	String clase;
	Point posicion;
	public ImagenAGuardar(String nombreArchivoImagen, String claseCelda, Point posicion) {
		this.clase = claseCelda;
		this.nombreArchivoImagen = nombreArchivoImagen;
		this.posicion = posicion;
		this.imagen = new ImageIcon(nombreArchivoImagen);
	}
	
	public String getNombreArchivoImagen(){
		return this.nombreArchivoImagen;
	}
	
	public Image getImage(){
		return this.imagen.getImage();
	}
	
	public String getTipoCelda(){
		return this.clase;
	}
	
	public void setPosicion(Point nuevaPosicion){
		this.posicion = nuevaPosicion;
	}
	
	public Point getPosicion(){
		return this.posicion;
	}
	
	public String getXML(){
		String total = null;
		total = "<" + this.clase + ">\n\t";
		total += "<NombreArchivo>" + this.nombreArchivoImagen + "</NombreArchivo>\n\t";
		total += "<PosicionX>" + String.valueOf(this.posicion.x) + "</PosicionX>\n\t";
		total += "<PosicionY>" + String.valueOf(this.posicion.y) + "</PosicionY>\n";
		total += "</" + this.clase + ">\n";
		
		
		return total;
	}
	
	public Object clone(){
		ImagenAGuardar nuevoObjeto;
		nuevoObjeto = new ImagenAGuardar(this.nombreArchivoImagen, this.clase, this.posicion);
		
		return nuevoObjeto;
	}

	public ImageObserver getImageObserver() {
		
		return imagen.getImageObserver();
	}
	
}
