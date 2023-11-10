package proyecto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import Arreglos.ArregloCurso;
import Clases.Curso;

import javax.swing.UIManager;

public class ManteCursos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigoCurso;
	private JLabel lblNombreCurso;
	private JLabel lblCodigoDocente;
	private JTextField txtCodigoCurso;
	private JTextField txtNombreCurso;
	private JTextField txtHoras;
	private JSeparator separator;
	private JLabel lblMantCursos;
	private JButton btnIngresar;
	private JButton btnOpciones;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JLabel lblHora;
	private JTextField txtCodigoDocente;
	private JButton btnBuscar;
	private JButton btnOk;
	private JButton btnSalir;
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
					ManteCursos dialog = new ManteCursos();
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
	public ManteCursos() {
		setModal(true);
		setTitle("MANTENIMIENTO DE CURSOS");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMantCursos = new JLabel("Mantenimiento de Cursos");
		lblMantCursos.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		lblMantCursos.setBounds(235, 0, 321, 37);
		contentPane.add(lblMantCursos);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 764, 14);
		contentPane.add(separator);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 764, 309);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setColumnHeaderView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código del curso");
		modelo.addColumn("Nombre del curso");
		modelo.addColumn("Código del docente");
		modelo.addColumn("Horas");
		tblTabla.setModel(modelo);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(118, 173, 121, 22);
		contentPane.add(txtHoras);
		txtHoras.setEnabled(false);
		txtHoras.setColumns(10);
		
		txtCodigoDocente = new JTextField();
		txtCodigoDocente.setBounds(118, 136, 121, 22);
		contentPane.add(txtCodigoDocente);
		txtCodigoDocente.setEnabled(false);
		txtCodigoDocente.setColumns(10);
		
		lblHora = new JLabel("Horas");
		lblHora.setBounds(10, 177, 98, 14);
		contentPane.add(lblHora);
		
		lblCodigoDocente = new JLabel("Código del docente");
		lblCodigoDocente.setBounds(10, 138, 114, 18);
		contentPane.add(lblCodigoDocente);
		
		lblNombreCurso = new JLabel("Nombre del curso");
		lblNombreCurso.setBounds(10, 99, 106, 17);
		contentPane.add(lblNombreCurso);
		
		lblCodigoCurso = new JLabel("Código del curso");
		lblCodigoCurso.setBounds(10, 60, 98, 17);
		contentPane.add(lblCodigoCurso);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setBounds(118, 97, 253, 20);
		contentPane.add(txtNombreCurso);
		txtNombreCurso.setEnabled(false);
		txtNombreCurso.setColumns(10);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setBounds(118, 59, 121, 20);
		contentPane.add(txtCodigoCurso);
		txtCodigoCurso.setEnabled(false);
		txtCodigoCurso.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(258, 56, 113, 25);
		contentPane.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(661, 172, 113, 23);
		contentPane.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(661, 135, 113, 23);
		contentPane.add(btnModificar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(661, 56, 113, 23);
		contentPane.add(btnIngresar);
		
		btnOk = new JButton("OK");
		btnOk.setEnabled(false);
		btnOk.setBounds(258, 172, 113, 25);
		contentPane.add(btnOk);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(661, 206, 113, 23);
		contentPane.add(btnListar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOpciones(e);
			}
		});
		btnOpciones.setBounds(538, 58, 113, 99);
		contentPane.add(btnOpciones);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(661, 95, 113, 23);
		contentPane.add(btnConsultar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSalir(e);
			}
		});
		btnSalir.setBounds(538, 172, 113, 23);
		contentPane.add(btnSalir);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnConsultar(e);
			}
		});

		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListar(e);
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnOk(e);
			}
		});
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificar(e);
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnEliminar(e);
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnBuscar(e);
			}
		});
		
		ajustarAnchoColumnas();
		listar();
	}
	
	// Declaración global
	ArregloCurso ac = new ArregloCurso();
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		
		txtCodigoCurso.setText("" + ac.codigoCorrelativo());
		
		habilitarBotones(false);
		habilitarCampos(true);
		txtCodigoCurso.setEnabled(false);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		txtCodigoCurso.setEnabled(true);
		habilitarBotones(false);
		txtCodigoCurso.requestFocus();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		txtCodigoCurso.setText("");
		tipoOperacion = ELIMINAR;
		txtCodigoCurso.setEnabled(true);
		habilitarBotones(false);
		txtCodigoCurso.requestFocus();
	}

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;
		txtCodigoCurso.setEnabled(true);
		habilitarBotones(false);
		txtCodigoCurso.requestFocus();
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		tipoOperacion = LISTAR;
	}
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		txtCodigoCurso.setText("");
		txtNombreCurso.setText("");
		txtCodigoDocente.setText("");
		txtHoras.setText("");
		habilitarBotones(true);
		habilitarCampos(false);
		btnBuscar.setEnabled(false);
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		consultarCursos();
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		this.dispose();	
	}
	protected void actionPerformedBtnOk(ActionEvent e) {
		try {
			switch(tipoOperacion) {
			case ADICIONAR:
				adicionarCursos();
				break;
			case CONSULTAR:
				consultarCursos();
				break;
			case MODIFICAR:
				modificarCursos();
				break;
			case ELIMINAR:
				eliminarCurso();
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
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // Código del curso
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30)); // Nombre del curso
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); // Código del docente
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // Horas
	}
	
	void listar() {
		modelo.setRowCount(0);
		for(int i=0; i<ac.tamanio(); i++) {
			Object[] fila = { ac.obtener(i).getCodigoCurso(),
						      ac.obtener(i).getNombre(),
							  ac.obtener(i).getCodigoDocente(),
							  ac.obtener(i).getHoras() };
			modelo.addRow(fila);
		}
	}
	
	void adicionarCursos() {
		int codigoCurso = leerCodigoCurso();
		if(ac.buscar(codigoCurso) == null) {
			String nombreCurso = leerNombreCurso();
			if(nombreCurso.length() > 0 && ac.buscar(nombreCurso) == null)
				try {
					int codigoDocente = leerCodigoDocente();
					try {
						double horas = leerHoras();
						Curso nuevo = new Curso(codigoCurso, nombreCurso, codigoDocente, horas);
						ac.adicionar(nuevo);
						listar();
						txtCodigoCurso.setText("" + ac.codigoCorrelativo());
						txtNombreCurso.setText("");
						txtCodigoDocente.setText("");
						txtHoras.setText("");
						txtNombreCurso.requestFocus();
					} catch(Exception e) {
						error("Ingrese bien las HORAS",txtHoras);
					}
				} catch(Exception e) {
					error("Ingrese bien el CÓDIGO DOCENTE",txtCodigoDocente);
				}
			else
				error("Ingrese bien el NOMBRE DEL CURSO",txtNombreCurso);
		} else
			error("El CÓDIGO CURSO ya existe", txtCodigoCurso);
	}
///////////////////////////////////
	void consultarCursos() {
		try {
			int codigoCurso = leerCodigoCurso();
			Curso x = ac.buscar(codigoCurso);
			
			if(x != null) {
				txtNombreCurso.setText(x.getNombre());
				txtCodigoDocente.setText("" + x.getCodigoDocente());
				txtHoras.setText("" + x.getHoras());
				if(tipoOperacion == MODIFICAR) {
					habilitarCampos(true);
					txtCodigoCurso.setEnabled(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
					txtNombreCurso.requestFocus();
				}
				if(tipoOperacion == ELIMINAR) {
					txtCodigoCurso.setEnabled(false);
					btnBuscar.setEnabled(false);
					btnOk.setEnabled(true);
				}
			}
			else
				error("El código" + codigoCurso + "no existe",txtCodigoCurso);
		} catch(Exception e) {
			error("Ingrese el CÓDIGO DEL CURSO correctamente",txtCodigoCurso);
		}
	}
	
	void modificarCursos() {
		try {
			int codigoCurso = leerCodigoCurso();
			Curso x = ac.buscar(codigoCurso);
			
			if(x != null) {
				String nombreCurso = leerNombreCurso();
				if(nombreCurso.length() > 0)
					try {
						int codigoDocente = leerCodigoDocente();
						try{
							double hora = leerHoras();
							x.setNombre(nombreCurso);
							x.setCodigoDocente(codigoDocente);
							x.setHoras(hora);
							int ok = confirmar("¿ Desea modificar el curso ?");
							if(ok == 0) {
							ac.actualizarArchivo();
							listar();
							txtNombreCurso.requestFocus();
							} 
						} catch(Exception e) {
							error("Ingrese bien las HORAS", txtHoras);
						}
					} catch(Exception e) {
						error("Ingrese bien el CÓDIGO DOCENTE",txtCodigoDocente);
					}
				else 
					error("Ingrese el NOMBRE DEL CURSO CORRECTAMENTE", txtNombreCurso);
			}
			else
				error("El código" + codigoCurso + "no existe",txtCodigoCurso);
		} catch(Exception e) {
			error("Ingrese el CÓDIGO CORRECTAMENTE",txtCodigoCurso);
		}
	}
	
	void eliminarCurso() {
		try {
			int codigoCurso = leerCodigoCurso();
			Curso x = ac.buscar(codigoCurso);
			
			if(x != null) {
				int ok = confirmar("¿Desea eliminar el curso?");
				if(ok == 0) {
					ac.eliminar(x);
					listar();
					btnOk.setEnabled(false);
				}
			}
			else 
				error("El código" + codigoCurso + "no existe",txtCodigoCurso);
		} catch(Exception e) {
			error("Ingrese el CÓDIGO DEL CURSO correctamente",txtCodigoCurso);
		}
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
		txtCodigoCurso.setEnabled(sino);
		txtNombreCurso.setEnabled(sino);
		txtCodigoDocente.setEnabled(sino);
		txtHoras.setEnabled(sino);
	}
	

	// Métodos que retornan valor (sin parámetros)
	int leerCodigoCurso() {
		return Integer.parseInt(txtCodigoCurso.getText().trim());
	}
	
	String leerNombreCurso() {
		return txtNombreCurso.getText().trim().toUpperCase();
	}
	
	int leerCodigoDocente() {
		return Integer.parseInt(txtCodigoDocente.getText().trim());
	}
	
	Double leerHoras() {
		return Double.parseDouble(txtHoras.getText().trim());
	}
	// Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
