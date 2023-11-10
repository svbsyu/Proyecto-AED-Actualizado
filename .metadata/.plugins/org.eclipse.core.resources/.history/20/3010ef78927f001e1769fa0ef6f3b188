package proyecto;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnMatriculas;
	private JMenu mnRetiros;
	private JMenu mnAsignacion;
	private JMenu mnReportes;
	private JMenuItem mntmDocentes;
	private JMenuItem mntmAlumnos;
	private JMenuItem mntmCursos;
	private JMenuItem mntmRetiros;
	private JMenuItem mntmAsignarDocente;
	private JMenuItem mntmMatriculas;
	private JMenuItem mntmReporte;

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
					GuiPrincipal frame = new GuiPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiPrincipal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 474);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		 
		// Altura y anchura de las imagenes
		int ancho = 35; 
	    int altura = 35;
	     
		// Menu Mantenimiento
		mnMantenimiento = new JMenu("Mantenimiento");		
        ImageIcon Mantenimiento = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Mantenimiento.png"));
        Image imagen1 = Mantenimiento.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
        ImageIcon imagenAjustada1 = new ImageIcon(imagen1);
        mnMantenimiento.setIcon(imagenAjustada1);
		menuBar.add(mnMantenimiento);
		
		// Sub menu de Docentes
		mntmDocentes = new JMenuItem("Docentes");
		mntmDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmDocentes(e);
			}
		});
		ImageIcon Docente = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Docente.png"));
	    Image subImg1 = Docente.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
	    ImageIcon subImgAjus1 = new ImageIcon(subImg1);
	    mntmDocentes.setIcon(subImgAjus1);
		mnMantenimiento.add(mntmDocentes);
		
		// Sub menu de Alumnos
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmAlumnos(e);
			}
		});
		ImageIcon Alumno = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Alumno.png"));
	    Image subImg2 = Alumno.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
	    ImageIcon subImgAjus2 = new ImageIcon(subImg2);
	    mntmAlumnos.setIcon(subImgAjus2);
		mnMantenimiento.add(mntmAlumnos);
		
		// Sub menu de Cursos
		mntmCursos = new JMenuItem("Cursos");
		mntmCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmCursos(e);
			}
		});
		ImageIcon Curso = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Cursos.png"));
	    Image subImg3 = Curso.getImage().getScaledInstance(40, 50, Image.SCALE_SMOOTH);
	    ImageIcon subImgAjus3 = new ImageIcon(subImg3);
	    mntmCursos.setIcon(subImgAjus3);
		mnMantenimiento.add(mntmCursos);
		
		// Menu Matriculas
		mnMatriculas = new JMenu("Matrículas");
		ImageIcon Matricula = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Matricula.png"));
		Image imagen2 = Matricula.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		ImageIcon imagenAjustada2 = new ImageIcon(imagen2);
		mnMatriculas.setIcon(imagenAjustada2);
		menuBar.add(mnMatriculas);
		
		mntmMatriculas = new JMenuItem("Matriculas");
		mntmMatriculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmMatriculas(e);
			}
		});
		mnMatriculas.add(mntmMatriculas);
		
		// Menu Retiros
		mnRetiros = new JMenu("Retiros");
		ImageIcon Retiros = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Retiros.png"));
		Image imagen3 = Retiros.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		ImageIcon imagenAjustada3 = new ImageIcon(imagen3);
		mnRetiros.setIcon(imagenAjustada3);
		menuBar.add(mnRetiros);
		
		mntmRetiros = new JMenuItem("Retiros");
		mntmRetiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem(e);
			}
		});
		mnRetiros.add(mntmRetiros);
		
		// Menu Asignacion
		mnAsignacion = new JMenu("Asignación docente");
		ImageIcon Asignacion = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Asignacion.png"));
		Image imagen4 = Asignacion.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		ImageIcon imagenAjustada4 = new ImageIcon(imagen4);
		mnAsignacion.setIcon(imagenAjustada4);
		menuBar.add(mnAsignacion);
		
		mntmAsignarDocente = new JMenuItem("Asignar Docente");
		mntmAsignarDocente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmNewMenuItem_1(e);
			}
		});
		mnAsignacion.add(mntmAsignarDocente);
		
		// Menu Reporte
		mnReportes = new JMenu("Reportes");
		ImageIcon Reporte = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Reporte.png"));
		//ImageIcon Reporte = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Reporte.png"));
		Image imagen5 = Reporte.getImage().getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		ImageIcon imagenAjustada5 = new ImageIcon(imagen5);
		mnReportes.setIcon(imagenAjustada5);
		menuBar.add(mnReportes);
		
		mntmReporte = new JMenuItem("Reportes");
		mntmReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmReporte(e);
			}
		});
		mnReportes.add(mntmReporte);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	protected void actionPerformedMntmDocentes(ActionEvent e) {
		ManteDocentes d;
		d = new ManteDocentes();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmAlumnos(ActionEvent e) {
		ManteAlumnos d;
		d = new ManteAlumnos();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmCursos(ActionEvent e) {
		ManteCursos d;
		d = new ManteCursos();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		GuiRetiros d;
		d = new GuiRetiros();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		GuiAsignacionDocente d;
		d = new GuiAsignacionDocente();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmMatriculas(ActionEvent e) {
		GuiMatriculas d;
		d = new GuiMatriculas();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	protected void actionPerformedMntmReporte(ActionEvent e) {
		GuiReportes d;
		d = new GuiReportes();
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
}
