package proyecto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloAlumno;
import Clases.Alumno;

import javax.swing.UIManager;

public class ManteAlumnos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCelular;
	private JLabel lblDNI;
	private JLabel lblEstado;
	private JTextField txtCodigoAlumno;
	private JTextField txtNombreAlumno;
	private JTextField txtApellidoAlumno;
	private JTextField txtCelularAlumno;
	private JComboBox<String> cboEstado;
	private JSeparator separator;
	private JLabel lblMantAlumnos;
	private JButton btnOk;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JButton btnSalir;
	private JButton btnOpciones;
	private JButton btnBuscar;
	private JTextField txtDNI;
	/**
	 * Launch the application.
	 */
	
	// Tipo de operación a procesar: Adicionar, Consultar, Modificar, Eliminar O Listar
	private int tipoOperacion;
	
	// Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;
	public final static int LISTAR = 4;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManteAlumnos dialog = new ManteAlumnos();
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
	public ManteAlumnos() {
		setResizable(false);
		setTitle("MANTENIMIENTO DE ALUMNOS");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(37, 64, 98, 14);
		contentPane.add(lblCodigo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(37, 93, 64, 14);
		contentPane.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(37, 121, 55, 14);
		contentPane.add(lblApellidos);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(37, 149, 55, 14);
		contentPane.add(lblCelular);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(37, 177, 55, 14);
		contentPane.add(lblDNI);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(37, 213, 55, 14);
		contentPane.add(lblEstado);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setEnabled(false);
		txtCodigoAlumno.setBounds(102, 61, 121, 20);
		contentPane.add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		txtNombreAlumno = new JTextField();
		txtNombreAlumno.setEnabled(false);
		txtNombreAlumno.setColumns(10);
		txtNombreAlumno.setBounds(102, 90, 244, 20);
		contentPane.add(txtNombreAlumno);
		
		txtApellidoAlumno = new JTextField();
		txtApellidoAlumno.setEnabled(false);
		txtApellidoAlumno.setColumns(10);
		txtApellidoAlumno.setBounds(102, 118, 244, 20);
		contentPane.add(txtApellidoAlumno);
		
		txtCelularAlumno = new JTextField();
		txtCelularAlumno.setEnabled(false);
		txtCelularAlumno.setColumns(10);
		txtCelularAlumno.setBounds(102, 146, 121, 20);
		contentPane.add(txtCelularAlumno);
		
		txtDNI = new JTextField();
		txtDNI.setEnabled(false);
		txtDNI.setColumns(10);
		txtDNI.setBounds(102, 174, 121, 20);
		contentPane.add(txtDNI);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"MATRICULADO", "REGISTRADO", "RETIRADO"}));
		cboEstado.setBounds(102, 209, 121, 22);
		cboEstado.setEnabled(false);
		contentPane.add(cboEstado);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 662, 14);
		contentPane.add(separator);
		
		lblMantAlumnos = new JLabel("Mantenimiento de Alumnos");
		lblMantAlumnos.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		lblMantAlumnos.setBounds(197, 0, 321, 37);
		contentPane.add(lblMantAlumnos);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOk(e);
			}
		});
		btnOk.setEnabled(false);
		btnOk.setBounds(233, 209, 113, 23);
		contentPane.add(btnOk);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnIngresar.setBounds(650, 54, 113, 23);
		contentPane.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		btnModificar.setBounds(650, 133, 113, 23);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnConsultar(e);
			}
		});
		btnConsultar.setBounds(650, 93, 113, 23);
		contentPane.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnEliminar.setBounds(650, 170, 113, 23);
		contentPane.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListar(e);
			}
		});
		btnListar.setBounds(527, 170, 113, 23);
		contentPane.add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 254, 774, 296);
		contentPane.add(scrollPane);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSalir(e);
			}
		});
		btnSalir.setBounds(527, 204, 236, 23);
		contentPane.add(btnSalir);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Celular");
		modelo.addColumn("DNI");
		modelo.addColumn("Estado");
		tblTabla.setModel(modelo);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOpciones(e);
			}
		});
		btnOpciones.setBounds(527, 54, 113, 105);
		contentPane.add(btnOpciones);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(233, 60, 113, 23);
		contentPane.add(btnBuscar);
		
		ajustarAnchoColumnas();
		listar();
	}
	
	// Declaración global
	ArregloAlumno aa = new ArregloAlumno();
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		
		txtCodigoAlumno.setText("" + aa.codigoCorrelativo());
		
		habilitarBotones(false);
		habilitarCampos(true);
		txtCodigoAlumno.setEnabled(false);
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		habilitarCampos(false);
		txtCodigoAlumno.setText("");
		txtCodigoAlumno.setEnabled(true);
		habilitarBotones(false);
		txtCodigoAlumno.requestFocus();
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoAlumno.setText("");
		tipoOperacion = ELIMINAR;
		txtCodigoAlumno.setEnabled(true);
		habilitarBotones(false);
		txtCodigoAlumno.requestFocus();
	}
	
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		txtCodigoAlumno.setText("");
		tipoOperacion = CONSULTAR;
		txtCodigoAlumno.setEnabled(true);
		habilitarBotones(false);
		txtCodigoAlumno.requestFocus();
	}
	
	protected void actionPerformedBtnListar(ActionEvent e) {
		tipoOperacion = LISTAR;
	}
	
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtCodigoAlumno.setText("");
		txtNombreAlumno.setText("");
		txtApellidoAlumno.setText("");
		txtCelularAlumno.setText("");
		txtDNI.setText("");
		habilitarBotones(true);
		habilitarCampos(false);
		btnBuscar.setEnabled(false);
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarAlumnos();
	}
	
	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		try {
			switch(tipoOperacion) {
			case ADICIONAR:
				adicionarAlumnos();
				break;
			case CONSULTAR:
				consultarAlumnos();
				break;
			case MODIFICAR:
				modificarAlumno();
				break;
			case ELIMINAR:
				eliminarAlumno();
				break;
			case LISTAR:
				break;
			default:
				break;
			}
		} catch(Exception e1) {
			mensaje("Ingrese datos");
		}
	}
	
	
	// Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8)); // Código del Alumno
		tcm.getColumn(1).setPreferredWidth(anchoColumna(16)); // Nombre del Alumno
		tcm.getColumn(2).setPreferredWidth(anchoColumna(16)); // Apellido del Alumno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // Celular
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); // Dni
	}
	
	void listar() {
		modelo.setRowCount(0);
		for(int i=0; i<aa.tamanio(); i++) {
			Object[] fila = { aa.obtener(i).getCodigoAlumno(),
						      aa.obtener(i).getNombre(),
							  aa.obtener(i).getApellido(),
							  aa.obtener(i).getCelular(),
							  aa.obtener(i).getDni(),
							  textoEstado(aa.obtener(i).getEstado())};
			modelo.addRow(fila);
		}
	}
	
	void adicionarAlumnos() {
	    int codigoAlumno = leerCodigoAlumno();
	    String nombreAlumno = leerNombreAlumno();
	    String apellidoAlumno = leerApellidoAlumno();
	    String celularAlumno = leerCelular();
	    String dniAlumno = leerDni();
	    int estado = leerEstado();

	    if (aa.buscar(codigoAlumno) != null) {
	        error("El CÓDIGO DEL ALUMNO ya existe", txtCodigoAlumno);
	        return;
	    }

	    if (nombreAlumno.length() == 0) {
	        error("Ingrese bien el NOMBRE DEL ALUMNO", txtNombreAlumno);
	        return;
	    }

	    if (apellidoAlumno.length() == 0) {
	        error("Ingrese bien el APELLIDO DEL ALUMNO", txtApellidoAlumno);
	        return;
	    }

	    if (celularAlumno.length() != 9) {
	        error("Número CELULAR debe contener 9 dígitos", txtCelularAlumno);
	        return;
	    }

	    if (dniAlumno.length() != 8) {
	        error("Número de DNI debe contener 8 dígitos", txtDNI);
	        return;
	    }
	    
	    if (comparacionNomApe() == true  && aa.buscarDni(dniAlumno) != null) {
	        JOptionPane.showMessageDialog(this, "El alumno ya se encuentra registrado");
	    }
	    
	   else if (comparacionNomApe() == false && aa.buscarDni(dniAlumno) != null) {
	        error("Número de DNI ya existe", txtDNI);
	        return;
	    }
	    
	    else {
	    Alumno nuevo = new Alumno(codigoAlumno, nombreAlumno, apellidoAlumno, celularAlumno, dniAlumno,estado);
	    aa.adicionar(nuevo);
	    listar();
	    txtCodigoAlumno.setText("" + aa.codigoCorrelativo());
	    txtNombreAlumno.setText("");
	    txtApellidoAlumno.setText("");
	    txtCelularAlumno.setText("");
	    txtDNI.setText("");
	    txtNombreAlumno.requestFocus();
	    }
	}

	
	void consultarAlumnos() {
		try {
			int codigoAlumno = leerCodigoAlumno();
			Alumno x = aa.buscar(codigoAlumno);
			
			if(x != null) {
				txtNombreAlumno.setText(x.getNombre());
				txtApellidoAlumno.setText(x.getApellido());
				txtCelularAlumno.setText(x.getCelular());
				txtDNI.setText(x.getDni());
				if(tipoOperacion == MODIFICAR) {
					habilitarCampos(true);
					txtCodigoAlumno.setEnabled(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
					txtNombreAlumno.requestFocus();
				}
				if(tipoOperacion == ELIMINAR) {
					txtCodigoAlumno.setEnabled(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
				}
			}
			else
				error("El código " + codigoAlumno + " no existe",txtCodigoAlumno);
		} catch(Exception e) {
			error("Ingrese el CÓDIGO DEL CURSO correctamente",txtCodigoAlumno);
		}
	}
	
	void modificarAlumno() {
	    try {
	    	Alumno x = aa.buscar(leerCodigoAlumno());
	    	String nombres = leerNombreAlumno();
	    	if(nombres.length() > 0) {
	    		String apellidos = leerApellidoAlumno();
	    		if(apellidos.length() > 0) {
	    			String numCelular = leerCelular();
	    			if(numCelular.length() > 0) 
	    					try {
	    						int estado = leerEstado();
	    						x.setNombre(nombres);
	    						x.setApellido(apellidos);
	    						x.setCelular(numCelular);
	    						x.setEstado(estado);
	    						int ok = confirmar("¿ Desea modificar los datos del alumno ?");
	    						if(ok == 0) {		
	    						aa.actualizarArchivo();
	    						listar();
	    						txtNombreAlumno.requestFocus();
	    						}
	    					} catch(Exception e) {
	    						mensaje("Ingrese bien el ESTADO");
	    					}
	    			else
	    				error("Ingrese bien el NUMERO",txtCelularAlumno);
	    		}
	    		else
	    			error("Ingrese el apellido correctamente",txtApellidoAlumno);
	    	}
	    	else
	    		error("Ingrese bien el nombre",txtNombreAlumno);
	    } catch(Exception e) {
	    	error("Ingrese el CÓDIGO CORRECTAMENTE",txtCodigoAlumno);
	    }
	}
	
	void eliminarAlumno() {
		try {
			int codigoAlumno = leerCodigoAlumno();
			Alumno x = aa.buscar(codigoAlumno);
			
			if(x != null) {
				int ok = confirmar("¿Desea eliminar el curso?");
				if(ok == 0) {
					aa.eliminar(x);
					listar();
					btnOk.setEnabled(false);
				}
			}
			else 
				error("El código " + codigoAlumno + " no existe",txtCodigoAlumno);
		} catch(Exception e) {
			error("Ingrese el CÓDIGO DEL ALUMNO correctamente",txtCodigoAlumno);
		}
	}
	
	//Metodos boleanos
	boolean comparacionNomApe() {
		if(aa.nomApellido(leerNombreAlumno(), leerApellidoAlumno()) != null)
			return true;
		else
			return false;
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
	
	void habilitarBotones(boolean sino) {
		if(tipoOperacion == ADICIONAR) {
			btnOk.setEnabled(!sino);
			btnBuscar.setEnabled(sino);
			btnEliminar.setEnabled(sino);
			btnConsultar.setEnabled(sino);
			btnModificar.setEnabled(sino);
			btnListar.setEnabled(sino);
		}
		else {
		btnBuscar.setEnabled(!sino);
		btnIngresar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		btnListar.setEnabled(sino);
		}
	}
	
	void habilitarCampos(boolean sino) {
		txtCodigoAlumno.setEnabled(sino);
		txtNombreAlumno.setEnabled(sino);
		txtApellidoAlumno.setEnabled(sino);
		txtCelularAlumno.setEnabled(sino);
			if(tipoOperacion == ADICIONAR)
			   txtDNI.setEnabled(sino);
		cboEstado.setEnabled(sino);
	}
	
	
	// Métodos que retornan valor (sin parámetros)
	int leerCodigoAlumno() {
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	
	String leerNombreAlumno() {
		return txtNombreAlumno.getText().trim().toUpperCase();
	}
	
	String leerApellidoAlumno() {
		return txtApellidoAlumno.getText().trim().toUpperCase();
	}
	
	String leerCelular() {
		return txtCelularAlumno.getText().trim();
	}
	
	String leerDni() {
		return txtDNI.getText().trim();
	}
	
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	// Métodos que retornan valor (con parámetros)
	String textoEstado(int i) {
		return cboEstado.getItemAt(i);
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
