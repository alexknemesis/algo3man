package grupo9.algo3man.titiritero.vista;

import grupo9.algo3man.titiritero.ControladorJuego;
import grupo9.algo3man.titiritero.SuperficieDeDibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Panel extends java.awt.Panel implements SuperficieDeDibujo {


	private static final long serialVersionUID = -5159188497592488407L;
	private Image imagen;

	// es llamado internamente por el metodo repaint() de la clase Frame
	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		g.drawImage(this.imagen, 0, 0, null);
	}
	
	public void actualizar() {
		this.repaint();
	}

	public void limpiar() {
		if(this.imagen == null)
			this.imagen = this.createImage(getSize().width, getSize().height);
		Graphics superficieParaDibujar =  this.imagen.getGraphics();
		superficieParaDibujar.setColor(Color.YELLOW);// 
		superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);
		this.setBackground(Color.RED);
	}

	public Object getBuffer(){
		return this.imagen.getGraphics();
	}
	
	public Panel(int ancho,int alto, ControladorJuego unControlador){
		this.addMouseListener(new MouseClickController(unControlador));
		this.setSize(ancho, alto);
		this.setVisible(true);
	}
	

}
