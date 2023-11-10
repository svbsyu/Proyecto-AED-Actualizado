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

public class last extends JDialog {

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
	private JLabel lblCategoria;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCelular;
	private JComboBox<String> cboCategoria;
	private JSeparator separator;
	private JLabel lblMantDocentes;
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
					last dialog = new last();
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
	public last() {
		setTitle("MANTENIMIENTO DE DOCENTES");
		setBounds(100, 100, 695, 535);
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
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(42, 119, 98, 14);
		contentPane.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(42, 143, 98, 14);
		contentPane.add(lblApellidos);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(42, 168, 98, 14);
		contentPane.add(lblCelular);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setBounds(42, 192, 98, 14);
		contentPane.add(lblDNI);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(42, 217, 98, 14);
		contentPane.add(lblCategoria);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(150, 92, 121, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(150, 116, 121, 20);
		contentPane.add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(150, 140, 121, 20);
		contentPane.add(txtApellidos);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(150, 165, 121, 20);
		contentPane.add(txtCelular);
		
		JTextField txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(150, 189, 121, 20);
		contentPane.add(txtDNI);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"uno", "dos", "tres"}));
		cboCategoria.setBounds(150, 213, 121, 22);
		contentPane.add(cboCategoria);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 662, 14);
		contentPane.add(separator);
		
		lblMantDocentes = new JLabel("Mantenimiento de Docentes");
		lblMantDocentes.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		lblMantDocentes.setBounds(184, 11, 321, 37);
		contentPane.add(lblMantDocentes);
		
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
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
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
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n Personal", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 61, 297, 190);
		contentPane.add(panel_1);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Celular");
		modelo.addColumn("DNI");
		modelo.addColumn("Categoria");
		tblTabla.setModel(modelo);
		
		modelo.setRowCount(0);
		Object[] fila = { 1001, "Paola", "Robles", "982054869", "47186568", "Matemática" };
		modelo.addRow(fila);
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
}