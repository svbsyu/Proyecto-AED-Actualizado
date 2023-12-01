package Hijos;

import Padre.Persona;

public class Docente extends Persona{
	
	//atributos privados
    private int CodigoDocente, categoria, codCurso;
    private String nomCurso;
    //Constructor
    public Docente(int CodigoDocente, String nombres, String apellidos, String telefono, String dni,
    				int codCurso, String nomCurso, int categoria) {
		super(nombres, apellidos, telefono, dni);
		this.CodigoDocente = CodigoDocente;
		this.codCurso = codCurso;
		this.nomCurso = nomCurso;
		this.categoria = categoria;
	}
    

	// SET/GET
	public int getCodigoDocente() {
		return CodigoDocente;
	}

	public void setCodigoDocente(int codigoDocente) {
		CodigoDocente = codigoDocente;
	}
	
    public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomCurso() {
		return nomCurso;
	}

	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}
	
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String nombreApellido() {
		return nombres + " " + apellidos;
	}
}