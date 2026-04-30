package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class InventoryView {

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

	public InventoryView() {

	}

	public void inventario() {
		JFrame ventana = new JFrame();

		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

		// Panel con imagen de fondo
		JPanel opciones = new JPanel() {
			private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);

			}

		};

		opciones.setBackground(Color.decode("#FEF9F3"));
		opciones.setLayout(null);
		opciones.setSize(270, 800);
		ventana.add(opciones);

		// Panel principal
		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setSize(1200, 800);
		contenido.setBackground(Color.decode("#FEF9F3"));
		ventana.add(contenido);

		JPanel linea = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea.setBounds(0, 100, 270, 1);
		linea.setOpaque(false);
		opciones.add(linea);

		JPanel linea1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#FFFFFF"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea1.setBounds(0, 620, 270, 1);
		linea1.setOpaque(false);
		opciones.add(linea1);

		// Añadir Componentes

		// Logo
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
		Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(img);
		JLabel iconLabel = new JLabel(scaledIcon);
		iconLabel.setSize(220, 80);
		iconLabel.setLocation(30, 10);
		opciones.add(iconLabel);

		// Boton de panel de control
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/dashboard.png"));
		Image img1 = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(img1);

		JButton btnControl = new JButton("Panel de control", scaledIcon1);
		btnControl.setSize(200, 50);
		btnControl.setLocation(30, 160);
		btnControl.setFont(new Font("belanosima", Font.BOLD, 16));
		btnControl.setOpaque(false);
		btnControl.setBorder(null);
		btnControl.setBackground(Color.decode("#ad3813"));
		btnControl.setForeground(Color.white);
		btnControl.setHorizontalAlignment(SwingConstants.LEFT); // alinea todo el contenido a la izquierda
		btnControl.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del icono
		btnControl.setVerticalTextPosition(SwingConstants.CENTER); // texto centrado verticalmente
		btnControl.setIconTextGap(10);
		btnControl.setFocusPainted(false);

		btnControl.addActionListener(e -> {
		    HomeViews dashboard = new HomeViews();
		    dashboard.panelControl();
		    ventana.dispose(); 
		});

		opciones.add(btnControl);

		// Boton de platillos
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/platillos.png"));
		Image img2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(img2);

		JButton btnPlatillos = new JButton("Platillos", scaledIcon2);
		btnPlatillos.setSize(200, 50);
		btnPlatillos.setLocation(30, 250);
		btnPlatillos.setFont(new Font("belanosima", Font.BOLD, 16));
		btnPlatillos.setOpaque(false);
		btnPlatillos.setBorder(null);
		btnPlatillos.setBackground(Color.decode("#ad3813"));
		btnPlatillos.setForeground(Color.white);
		btnPlatillos.setHorizontalAlignment(SwingConstants.LEFT);
		btnPlatillos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPlatillos.setVerticalTextPosition(SwingConstants.CENTER);
		btnPlatillos.setIconTextGap(10);
		btnPlatillos.setFocusPainted(false);

		btnPlatillos.addActionListener(e -> {
		    DishesView dish = new DishesView();
		    dish.platillos();
		    ventana.dispose(); 
		});
		
		opciones.add(btnPlatillos);

		// Boton de ordenes
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/órdenes.png"));
		Image img3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon3 = new ImageIcon(img3);

		JButton btnOrdenes = new JButton("Órdenes", scaledIcon3);
		btnOrdenes.setSize(200, 50);
		btnOrdenes.setLocation(30, 340);
		btnOrdenes.setFont(new Font("belanosima", Font.BOLD, 16));
		btnOrdenes.setOpaque(false);
		btnOrdenes.setBorder(null);
		btnOrdenes.setBackground(Color.decode("#ad3813"));
		btnOrdenes.setForeground(Color.white);
		btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
		btnOrdenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnOrdenes.setVerticalTextPosition(SwingConstants.CENTER);
		btnOrdenes.setIconTextGap(10);
		btnOrdenes.setFocusPainted(false);

		btnOrdenes.addActionListener(e -> {
		    OrdersView orders = new OrdersView();
		    orders.ordenes();
		    ventana.dispose(); 
		});

		opciones.add(btnOrdenes);

		// Boton de clientes
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/clientes.png"));
		Image img4 = icon4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon4 = new ImageIcon(img4);

		JButton btnClientes = new JButton("Clientes", scaledIcon4);
		btnClientes.setSize(200, 50);
		btnClientes.setLocation(30, 430);
		btnClientes.setFont(new Font("belanosima", Font.BOLD, 16));
		btnClientes.setOpaque(false);
		btnClientes.setBorder(null);
		btnClientes.setBackground(Color.decode("#ad3813"));
		btnClientes.setForeground(Color.white);
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
		btnClientes.setIconTextGap(10);
		btnClientes.setFocusPainted(false);

		btnClientes.addActionListener(e -> {
		    ClientsViews clients = new ClientsViews();
		    clients.clientes();
		    ventana.dispose(); 
		});

		opciones.add(btnClientes);

		// Boton de clientes
		ImageIcon icon5 = new ImageIcon(getClass().getResource("/images/inventario.png"));
		Image img5 = icon5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon5 = new ImageIcon(img5);

		JButton btnInventario = new JButton("Inventario", scaledIcon5);
		btnInventario.setSize(200, 50);
		btnInventario.setLocation(30, 520);
		btnInventario.setFont(new Font("belanosima", Font.BOLD, 16));
		btnInventario.setOpaque(false);
		btnInventario.setBorder(null);
		btnInventario.setBackground(Color.decode("#ad3813"));
		btnInventario.setForeground(Color.white);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInventario.setVerticalTextPosition(SwingConstants.CENTER);
		btnInventario.setIconTextGap(10);
		
		btnInventario.addActionListener(e -> {
		    InventoryView inventory = new InventoryView();
		    inventory.inventario();
		    ventana.dispose(); 
		});
		
		btnInventario.setFocusPainted(false);

		

		opciones.add(btnInventario);

		// Boton de correo electronico
		ImageIcon icon6 = new ImageIcon(getClass().getResource("/images/user.png"));
		Image img6 = icon6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6 = new ImageIcon(img6);

		JButton btnCorreo = new JButton("Correo electrónico", scaledIcon6);
		btnCorreo.setSize(230, 50);
		btnCorreo.setLocation(20, 650);
		btnCorreo.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCorreo.setOpaque(false);
		btnCorreo.setBorder(null);
		btnCorreo.setBackground(Color.decode("#ad3813"));
		btnCorreo.setForeground(Color.white);
		btnCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCorreo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCorreo.setVerticalTextPosition(SwingConstants.CENTER);
		btnCorreo.setIconTextGap(10);
		btnCorreo.setFocusPainted(false);
		opciones.add(btnCorreo);

		// Boton de correo electronico
		ImageIcon icon7 = new ImageIcon(getClass().getResource("/images/logout.png"));
		Image img7 = icon7.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon7 = new ImageIcon(img7);

		JButton btnCerrar = new JButton("Cerrar sesión", scaledIcon7);
		btnCerrar.setSize(230, 50);
		btnCerrar.setLocation(10, 720);
		btnCerrar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCerrar.setOpaque(false);
		btnCerrar.setBorder(null);
		btnCerrar.setBackground(Color.decode("#ad3813"));
		btnCerrar.setForeground(Color.white);
		btnCerrar.setFocusPainted(false);

		btnCerrar.addActionListener(e -> {
		    AuthViews close = new AuthViews();
		    close.inicioSesion();
		    ventana.dispose(); 
		});

		opciones.add(btnCerrar);

		// PANEL PRINCIPAL

		// Etiqueta de titulo
		JLabel Titulo = new JLabel("Inventario");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("belanosima", Font.BOLD, 38));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar ingredientes", 40);
		btnAgregar.setSize(350, 50);
		btnAgregar.setLocation(800, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);

		

		contenido.add(btnAgregar);

		// Subclase para botones redondeados
		class BotonConBorde extends RoundedButton {
			public BotonConBorde(String text, int radius) {
				super(text, radius);
			}

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				//
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#E8E2DD"));
				g2.setStroke(new BasicStroke(2));

				g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 40, 40);

				g2.dispose();
			}
		}

		// Boton 1
		BotonConBorde btnLimon = new BotonConBorde("Limón", 40);
		btnLimon.setBounds(340, 160, 200, 170);
		btnLimon.setFont(new Font("belanosima", Font.BOLD, 22));
		btnLimon.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimon.setVerticalAlignment(SwingConstants.TOP);
		btnLimon.setMargin(new Insets(20, 25, 0, 0));
		btnLimon.setBackground(Color.WHITE);
		btnLimon.setLayout(null);
		contenido.add(btnLimon);

		JLabel textLimon = new JLabel("0 kg");
		textLimon.setBounds(25, 55, 100, 30);
		textLimon.setFont(new Font("belanosima", Font.BOLD, 18));
		textLimon.setForeground(Color.GRAY);
		btnLimon.add(textLimon);

		JLabel textQuedan = new JLabel("Quedan: 0");
		textQuedan.setBounds(25, 110, 80, 20);
		textQuedan.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan.setForeground(Color.DARK_GRAY);
		btnLimon.add(textQuedan);

		JPanel barraNaranja = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja.setOpaque(false);
		barraNaranja.setBounds(25, 140, 150, 8);
		barraNaranja.setLayout(null);
		btnLimon.add(barraNaranja);

		JLabel iconoAlerta = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/agotado.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta.setBounds(145, 22, 30, 30);
		btnLimon.add(iconoAlerta);

		// Boton 2
		BotonConBorde btnPollo = new BotonConBorde("Pollo", 40);
		btnPollo.setBounds(540, 160, 200, 170);
		btnPollo.setFont(new Font("belanosima", Font.BOLD, 22));
		btnPollo.setHorizontalAlignment(SwingConstants.LEFT);
		btnPollo.setVerticalAlignment(SwingConstants.TOP);
		btnPollo.setMargin(new Insets(20, 25, 0, 0));
		btnPollo.setBackground(Color.WHITE);
		btnPollo.setLayout(null);
		contenido.add(btnPollo);

		JLabel textPollo = new JLabel("1.5 kg");
		textPollo.setBounds(25, 55, 100, 30);
		textPollo.setFont(new Font("belanosima", Font.BOLD, 18));
		textPollo.setForeground(Color.GRAY);
		btnPollo.add(textPollo);

		JLabel textQuedan1 = new JLabel("Quedan: 1");
		textQuedan1.setBounds(25, 110, 80, 20);
		textQuedan1.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan1.setForeground(Color.DARK_GRAY);
		btnPollo.add(textQuedan1);

		JLabel textAgotado1 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado1.setBounds(140, 95, 80, 40);
		textAgotado1.setFont(new Font("belanosima", Font.BOLD, 13));
		textAgotado1.setForeground(Color.decode("#F57C00"));
		btnPollo.add(textAgotado1);

		JPanel barraNaranja1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja1.setOpaque(false);
		barraNaranja1.setBounds(25, 140, 150, 8);
		barraNaranja1.setLayout(null);
		btnPollo.add(barraNaranja1);

		JPanel barraProgreso1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#F57C00"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraProgreso1.setOpaque(false);
		barraProgreso1.setBounds(0, 0, 45, 8);
		barraNaranja1.add(barraProgreso1);

		JLabel iconoAlerta1 = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/bajo_stock.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta1.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta1.setBounds(145, 22, 30, 30);
		btnPollo.add(iconoAlerta1);

		// Boton 3
		BotonConBorde btnCebolla = new BotonConBorde("Cebolla", 40);
		btnCebolla.setBounds(740, 160, 200, 170);
		btnCebolla.setFont(new Font("belanosima", Font.BOLD, 22));
		btnCebolla.setHorizontalAlignment(SwingConstants.LEFT);
		btnCebolla.setVerticalAlignment(SwingConstants.TOP);
		btnCebolla.setMargin(new Insets(20, 25, 0, 0));
		btnCebolla.setBackground(Color.WHITE);
		btnCebolla.setLayout(null);
		contenido.add(btnCebolla);

		JLabel textCebolla = new JLabel("0.3 kg");
		textCebolla.setBounds(25, 55, 100, 30);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 18));
		textCebolla.setForeground(Color.GRAY);
		btnCebolla.add(textCebolla);

		JLabel textQuedan2 = new JLabel("Quedan: 3");
		textQuedan2.setBounds(25, 110, 80, 20);
		textQuedan2.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan2.setForeground(Color.DARK_GRAY);
		btnCebolla.add(textQuedan2);

		JLabel textAgotado2 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado2.setBounds(140, 95, 80, 40);
		textAgotado2.setFont(new Font("belanosima", Font.BOLD, 13));
		textAgotado2.setForeground(Color.decode("#F57C00"));
		btnCebolla.add(textAgotado2);

		// barra de progreso
		JPanel barraNaranja2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja2.setOpaque(false);
		barraNaranja2.setBounds(25, 140, 150, 8);
		barraNaranja2.setLayout(null);
		btnCebolla.add(barraNaranja2);

		JPanel barraProgreso2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#F57C00"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraProgreso2.setOpaque(false);
		barraProgreso2.setBounds(0, 0, 15, 8);
		barraNaranja2.add(barraProgreso2);

		JLabel iconoAlerta2 = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/bajo_stock.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta2.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta2.setBounds(145, 22, 30, 30);
		btnCebolla.add(iconoAlerta2);

		// Boton 3
		BotonConBorde btnTomate = new BotonConBorde("Tomate", 40);
		btnTomate.setBounds(940, 160, 200, 170);
		btnTomate.setFont(new Font("belanosima", Font.BOLD, 22));
		btnTomate.setHorizontalAlignment(SwingConstants.LEFT);
		btnTomate.setVerticalAlignment(SwingConstants.TOP);
		btnTomate.setMargin(new Insets(20, 25, 0, 0));
		btnTomate.setBackground(Color.WHITE);
		btnTomate.setLayout(null);
		contenido.add(btnTomate);

		JLabel textTomate = new JLabel("0.3 kg");
		textTomate.setBounds(25, 55, 100, 30);
		textTomate.setFont(new Font("belanosima", Font.BOLD, 18));
		textTomate.setForeground(Color.GRAY);
		btnTomate.add(textTomate);

		JLabel textQuedan3 = new JLabel("Quedan: 3");
		textQuedan3.setBounds(25, 110, 80, 20);
		textQuedan3.setFont(new Font("belanosima", Font.PLAIN, 13));
		textQuedan3.setForeground(Color.DARK_GRAY);
		btnTomate.add(textQuedan3);

		JLabel textAgotado3 = new JLabel("<html>Stock<br>bajo<br></html>");
		textAgotado3.setBounds(140, 95, 80, 40);
		textAgotado3.setFont(new Font("belanosima", Font.BOLD, 13));
		textAgotado3.setForeground(Color.decode("#F57C00"));
		btnTomate.add(textAgotado3);

		// barra de progreso
		JPanel barraNaranja3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Color.decode("#F5F0E6"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraNaranja3.setOpaque(false);
		barraNaranja3.setBounds(25, 140, 150, 8);
		barraNaranja3.setLayout(null);
		btnTomate.add(barraNaranja3);

		JPanel barraProgreso3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#F57C00"));
				g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

				g2.dispose();
			}
		};
		barraProgreso3.setOpaque(false);
		barraProgreso3.setBounds(0, 0, 15, 8);
		barraNaranja3.add(barraProgreso3);

		JLabel iconoAlerta3 = new JLabel();

		try {

			ImageIcon iconRaw = new ImageIcon(getClass().getResource("/images/bajo_stock.png"));

			Image imgEscalada = iconRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			iconoAlerta3.setIcon(new ImageIcon(imgEscalada));

		} catch (Exception e) {

		}

		iconoAlerta3.setBounds(145, 22, 30, 30);
		btnTomate.add(iconoAlerta3);

		// Datos
		String[] columnas = { "Nombre", "Cantidad", "Unidad", "Minimo", "Estado", "Acciones" };
		Object[][] datos = { { "Tortilla de maíz", "450", "Piezas", "500", "Suficiente", "" },
				{ "Limón", "0", "kg", "1", "Agotado", "" }, { "Pollo", "1", "kg", "10", "Stock bajo", "" },
				{ "Cebolla", "3", "kg", "1", "Stock bajo", "" } };

		// Modelo de tabla
		DefaultTableModel modeloPlatillos = new DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 5;
			}
		};

		JTable tabla = new JTable(modeloPlatillos);

		// Estetica
		tabla.setRowHeight(60);
		tabla.setShowGrid(false);
		tabla.setBackground(Color.WHITE);
		tabla.setIntercellSpacing(new Dimension(0, 0));
		tabla.setSelectionBackground(new Color(250, 248, 245));

		// Encabezado
		JTableHeader header = tabla.getTableHeader();
		header.setPreferredSize(new Dimension(0, 50));
		header.setBackground(new Color(245, 240, 230));
		header.setForeground(new Color(100, 100, 100));
		header.setFont(new Font("belanosima", Font.BOLD, 14));
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

		// Renderer
		tabla.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel lbl = new JLabel(v.toString(), SwingConstants.CENTER);
				lbl.setOpaque(true);
				lbl.setFont(new Font("SansSerif", Font.BOLD, 12));
				lbl.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

				if ("Suficiente".equals(v)) {
					lbl.setBackground(Color.decode("#EAEFE4"));
					lbl.setForeground(Color.decode("#558B2F"));
				} else if ("Agotado".equals(v)) {
					lbl.setBackground(Color.decode("#FAEAEA"));
					lbl.setForeground(Color.decode("#C62828"));
				} else if ("Stock bajo".equals(v)) {
					lbl.setBackground(Color.decode("#FEF2E6"));
					lbl.setForeground(Color.decode("#F57C00"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(lbl);
				return p;
			}
		});

		// Clase panel
		class PanelBotones extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public PanelBotones() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
				setBackground(Color.WHITE);

				btnVer = crearBoton("/images/detalles.png");
				btnEdit = crearBoton("/images/editar.png");
				btnDel = crearBoton("/images/borrar.png");

				add(btnVer);
				add(btnEdit);
				add(btnDel);
			}

			private JButton crearBoton(String ruta) {
				JButton btn;
				try {
					ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
					Image img = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
					btn = new JButton(new ImageIcon(img));
				} catch (Exception e) {
					btn = new JButton("?");
				}
				btn.setPreferredSize(new Dimension(30, 30));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		tabla.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				PanelBotones p = new PanelBotones();
				p.setBackground(s ? t.getSelectionBackground() : Color.WHITE); // Mantiene el color si seleccionas la
																				// fila
				return p;
			}
		});

		
		tabla.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			PanelBotones botones = new PanelBotones();

			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				
				String nombreProducto = t.getValueAt(r, 0).toString().split(" ")[0];

				
				for (java.awt.event.ActionListener al : botones.btnVer.getActionListeners())
					botones.btnVer.removeActionListener(al);
				for (java.awt.event.ActionListener al : botones.btnEdit.getActionListeners())
					botones.btnEdit.removeActionListener(al);
				for (java.awt.event.ActionListener al : botones.btnDel.getActionListeners())
					botones.btnDel.removeActionListener(al);

				// Acción VER
				botones.btnVer.addActionListener(e -> {
					stopCellEditing();
					
				});

				// Acción EDITAR
				botones.btnEdit.addActionListener(e -> {
					stopCellEditing();
					
				});

				// Acción BORRAR
				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					int confirm = JOptionPane.showConfirmDialog(t, "¿Eliminar " + t.getValueAt(r, 0) + "?");
					if (confirm == JOptionPane.YES_OPTION) {
						((DefaultTableModel) t.getModel()).removeRow(r);
					}
				});

				return botones;
			}

			@Override
			public Object getCellEditorValue() {
				return "";
			}
		});

		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 3; i++) {
			tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		((DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		// Integracion panel
		JScrollPane scrollPlatillos = new JScrollPane(tabla);
		scrollPlatillos.setBounds(350, 350, 800, 350);
		scrollPlatillos.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scrollPlatillos.getViewport().setBackground(Color.WHITE);
		contenido.add(scrollPlatillos);
		ventana.setVisible(true);

	}
}
