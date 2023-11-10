package Arreglos;
import Clases.Matricula;
import java.util.ArrayList;
public class ArregloMatricula {
    private ArrayList <Matricula> mat;
    public ArregloMatricula(){
        mat = new ArrayList<>();
        adicionar(new Matricula(4001, 2001, 3001));
        adicionar(new Matricula(4002, 2002, 3002));
    }
    public void adicionar(Matricula x){
        mat.add(x);
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
    }
    public int codigoCorrelativo() {
    	if(tamanio() == 0)
    		return 4001;
    	else
    		return obtener(tamanio() -1).getCodigoMatricula() + 1;
    }
}
