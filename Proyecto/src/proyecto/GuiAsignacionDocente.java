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


import Clases.Curso;
import Hijos.Docente;
import Arreglos.ArregloDocente;
import Arreglos.ArregloCurso;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;


public class GuiAsignacionDocente extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton btnSalir;
	private JButton btnMatricular;
	private JLabel lblCodDoc;
	private JLabel lblCodCurso;
	private JTextField txtCodDoc;
	private JTextField txtCodCurso;
	private DefaultTableModel modelo;
	private JButton btnOk;
	private JLabel lblCategoria;
	private JComboBox<Object> cboCodDoc;
	private JComboBox<Object> cboCodCur;
	private JScrollPane scrollPane;
	private JTable tblTable;
	private JComboBox<String> cboCategoria;


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
			GuiAsignacionDocente dialog = new GuiAsignacionDocente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiAsignacionDocente() {
		setTitle("Asignacion Docente");
		setModal(true);
		setBounds(100, 100, 706, 477);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		getContentPane().setLayout(null);
		 
		 txtCodDoc = new JTextField();
		 txtCodDoc.setBounds(10, 35, 218, 20);
		 getContentPane().add(txtCodDoc);
		 txtCodDoc.setEditable(false);
		 txtCodDoc.setColumns(10);
		 
		 txtCodCurso = new JTextField();
		 txtCodCurso.setBounds(10, 91, 218, 20);
		 getContentPane().add(txtCodCurso);
		 txtCodCurso.setEditable(false);
		 txtCodCurso.setColumns(10);
		 
		 lblCodDoc = new JLabel("Código del Docente");
		 lblCodDoc.setBounds(10, 11, 119, 14);
		 getContentPane().add(lblCodDoc);
		 
		 lblCodCurso = new JLabel("Código de curso");
		 lblCodCurso.setBounds(10, 66, 102, 14);
		 getContentPane().add(lblCodCurso);
		 
		 btnSalir = new JButton("Salir");
		 btnSalir.setBounds(591, 82, 89, 61);
		 getContentPane().add(btnSalir);
		 
		 btnMatricular = new JButton("Asignar");
		 btnMatricular.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnAsignar(e);
		 	}
		 });
		 btnMatricular.setBounds(591, 7, 89, 64);
		 getContentPane().add(btnMatricular);
		 
		 btnOk = new JButton("OK");
		 btnOk.setEnabled(false);
		 btnOk.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnOk(e);
		 	}
		 });
		 btnOk.setBounds(238, 120, 89, 23);
		 getContentPane().add(btnOk);
		 
		 lblCategoria = new JLabel("Categoria");
		 lblCategoria.setBounds(10, 122, 65, 14);
		 getContentPane().add(lblCategoria);
		 
		 scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 154, 670, 273);
		 getContentPane().add(scrollPane);
		 
		 tblTable = new JTable();
		 tblTable.setFillsViewportHeight(true);
		 tblTable.setRowSelectionAllowed(false);
		 tblTable.setEnabled(false);
		 scrollPane.setViewportView(tblTable);
		 btnSalir.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		actionPerformedBtnSalir(e);
		 	}
		 });
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Celular");
		modelo.addColumn("DNI");
		modelo.addColumn("Cód. Curso");
		modelo.addColumn("Nombre curso");
		modelo.addColumn("Categoria");
		tblTable.setModel(modelo);
		cboCategoria = new JComboBox<String>();
		cboCategoria.setEnabled(false);
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Día", "Tarde", "Noche"}));
		cboCategoria.setBounds(109, 122, 119, 22);
		getContentPane().add(cboCategoria);
		
		cboCodDoc = new JComboBox<Object>();
		cboCodDoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				itemStateChangedCboCodDoc(e);
			}
		});
		cboCodDoc.setEnabled(false);
		cboCodDoc.setBounds(139, 7, 89, 22);
		getContentPane().add(cboCodDoc);
		
		cboCodCur = new JComboBox<Object>();
		cboCodCur.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				itemStateChangedCboCodCur(e);
			}
		});
		cboCodCur.setEnabled(false);
		cboCodCur.setBounds(138, 62, 89, 22);
		getContentPane().add(cboCodCur);
		modelo.setRowCount(0);
		
		
		actualizarCboDocente();
		actualizarCboCurso();
		listar();
		limpieza();
	}
	
	ArregloDocente ad = new ArregloDocente();
	ArregloCurso ac = new ArregloCurso();
	

	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAsignar(ActionEvent e) {
		habilitarcampos(true);
		cboCategoria.setSelectedIndex(0);
		btnOk.setEnabled(true);
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		try {
			int codDoc = leerCodDoc();
			Docente x = ad.buscar(codDoc);
			int codCurso = leerCodigoCurso();
			try {
			if(x.getCodCurso() == 0  ||  x.getCodCurso() == -1) {
			x.setCodCurso(codCurso);
			x.setNomCurso(txtCodCurso.getText());
			ad.actualizarArchivo();
			listar();
			limpieza();
			}
			else {
				mensaje("El docente ya tiene un curso asignado");
				limpieza();
				}
			}catch(Exception f) {
				mensaje("Ingrese bien los datos");
			}
		} catch(Exception f) {
			mensaje("Ha ocurrido un error inesperado");
		}
	}
	
	// Métodos tipo void (sin parámetros)
	void listar() {
		Docente x;
		modelo.setRowCount(0);
		for(int i = 0; i < ad.tamanio(); i++) {
			x = ad.obtener(i);
			Object[] fila = {
					x.getCodigoDocente(),
					x.getNombres(),
					x.getApellidos(),
					x.getTelefono(),
					x.getDni(),
					x.getCodCurso(),
					x.getNomCurso().toUpperCase(),
					enTextoEstado(x.getCategoria()).toUpperCase()
			};
		modelo.addRow(fila);
		}
	}
	
	
	// Encontrar códigos de alumnos y cursos
	void actualizarCboDocente() {
		cboCodDoc.removeAllItems();
		for(int i = 0; i < ad.tamanio(); i++) {
			cboCodDoc.addItem(ad.obtener(i).getCodigoDocente());
		}
		cboCodDoc.setSelectedIndex(-1);
	}
	
	void actualizarCboCurso() {
		cboCodCur.removeAllItems();
		for(int i=0; i < ac.tamanio(); i++) {
			cboCodCur.addItem(ac.obtener(i).getCodigoCurso());
		}
		cboCodCur.setSelectedIndex(-1);
	}
	
	void limpieza() {
		txtCodDoc.setText("");
		txtCodCurso.setText("");
		cboCategoria.setSelectedIndex(-1);
		cboCodDoc.setSelectedIndex(-1);
		cboCodCur.setSelectedIndex(-1);
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
		cboCodDoc.setEnabled(sino);;
		cboCodCur.setEnabled(sino);
	}
	// Métodos que retornan valor (sin parámetros)
	
	int leerCodDoc() {
		return Integer.parseInt(cboCodDoc.getSelectedItem().toString().toUpperCase());
	}
	
	int leerCodigoCurso() {
		return Integer.parseInt(cboCodCur.getSelectedItem().toString().toUpperCase());
	}
	
	int leerEstado() {
		return cboCategoria.getSelectedIndex();
	}

	// Métodos que retornan valor (con parámetros)
	String enTextoEstado(int i) {
		return cboCategoria.getItemAt(i);
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	protected void itemStateChangedCboCodDoc(ItemEvent e){
		try {
			int codDocente = leerCodDoc();
			Docente d = ad.buscar(codDocente);
			txtCodDoc.setText(d.nombreApellido());
		}
		catch(Exception f) {
			
		}
	}
	protected void itemStateChangedCboCodCur(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso c = ac.buscar(codCurso);
			txtCodCurso.setText(c.getNombre());
		} catch(Exception f) {	
		}
	}
}
