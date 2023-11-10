package proyecto;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiAsignacionDocente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigoDocente;
	private JLabel lblNombreDocente;
	private JLabel lblCodigoCurso;
	private JLabel lblNombreCurso;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBuscar;
	private JButton btnAsignar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnNuevo;
	private JButton btnListar;
	private JPanel panel;
	private JButton btnBuscar1;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JPanel panel_1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setModal(true);
		setTitle("Asignacion Docente");
		setBounds(100, 100, 595, 456);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		
		lblCodigoDocente = new JLabel("Código Docente");
		lblCodigoDocente.setBounds(21, 83, 114, 14);
		contentPanel.add(lblCodigoDocente);
		
		lblNombreDocente = new JLabel("Nombre del Docente");
		lblNombreDocente.setBounds(21, 116, 121, 14);
		contentPanel.add(lblNombreDocente);
		
		lblCodigoCurso = new JLabel("Código Curso");
		lblCodigoCurso.setBounds(21, 141, 107, 22);
		contentPanel.add(lblCodigoCurso);
		
		lblNombreCurso = new JLabel("Nombre del Curso");
		lblNombreCurso.setBounds(21, 174, 114, 14);
		contentPanel.add(lblNombreCurso);
		
		lblNewLabel = new JLabel("Asignación de Docente");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblNewLabel.setBounds(145, 11, 297, 31);
		contentPanel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(78, 40, 385, 2);
		contentPanel.add(separator);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 80, 173, 20);
		contentPanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 143, 76, 20);
		contentPanel.add(textField_1);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(350, 94, 92, 23);
		contentPanel.add(btnBuscar);
		
		btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(457, 94, 92, 23);
		contentPanel.add(btnAsignar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(350, 128, 92, 23);
		contentPanel.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		btnCancelar.setBounds(457, 128, 92, 23);
		contentPanel.add(btnCancelar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(457, 162, 92, 23);
		contentPanel.add(btnNuevo);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(350, 162, 92, 23);
		contentPanel.add(btnListar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Acciones", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(336, 53, 226, 156);
		contentPanel.add(panel);
		
		btnBuscar1 = new JButton("Buscar");
		btnBuscar1.setBounds(224, 141, 92, 23);
		contentPanel.add(btnBuscar1);
		
		comboBox = new JComboBox<String>();
		comboBox.setToolTipText("");
		comboBox.setBounds(143, 170, 173, 22);
		contentPanel.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(143, 112, 173, 22);
		contentPanel.add(comboBox_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Informaci\u00F3n ", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_1.setBounds(10, 53, 316, 156);
		contentPanel.add(panel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 552, 185);
		contentPanel.add(scrollPane);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
