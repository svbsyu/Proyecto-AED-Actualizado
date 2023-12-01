package Arreglos;
import Clases.Curso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class ArregloCurso {
    // Atributos Privados
    private ArrayList <Curso> cur;
    
    // Constructor
    public ArregloCurso(){
        cur = new ArrayList<Curso>();
        cargarCursos();
    }
    
    // Operaciones públicas básicas
    public void adicionar(Curso x){
        cur.add(x);
        grabarCursos();
    }
    
    public int tamanio(){
        return cur.size();
    }
    
    public Curso obtener(int i){
        return cur.get(i);
    }
    
    public void eliminar(Curso x) {
    	cur.remove(x);
    	grabarCursos();
    }
    
    public Curso buscar(int codigoCurso){
        for(int i = 0; i < tamanio(); i++)
        if(obtener(i).getCodigoCurso() == codigoCurso)
            return obtener(i);
        return null;
    }
    
    public Curso buscar(String nombreCurso) {
    	for(int i = 0; i<tamanio(); i++)
    		if(obtener(i).getNombre().equals(nombreCurso))
    			return obtener(i);
    	return null;
    }
    // Operaciones públicas complementarias
    public int codigoCorrelativo() {
    	if(tamanio() == 0) 
    		return 3001;
    	else
    		return obtener(tamanio()-1).getCodigoCurso() + 1;
    }
    
    public void actualizarArchivo() {
    	grabarCursos();
    }
    
    public void grabarCursos() {
    	try {
    		PrintWriter pw;
    		String linea;
    		Curso x;
    		pw = new PrintWriter(new FileWriter("cursos.txt"));
    		for(int i=0; i<tamanio(); i++) {
    			x = obtener(i);
    			linea = x.getCodigoCurso() + ";" +
    					x.getNombre() + ";" + 
    					x.getHoras();
    			pw.println(linea);
    		}
    		pw.close();
    	} catch(Exception e) {
    	}
    }
    
    public void cargarCursos() {
    	try {
    		BufferedReader br;
    		String linea, nombreCursos;
    		String[] s;
    		int codigoCurso;
    		double horas;
    		br = new BufferedReader(new FileReader("cursos.txt"));
    		while((linea = br.readLine()) != null) {
    			s = linea.split(";");
    			codigoCurso = Integer.parseInt(s[0].trim());
    			nombreCursos = s[1].trim();
    			horas = Double.parseDouble(s[2].trim());
    			adicionar(new Curso(codigoCurso, nombreCursos, horas));
    		}
    		br.close();
    	} catch(Exception e) {
    	}
    }
    public ArrayList <Curso> getCur(){
		return this.cur;
	}
}
