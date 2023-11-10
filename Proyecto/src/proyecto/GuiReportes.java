package proyecto;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

public class GuiReportes extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblReportes;
	private JComboBox<Object> cboReportes;
	private JButton btnCerrar;
	private JTextArea txtReportes;

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
			GuiReportes dialog = new GuiReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiReportes() {
		setTitle("Reportes");
		setModal(true);
		setBounds(100, 100, 513, 472);
		getContentPane().setLayout(null);
		
		lblReportes = new JLabel("Tipo de reportes");
		lblReportes.setBounds(12, 13, 95, 16);
		getContentPane().add(lblReportes);
		
		cboReportes = new JComboBox<Object>();
		cboReportes.setModel(new DefaultComboBoxModel<Object>(new String[] {"Cursos matriculados por un alumno", "Cursos asignados a un docente", "Alumnos matriculados en un curso", "Docentes sin cursos asignados", "Alumnos no matriculados"}));
		cboReportes.setBounds(119, 9, 257, 24);
		getContentPane().add(cboReportes);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCerrar(e);
			}
		});
		btnCerrar.setBounds(388, 9, 97, 25);
		getContentPane().add(btnCerrar);
		
		txtReportes = new JTextArea();
		txtReportes.setBounds(12, 42, 473, 378);
		getContentPane().add(txtReportes);
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
