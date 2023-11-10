package Arreglos;
import Clases.Docente;
import java.util.ArrayList;
public class ArregloDocente {
	private ArrayList<Docente> doc;
	
	public ArregloDocente() {
		doc = new ArrayList<Docente>();
	}
	public void adicionar(Docente x) {
		doc.add(x);
	}
	public int tamanio() {
		return doc.size();
	}
	public Docente obtener(int i) {
		return doc.get(i);
	}
	public Docente buscar(int codigo) {
		Docente x;
		for(int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getCodigoDocente() == codigo)
				return x;
		}
		return null;
	}
	public Docente buscar(String dni) {
		Docente x;
		for(int i = 0 ; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(Docente x) {
		doc.remove(x);
	}
	public int codigoCorrelativo() {
		if(tamanio() == 0)
			return 1001;
		else 
			return obtener(tamanio()-1).getCodigoDocente() + 1;
	}
}