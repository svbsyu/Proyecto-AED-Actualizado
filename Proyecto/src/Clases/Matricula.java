package Clases;
public class Matricula{
   public int codigoMatricula, codigoAlumno, codigoCurso;
   public Matricula(int codigoMatricula, int codigoAlumno, int codigoCurso){
	   this.codigoMatricula=codigoMatricula;
	   this.codigoAlumno=codigoAlumno;
	   this.codigoCurso=codigoCurso;
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
}

