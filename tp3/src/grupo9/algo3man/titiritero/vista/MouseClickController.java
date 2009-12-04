package grupo9.algo3man.titiritero.vista;

import grupo9.algo3man.titiritero.ControladorJuego;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseClickController extends MouseAdapter {

	private ControladorJuego controlador; 
	
	public MouseClickController(ControladorJuego unControlador) {
		this.controlador = unControlador;
	}
	
	public void mouseClicked(MouseEvent e){
		this.controlador.despacharMouseClick(e.getX(), e.getY());
	}
	
}
