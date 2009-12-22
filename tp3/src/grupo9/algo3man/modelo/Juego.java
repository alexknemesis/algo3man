package grupo9.algo3man.modelo;

import grupo9.algo3man.titiritero.ControladorJuego;
import grupo9.algo3man.vista.Algo3Man;
import grupo9.algo3man.vista.PuntoPosicionable;
import grupo9.algo3man.vista.VistaCeldaPared;
import grupo9.algo3man.vista.VistaCeldaPunto;
import grupo9.algo3man.vista.VistaFantasmaCeleste;
import grupo9.algo3man.vista.VistaFantasmaNaranja;
import grupo9.algo3man.vista.VistaFantasmaRojo;
import grupo9.algo3man.vista.VistaFantasmaVioleta;
import grupo9.algo3man.vista.VistaPacman;

import java.awt.Point;

public class Juego {
	
	final private int VIDAS_INICIALES = 3;
	final private int NIVEL_INICIAL = 0;
	final private int PUNTOS_NIVEL_GANADO = 1000;
	
	private Algo3Man ventanaPrincipal;
	private int nivel;
	private int puntaje;
	private int vidas;
	private Mapa mapa;
	private ControladorJuego controlador;
	
	public Juego(){
		
		this.controlador = new ControladorJuego();
		this.inicializarJuego();
	}
	
	public void comenzarJuego(){
		this.nivel = NIVEL_INICIAL;
		this.puntaje = 0;
		this.vidas = VIDAS_INICIALES;
	
		this.inicializarJuego();
		this.controlador.comenzarJuego();
	}
	
	public void pausarJuego(){
		
		this.controlador.detenerJuego();
	}
	
	public void continuarJuego() {
		this.controlador.reanudarJuego();
	}
	
	public void avanzarNivel(){
		if(this.isGameOver())
			throw new GameOverException();
		
		//this.nivel++; /*Falta el mapa siguiente*/
		this.sumarPuntos(PUNTOS_NIVEL_GANADO);
		this.pausarJuego();
		this.inicializarJuego();
		this.continuarJuego();
	}
	
	public void sumarPuntos(int puntos){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.puntaje += puntos;
	}
	
	public void restarVida(){
		if(this.isGameOver())
			throw new GameOverException();
		
		this.vidas--;
		this.reiniciarPersonajes();
		
		if(this.isGameOver())
			this.controlador.detenerJuego();
	}
	
	public void reiniciarPersonajes(){
		this.mapa.getPacman().reiniciar();
		for(int i=0; i< this.mapa.getFantasmas().size(); i++){
			((Fantasma)(this.mapa.getFantasmas().get(i))).reiniciar();
		}
	}

	public Celda getCelda(Point punto){
		Celda celdaTrucha = null;
		try{
			celdaTrucha = this.mapa.getCelda(punto);
		}catch(RangoException e){/* issue de fantasma violeta era por esto, en el catch estaba vacío */
			/* Devuelvo rangoException */
			throw new RangoException();
		}
		return celdaTrucha;
	}
	
	public boolean isGameOver(){
		if(this.vidas == 0)
			return true;
		return false;
	}
	
	public int getNivel(){
		return this.nivel;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public int getVidas(){
		return this.vidas;
	}
	
	public ControladorJuego getControlador(){
		return this.controlador;
	}
	
	public Pacman getPacman(){
		return this.mapa.getPacman();
	}
	public ListaFantasma getFantasmas(){
		return this.mapa.getFantasmas();
	}
	public Point getDimensiones(){
		return new Point(this.mapa.getN(), this.mapa.getM());
	}

	public Mapa getMapa() { // Para que? Deberia ser transparente.
		return this.mapa;
	}

	public void inicializarJuego(){
		this.mapa = FabricaDeMapas.obtenerMapa(this.nivel, this);
		
		this.controlador.vaciarDibujables();
		this.controlador.vaciarObjetoVivo();
		
		this.controlador.agregarObjetoVivo(this.getPacman());
		this.controlador.setIntervaloSimulacion(10);
		ListaFantasma fantasmas = this.getFantasmas();
		for(int i=0; i<fantasmas.size(); i++){
			this.controlador.agregarObjetoVivo(fantasmas.get(i));
		}
		
		for(int i=0;i<this.getMapa().getN();i++){
			for(int j=0;j<this.getMapa().getM();j++){
				Celda celda = this.getCelda(new Point(i,j));
				PuntoPosicionable posicionable = new PuntoPosicionable(new Point(1,1));
				if(celda.esTransitable()){
					this.controlador.agregarDibujable(new VistaCeldaPunto(posicionable.getX(),posicionable.getY(),(CeldaPunto) celda));
				} else {
					this.controlador.agregarDibujable(new VistaCeldaPared(posicionable.getX(),posicionable.getY(),(CeldaPared) celda));
				}
					
			}
		}
		
		this.controlador.agregarDibujable(new VistaPacman(this.getPacman(),this.ventanaPrincipal));
		this.controlador.agregarDibujable(new VistaFantasmaCeleste(this.mapa.getFantasmaCeleste()));
		this.controlador.agregarDibujable(new VistaFantasmaNaranja(this.mapa.getFantasmaNaranja()));
		this.controlador.agregarDibujable(new VistaFantasmaRojo(this.mapa.getFantasmaRojo()));
		this.controlador.agregarDibujable(new VistaFantasmaVioleta(this.mapa.getFantasmaVioleta()));
	}
	
	public void setVentanaPrincipal(Algo3Man ventana){
		this.ventanaPrincipal = ventana;
	}

}
