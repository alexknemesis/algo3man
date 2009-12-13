package grupo9.algo3man.vista;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import grupo9.algo3man.modelo.Juego;
import grupo9.algo3man.modelo.PuntoPosicionable;
import grupo9.algo3man.titiritero.vista.Panel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Algo3Man extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JMenu menu;
	private JMenuItem menuItemStart, menuItemPause;
	private Juego juego;
	private Panel panelPacman;
	
	public Algo3Man(){
		super("Algo3Man");
		
		this.menu = new JMenu("Juego");
		this.menuItemStart = new JMenuItem("Nuevo Juego");
		this.menuItemStart.setMnemonic(KeyEvent.VK_F2);
		this.menuItemStart.addActionListener(this);
		this.menu.add(menuItemStart);
		this.menuItemPause = new JMenuItem("Pausa");
		this.menuItemPause.addActionListener(this);
		this.menu.add(menuItemPause);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menu);
		this.setJMenuBar(barraMenu);
		
		this.juego = new Juego();
		PuntoPosicionable posicionable = new PuntoPosicionable(new Point(1,1));
		int dimensionX = (int) (juego.getDimensiones().getX()*posicionable.getX());
		int dimensionY = (int) (juego.getDimensiones().getY()*posicionable.getY());
		this.panelPacman = new Panel(dimensionX, dimensionY, juego.getControlador());
		juego.getControlador().setSuperficieDeDibujo(panelPacman);
		this.getContentPane().add(panelPacman);
		
		addWindowListener (new WindowAdapter(){

			@Override
			public void windowClosing (WindowEvent e) {
				juego.pausarJuego();
				System.exit(0);
			}

		});
		
	}
	
	public static void main(String args[]){
		Algo3Man algo3man = new Algo3Man();
		
		algo3man.setSize(600,600);
		algo3man.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.menuItemStart)
			this.juego.comenzarJuego();
		else if(e.getSource() == this.menuItemPause)
			this.juego.pausarJuego();
		
	}
}
