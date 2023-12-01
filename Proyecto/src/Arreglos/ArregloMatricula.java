package Arreglos;
import Clases.Matricula;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class ArregloMatricula {
    private ArrayList <Matricula> mat;
    public ArregloMatricula(){
        mat = new ArrayList<>();
        cargarMatriculas();;
    }
    public void adicionar(Matricula x){
        mat.add(x);
        grabarMatriculas();
    }
    public int tamanio(){
        return mat.size();
    }
    public Matricula obtener(int i){
        return mat.get(i);
    }
    public Matricula buscar(int codigoMatricula){
        for(int i = 0; i < tamanio(); i++)
        if(obtener(i).getCodigoMatricula() == codigoMatricula)
            return obtener(i);
        return null;
    }
    public void eliminar(Matricula x) {
    	mat.remove(x);
    	grabarMatriculas();
    }
    public int codigoCorrelativo() {
    	if(tamanio() == 0)
    		return 4001;
    	else
    		return obtener(tamanio() -1).getCodigoMatricula() + 1;
    }
    public void actualizarArchivo() {
    	grabarMatriculas();
    }
	public void AlumnosNoMatriculados() {
		
	}
    public void grabarMatriculas() {
    	try {
    		PrintWriter pw;
    		String linea;
    		Matricula x;
    		pw = new PrintWriter(new FileWriter("matriculas.txt"));
    		for(int i=0; i<tamanio(); i++) {
    			x = obtener(i);
    			linea = x.getCodigoMatricula() + ";" +
    					x.getCodigoAlumno() + ";" + 
    					x.getCodigoCurso() + ";" +
    					x.getEstado();
    			pw.println(linea);
    		}
    		pw.close();
    	} catch(Exception e) {
    	}
    }
    
    public void cargarMatriculas() {
    	try {
    		BufferedReader br;
    		String linea;
    		String[] s;
    		int codigoMatricula, codigoAlumno, codigoCurso,estado;
    		br = new BufferedReader(new FileReader("matriculas.txt"));
    		while((linea = br.readLine()) != null) {
    			s = linea.split(";");
    			codigoMatricula = Integer.parseInt(s[0].trim());
    			codigoAlumno = Integer.parseInt(s[1].trim());
    			codigoCurso = Integer.parseInt(s[2].trim());
    			estado = Integer.parseInt(s[3].trim());
    			adicionar(new Matricula(codigoMatricula, codigoAlumno, codigoCurso, estado));
    		}
    		br.close();
    	} catch(Exception e) {
    	}
    }
    public ArrayList<Matricula> getMatriculas(){
    	return this.mat;
    }
    
}
