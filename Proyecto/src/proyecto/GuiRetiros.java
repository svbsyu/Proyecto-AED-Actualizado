package proyecto;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloAlumno;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Curso;
import Hijos.Alumno;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GuiRetiros extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblCdCurso;
	private JLabel lblCodAlumno;
	private JLabel lblNewLabel_1;
	private JTextField txtCurso;
	private JTextField txtAlumno;
	private JComboBox<Object> cboCodAlumno;
	private JButton btnRetirar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JComboBox<Object> cboCurso;
	private JComboBox<String> cboEstado;
	private JButton btnOk;
	private DefaultTableModel modelo;

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
			GuiRetiros dialog = new GuiRetiros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiRetiros() {
		setModal(true);
		setResizable(false);
		setTitle("Retiros");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Celular");
		modelo.addColumn("DNI");
		modelo.addColumn("Estado");
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(683, 97, 89, 69);
		getContentPane().add(btnSalir);
		
		btnRetirar = new JButton("Retirar");
		btnRetirar.setBounds(683, 12, 89, 72);
		getContentPane().add(btnRetirar);
		
		cboCodAlumno = new JComboBox<Object>();
		cboCodAlumno.setBounds(106, 12, 100, 22);
		getContentPane().add(cboCodAlumno);
		cboCodAlumno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				itemStateChangedCboCodAlumno(e);
			}
		});
		cboCodAlumno.setEnabled(false);
		
		cboCurso = new JComboBox<Object>();
		cboCurso.setBounds(106, 76, 100, 22);
		getContentPane().add(cboCurso);
		cboCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				itemStateChangedCboCurso(e);
			}
		});
		cboCurso.setEnabled(false);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setBounds(106, 141, 100, 22);
		getContentPane().add(cboEstado);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"REGISTRADO", "MATRICULADO", "RETIRADO"}));
		cboEstado.setEnabled(false);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOk(e);
			}
		});
		btnOk.setBounds(218, 141, 89, 23);
		getContentPane().add(btnOk);
		btnOk.setEnabled(false);
		
		txtCurso = new JTextField();
		txtCurso.setBounds(12, 111, 194, 20);
		getContentPane().add(txtCurso);
		txtCurso.setEditable(false);
		txtCurso.setEnabled(false);
		txtCurso.setColumns(10);
		
		txtAlumno = new JTextField();
		txtAlumno.setBounds(12, 47, 194, 20);
		getContentPane().add(txtAlumno);
		txtAlumno.setEditable(false);
		txtAlumno.setEnabled(false);
		txtAlumno.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Estado");
		lblNewLabel_1.setBounds(12, 142, 122, 20);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		
		lblCdCurso = new JLabel("Cód. Curso");
		lblCdCurso.setBounds(12, 77, 122, 20);
		getContentPane().add(lblCdCurso);
		lblCdCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblCodAlumno = new JLabel("Cód. Alumno");
		lblCodAlumno.setBounds(12, 13, 122, 20);
		getContentPane().add(lblCodAlumno);
		lblCodAlumno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 179, 760, 369);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		tblTabla.setFillsViewportHeight(true);
		tblTabla.setModel(modelo);
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnRetirar(e);
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_2(e);
			}
		});
		

		
		actualizarCboAlumno();
		actualizarCboCurso();
		limpieza();
		listar();
	}
	
	ArregloMatricula am = new ArregloMatricula();
	ArregloAlumno al = new ArregloAlumno();
	ArregloCurso ac = new ArregloCurso();
	
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnRetirar(ActionEvent e) {
		habilitarcampos(true);
		cboEstado.setSelectedIndex(2);
		btnOk.setEnabled(true);
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno a = al.buscar(codAlumno);
			if(a != null)
			try {
				int codCurso = leerCodigoCurso();
				int estado = leerEstado();
			if(ac.buscar(codCurso) != null) {
					int ok = confirmar("Desea retirar al " + obtenerAlumno());
					if(ok == 0) {
						a.setEstado(estado);
						al.actualizarArchivo();
						listar();
					}
				} else {
					mensaje("El código curso no existe");
				}
			} catch(Exception f) {
				mensaje("Ingrese bien el código curso");
			}
			else
				mensaje("El código alumno no existe");
		} catch(Exception f) {
			mensaje("Ha ocurrido un error inesperado");
		}
	}
	// Métodos tipo void (sin parámetros)
	void limpieza() {
		txtAlumno.setText("");
		txtCurso.setText("");
		cboEstado.setSelectedIndex(-1);
	}
	
	void listar() {
		modelo.setRowCount(0);
		for(int i=0; i<al.tamanio(); i++) {
			Object[] fila = { al.obtener(i).getCodigoAlumno(),
						      al.obtener(i).getNombres(),
							  al.obtener(i).getApellidos(),
							  al.obtener(i).getTelefono(),
							  al.obtener(i).getDni(),
							  textoEstado(al.obtener(i).getEstado())};
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
		cboCurso.removeAllItems();
		for(int i=0; i < ac.tamanio(); i++) {
			cboCurso.addItem(ac.obtener(i).getCodigoCurso());
		}
		cboCurso.setSelectedIndex(-1);
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
			cboCurso.setEnabled(sino);
		}
	
	// Métodos que retornan valor (sin parámetros)
	int leerCodigoAlumno() {
		return Integer.parseInt(cboCodAlumno.getSelectedItem().toString());
	}
	
	int leerCodigoCurso() {
		return Integer.parseInt(cboCurso.getSelectedItem().toString());
	}
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	// Métodos que retornar valor(con parámetros)
	String textoEstado(int i) {
		return cboEstado.getItemAt(i);
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	String obtenerAlumno() {
		Alumno a = al.buscar(leerCodigoAlumno());
		return "alumno " + a.getNombres() + " " + a.getApellidos();
	}
	
	// Accionar al seleccionar un cbo
	protected void itemStateChangedCboCodAlumno(ItemEvent e) {
		try {
			int codAlumno = leerCodigoAlumno();
			Alumno a = al.buscar(codAlumno);
			txtAlumno.setText(a.getNombres() + " " + a.getApellidos());
		} catch(Exception f) {
		}
	}
	protected void itemStateChangedCboCurso(ItemEvent e) {
		try {
			int codCurso = leerCodigoCurso();
			Curso c = ac.buscar(codCurso);
			txtCurso.setText(c.getNombre());
		} catch(Exception f) {	
		}
	}
}
