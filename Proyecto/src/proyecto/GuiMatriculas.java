package proyecto;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;


public class GuiMatriculas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnCancelar;
	private JButton btnMatricular;
	private JButton btnBuscar;
	private JPanel panel_1;
	private JLabel Nume;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtCodMatricula;
	private JTextField txtCodAlumno;
	private JTextField txtCodCurso;
	private JComboBox<Object> cboCodAlumno;
	private JComboBox<Object> cboCodCurso;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private JTable tblTabla;


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
		
		panel = new JPanel();
		panel.setBounds(495, 11, 185, 125);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Acciones", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(27, 189, 243)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnMatricular = new JButton("Matrícular");
		btnMatricular.setBounds(48, 21, 89, 23);
		panel.add(btnMatricular);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(48, 49, 89, 23);
		panel.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCancelar(e);
			}
		});
		btnCancelar.setBounds(48, 77, 89, 23);
		panel.add(btnCancelar);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 470, 125);
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registro de matr\u00EDcula", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(27, 189, 243)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Nume = new JLabel("Código de matrícula\r\n");
		Nume.setBounds(10, 27, 119, 14);
		panel_1.add(Nume);
		
		lblNewLabel_1 = new JLabel("Código de alumno\r\n");
		lblNewLabel_1.setBounds(10, 59, 119, 14);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Código de curso");
		lblNewLabel_2.setBounds(10, 89, 102, 14);
		panel_1.add(lblNewLabel_2);
		
		txtCodMatricula = new JTextField();
		txtCodMatricula.setBounds(135, 24, 86, 20);
		panel_1.add(txtCodMatricula);
		txtCodMatricula.setColumns(10);
		
		txtCodAlumno = new JTextField();
		txtCodAlumno.setEditable(false);
		txtCodAlumno.setBounds(135, 56, 86, 20);
		panel_1.add(txtCodAlumno);
		txtCodAlumno.setColumns(10);
		
		txtCodCurso = new JTextField();
		txtCodCurso.setEditable(false);
		txtCodCurso.setBounds(135, 86, 86, 20);
		panel_1.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		cboCodAlumno = new JComboBox<Object>();
		cboCodAlumno.setModel(new DefaultComboBoxModel<Object>(new String[] {"2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"}));
		cboCodAlumno.setBounds(289, 55, 89, 22);
		panel_1.add(cboCodAlumno);
		
		cboCodCurso = new JComboBox<Object>();
		cboCodCurso.setModel(new DefaultComboBoxModel<Object>(new String[] {"3001", "3002", "3003", "3004", "3005", "3006", "3007", "3008", "3009", "3010"}));
		cboCodCurso.setBounds(289, 85, 89, 22);
		panel_1.add(cboCodCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 670, 280);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		 modelo.addColumn("Código de matrícula");
		 modelo.addColumn("Código de alumno");
		 modelo.addColumn("Código de curso");
		 tblTabla.setModel(modelo);
		 modelo.setRowCount(0);
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
