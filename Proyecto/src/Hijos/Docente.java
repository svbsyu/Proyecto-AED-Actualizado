package Hijos;

import Padre.Persona;

public class Docente extends Persona{
	
	//atributos privados
    private int CodigoDocente, categoria;
    
    //Constructor
    public Docente(int CodigoDocente, String nombres, String apellidos, String telefono, String dni, int categoria) {
		super(nombres, apellidos, telefono, dni);
		this.CodigoDocente = CodigoDocente;
		this.categoria = categoria;
	}
    
    // SET/GET
	public int getCodigoDocente() {
		return CodigoDocente;
	}

	public void setCodigoDocente(int codigoDocente) {
		CodigoDocente = codigoDocente;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
}