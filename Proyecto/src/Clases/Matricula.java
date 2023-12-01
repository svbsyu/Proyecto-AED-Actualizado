package Clases;
public class Matricula{
   public int codigoMatricula, codigoAlumno, codigoCurso,estado;
   public Matricula(int codigoMatricula, int codigoAlumno, int codigoCurso, int estado){
	   this.codigoMatricula=codigoMatricula;
	   this.codigoAlumno=codigoAlumno;
	   this.codigoCurso=codigoCurso;
	   this.estado = estado;
   }
public int getCodigoMatricula() {
	return codigoMatricula;
}
public void setCodigoMatricula(int codigoMatricula) {
	this.codigoMatricula = codigoMatricula;
}
public int getCodigoAlumno() {
	return codigoAlumno;
}
public void setCodigoAlumno(int codigoAlumno) {
	this.codigoAlumno = codigoAlumno;
}
public int getCodigoCurso() {
	return codigoCurso;
}
public void setCodigoCurso(int codigoCurso) {
	this.codigoCurso = codigoCurso;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
}

