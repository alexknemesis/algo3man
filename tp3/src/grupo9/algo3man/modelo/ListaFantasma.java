package grupo9.algo3man.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaFantasma {
	private ArrayList fantasmas;
	
	public ListaFantasma(){
		this.fantasmas = new ArrayList();
	}
	
	public boolean add(Fantasma arg0) {
		return fantasmas.add(arg0);
	}

	public void clear() {
		fantasmas.clear();
	}

	public Fantasma get(int arg0) {
		return (Fantasma) fantasmas.get(arg0);
	}

	public int indexOf(Fantasma arg0) {
		return fantasmas.indexOf(arg0);
	}

	public boolean isEmpty() {
		return fantasmas.isEmpty();
	}

	public Iterator iterator() {
		return fantasmas.iterator();
	}

	public Fantasma remove(int arg0) {
		return (Fantasma) fantasmas.remove(arg0);
	}

	public int size() {
		return fantasmas.size();
	}
	
	
}
