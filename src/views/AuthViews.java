package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AuthViews {

	private Font belanosima;

	public static class RoundedTextField extends JTextField {
		private int arc;

		public RoundedTextField(int columns, int arc) {
			super(columns);
			this.arc = arc;
			setOpaque(false);
			setBorder(null);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
			g2.dispose();
			super.paintComponent(g);
		}
	}

	// Campo de contraseña redondeado
	public static class RoundedPasswordField extends JPasswordField {
		private int arc;

		public RoundedPasswordField(int columns, int arc) {
			super(columns);
			this.arc = arc;
			setOpaque(false);
			setBorder(null);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
			g2.dispose();
			super.paintComponent(g);
		}
	}

	// Boton redondeado
	public static class RoundedButton extends JButton {
		private int arc;

		public RoundedButton(String text, int arc) {
			super(text);
			this.arc = arc;
			setOpaque(false);
			setBorderPainted(false); // elimina el borde estándar
			setFocusPainted(false); // elimina el borde de enfoque
			setContentAreaFilled(false); // evita que Swing pinte el área por defecto

		}

		public RoundedButton(String text, int arc, Icon icon) {
			super(text, icon);
			setup(arc);
		}

		private void setup(int arc) {
			this.arc = arc;
			setOpaque(false);
			setBorderPainted(false);
			setFocusPainted(false);
			setContentAreaFilled(false);
			setHorizontalTextPosition(SwingConstants.RIGHT);
			setIconTextGap(10);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			super.paintComponent(g);

			g2.dispose();
		}
	}

	public AuthViews() {

	}

	public void inicioSesion() {

		JFrame ventana = new JFrame();

		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

		try {
			Image iconImage = ImageIO.read(getClass().getResource("/images/LOGO NUDE VR.jpg"));

			ventana.setIconImage(iconImage);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			belanosima = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/fonts/Belanosima-Regular.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(belanosima);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel inicio_contenedor = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/fondo login.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		inicio_contenedor.setLayout(null);
		inicio_contenedor.setSize(1200, 800);
		ventana.add(inicio_contenedor);

		// Panel redondeado blanco
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int arc = 40;
				g2d.setColor(Color.decode("#FFFFFF"));
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
				g2d.dispose();
			}
		};
		panel.setOpaque(false);
		panel.setSize(480, 580);
		panel.setLocation((inicio_contenedor.getWidth() - panel.getWidth()) / 2,
				(inicio_contenedor.getHeight() - panel.getHeight()) / 2);
		panel.setLayout(null);
		inicio_contenedor.add(panel);

		// Añadir componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO FINAL VR.png"));
		Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(150, 100);
		iconLabel.setLocation(170, 10);
		panel.add(iconLabel);

		// Etiqueta de correo
		JLabel correo = new JLabel("Correo electrónico");
		correo.setBounds(40, 110, 200, 100);
		correo.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(correo);

		// Cuadro de texto de correo
		RoundedTextField textCorreo = new RoundedTextField(20, 20);
		textCorreo.setSize(400, 50);
		textCorreo.setLocation(40, 185);
		textCorreo.setBackground(Color.decode("#FFB25B"));
		textCorreo.setFont(new Font("belanosima", Font.BOLD, 16));
		textCorreo.setOpaque(false);
		textCorreo.setBorder(null);
		panel.add(textCorreo);

		// Etiqueta de contraseña
		JLabel contra = new JLabel("Contraseña");
		contra.setBounds(40, 230, 200, 100);
		contra.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(contra);

		// Cuadro de contraseña
		RoundedPasswordField textContra = new RoundedPasswordField(20, 20);
		textContra.setSize(400, 50);
		textContra.setLocation(40, 305);
		textContra.setBackground(Color.decode("#FFB25B"));
		textContra.setFont(new Font("belanosima", Font.BOLD, 16));
		textContra.setOpaque(false);
		textContra.setBorder(null);

		// Botón para mostrar/ocultar contraseña
		ImageIcon eyeIcon = new ImageIcon(getClass().getResource("/images/ojo.png"));

		Image img1 = eyeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledEyeIcon = new ImageIcon(img1);

		JButton visible = new JButton(scaledEyeIcon);
		visible.setSize(50, 50);
		visible.setLocation(390, 305);
		visible.setFocusPainted(false);
		visible.setBorderPainted(false);
		visible.setContentAreaFilled(false);

		visible.addActionListener(e -> {
			if (textContra.getEchoChar() == '\u0000') {
				// Si ya está visible, vuelve a ocultar
				textContra.setEchoChar('•');
			} else {
				// Si está oculto, mostrar texto
				textContra.setEchoChar((char) 0);
			}
		});
		panel.add(visible);
		panel.add(textContra);

		// Boton de olvidaste tu contraseña
		JButton btnOlvido = new JButton("¿Olvidaste tu contraseña?");
		btnOlvido.setSize(250, 30);
		btnOlvido.setLocation(210, 370);
		btnOlvido.setOpaque(false);
		btnOlvido.setBackground(Color.white);
		btnOlvido.setBorder(null);
		btnOlvido.setFont(new Font("belanosima", Font.BOLD, 14));
		panel.add(btnOlvido);

		// Boton de iniciar sesion
		RoundedButton btnInicio = new RoundedButton("Iniciar sesión", 20);
		btnInicio.setSize(250, 50);
		btnInicio.setLocation(115, 430);
		btnInicio.setBackground(Color.decode("#B6200D"));
		btnInicio.setFont(new Font("belanosima", Font.BOLD, 20));
		btnInicio.setForeground(Color.white);
		panel.add(btnInicio);

		// Boton de no tienes cuenta
		JButton btnnoCuenta = new JButton("¿No tienes cuenta? Regístrate");
		btnnoCuenta.setSize(250, 30);
		btnnoCuenta.setLocation(115, 500);
		btnnoCuenta.setOpaque(false);
		btnnoCuenta.setBackground(Color.white);
		btnnoCuenta.setForeground(Color.decode("#981406"));
		btnnoCuenta.setBorder(null);
		btnnoCuenta.setFont(new Font("belanosima", Font.BOLD, 16));
		panel.add(btnnoCuenta);

		inicio_contenedor.add(btnnoCuenta);
		btnnoCuenta.addActionListener((e) -> {
			this.registro();
			ventana.dispose();
		});

		// Acción del botón de iniciar sesión
		btnInicio.addActionListener(e -> {
			String correoStr = textCorreo.getText().trim();
			String contraStr = new String(textContra.getPassword()).trim();

			// Validar correo
			boolean correoOk = false;
			if (correoStr.equals("")) {
				textCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			} else {
				textCorreo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				correoOk = true;
			}

			// Validar contraseña
			boolean contraOk = false;
			if (contraStr.equals("")) {
				textContra.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			} else if (contraStr.length() < 8) {
				textContra.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
			} else {
				textContra.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
				contraOk = true;
			}

			// Validacion final
			if (correoOk && contraOk) {
				if (correoStr.equals("admin@maiz.com") && contraStr.equals("12345678")) {
					
					JOptionPane.showMessageDialog(
				            inicio_contenedor, 
				            "¡Bienvenido a La Casa del Maíz!", 
				            "Acceso Concedido", 
				            JOptionPane.INFORMATION_MESSAGE
				        );
					
					HomeViews home = new HomeViews();
					home.panelControl();
					ventana.dispose();
				} else {
					JOptionPane.showMessageDialog(inicio_contenedor, "Credenciales incorrectas", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(inicio_contenedor, "Revisa bien los campos", "Datos incompletos",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		panel.add(btnnoCuenta);
		ventana.setVisible(true);

	}

	public void registro() {

		JFrame ventana = new JFrame();

		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

		// Panel principal con imagen de fondo
		JPanel registro_contenedor = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/fondo login.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
			}
		};
		registro_contenedor.setLayout(null);
		registro_contenedor.setSize(1200, 800);
		ventana.add(registro_contenedor);

		// Panel redondeado blanco
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				int arc = 40;
				g2d.setColor(Color.decode("#FFFFFF"));
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
				g2d.dispose();
			}
		};
		panel.setOpaque(false);
		panel.setSize(650, 580);
		panel.setLocation((registro_contenedor.getWidth() - panel.getWidth()) / 2,
				(registro_contenedor.getHeight() - panel.getHeight()) / 2);
		panel.setLayout(null);
		registro_contenedor.add(panel);

		// Añadir componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO FINAL VR.png"));
		Image img = icon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(150, 100);
		iconLabel.setLocation(245, 10);
		panel.add(iconLabel);

		// Etiqueta de nombre
		JLabel nombre = new JLabel("Nombre(s)");
		nombre.setBounds(40, 110, 200, 100);
		nombre.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(nombre);

		// Cuadro de texto de nombre
		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(250, 50);
		textNombre.setLocation(40, 185);
		textNombre.setBackground(Color.decode("#FFB25B"));
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Etiqueta de apellido
		JLabel apellido = new JLabel("Apellido(s)");
		apellido.setBounds(350, 110, 200, 100);
		apellido.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(apellido);

		// Cuadro de texto de nombre
		RoundedTextField textApellido = new RoundedTextField(20, 20);
		textApellido.setSize(250, 50);
		textApellido.setLocation(350, 185);
		textApellido.setBackground(Color.decode("#FFB25B"));
		textApellido.setFont(new Font("belanosima", Font.BOLD, 20));
		textApellido.setOpaque(false);
		textApellido.setBorder(null);
		panel.add(textApellido);

		// Etiqueta de correo electronico
		JLabel correo = new JLabel("Correo electrónico");
		correo.setBounds(40, 210, 300, 100);
		correo.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(correo);

		// Cuadro de texto de correo electronico
		RoundedTextField textCorreo = new RoundedTextField(20, 20);
		textCorreo.setSize(560, 50);
		textCorreo.setLocation(40, 280);
		textCorreo.setBackground(Color.decode("#FFB25B"));
		textCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
		textCorreo.setOpaque(false);
		textCorreo.setBorder(null);
		panel.add(textCorreo);

		// Etiqueta de contraseña
		JLabel contra = new JLabel("Contraseña");
		contra.setBounds(40, 310, 300, 100);
		contra.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(contra);

		// Cuadro de texto de nombre
		RoundedTextField textContra = new RoundedTextField(20, 20);
		textContra.setSize(250, 50);
		textContra.setLocation(40, 380);
		textContra.setBackground(Color.decode("#FFB25B"));
		textContra.setFont(new Font("belanosima", Font.BOLD, 20));
		textContra.setOpaque(false);
		textContra.setBorder(null);
		panel.add(textContra);

		// Etiqueta de contraseña
		JLabel contra1 = new JLabel("Confirmar contraseña");
		contra1.setBounds(350, 310, 300, 100);
		contra1.setFont(new Font("belanosima", Font.BOLD, 20));
		panel.add(contra1);

		// Cuadro de texto de nombre
		RoundedTextField textContra1 = new RoundedTextField(20, 20);
		textContra1.setSize(250, 50);
		textContra1.setLocation(350, 380);
		textContra1.setBackground(Color.decode("#FFB25B"));
		textContra1.setFont(new Font("belanosima", Font.BOLD, 20));
		textContra1.setOpaque(false);
		textContra1.setBorder(null);
		panel.add(textContra1);

		// Boton de registrarse
		RoundedButton btnRegistro = new RoundedButton("Registrarse", 20);
		btnRegistro.setSize(250, 50);
		btnRegistro.setLocation(190, 460);
		btnRegistro.setBackground(Color.decode("#B6200D"));
		btnRegistro.setFont(new Font("belanosima", Font.BOLD, 20));
		btnRegistro.setForeground(Color.white);
		panel.add(btnRegistro);

		// Boton de ya tienes cuenta
		JButton btnsiCuenta = new JButton("¿Ya tienes cuenta? Inicia sesión");
		btnsiCuenta.setSize(250, 30);
		btnsiCuenta.setLocation(190, 530);
		btnsiCuenta.setOpaque(false);
		btnsiCuenta.setBackground(Color.white);
		btnsiCuenta.setForeground(Color.decode("#981406"));
		btnsiCuenta.setBorder(null);
		btnsiCuenta.setFont(new Font("belanosima", Font.BOLD, 16));

		registro_contenedor.add(btnsiCuenta);
		btnsiCuenta.addActionListener((e) -> {
			this.inicioSesion();
			ventana.dispose();
		});

		btnRegistro.addActionListener(e -> {
			// Obtener los valores de todos los campos
			String nom = textNombre.getText().trim();
			String ape = textApellido.getText().trim();
			String mail = textCorreo.getText().trim();
			String pass = textContra.getText().trim();
			String passConfirm = textContra1.getText().trim();

			// Validar nombre y apellido
			if (nom.isEmpty()) {
				textNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			} else {
				textNombre.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			}

			if (ape.isEmpty()) {
				textApellido.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			} else {
				textApellido.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			}

			// Validar correo
			if (mail.isEmpty()) {
				textCorreo.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			} else {
				textCorreo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			}

			// Validar primera contraseña
			if (pass.isEmpty() || pass.length() < 8) {
				textContra.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			} else {
				textContra.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			}

			// Validadion de contraseña
			if (passConfirm.isEmpty() || !passConfirm.equals(pass)) {
				textContra1.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
			} else {
				textContra1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
			}

			// Verificación final
			if (!nom.isEmpty() && !ape.isEmpty() && !mail.isEmpty() && pass.length() >= 8 && pass.equals(passConfirm)) {

				JOptionPane.showMessageDialog(panel, "Registro exitoso", "La Casa del Maíz",
						JOptionPane.INFORMATION_MESSAGE);

				ventana.dispose();
			} else {
				// Alerta si las contraseñas no coinciden
				if (!pass.equals(passConfirm) && !passConfirm.isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Las contraseñas no coinciden", "Error de Validación",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		panel.add(btnsiCuenta);
		ventana.setVisible(true);
	}

}
