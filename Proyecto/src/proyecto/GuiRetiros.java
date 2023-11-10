package proyecto;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
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

public class GuiRetiros extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCdCurso;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<Object> comboBox;
	private JPanel panel_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTable table;

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
		setBounds(100, 100, 555, 500);
		getContentPane().setLayout(null);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		
		panel = new JPanel();
		panel.setBounds(0, 0, 539, 461);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 353, 126);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Datos del Matriculado", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		
		lblCdCurso = new JLabel("Cód. Curso");
		lblCdCurso.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		lblCdCurso.setBounds(10, 87, 122, 20);
		panel_1.add(lblCdCurso);
		
		lblNewLabel = new JLabel("Cód. Alumno");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 23, 122, 20);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cód. Matricula");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 56, 122, 20);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(141, 25, 86, 20);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(141, 58, 86, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(141, 89, 86, 20);
		panel_1.add(textField_2);
		
		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"comojodes"}));
		comboBox.setBounds(250, 24, 86, 22);
		panel_1.add(comboBox);
		
		panel_2 = new JPanel();
		panel_2.setBounds(373, 11, 157, 126);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Acciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(36, 19, 89, 23);
		panel_2.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Retirar");
		btnNewButton_1.setBounds(36, 53, 89, 23);
		panel_2.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnNewButton_2(e);
			}
		});
		btnNewButton_2.setBounds(36, 87, 89, 23);
		panel_2.add(btnNewButton_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 520, 309);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		dispose();
	}
}
