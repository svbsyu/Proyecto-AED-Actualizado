package Arreglos;
import Clases.Curso;
import java.util.ArrayList;
public class ArregloCurso {
   private ArrayList<Curso> cur;
   public ArregloCurso() {
	   cur = new ArrayList<Curso>();
	   adicionar(new Curso(3001, 1001, "Matematica", 20));
   }
   public void adicionar(Curso x) {
	   cur.add(x);
   }
   public int tamanio() {
		return cur.size();
	}
	public Curso obtener(int i) {
		return cur.get(i);
	}
	public Curso buscar(int codigo) {
		Curso x;
		for(int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getCodigoCurso() == codigo)
				return x;
		}
		return null;
	}
	public Curso buscar1(int codDoc) {
		Curso x;
		for(int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getCodigoDocente() == codDoc)
				return x;
		}
		return null;
	}
	public void eliminar(Curso x) {
		cur.remove(x);
	}
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 3001;
		else
			return obtener(tamanio()-1).getCodigoCurso() + 1;		
	}
}
