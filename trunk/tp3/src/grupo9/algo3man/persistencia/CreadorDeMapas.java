package grupo9.algo3man.persistencia;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CreadorDeMapas extends JFrame implements KeyListener{

	private static final int ANCHO_CELDA = 16;
	private static final int ANCHO_MAPA = 28;
	private static final int ALTO_MAPA = 31;
	private static final String ARCHIVO_XML = "mapa0.xml";

	private static final long serialVersionUID = 1L;

	private ArrayList<ImagenAGuardar> imagenes;
	private ImagenAGuardar [][] grillaImagenes;
	private JInternalFrame grilla, frameDerecho;
	
	private JLabel label;
	private int xGrilla;
	private int yGrilla;
	private int yTools;
	
	private File archivo;

	public static void main (String[] args) {
		CreadorDeMapas ejemplo = new CreadorDeMapas();
		ejemplo.setVisible (true); 
	}

	CreadorDeMapas() {
		super ("Creador de Mapas");
		this.setResizable(false);
		setSize (1024, 600); 
		
		grillaImagenes = new ImagenAGuardar[ANCHO_MAPA][ALTO_MAPA];

		grilla = new JInternalFrame();
		this.add(grilla);
		this.grilla.setBounds(16, 16 , ANCHO_MAPA * ANCHO_CELDA + 1, ALTO_MAPA * ANCHO_CELDA +1);


		frameDerecho = new JInternalFrame();
		this.add(frameDerecho);
		this.frameDerecho.setBounds(600, 16 , 400, 600);
		
		label = new JLabel("Hola");
		
		this.label.setBounds(16, 16, 100, 100);
		this.label.setVisible(true);
		
		
		imagenes = new ArrayList<ImagenAGuardar>();
		cargarImagenes();
		llenarGrillaDeVacios();
		
		xGrilla = 0;
		yGrilla = 0;
		addKeyListener (this);
		
		addWindowListener (new WindowAdapter(){

			@Override
			public void windowClosing (WindowEvent e) {
				System.exit(0);
			}

		});
	}

	private void llenarGrillaDeVacios() {
		ImagenAGuardar auxImagen;
		for(int x =0; x< ANCHO_MAPA; x++){
			for (int y = 0; y< ALTO_MAPA; y++){
					auxImagen=(ImagenAGuardar) imagenes.get(0).clone();
					auxImagen.setPosicion(new Point(x,y));
					grillaImagenes[x][y]= auxImagen;
			}
		}
	
	}

	@Override
	public void keyPressed (KeyEvent e) {
		ImagenAGuardar auxImagen;
		boolean cambio = true;
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_UP:
			yGrilla-= ANCHO_CELDA;
			if (yGrilla < 0)
				yGrilla=0;
			
			break;
		case KeyEvent.VK_DOWN:
			yGrilla+= ANCHO_CELDA;
			if (yGrilla > ((ALTO_MAPA-1) * ANCHO_CELDA))
				yGrilla=((ALTO_MAPA-1) * ANCHO_CELDA);

			break;
		case KeyEvent.VK_LEFT:
			xGrilla-=ANCHO_CELDA;
			if (xGrilla < 0)
				xGrilla=0;

			break;
		case KeyEvent.VK_RIGHT:
			xGrilla+=ANCHO_CELDA;
			if (xGrilla > ((ANCHO_MAPA-1) * ANCHO_CELDA))
				xGrilla=((ANCHO_MAPA-1) * ANCHO_CELDA);

			break;
		case KeyEvent.VK_NUMPAD8:
			
			yTools--;
			if (yTools < 0)
				yTools=0;

			break;
		case KeyEvent.VK_NUMPAD2:
			yTools++;
			if (yTools > (imagenes.size()-1))
				yTools=imagenes.size()-1;

			break;
		case KeyEvent.VK_ENTER:
			auxImagen = (ImagenAGuardar) imagenes.get(yTools).clone();
			auxImagen.setPosicion(new Point(xGrilla,yGrilla));
			grillaImagenes[xGrilla / ANCHO_CELDA][yGrilla / ANCHO_CELDA]= auxImagen;
			
			break;

		case KeyEvent.VK_F12:
			guardarComoXML();
			break;

		default:
			cambio = false;
		}
		if(cambio)
			repaint();
	}



	@Override
	public void paint (Graphics g) {
			
			dibujarGrilla(this.grilla.getGraphics());
			dibujarImagenes(this.frameDerecho.getGraphics());
			dibujarSeparadores(this.frameDerecho.getGraphics());
			
			
			

	}
	
	private void dibujarSeparadores(Graphics graphics) {
		
		for (int y = 1; y<= this.imagenes.size()+1; y++){
			graphics.setColor(Color.WHITE);
			graphics.drawLine(0, y*16, 16, y*16);
		}
		graphics.drawLine(0, ANCHO_CELDA, 0, (this.imagenes.size()+1)*ANCHO_CELDA);
		graphics.drawLine(ANCHO_CELDA, ANCHO_CELDA, ANCHO_CELDA, (this.imagenes.size()+1)*ANCHO_CELDA);
		graphics.setColor(Color.RED);
		graphics.drawRect(0, (yTools+1)*ANCHO_CELDA, ANCHO_CELDA, ANCHO_CELDA);
		graphics.setColor(Color.BLACK);
		
	}

	public void dibujarGrilla(Graphics g){
		for(int x =0; x< ANCHO_MAPA; x++)
			for (int y = 0; y< ALTO_MAPA; y++)
				g.drawImage(grillaImagenes[x][y].getImage(),x*ANCHO_CELDA,y*ANCHO_CELDA,grillaImagenes[x][y].getImageObserver());
		
		
		for (int x = 0; x<= (ANCHO_MAPA*ANCHO_CELDA)+1; x+= ANCHO_CELDA){
			g.drawLine(x, 0, x, ALTO_MAPA * ANCHO_CELDA);
			
		}
		for (int y = 0; y<= (ALTO_MAPA*ANCHO_CELDA)+1; y+= ANCHO_CELDA){
			g.drawLine(0, y, ANCHO_MAPA * ANCHO_CELDA, y);
		}
		g.setColor(Color.RED);
		g.drawRect(xGrilla, yGrilla, ANCHO_CELDA, ANCHO_CELDA);
		g.setColor(Color.BLACK);

	}
	
	public void dibujarImagenes(Graphics g){
		ImagenAGuardar imagen;
		for (int i =0; i < imagenes.size(); i++){
			imagen = imagenes.get(i);
			g.drawImage(imagen.getImage(), imagen.getPosicion().x*ANCHO_CELDA, imagen.getPosicion().y*ANCHO_CELDA, imagen.getImageObserver());
		}
	}
	
	public void cargarImagenes(){
		imagenes.add ( new ImagenAGuardar("imagenes/vacio.png","CeldaVacia",new Point(0,1)));
		imagenes.add ( new ImagenAGuardar("imagenes/dobleBordeDer.png","CeldaPared",new Point(0,2)));
		imagenes.add ( new ImagenAGuardar("imagenes/dobleBordeInf.png","CeldaPared",new Point(0,3)));
		imagenes.add ( new ImagenAGuardar("imagenes/dobleBordeIzq.png","CeldaPared",new Point(0,4)));
		imagenes.add ( new ImagenAGuardar("imagenes/dobleBordeSup.png","CeldaPared",new Point(0,5)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaDobleInfDer.png","CeldaPared",new Point(0,6)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaDobleInfIzq.png","CeldaPared",new Point(0,7)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaDobleSupDer.png","CeldaPared",new Point(0,8)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaDobleSupIzq.png","CeldaPared",new Point(0,9)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaRectaInfDer.png","CeldaPared",new Point(0,10)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaRectaInfIzq.png","CeldaPared",new Point(0,11)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaRectaSupDer.png","CeldaPared",new Point(0,12)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaRectaSupIzq.png","CeldaPared",new Point(0,13)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaSimpleInfDer.png","CeldaPared",new Point(0,14)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaSimpleInfIzq.png","CeldaPared",new Point(0,15)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaSimpleSupDer.png","CeldaPared",new Point(0,16)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaSimpleSupIzq.png","CeldaPared",new Point(0,17)));
		imagenes.add ( new ImagenAGuardar("imagenes/lineaHorizAlta.png","CeldaPared",new Point(0,18)));
		imagenes.add ( new ImagenAGuardar("imagenes/lineaHorizBaja.png","CeldaPared",new Point(0,19)));
		imagenes.add ( new ImagenAGuardar("imagenes/lineaVertDerecha.png","CeldaPared",new Point(0,20)));
		imagenes.add ( new ImagenAGuardar("imagenes/lineaVertIzquierda.png","CeldaPared",new Point(0,21)));
		imagenes.add ( new ImagenAGuardar("imagenes/puerta.png","CeldaPuerta",new Point(0,22)));
		imagenes.add ( new ImagenAGuardar("imagenes/puntoChico.png","PuntoOrdinario",new Point(0,23)));
		imagenes.add ( new ImagenAGuardar("imagenes/puntoGrande.png","PuntoPoder",new Point(0,24)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaSimpleInfDerLineaArriba.png","CeldaPared",new Point(0,25)));
		imagenes.add ( new ImagenAGuardar("imagenes/esquinaSimpleInfIzqLineaArriba.png","CeldaPared",new Point(0,26)));
		imagenes.add ( new ImagenAGuardar("imagenes/posPreferidaFantasmaCeleste.png","PosPreferidaFantasmaCeleste",new Point(0,27)));
		imagenes.add ( new ImagenAGuardar("imagenes/posPreferidaFantasmaNaranja.png","PosPreferidaFantasmaNaranja",new Point(0,28)));
		imagenes.add ( new ImagenAGuardar("imagenes/posPreferidaFantasmaRojo.png","PosPreferidaFantasmaRojo",new Point(0,29)));
		imagenes.add ( new ImagenAGuardar("imagenes/posPreferidaFantasmaVioleta.png","PosPreferidaFantasmaVioleta",new Point(0,30)));
		
		

	}
	
	private void guardarComoXML(){
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	String nombreArchivo = chooser.getSelectedFile().getPath();
			try{
			    File file = new File (nombreArchivo);
    			FileWriter out = new FileWriter(file);
    			for(int x =0; x< ANCHO_MAPA; x++)
    				for (int y = 0; y< ALTO_MAPA; y++)
    					out.write(grillaImagenes[x][y].getXML());
    			out.close();
    		}
  			catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No se Pudo Guardar '" +nombreArchivo + "'","Error de Escritura",JOptionPane.ERROR_MESSAGE);  						
  			}
        }	
    }	

	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

}