package Arreglos;
import Hijos.Docente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class ArregloDocente {
	private ArrayList<Docente> doc;
	
	public ArregloDocente() {
		doc = new ArrayList<Docente>();
		cargarDocente();
	}
	public void adicionar(Docente x) {
		doc.add(x);
		grabarDocente();
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
	public Docente buscarTelf(int telefono) {
		Docente x;
		for(int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if(x.getCodigoDocente() == telefono)
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
		grabarDocente();
	}
	public int codigoCorrelativo() {
	    if (tamanio() == 0) {
	    	return 1001;
	    } 
	    else{
	        return obtener(tamanio() - 1).getCodigoDocente() + 1;
	    }
	}

	   public void actualizarArchivo() {
	    	grabarDocente();
	    }
	
	public void grabarDocente() {
		try {
			PrintWriter pw;
    		String linea;
    		Docente x;
    		pw = new PrintWriter(new FileWriter("docentes.txt"));
    		for(int i=0; i<tamanio(); i++) {
    			x = obtener(i);
    			linea = x.getCodigoDocente() + ";" +
    					x.getNombres() + ";" +
    					x.getApellidos() + ";" +
    					x.getTelefono() + ";" +
    					x.getDni() + ";" +
    					x.getCodCurso() + ";" +
    					x.getNomCurso() + ";" +
    					x.getCategoria();
    			pw.println(linea);
    		}
    		pw.close();
		} catch(Exception e) {
		}
	}
	
	public void cargarDocente() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, telefono, dni, nomCurso;
			String[] s;
			int codDocente, categoria, codCurso;
			br = new BufferedReader(new FileReader("docentes.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codDocente = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				telefono = s[3].trim();
				dni = s[4].trim();
				codCurso = Integer.parseInt(s[5].trim());
				nomCurso = s[6].trim();
				categoria = Integer.parseInt(s[7].trim());
				adicionar(new Docente(codDocente, nombres, apellidos, telefono, dni, codCurso, nomCurso, categoria));
			}
			br.close();
		} catch(Exception e) {
		}
	}
    public Docente nomApellido(String nombreAlumno, String apellidoAlumno) {
    	String nomApe = nombreAlumno + apellidoAlumno;
    	for(int i=0; i<tamanio(); i++) {
    		if(nomApe.equals(obtener(i).nombreApellido()))
    			return obtener(i);
    	}
    	return null;
    }
    public ArrayList <Docente> getDocente(){
  		return this.doc;
  	}
}