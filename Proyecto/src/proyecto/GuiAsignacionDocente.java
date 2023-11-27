package proyecto;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import Arreglos.ArregloDocente;

import Hijos.*;


import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class GuiAsignacionDocente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigoDocente;
	private JTextField txtCodDoc;
	private JButton btnBuscar;
	private JButton btnAsignar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JComboBox<String> cboNombreCurso;
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JButton btnOpciones;
	private JTable tblDocente;
	private DefaultTableModel modelo;
	
//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
	//  Constantes para los tipos de operaciones
	public final static int ASIGNAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		setResizable(false);
		setModal(true);
		setTitle("Asignacion Docente");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		contentPanel.setLayout(null);
		
		lblCodigoDocente = new JLabel("Código Docente");
		lblCodigoDocente.setBounds(10, 11, 114, 23);
		contentPanel.add(lblCodigoDocente);
		
		txtCodDoc = new JTextField();
		txtCodDoc.setBounds(134, 11, 70, 22);
		txtCodDoc.setEditable(false);
		txtCodDoc.setColumns(10);
		contentPanel.add(txtCodDoc);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(214, 11, 123, 23);
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		contentPanel.add(btnBuscar);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(660, 11, 114, 23);
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnAsignar(e);
			}
		});
		contentPanel.add(btnAsignar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(660, 72, 114, 23);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		contentPanel.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(549, 131, 225, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		contentPanel.add(btnSalir);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(660, 102, 114, 23);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnConsultar(e);
			}
		});
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(660, 41, 114, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		contentPanel.add(btnModificar);
		
		cboNombreCurso = new JComboBox<String>();
		cboNombreCurso.setBounds(134, 199, 121, 22);
		cboNombreCurso.setEnabled(false);
		cboNombreCurso.setModel(new DefaultComboBoxModel<String>(new String[] {"--Sin Asignar--", "Matematicas", "Comunicación", "Personal Social", "Ingles", "Computación "}));
		cboNombreCurso.setToolTipText("");
		contentPanel.add(cboNombreCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 764, 318);
		contentPanel.add(scrollPane);
		
		tblDocente = new JTable();
		tblDocente.setFillsViewportHeight(true);
		tblDocente.setEnabled(false);
		scrollPane.setViewportView(tblDocente);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(265, 197, 60, 26);
		btnOk.setEnabled(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOk(e);
			}
		});
		contentPanel.add(btnOk);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(549, 11, 106, 113);
		btnOpciones.setEnabled(false);
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOpciones(e);
			}
		});
		contentPanel.add(btnOpciones);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo Docente");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Telefonia");
		modelo.addColumn("Dni");
		modelo.addColumn("Categoria");
		modelo.addColumn("Curso");
		tblDocente.setModel(modelo);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 40, 114, 23);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(10, 75, 114, 23);
		contentPanel.add(lblApellido);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 109, 114, 23);
		contentPanel.add(lblTelefono);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 140, 114, 23);
		contentPanel.add(lblDni);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 170, 114, 23);
		contentPanel.add(lblCategoria);
		
		lblNombreDelCurso = new JLabel("Nombre del Curso");
		lblNombreDelCurso.setBounds(10, 199, 114, 23);
		contentPanel.add(lblNombreDelCurso);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(134, 41, 203, 22);
		contentPanel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(134, 76, 203, 22);
		contentPanel.add(txtApellido);
		
		txtTelefonia = new JTextField();
		txtTelefonia.setEditable(false);
		txtTelefonia.setColumns(10);
		txtTelefonia.setBounds(134, 110, 203, 22);
		contentPanel.add(txtTelefonia);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(134, 141, 203, 22);
		contentPanel.add(txtDni);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Dia", "Tarde", "Noche"}));
		cboCategoria.setToolTipText("");
		cboCategoria.setEnabled(false);
		cboCategoria.setBounds(134, 170, 203, 22);
		contentPanel.add(cboCategoria);
		listar();
	}
	protected void actionPerformedBtnOpciones(ActionEvent arg0) {
		txtCodDoc.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefonia.setText("");
		txtCodDoc.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		switch(tipoOperacion) {
		case ASIGNAR:
			adicionarDocente();break;
		case CONSULTAR:
			consultarDocente();break;
		case MODIFICAR:
			modificarDocente();break;
		case ELIMINAR:
			eliminarDocenteAsinado();break;
		}
	
	}

	ArregloDocente ad=new ArregloDocente();
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblCategoria;
	private JLabel lblNombreDelCurso;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefonia;
	private JTextField txtDni;
	private JComboBox<String> cboCategoria;

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarDocente();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		tipoOperacion = ELIMINAR;
		txtCodDoc.setEditable(true);
		habilitarBotones(false);
		txtCodDoc.requestFocus();
	}
	protected void actionPerformedBtnAsignar(ActionEvent e) {
		tipoOperacion = ASIGNAR;
		txtCodDoc.setText("" + ad.codigoCorrelativo());
		habilitarEntradas(false);
		cboCategoria.setEnabled(true);
		btnBuscar.setEnabled(true);
		txtCodDoc.setEditable(true);
		cboNombreCurso.setEnabled(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtCodDoc.setEditable(true);
		habilitarBotones(false);
		txtCodDoc.requestFocus();
		txtDni.setEnabled(false);
	    
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtCodDoc.setEditable(true);
		habilitarBotones(false);
		txtCodDoc.requestFocus();
	}
	
	
	
	
	void adicionarDocente() {
		int codigo = leerCodigoDocente();
		String nombre = leerNombreDocente();
		if(nombre.length() > 0) {
			String apellido = leerApellidoDocente();
			if(apellido.length() > 0) {
				String celular = leerTelefonia();
				if(celular.length() > 0) {
					String telefonia = leerTelefonia();
					String dni = leerDni();
					if(ad.buscar(dni)==null){
						try {
							int categoria = leerPosCategoria();
							Docente nuevo = new Docente(codigo, nombre, apellido, telefonia, dni, categoria);
							ad.adicionar(nuevo);
							listar();
							txtCodDoc.setText("" + ad.codigoCorrelativo());
							txtNombre.setText("");
							txtApellido.setText("");
							txtTelefonia.setText("");
							txtDni.setText("");
							txtNombre.requestFocus();
						}
						catch(Exception e) {
						error("El DNI"+ dni + "ya existe.", txtDni);
					}
				}
				}
				else
					error("Ingrese un número valido", txtTelefonia);
			}
			else
				error("Ingrese el apellido correctamente", txtApellido);
		}
		else
			error("Ingrese el nombre correctamente", txtNombre);
	}
	void modificarDocente() {
		try {
			int codigo = leerCodigoDocente();
			Docente x = ad.buscar(codigo);
			if(x != null) {
				String nombre = leerNombreDocente();
				if(nombre.length() > 0) {
					String apellidos = leerApellidoDocente();
					if(apellidos.length() > 0) {
						String celular = leerTelefonia();
						if(celular.length() > 0) {
							String dni = leerDni();
							if(ad.buscar(dni) != null)
								try {
									int estado = leerPosCategoria();
									x.setNombres(nombre);
									x.setApellidos(apellidos);
									x.setTelefono(celular);
									x.setDni(dni);
									x.setCategoria(estado);
									int ok = confirmar("¿ Desea modificar el curso ?");
									if(ok == 0) {
									ad.actualizarArchivo();
									listar();
									txtNombre.requestFocus();
									}
								}
							catch(Exception e) {
								error("El dni se encuentra vacio", txtDni);
							}
						}
						else
							error("Ingrese un número valido", txtTelefonia);
					}
					else
						error("Ingrese un apellido", txtApellido);
				}
				else
					error("Ingrese un nombre", txtNombre);
			}
			else
				error("El código no existe", txtCodDoc);
		}
		catch(Exception e) {
			error("Ingrese el codigo correctamente", txtCodDoc);
		}
	}
	void consultarDocente() {
		try {
			int codigo = leerCodigoDocente();
			Docente x = ad.buscar(codigo);
			if (x != null) {
				txtNombre.setText(x.getNombres());
				txtApellido.setText(x.getApellidos());
				txtTelefonia.setText(x.getTelefono());
				cboCategoria.setSelectedIndex(x.getCategoria());
				txtDni.setText(x.getDni());
				
				if (tipoOperacion == MODIFICAR) {
					habilitarEntradas(true);
					txtCodDoc.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
					txtNombre.requestFocus();
					txtDni.setEnabled(false);
				}
				if (tipoOperacion == ELIMINAR) {
					txtCodDoc.setEditable(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodDoc);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodDoc);
		}
	}
	
	void eliminarDocenteAsinado() {
		try {
			int codigo = leerCodigoDocente();
			Docente x = ad.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					ad.eliminar(x);
					listar();
					btnOk.setEnabled(false);
				}
			}
			else
				error("El código " + codigo + " no existe", txtCodDoc);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtCodDoc);
		}	
	}
//  Métodos tipo void (con parámetros)
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		if (tipoOperacion == ASIGNAR)	
		txtDni.setEditable(!sino);
		txtCodDoc.setEditable(sino);
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtTelefonia.setEditable(sino);
		cboCategoria.setEnabled(sino);
		txtDni.setEditable(sino);
		cboNombreCurso.setEnabled(sino);
		
	}
	void habilitarBotones(boolean sino) {
		if (tipoOperacion == ASIGNAR)
			btnOk.setEnabled(!sino);
		else {
			btnBuscar.setEnabled(!sino);
			btnOk.setEnabled(false);
		}	
		btnAsignar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnOpciones.setEnabled(!sino);	
	}
	
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
					x.getCategoria(),
					
					};
		modelo.addRow(fila);
		}
		
		}
	


	
	/*Metodos de retorno*/
	int leerCodigoDocente() {
		return Integer.parseInt(txtCodDoc.getText().trim());
	}
	String leerNombreDocente() {
		return txtNombre.getText().trim();
	}
	String leerApellidoDocente() {
		return txtApellido.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	String leerTelefonia() {
		return txtTelefonia.getText().trim();
	}
	int leerPosCategoria(){
		return cboCategoria.getSelectedIndex();
	}
	int nombreCurso() {
		return cboNombreCurso.getSelectedIndex();
	}
	String enTextoCurso(int i) {
		return cboNombreCurso.getItemAt(i);
	}
	String enTextoCategoria(int i) {
		return cboCategoria.getItemAt(i);
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	}

