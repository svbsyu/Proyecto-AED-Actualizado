package proyecto;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloAlumno;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Curso;
import Clases.Matricula;
import Hijos.Alumno;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;


public class GuiMatriculas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnSalir;
	private JButton btnMatricular;
	private JLabel lblCodMatricula;
	private JLabel lblCodAlumno;
	private JLabel lblCodCurso;
	private JTextField txtCodMatricula;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JComboBox<Object> cboCodAlumno;
	private JComboBox<Object> cboCodCurso;
	private DefaultTableModel modelo;
	private JButton btnOk;
	private JLabel lblEstado;
	private JScrollPane scrollPane;
	private JTable tblTable;
	private JComboBox<String> cboEstado;


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			GuiMatriculas dialog = new GuiMatriculas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiMatriculas() {
		setTitle("Matriculas");
		setModal(true);
		setBounds(100, 100, 706, 477);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		getContentPane().setLayout(null);
		 
		 txtCodMatricula = new JTextField();
		 txtCodMatricula.setEnabled(false);
		 txtCodMatricula.setEditable(false);
		 txtCodMatricula.setBounds(109, 8, 119, 20);
		 getContentPane().add(txtCodMatricula);
		 txtCodMatricula.setColumns(10);
		 
		 cboCodAlumno = new JComboBox<Object>();
		 cboCodAlumno.setEnabled(false);
		 cboCodAlumno.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		itemStateChangedCboCodAlumno(e);
		 	}
		 });
		 cboCodAlumno.setBounds(109, 32, 119, 22);
		 getContentPane().add(cboCodAlumno);
		 
		 cboCodCurso = new JComboBox<Object>();
		 cboCodCurso.setEnabled(false);
		 cboCodCurso.setSelectedIndex(-1);
		 cboCodCurso.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		itemStateChangedCboCodCurso(e);
		 	}
		 });
		 cboCodCurso.setBounds(109, 87, 119, 22);
		 getContentPane().add(cboCodCurso);
		 
		 txtCodAlumno = new JTextField();
		 txtCodAlumno.setBounds(10, 60, 218, 20);
		 getContentPane().add(txtCodAlumno);
		 txtCodAlumno.setEditable(false);
		 txtCodAlumno.setColumns(10);
		 
		 txtCodCurso = new JTextField();
		 txtCodCurso.setBounds(10, 116, 218, 20);
		 getContentPane().add(txtCodCurso);
		 txtCodCurso.setEditable(false);
		 txtCodCurso.setColumns(10);
		 
		 lblCodMatricula = new JLabel("Código de matrícula\r\n");
		 lblCodMatricula.setBounds(10, 11, 119, 14);
		 getContentPane().add(lblCodMatricula);
		 
		 lblCodAlumno = new JLabel("Código de alumno\r\n");
		 lblCodAlumno.setBounds(10, 36, 119, 14);
		 getContentPane().add(lblCodAlumno);
		 
		 lblCodCurso = new JLabel("Código de curso");
		 lblCodCurso.setBounds(10, 91, 102, 14);
		 getContentPane().add(lblCodCurso);
		 
		 btnSalir = new JButton("Salir");
		 btnSalir.setBounds(591, 94, 89, 75);
		 getContentPane().add(btnSalir);
		 
		 btnMatricular = new JButton("Matrícular");
		 btnMatricular.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnMatricular(e);
		 	}
		 });
		 btnMatricular.setBounds(591, 7, 89, 80);
		 getContentPane().add(btnMatricular);
		 
		 btnOk = new JButton("OK");
		 btnOk.setEnabled(false);
		 btnOk.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnOk(e);
		 	}
		 });
		 btnOk.setBounds(238, 143, 89, 23);
		 getContentPane().add(btnOk);
		 
		 lblEstado = new JLabel("Estado");
		 lblEstado.setBounds(10, 147, 46, 14);
		 getContentPane().add(lblEstado);
		 
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 180, 670, 247);
		 getContentPane().add(scrollPane);
		 
		 tblTable = new JTable();
		 tblTable.setRowSelectionAllowed(false);
		 tblTable.setEnabled(false);
		 tblTable.setFillsViewportHeight(true);
		 scrollPane.setViewportView(tblTable);
		 btnSalir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnSalir(e);
		 	}
		 });
		
		
		actualizarCboAlumno();
		actualizarCboCurso();
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Matricula");
		modelo.addColumn("Cod. Alumno");
		modelo.addColumn("Nombre del alumno");
		modelo.addColumn("Cod. Curso");
		modelo.addColumn("Nombre del curso");
		modelo.addColumn("Estado");
		tblTable.setModel(modelo);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setEnabled(false);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"MATRICULADO", "NO MATRICULADO"}));
		cboEstado.setBounds(109, 143, 119, 22);
		getContentPane().add(cboEstado);
		modelo.setRowCount(0);
		
		ajustarAnchoColumnas();
		listar();
		limpieza();
	}
	
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno al = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();

	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnMatricular(ActionEvent e) {
		txtCodMatricula.setText("" + am.codigoCorrelativo());
		habilitarcampos(true);
		cboEstado.setSelectedIndex(0);
		btnOk.setEnabled(true);
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		try {
			int codMatricula = leerCodigoMatricula();
			if(am.buscar(codMatricula) == null)
				try {
					int codAlumno = leerCodigoAlumno();
					Alumno a = al.buscar(codAlumno);
					if(a != null)
						try {
							int codCurso = leerCodigoCurso();
							int estado = leerEstado();
							if(ac.buscar(codCurso) != null) {
								int ok = confirmar("¿Deseas matricular al " + obtenerAlumno() + " al curso " + ac.buscar(leerCodigoCurso()).getNombre());
								if(ok == 0) {
								Matricula nuevo = new Matricula(codMatricula, codAlumno, codCurso, estado);
								am.adicionar(nuevo);
								a.setEstado(1);
								al.actualizarArchivo();
								listar();
								txtCodMatricula.setText("" + am.codigoCorrelativo());
								}
							}
							else
								mensaje("El código no existe");
						} catch(Exception f) {
							mensaje("Escoge correctamente el código del curso");	
						}
					else
						mensaje("El código no existe");
				} catch(Exception f) {
					mensaje("Escoge correctamente el código del curso");
				}
		} catch(Exception f) {
			mensaje("Ocurrió un error inesperado");
		}
	}
	
	
	// Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTable.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(4)); // Código de la matricula
		tcm.getColumn(1).setPreferredWidth(anchoColumna(2)); // Código del alumno
		tcm.getColumn(2).setPreferredWidth(anchoColumna(16)); // Nombre del alumno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(2)); // Código del curso
		tcm.getColumn(4).setPreferredWidth(anchoColumna(13)); // Nombre del curso
		tcm.getColumn(5).setPreferredWidth(anchoColumna(6)); // Estado
	}
	
	void listar() {
			modelo.setRowCount(0);
			Matricula m;
			for(int i=0; i<am.tamanio(); i++) {
				m = am.obtener(i);
				Alumno a = al.buscar(m.getCodigoAlumno());
				Curso c = ac.buscar(m.getCodigoCurso());
				Object[] fila= { m.getCodigoMatricula(),
							     m.getCodigoAlumno(),
							     a.nombreApellido(),
							     m.getCodigoCurso(),
							     c.getNombre(),
							     enTextoEstado(am.obtener(i).getEstado()) };
				modelo.addRow(fila);
			}
	}
	
	
	// Encontrar códigos de alumnos y cursos
	void actualizarCboAlumno() {
		cboCodAlumno.removeAllItems();
		for(int i=0; i < al.tamanio(); i++) {
			cboCodAlumno.addItem(al.obtener(i).getCodigoAlumno());
		}
		cboCodAlumno.setSelectedIndex(-1);
	}
	
	void actualizarCboCurso() {
		cboCodCurso.removeAllItems();
		for(int i=0; i < ac.tamanio(); i++) {
			cboCodCurso.addItem(ac.obtener(i).getCodigoCurso());
		}
		cboCodCurso.setSelectedIndex(-1);
	}
	
	void limpieza() {
		txtCodAlumno.setText("");
		txtCodCurso.setText("");
		cboEstado.setSelectedIndex(-1);
	}
	
	// Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
		
	void error(String s, JTextField txt) {
			mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void habilitarcampos(boolean sino) {
		cboCodAlumno.setEnabled(sino);;
		cboCodCurso.setEnabled(sino);
	}
	// Métodos que retornan valor (sin parámetros)
	int leerCodigoMatricula() {
		return Integer.parseInt(txtCodMatricula.getText());
	}
	
	int leerCodigoAlumno() {
		return Integer.parseInt(cboCodAlumno.getSelectedItem().toString());
	}
	int leerCodigoCurso() {
		return Integer.parseInt(cboCodCurso.getSelectedItem().toString());
	}
	
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	String obtenerAlumno() {
		Alumno a = al.buscar(leerCodigoAlumno());
		return "alumno " + a.getNombres() + " " + a.getApellidos();
	}
	// Métodos que retornan valor (con parámetros)
	String enTextoEstado(int i) {
		return cboEstado.getItemAt(i);
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	
	// Accionar al seleccionar un cbo
	protected void itemStateChangedCboCodAlumno(ItemEvent e) {
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno a = al.buscar(codAlumno);
			txtCodAlumno.setText(a.getNombres() + " " + a.getApellidos());
		} catch(Exception f) {
		}
	}
	protected void itemStateChangedCboCodCurso(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso c = ac.buscar(codCurso);
			txtCodCurso.setText(c.getNombre());
		} catch(Exception f) {	
		}
	}
}
