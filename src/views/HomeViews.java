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
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class HomeViews {
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

	public HomeViews() {

	}

	public void panelControl() {

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
		btnInventario.setFocusPainted(false);
		
		btnInventario.addActionListener(e -> {
		    InventoryView inventory = new InventoryView();
		    inventory.inventario();
		    ventana.dispose(); 
		});
		
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
		JLabel Titulo = new JLabel("Panel de control");
		Titulo.setBounds(350, -10, 350, 100);
		Titulo.setFont(new Font("belanosima", Font.BOLD, 38));
		contenido.add(Titulo);

		// Boton de pendiente
		RoundedButton btnPendiente = new RoundedButton("Pendiente", 20);
		btnPendiente.setSize(250, 200);
		btnPendiente.setLocation(340, 160);
		btnPendiente.setBackground(Color.decode("#DC542B"));
		btnPendiente.setFont(new Font("belanosima", Font.BOLD, 20));
		btnPendiente.setForeground(Color.white);
		contenido.add(btnPendiente);

		// Boton de preparandd
		RoundedButton btnPreparado = new RoundedButton("Preparando", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DC542B"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 200);
		btnPreparado.setLocation(620, 160);
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 20));
		btnPreparado.setForeground(Color.decode("#DC542B"));
		btnPreparado.setBackground(Color.WHITE);
		contenido.add(btnPreparado);

		// Boton de entregados
		RoundedButton btnEntregado = new RoundedButton("Entregado", 20);
		btnEntregado.setSize(250, 200);
		btnEntregado.setLocation(900, 160);
		btnEntregado.setBackground(Color.decode("#DC542B"));
		btnEntregado.setFont(new Font("belanosima", Font.BOLD, 20));
		btnEntregado.setForeground(Color.white);
		contenido.add(btnEntregado);

		// Panel que dibuja la gráfica de pastel
		JPanel grafica = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				// Datos de los platillos
				int[] valores = { 40, 25, 15, 10, 10 };
				Color[] colores = { Color.GREEN, Color.RED, Color.YELLOW, Color.BLUE, Color.ORANGE };
				String[] nombres = { "Tacos", "Sopes", "Pozole rojo", "Enchiladas", "Pozole verde" };

				// Calcular total
				int total = 0;
				for (int v : valores)
					total += v;

				// Dibujar pastel
				int startAngle = 0;
				for (int i = 0; i < valores.length; i++) {
					int arcAngle = (int) Math.round(360.0 * valores[i] / total);
					g2.setColor(colores[i]);
					g2.fillArc(50, 50, 200, 200, startAngle, arcAngle);
					startAngle += arcAngle;
				}

				// leyenda a la derecha
				int y = 80;
				int x = 280;
				for (int i = 0; i < nombres.length; i++) {
					g2.setColor(colores[i]);
					g2.fillRect(x, y, 20, 20);
					g2.setColor(Color.BLACK);
					g2.drawString(nombres[i], x + 30, y + 15);
					y += 30;
				}

				// Título
				g2.setFont(new Font("belanosima", Font.BOLD, 18));
				g2.drawString("Platillos más vendidos", 50, 30);
			}
		};
		grafica.setBounds(530, 400, 400, 300);
		contenido.add(grafica);

		ventana.setVisible(true);
	}

	

}
