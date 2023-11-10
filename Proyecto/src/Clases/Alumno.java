package Clases; 
public class Alumno {
    //Atributos privados
    private int codigoAlumno, estado;
    private String nombre, apellido, celular, dni;
    //Constructor
    public Alumno(int codigoAlumno, String nombre, String apellido, String celular, String dni, int estado) {
        this.codigoAlumno = codigoAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.dni = dni;
        this.estado = estado;
    }
    //Getters and Setters
	public int getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String nombreApellido() {
		return nombre + apellido;
	}
}
