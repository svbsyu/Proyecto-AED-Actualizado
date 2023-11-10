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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class ManteCursos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblAsignatura;
	private JLabel lblCiclo;
	private JLabel lblCreditos;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JSeparator separator;
	private JLabel lblMantCursos;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnConsultar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JButton btnSalir;
	private JPanel panel;
	private JComboBox<String> cboCiclo;
	private JLabel lblCanHora;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */
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
		setTitle("MANTENIMIENTO DE CURSOS");
		setBounds(100, 100, 696, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(42, 95, 98, 14);
		contentPane.add(lblCodigo);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(42, 119, 98, 14);
		contentPane.add(lblAsignatura);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(42, 143, 98, 14);
		contentPane.add(lblCiclo);
		
		lblCreditos = new JLabel("Creditos");
		lblCreditos.setBounds(42, 168, 98, 14);
		contentPane.add(lblCreditos);
		
		lblCanHora = new JLabel("Cant. de Horas");
		lblCanHora.setBounds(42, 192, 98, 14);
		contentPane.add(lblCanHora);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(150, 92, 121, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setColumns(10);
		txtAsignatura.setBounds(150, 116, 121, 20);
		contentPane.add(txtAsignatura);
		
		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(150, 165, 121, 20);
		contentPane.add(txtCreditos);
		
		JTextField txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(150, 189, 121, 20);
		contentPane.add(txtHora);
		
		lblMantCursos = new JLabel("Mantenimiento de Cursos");
		lblMantCursos.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		lblMantCursos.setBounds(184, 11, 321, 37);
		contentPane.add(lblMantCursos);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 662, 14);
		contentPane.add(separator);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(409, 95, 113, 23);
		contentPane.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(532, 95, 113, 23);
		contentPane.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(409, 130, 113, 23);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(532, 130, 113, 23);
		contentPane.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(409, 166, 113, 23);
		contentPane.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(532, 166, 113, 23);
		contentPane.add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 262, 662, 223);
		contentPane.add(scrollPane);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnSalir(e);
			}
		});
		btnSalir.setBounds(409, 200, 236, 23);
		contentPane.add(btnSalir);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(381, 61, 291, 190);
		contentPane.add(panel);

		cboCiclo = new JComboBox<String>();
		cboCiclo.setModel(new DefaultComboBoxModel<String>(new String[] {"PRIMER", "SEGUNDO", "TERCER", "CUARTO", "QUINTO", "SEXTO"}));
		cboCiclo.setBounds(150, 139, 121, 22);
		contentPane.add(cboCiclo);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Asignatura");
		modelo.addColumn("Ciclo");
		modelo.addColumn("Creditos");
		modelo.addColumn("Cant. Horas");
		tblTabla.setModel(modelo);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n del Curso", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 61, 307, 190);
		contentPane.add(panel_1);
		
		modelo.setRowCount(0);
		Object[] fila = { 1001, "Paola", "Robles", "982054869", "47186568", "Matriculado" };
		modelo.addRow(fila);
	}

	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
}
