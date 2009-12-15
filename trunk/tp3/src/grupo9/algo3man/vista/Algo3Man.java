package grupo9.algo3man.vista;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.vista.Ventana;

public class Algo3Man extends Ventana implements ActionListener{

	private static final long serialVersionUID = 1L;

	private Juego juego;
	private MenuItem menuItemStart, menuItemPause;


	public Algo3Man(int dimensionX, int dimensionY, Juego juego){
		super(dimensionX, dimensionY,juego.getControlador());
		this.juego = juego;
		this.juego.getControlador().setSuperficieDeDibujo(this);

		Menu menu = new Menu("Juego");
		this.menuItemStart = new MenuItem("Nuevo Juego");
		this.menuItemStart.addActionListener(this);
		menu.add(menuItemStart);
		this.menuItemPause = new MenuItem("Pausa");
		this.menuItemPause.addActionListener(this);
		menu.add(menuItemPause);

		MenuBar barraMenu = new MenuBar();
		barraMenu.add(menu);
		this.setMenuBar(barraMenu);

	}

	public static void main(String args[]){
		Juego juego = new Juego();

		PuntoPosicionable posicionable = new PuntoPosicionable(new Point(1,1));
		int dimensionX = (int) (juego.getDimensiones().getX()*posicionable.getX());
		int dimensionY = (int) (juego.getDimensiones().getY()*posicionable.getY());
		final Algo3Man algo3man = new Algo3Man(dimensionX, dimensionY, juego);

		algo3man.setSize(600,600);
		algo3man.setResizable(false);
		algo3man.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.menuItemStart){
			this.juego.comenzarJuego();

		}else if(e.getSource() == this.menuItemPause){
			this.juego.pausarJuego();

		}
	}



}
