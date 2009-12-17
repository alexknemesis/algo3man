package grupo9.algo3man.vista;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import grupo9.algo3man.controlador.EscuchadorDeTeclado;
import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.titiritero.vista.Ventana;


public class Algo3Man extends Ventana implements ActionListener{

	private static final long serialVersionUID = 1L;

	private Juego juego;
	private MenuItem menuItemStart, menuItemPause;
	private boolean pausado;
	private SonidoThread sonidoComienzo;


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
		this.menuItemPause.setEnabled(false);
		
		pausado = false;

		MenuBar barraMenu = new MenuBar();
		barraMenu.add(menu);
		this.setMenuBar(barraMenu);
		this.setTitle("Algo3Man");
		
		 
		

	}

	public static void main(String args[]){
		Juego juego = new Juego();
		EscuchadorDeTeclado escuchador = null;

		
		PuntoPosicionable posicionable = new PuntoPosicionable(new Point(1,1));
		int dimensionX = (int) (juego.getDimensiones().getX()*posicionable.getX());
		int dimensionY = (int) (juego.getDimensiones().getY()*posicionable.getY());
		final Algo3Man algo3man = new Algo3Man(dimensionX, dimensionY, juego);
		
		algo3man.setSize(600,600);
		algo3man.setResizable(false);
		algo3man.setVisible(true);
		escuchador = new EscuchadorDeTeclado(juego);
		algo3man.addKeyListener(escuchador);
		
		

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.menuItemStart){
			sonidoComienzo = new SonidoThread("sonidos/pac_start.wav");
			sonidoComienzo.start();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.juego.comenzarJuego();
			this.menuItemPause.setEnabled(true);
			

		}else if(e.getSource() == this.menuItemPause){
			if (pausado){
				this.juego.continuarJuego();
				this.menuItemPause.setLabel("Pausa");
				pausado = false;
			}else{
				this.juego.pausarJuego();
				this.menuItemPause.setLabel("Continuar");
				pausado = true;

			}
			

		}
	}




}
