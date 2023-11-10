package proyecto;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLogin;
	private JLabel lblRectanguloDer;
	private JLabel lblRectanguloIzq;
	private JLabel lblIniciar;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContrasenia;
	private JSeparator spUsuario;
	private JSeparator spContrasenia;
	private JButton btnIngresar;
	private JPasswordField pswContrasenia;

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 222, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Logo principal
		ImageIcon logo = new ImageIcon(GuiPrincipal.class.getResource("/Imagenes/Logo.png"));
		Image imagen = logo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(new ImageIcon(imagen).getImage());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(76, 85, 246));
		panelLogin.setBounds(505, 0, 224, 473);
		contentPane.add(panelLogin);
		
		lblRectanguloDer = new JLabel("");
		lblRectanguloDer.setBounds(378, -295, 451, 410);
		contentPane.add(lblRectanguloDer);
		lblRectanguloDer.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Rectangulo.png")));
		
		lblRectanguloIzq = new JLabel("");
		lblRectanguloIzq.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/Rectangulo.png")));
		lblRectanguloIzq.setBounds(-310, 348, 489, 438);
		contentPane.add(lblRectanguloIzq);
		
		lblIniciar = new JLabel("INICIAR SESIÓN");
		lblIniciar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblIniciar.setBounds(157, 100, 169, 25);
		contentPane.add(lblIniciar);
		
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(198, 136, 71, 25);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsuario.setForeground(SystemColor.windowText);
		txtUsuario.setBackground(new Color(219, 222, 249));
		txtUsuario.setToolTipText("");
		txtUsuario.setBounds(125, 153, 224, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasenia = new JLabel("CONTRASEÑA");
		lblContrasenia.setFont(new Font("Arial", Font.PLAIN, 15));
		lblContrasenia.setBounds(180, 207, 101, 25);
		contentPane.add(lblContrasenia);
		
		spUsuario = new JSeparator();
		spUsuario.setBackground(Color.BLACK);
		spUsuario.setBounds(125, 186, 224, 14);
		contentPane.add(spUsuario);
		
		spContrasenia = new JSeparator();
		spContrasenia.setBackground(Color.BLACK);
		spContrasenia.setBounds(125, 262, 224, 8);
		contentPane.add(spContrasenia);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresar(e);
			}
		});
		btnIngresar.setRequestFocusEnabled(false);
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(new Color(76, 85, 245));
		btnIngresar.setBounds(180, 281, 115, 36);
		contentPane.add(btnIngresar);
		
		pswContrasenia = new JPasswordField();
		pswContrasenia.setBorder(null);
		pswContrasenia.setBackground(new Color(219, 222, 249));
		pswContrasenia.setBounds(125, 229, 224, 30);
		contentPane.add(pswContrasenia);
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String usu = txtUsuario.getText(), 
			   contra = new String(pswContrasenia.getPassword());
		
		if(usu.equals("Anderson") && contra.equals("anderson123")) {
			JOptionPane.showMessageDialog(this, "Bienvenido " + usu);
			GuiPrincipal g = new GuiPrincipal();
			g.setVisible(true);
			this.dispose();
		}
		else if(usu.equals("Gian") && contra.equals("gian123")) {
			JOptionPane.showMessageDialog(this, "Bienvenido " + usu);
			GuiPrincipal g = new GuiPrincipal();
			g.setVisible(true);
			this.dispose();
		}
		else if(usu.equals("Rafael") && contra.equals("rafael123")) {
			JOptionPane.showMessageDialog(this, "Bienvenido " + usu);
			GuiPrincipal g = new GuiPrincipal();
			g.setVisible(true);
			this.dispose();
		}
		else if(usu.equals("Willy") && contra.equals("willy123")) {
			JOptionPane.showMessageDialog(this, "Bienvenido " + usu);
			GuiPrincipal g = new GuiPrincipal();
			g.setVisible(true);
			this.dispose();
		}
		else if(usu.equals("Juan") && contra.equals("juan123")) {
			JOptionPane.showMessageDialog(this, "Bienvenido " + usu);
			GuiPrincipal g = new GuiPrincipal();
			g.setVisible(true);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "Error al ingresar");
		}
			
	}

	
}
