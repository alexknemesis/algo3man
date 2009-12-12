package grupo9.algo3man.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import grupo9.algo3man.modelo.Juego;
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
		int dimensionX = (int) (juego.getDimensiones().getX()*juego.TAMANIO_CELDA_PIXELES);
		int dimensionY = (int) (juego.getDimensiones().getY()*juego.TAMANIO_CELDA_PIXELES);
		Panel panelPacman = new Panel(dimensionX, dimensionY, juego.getControlador());
		juego.getControlador().setSuperficieDeDibujo(panelPacman);
		this.getContentPane().add(panelPacman);
		
	}
	
	public static void main(String args[]){
		Algo3Man algo3man = new Algo3Man();
		
		algo3man.setSize(600,400);
		algo3man.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.menuItemStart)
			this.juego.comenzarJuego();
		else if(e.getSource() == this.menuItemPause)
			this.juego.pausarJuego();
		
	}
}
