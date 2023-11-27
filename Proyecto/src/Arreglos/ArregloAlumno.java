package Arreglos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import Hijos.Alumno;

public class ArregloAlumno {
    //Atributos Privados
    private ArrayList <Alumno> alu;
    //Constructor
    public ArregloAlumno(){
        alu = new ArrayList<Alumno>();
        cargarAlumnos();
    }
    public void adicionar(Alumno x){
        alu.add(x);
        grabarAlumnos();
    }
    public int tamanio(){
        return alu.size();
    }
    public Alumno obtener(int i){
        return alu.get(i);
    }
    
    public void eliminar(Alumno x) {
    	alu.remove(x);
    	grabarAlumnos();
    }
    
    public Alumno buscar(int codigoAlumno){
        for(int i = 0; i < tamanio(); i++)
        if(obtener(i).getCodigoAlumno() == codigoAlumno)
            return obtener(i);
        return null;
    }
    
    public Alumno buscar(String nombreAlumno) {
    	for(int i = 0; i<tamanio(); i++)
    		if(obtener(i).getNombres().equals(nombreAlumno))
    			return obtener(i);
    	return null;
    }
    
    public Alumno buscarDni(String dniAlumno) {
    	for(int i = 0; i<tamanio(); i++)
    		if(obtener(i).getDni().equals(dniAlumno))
    			return obtener(i);
    	return null;
    }
    
    
    // Operaciones públicas complementarias
    public int codigoCorrelativo() {
    	if(tamanio() == 0) 
    		return 2001;
    	else
    		return obtener(tamanio()-1).getCodigoAlumno() + 1;
    }
    
    public void actualizarArchivo() {
    	grabarAlumnos();
    }
    
    
    public void grabarAlumnos() {
    	try {
    		PrintWriter pw;
    		String linea;
    		Alumno x;
    		pw = new PrintWriter(new FileWriter("alumnos.txt"));
    		for(int i=0; i<tamanio(); i++) {
    			x = obtener(i);
    			linea = x.getCodigoAlumno() + ";" +
    					x.getNombres() + ";" + 
    					x.getApellidos() + ";" +
    					x.getTelefono() + ";" +
    					x.getDni() + ";" +
    					x.getEstado();
    			pw.println(linea);
    		}
    		pw.close();
    	} catch(Exception e) {
    	}
    }
    
    public void cargarAlumnos() {
    	try {
    		BufferedReader br;
    		String linea, nombreAlumno, apellidoAlumno, telefonoAlumno, dniAlumno;
    		String[] s;
    		int codigoAlumno, estado;
    		br = new BufferedReader(new FileReader("alumnos.txt"));
    		while((linea = br.readLine()) != null) {
    			s = linea.split(";");
    			codigoAlumno = Integer.parseInt(s[0].trim());
    			nombreAlumno = s[1].trim();
    			apellidoAlumno = s[2].trim();
    			telefonoAlumno = s[3].trim();
    			dniAlumno = s[4].trim();
    			estado = Integer.parseInt(s[5].trim());
    			adicionar(new Alumno(codigoAlumno, nombreAlumno, apellidoAlumno, telefonoAlumno, dniAlumno, estado));
    		}
    		br.close();
    	} catch(Exception e) {
    	}
    }
    
    public Alumno nomApellido(String nombreAlumno, String apellidoAlumno) {
    	String nomApe = nombreAlumno + apellidoAlumno;
    	for(int i=0; i<tamanio(); i++) {
    		if(nomApe.equals(obtener(i).nombreApellido()))
    			return obtener(i);
    	}
    	return null;
    }
    
    
    
}
