package proyecto;


import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import Arreglos.ArregloAlumno;
import Arreglos.ArregloCurso;
import Arreglos.ArregloDocente;
import Arreglos.ArregloMatricula;
import Clases.*;
import Hijos.Alumno;
import Hijos.Docente;

import javax.swing.JScrollPane;


public class GuiReportes extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTipoDeReporte;
	private JComboBox<String> cboTipoDeReporte;
	private JButton btnCerrar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiReportes dialog = new GuiReportes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public GuiReportes() {
		setModal(true);
		setTitle("Generar Reportes");
		setBounds(100, 100, 677, 493);
		getContentPane().setLayout(null);
		
		lblTipoDeReporte = new JLabel("Tipo de reporte");
		lblTipoDeReporte.setBounds(10, 11, 74, 14);
		getContentPane().add(lblTipoDeReporte);
		
		cboTipoDeReporte = new JComboBox<String>();
		cboTipoDeReporte.addActionListener(this);
		cboTipoDeReporte.setModel(new DefaultComboBoxModel<String>(new String[] {"Cursos matriculados de un alumno", "Cursos asignados a un docente", "Alumnos matriculados en un curso", "Docentes sin cursos asignados", "Alumnos no matriculados"}));
		cboTipoDeReporte.setBounds(94, 7, 333, 22);
		getContentPane().add(cboTipoDeReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(562, 7, 89, 23);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 641, 407);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoDeReporte) {
			actionPerformedCboTipoDeReporte(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	ArregloMatricula am=new ArregloMatricula();
	ArregloAlumno aa= new ArregloAlumno();
	ArregloDocente ad= new ArregloDocente();
	ArregloCurso ac = new ArregloCurso();
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
	}
	
	protected void actionPerformedCboTipoDeReporte(ActionEvent e) {
		
		int tiporeporte;
	
		tiporeporte = cboTipoDeReporte.getSelectedIndex();
		
		switch(tiporeporte) {
		case 0:
			CursosMatriculadosAlumno(); break;
		case 1:
			CursosAsignadosDocente(); break;
		case 2:
			AlumnosMatriculadosCurso(); break;
		case 3:
			DocenteSinCursosAsignados(); break;
		default:
			AlumnosNoMatriculados();
		}
		}
	
	private ArrayList<Matricula> obtenerMatriculasPorAlumno(int codigoAlumno) {
	    ArrayList<Matricula> matriculas = new ArrayList<>();
	    
	    for (Matricula matricula : am.getMatriculas()) {
	        if (matricula.getCodigoAlumno() == codigoAlumno) {
	            matriculas.add(matricula);
	        }
	    }
	    
	    return matriculas;
	}
	private Curso obtenerCursoPorCodigo(int codigoCurso) {
	    for (Curso curso : ac.getCur()) {
	        if (curso.getCodigoCurso() == codigoCurso) {
	            return curso;
	        }
	    }
	    
	    return null;
	}
	void CursosMatriculadosAlumno() {
		txtS.setText("" + "\n");
	    ArrayList<Alumno> aluList = aa.getAlu();
	    
	    for (Alumno alumno : aluList) {
	        imprimir("Codigo de alumno : " + alumno.getCodigoAlumno());
	        imprimir("Nombre de alumno : " + alumno.getNombres());
	        imprimir("Apellido de alumno : " + alumno.getApellidos());
	        imprimir("DNI : " + alumno.getDni());
	        
	        imprimir("Cursos matriculados:");
	        
	        // Obtener la lista de matrículas para el alumno actual
	        ArrayList<Matricula> matriculas = obtenerMatriculasPorAlumno(alumno.getCodigoAlumno());
	        
	        
	        for (Matricula matricula : matriculas) {
	            Curso curso = obtenerCursoPorCodigo(matricula.getCodigoCurso());
	            if (curso != null) {
	                imprimir("  - Codigo de curso : " + curso.getCodigoCurso());
	                imprimir("    Nombre de curso : " + curso.getNombre());
	                imprimir("    Horas de curso  : " + curso.getHoras());
	            }
	        }
	        
	        imprimir("-------------------------------------------------------");
	        imprimir("");
	    }
	}
	void CursosAsignadosDocente() {
		txtS.setText("" + "\n");
		ArrayList <Docente> doc = ad.getDocente();
		for(int i= 0; i<doc.size(); i++) {
			Docente d = doc.get(i);
			if(d.getCodCurso() != -1) {
				imprimir("Codigo de Docente : " + doc.get(i).getCodigoDocente());
				imprimir("Nombre de alumno : " + doc.get(i).getNombres());
				imprimir("Apellido de alumno : " + doc.get(i).getApellidos());
				imprimir("DNI : " + doc.get(i).getDni());
				imprimir("");
			}	
		}
	}
	void AlumnosMatriculadosCurso() {
		txtS.setText("" + "\n");
		ArrayList <Alumno> alu = aa.getAlu();
		for(int i= 0; i<alu.size(); i++) {
			if(estadoMatricula(alu.get(i).getCodigoAlumno())) {
				imprimir("Codigo de alumno : " + alu.get(i).getCodigoAlumno());
				imprimir("Nombre de alumno : " + alu.get(i).getNombres());
				imprimir("Apellido de alumno : " + alu.get(i).getApellidos());
				imprimir("DNI : " + alu.get(i).getDni());
				imprimir("");

			}
				
		}
	}
	void DocenteSinCursosAsignados() {
		txtS.setText("" + "\n");
		ArrayList <Docente> doc = ad.getDocente();
		for(int i= 0; i<doc.size(); i++) {
			Docente d = doc.get(i);
			if(d.getCodCurso() == -1) {
				imprimir("Codigo de Docente : " + doc.get(i).getCodigoDocente());
				imprimir("Nombre de alumno : " + doc.get(i).getNombres());
				imprimir("Apellido de alumno : " + doc.get(i).getApellidos());
				imprimir("DNI : " + doc.get(i).getDni());
				imprimir("");
			}	
		}
	}

	void AlumnosNoMatriculados(){
		txtS.setText("" + "\n");
		ArrayList <Alumno> alu = aa.getAlu();
		for(int i= 0; i<alu.size(); i++) {
			if(!estadoMatricula(alu.get(i).getCodigoAlumno())) {
				imprimir("Codigo de alumno : " + alu.get(i).getCodigoAlumno());
				imprimir("Nombre de alumno : " + alu.get(i).getNombres());
				imprimir("Apellido de alumno : " + alu.get(i).getApellidos());
				imprimir("DNI : " + alu.get(i).getDni());
				imprimir("");

			}
				
		}
	}
	boolean estadoMatricula(int codigoAlumno) {
		for (int i=0; i<am.tamanio(); i++)
			if (am.obtener(i).getCodigoAlumno() == codigoAlumno)
				return true;
		return false;
	}
	boolean estadoAlumno(int codigoAlumno) {
		for (int i=0; i<aa.tamanio(); i++)
			if (aa.obtener(i).getCodigoAlumno() == codigoAlumno)
				return true;
		return false;
	}
	
	boolean estadoCurso(int codigoCurso) {
		for (int i=0; i<ac.tamanio(); i++)
			if (ac.obtener(i).getCodigoCurso() == codigoCurso)
				return true;
		return false;
	}
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}


