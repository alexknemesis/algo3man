package grupo9.algo3man.titiritero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Nicolas
 * Esta clase es la encargada de manejar todo el gameloop. B�sicamente tiene una lista
 * de ObjetosVivos y una Dibujables que son recorridas en cada gameloop.
 */
public class ControladorJuego {

	public ControladorJuego(){
		this.objetosVivos = new ArrayList<ObjetoVivo>();
		this.dibujables = new ArrayList<Dibujable>();
		this.mouseClickObservadores = new ArrayList<MouseClickObservador>();
	}

	public void comenzarJuego(){

		estaEnEjecucion = true;
		threadDelControlador = new ThreadDelControlador();
		threadDelControlador.start();	
	}

	/**
	 * Le da comienzo al juego poniendo en marcha el gameloop.
	 * @param cantidadDeCiclos cantidad de ciclos que debe correr el gameloop..  
	 */
	public void comenzarJuego(int cantidadDeCiclos){

		estaEnEjecucion = true;
		threadDelControlador = new ThreadDelControlador(cantidadDeCiclos);
		threadDelControlador.start();

	}

	/**
	 * Detiene el juego provocando la salida del gameloop.
	 */
	public void detenerJuego(){
		this.estaEnEjecucion = false;
	}
	
	public void reanudarJuego() {
		comenzarJuego();
		
	}

	public void agregarObjetoVivo(ObjetoVivo objetoVivo){
		objetosVivos.add(objetoVivo);
	}

	public void removerObjetoVivo(ObjetoVivo objetoVivo){
		objetosVivos.remove(objetoVivo);
	}

	public void agregarDibujable(Dibujable unDibujable){
		dibujables.add(unDibujable);
	}

	public void removerDibujable(Dibujable unDibujable){
		dibujables.remove(unDibujable);
	}

	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}

	private void dibujar() {
		Iterator<Dibujable> iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dibujable = iterador.next();
			dibujable.dibujar(this.superficieDeDibujo);
		}		
		this.superficieDeDibujo.actualizar();
	}

	/**
	 * Ejecuta la simulacion recorriendo la coleccion de objetivos vivos.
	 */
	private void simular() {
		this.superficieDeDibujo.limpiar();
		Iterator<ObjetoVivo> iterador = objetosVivos.iterator();
		while(iterador.hasNext()){
			iterador.next().vivir();
		}
	}

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}

	/**
	 * Se encarga de derivar el manejo del evento click al objeto vista correspondiente
	 * @param x posici�n horizontal del mouse
	 * @param y posici�n vertial del mouse
	 */
	public void despacharMouseClick(int x, int y){
		MouseClickObservador mouseClickObservador;
		Iterator<MouseClickObservador> iterador = this.mouseClickObservadores.iterator();
		while(iterador.hasNext()){
			mouseClickObservador = iterador.next();
			mouseClickObservador.MouseClick(x, y);
		}
	}

	public void agregarMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.add(unMouseClickObservador);
	}

	public void removerMouseClickObservador(MouseClickObservador unMouseClickObservador){
		this.mouseClickObservadores.remove(unMouseClickObservador);
	}
	
	private class ThreadDelControlador implements Runnable{
		Thread animacion;
		int ciclosARealizar;
		boolean acotado;

		ThreadDelControlador(){

			animacion = new Thread(this);
			acotado = false;
		}

		ThreadDelControlador(int cantidadDeCiclos){
			this();
			animacion = new Thread(this);
			this.ciclosARealizar = cantidadDeCiclos;
			acotado = true;


		}


		public void start(){
			animacion.start();


		}

		public void stop(){
			
			animacion = null;
		}

		public void run(){

			if(acotado){
				try{ 
					for(int i=0; i<ciclosARealizar; i++){
						simular();
						dibujar();
						Thread.sleep(intervaloSimulacion); 
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}else{
				try{ 
					while(estaEnEjecucion){
						simular();
						dibujar();
						Thread.sleep(intervaloSimulacion); 
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}

			}
		}


	}

	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private List<ObjetoVivo> objetosVivos;
	private List<Dibujable> dibujables;
	private List<MouseClickObservador> mouseClickObservadores;
	private SuperficieDeDibujo superficieDeDibujo;	
	private ThreadDelControlador threadDelControlador;

}
