package Arreglos;
import java.util.ArrayList;
import Clases.Alumno;
public class ArregloAlumno {
	private ArrayList<Alumno> alu;
	public ArregloAlumno() {
		alu = new ArrayList<Alumno>();
		adicionar(new Alumno(2001, "Juan Sebastian", "Romero Salazar", "987455828", "80128932"));
		adicionar(new Alumno(2002, "Anderson", "Cutipa", "987123674", "67845687"));
	}
	public void adicionar(Alumno x) {
		alu.add(x);
	}
	public int tamanio() {
		return alu.size();
	}
	public Alumno obtener(int i) {
		return alu.get(i);
	}
	public Alumno buscar(int codigo) {
		Alumno x;
		for(int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getCodigoAlumno() == codigo)
				return x;
		}
		return null;
	}
	public Alumno buscar(String dni) {
		Alumno x;
		for(int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getDni() == dni)
				return x;
		}
		return null;
	}
	public void eliminar(Alumno x) {
		alu.remove(x);
	}
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 2001;
		else
			return obtener(tamanio()-1).getCodigoAlumno() + 1;		
	}
}
