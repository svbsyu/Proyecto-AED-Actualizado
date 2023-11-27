package Hijos;

import Padre.Persona;

public class Alumno extends Persona {
    
	//Atributos privados
	private int codigoAlumno, estado;
	
	  //Constructor
	public Alumno(int codigoAlumno, String nombres, String apellidos, String telefono, String dni, int estado) {
		super(nombres, apellidos, telefono, dni);
		this.codigoAlumno = codigoAlumno;
		this.estado = estado;
	}

	// SET/GET
	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	// METODOS PUBLICOS
	public String nombreApellido() {
		return nombres + apellidos;
	}
}
