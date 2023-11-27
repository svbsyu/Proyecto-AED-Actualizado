package Clases;

public class Curso{
    //Atributos Privados
    private int codigoCurso, codigoDocente;
    private String nombre;
    private double horas;
    //Constructor
	public Curso(int codigoCurso, String nombre, int codigoDocente, double horas) {
		this.codigoCurso = codigoCurso;
		this.nombre = nombre;
		this.codigoDocente = codigoDocente;
		this.horas = horas;
	}
    //Getters and Setters
	public int getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigoDocente() {
		return codigoDocente;
	}
	public void setCodigoDocente(int codigoDocente) {
		this.codigoDocente = codigoDocente;
	}
	public double getHoras() {
		return horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
	}
}
