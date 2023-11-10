package Clases;

public class Docente {
    //atributos privados
    private int CodigoDocente, categoria;
    private String nombre, apellidos, telefonia, dni;
    //Constructor
    public Docente(int CodigoDocente, String nombre, String apellidos, String telefonia, String dni, int categoria) {
    	this.CodigoDocente=CodigoDocente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefonia = telefonia;
		this.dni = dni;
		this.categoria = categoria;
    }
	public int getCodigoDocente() {
		return CodigoDocente;
	}
	public void setCodigoDocente(int codigoDocente) {
		CodigoDocente = codigoDocente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getTelefonia() {
		return telefonia;
	}
	public void setTelefonia(String telefonia) {
		this.telefonia = telefonia;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

}