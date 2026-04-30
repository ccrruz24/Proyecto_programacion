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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ClientsViews {

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

	public static class RoundedTextArea extends JTextArea {
		private int arc;

		public RoundedTextArea(int arc) {
			this.arc = arc;
			setOpaque(false);
			setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			setLineWrap(true);
			setWrapStyleWord(true);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g2.setColor(getBackground());
			g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			g2.setColor(new Color(220, 220, 220));
			g2.setStroke(new BasicStroke(1));
			g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

			g2.dispose();

			super.paintComponent(g);
		}
	}

	public ClientsViews() {

	}

	public void clientes() {

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
		JLabel Titulo = new JLabel("Clientes");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("belanosima", Font.BOLD, 38));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar cliente", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 150);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);
		contenido.add(btnAgregar);

		// Tabla

		// Datos
		String[] columnasClientes = { "Nombre", "Email", "Teléfono", "Dirección", "Acciones" };
		Object[][] datosClientes = { { "Grady Rodríguez", "grady4217@gmail.com", "5512345678", "1 dirección", "" },
				{ "Marta Meza", "martahabla67@gmail.com", "5523456789", "1 dirección", "" },
				{ "Salma castillo", "sss.alma@gmail.com", "5534567890", "2 direcciones", "" } };

		// Modelo de tabla
		DefaultTableModel modeloClientes = new DefaultTableModel(datosClientes, columnasClientes) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 4;
			}
		};

		JTable tablaClientes = new JTable(modeloClientes);

		// Estetica
		tablaClientes.setRowHeight(60);
		tablaClientes.setShowGrid(false);
		tablaClientes.setBackground(Color.WHITE);
		tablaClientes.setIntercellSpacing(new Dimension(0, 0));
		tablaClientes.setSelectionBackground(new Color(250, 245, 245));

		// Encabezado
		JTableHeader headerC = tablaClientes.getTableHeader();
		headerC.setPreferredSize(new Dimension(0, 50));
		headerC.setBackground(new Color(245, 240, 230));
		headerC.setForeground(new Color(100, 100, 100));
		headerC.setFont(new Font("belanosima", Font.BOLD, 14));
		headerC.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

		// Centrado de texto
		DefaultTableCellRenderer centroC = new DefaultTableCellRenderer();
		centroC.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i <= 3; i++) {
			tablaClientes.getColumnModel().getColumn(i).setCellRenderer(centroC);
		}

		// Panel para las acciones
		class AccionesClientes extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public AccionesClientes() {
				setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
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
				btn.setPreferredSize(new Dimension(28, 28));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		// Asignar renderer
		tablaClientes.setRowHeight(45);

		// 2. Asignar Renderer (Solo para vista)
		tablaClientes.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				return new AccionesClientes();
			}
		});

		// 3. Asignar Editor (Para la funcionalidad manual)
		tablaClientes.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				AccionesClientes botones = new AccionesClientes();

				// LÓGICA MANUAL VER
				botones.btnVer.addActionListener(e -> {
					stopCellEditing();
					String nombreCompleto = t.getValueAt(r, 0).toString();
					String primerNombre = nombreCompleto.split(" ")[0].trim();

					// Instancia manual de tu clase de vista (ajusta el nombre si es diferente)
					ClientsViews cv = new ClientsViews();

					if (primerNombre.equalsIgnoreCase("Grady")) {
						cv.verClienteGrady();
						if (ventana != null)
							ventana.dispose();
					} else if (primerNombre.equalsIgnoreCase("Marta")) {
						cv.verClienteMarta();
						if (ventana != null)
							ventana.dispose();
					} else if (primerNombre.equalsIgnoreCase("Salma")) {
						cv.verClienteSalma();
						if (ventana != null)
							ventana.dispose();
					}

				});

				// LÓGICA MANUAL EDITAR
				botones.btnEdit.addActionListener(e -> {
					stopCellEditing();
					String primerNombre = t.getValueAt(r, 0).toString().split(" ")[0].trim();

					ClientsViews cv = new ClientsViews();

					if (primerNombre.equalsIgnoreCase("Grady")) {
						cv.editarClienteGrady();
						if (ventana != null)
							ventana.dispose();
					}

					if (primerNombre.equalsIgnoreCase("Marta")) {
						cv.editarClienteMarta();
						if (ventana != null)
							ventana.dispose();
					}

					if (primerNombre.equalsIgnoreCase("Salma")) {
						cv.editarClienteSalma();
						if (ventana != null)
							ventana.dispose();
					}
				});

				// LÓGICA ELIMINAR
				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					((DefaultTableModel) t.getModel()).removeRow(r);
				});

				return botones;
			}

			@Override
			public Object getCellEditorValue() {
				return "";
			}
		});

		// Agregar al panel
		JScrollPane scrollClientes = new JScrollPane(tablaClientes);
		scrollClientes.setBounds(350, 250, 800, 200);
		scrollClientes.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scrollClientes.getViewport().setBackground(Color.WHITE);
		contenido.add(scrollClientes);

		ventana.setVisible(true);

	}

	public void verClienteGrady() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

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
		opciones.setBounds(0, 0, 270, 800);
		ventana.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 900));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ventana.add(scrollPrincipal);

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

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a Clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		btnAgregar.setForeground(Color.black);

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 750);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Grady Rodríguez");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("grady4217@gmail.com");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		JLabel tituloDetalle1 = new JLabel("5512345678");
		tituloDetalle1.setSize(300, 40);
		tituloDetalle1.setLocation(50, 110);
		tituloDetalle1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle1.setForeground(Color.decode("#756B64"));
		tituloDetalle1.setOpaque(false);
		panel.add(tituloDetalle1);

		// boton editar
		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img11 = icon11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon11);
		btnEditar.setSize(160, 50);
		btnEditar.setLocation(680, 50);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		panel.add(btnEditar);

		// Boton de ordenes
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/órdenesN.png"));
		Image img12 = icon12.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon12 = new ImageIcon(img12);
		RoundedButton btnPreparado = new RoundedButton("Órdenes ", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 150);
		btnPreparado.setLocation(50, 200);
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 26));
		btnPreparado.setForeground(Color.decode("#000000"));
		btnPreparado.setBackground(Color.decode("#E8E2DD"));
		btnPreparado.setLayout(null);
		btnPreparado.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnPreparado);

		// Boton direcciones
		ImageIcon icon13 = new ImageIcon(getClass().getResource("/images/direcciones.png"));
		Image img13 = icon13.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon13 = new ImageIcon(img13);
		RoundedButton btnDirecciones = new RoundedButton("Direcciones", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnDirecciones.setSize(250, 150);
		btnDirecciones.setLocation(315, 200);
		btnDirecciones.setFont(new Font("belanosima", Font.BOLD, 26));
		btnDirecciones.setForeground(Color.decode("#000000"));
		btnDirecciones.setBackground(Color.decode("#E8E2DD"));
		btnDirecciones.setLayout(null);
		btnDirecciones.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnDirecciones);

		// Boton Total
		RoundedButton btnTotal = new RoundedButton("Total gastado", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.decode("#D44B28"));
				g2.drawString("$355", 90, 100);

				g2.dispose();
			}
		};
		btnTotal.setSize(250, 150);
		btnTotal.setLocation(580, 200);
		btnTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		btnTotal.setForeground(Color.decode("#000000"));
		btnTotal.setBackground(Color.decode("#E8E2DD"));
		btnTotal.setLayout(null);
		btnTotal.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnTotal);

		// Campo direcciones registradas
		JLabel tituloPlatillos = new JLabel("Direcciones registradas");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 400);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto direccion
		RoundedTextField textDirecc = new RoundedTextField(20, 20);
		textDirecc.setSize(800, 90);
		textDirecc.setLocation(40, 450);
		textDirecc.setText("Av. Insurgentes Sur 123");
		textDirecc.setForeground(Color.black);
		textDirecc.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc.setHorizontalAlignment(JTextField.LEFT);
		textDirecc.setBackground(Color.decode("#E8E2DD"));
		textDirecc.setOpaque(false);
		textDirecc.setBorder(null);
		textDirecc.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc);

		JLabel tituloDatos = new JLabel("CDMX, CP 06600");
		tituloDatos.setSize(300, 40);
		tituloDatos.setLocation(60, 40);
		tituloDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos.setForeground(Color.decode("#756B64"));
		tituloDatos.setOpaque(false);
		textDirecc.add(tituloDatos);

		// imagen de dirrecion
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/direccionesR.png"));
		Image imgEscalada = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imgEscalada);
		JLabel etiquetaImagen = new JLabel(iconoFinal);
		etiquetaImagen.setBounds(10, 20, 50, 50);
		textDirecc.add(etiquetaImagen);

		// Campo historial
		JLabel tituloHistorial = new JLabel("Historial de pedidos");
		tituloHistorial.setSize(300, 40);
		tituloHistorial.setLocation(40, 575);
		tituloHistorial.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloHistorial.setOpaque(false);
		panel.add(tituloHistorial);

		// Texto direccion
		RoundedTextField textDirecc1 = new RoundedTextField(20, 20);
		textDirecc1.setSize(800, 90);
		textDirecc1.setLocation(40, 625);
		textDirecc1.setText("Orden #1");
		textDirecc1.setForeground(Color.black);
		textDirecc1.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc1.setHorizontalAlignment(JTextField.LEFT);
		textDirecc1.setBackground(Color.decode("#E8E2DD"));
		textDirecc1.setOpaque(false);
		textDirecc1.setBorder(null);
		textDirecc1.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc1);

		JLabel tituloDatos1 = new JLabel("5 de abril, 2026");
		tituloDatos1.setSize(300, 40);
		tituloDatos1.setLocation(60, 40);
		tituloDatos1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos1.setForeground(Color.decode("#756B64"));
		tituloDatos1.setOpaque(false);
		textDirecc1.add(tituloDatos1);

		JLabel tituloDatos2 = new JLabel("$355");
		tituloDatos2.setSize(300, 40);
		tituloDatos2.setLocation(700, 12);
		tituloDatos2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos2.setForeground(Color.black);
		tituloDatos2.setOpaque(false);
		textDirecc1.add(tituloDatos2);

		JLabel tituloDatos3 = new JLabel("preparando");
		tituloDatos3.setSize(300, 40);
		tituloDatos3.setLocation(635, 40);
		tituloDatos3.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos3.setForeground(Color.decode("#756B64"));
		tituloDatos3.setOpaque(false);
		textDirecc1.add(tituloDatos3);

		ventana.setVisible(true);
	}

	public void editarClienteGrady() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

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
		opciones.setBounds(0, 0, 270, 800);
		ventana.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 1200));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ventana.add(scrollPrincipal);

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

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		btnAgregar.setForeground(Color.black);

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 950);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textEditarCliente = new JLabel("Editar cliente");
		textEditarCliente.setSize(300, 50);
		textEditarCliente.setLocation(50, 40);
		textEditarCliente.setFont(new Font("belanosima", Font.BOLD, 36));
		textEditarCliente.setOpaque(false);
		panel.add(textEditarCliente);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre completo");
		tituloNombre.setSize(300, 50);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 50);
		textNombre.setLocation(50, 150);
		textNombre.setText("Grady Rodríguez");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		panel.add(textNombre);

		// Campo telefono
		JLabel tituloTelefono = new JLabel("Telefono");
		tituloTelefono.setSize(300, 50);
		tituloTelefono.setLocation(500, 110);
		tituloTelefono.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTelefono.setOpaque(false);
		panel.add(tituloTelefono);

		RoundedTextField textTelefono = new RoundedTextField(20, 20);
		textTelefono.setSize(300, 50);
		textTelefono.setLocation(500, 150);
		textTelefono.setText("5512345678");
		textTelefono.setForeground(Color.gray);
		textTelefono.setFont(new Font("belanosima", Font.BOLD, 20));
		textTelefono.setBackground(Color.decode("#E8E2DD"));
		textTelefono.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		textTelefono.setOpaque(false);
		panel.add(textTelefono);

		// Campo email
		JLabel tituloEmail = new JLabel("Email");
		tituloEmail.setSize(300, 200);
		tituloEmail.setLocation(50, 140);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloEmail.setOpaque(false);
		panel.add(tituloEmail);

		RoundedTextArea textEmail = new RoundedTextArea(20);
		textEmail.setSize(750, 50);
		textEmail.setLocation(50, 260);
		textEmail.setText("grady4217@gmail.com");
		textEmail.setForeground(Color.gray);
		textEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		textEmail.setBackground(Color.decode("#E8E2DD"));
		textEmail.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 0));
		textEmail.setOpaque(false);
		panel.add(textEmail);

		// Campo direccion
		JLabel tituloDirecc = new JLabel("Direcciones");
		tituloDirecc.setSize(300, 40);
		tituloDirecc.setLocation(50, 330);
		tituloDirecc.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDirecc.setOpaque(false);
		panel.add(tituloDirecc);

		// Boton agregar direccion
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar dirección", 20);
		btnAgregaring.setSize(260, 30);
		btnAgregaring.setLocation(550, 330);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 24));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// funcion de panel de dirreciones
		RoundedTextField DireccPanel = new RoundedTextField(20, 20);
		DireccPanel.setSize(750, 400);
		DireccPanel.setLocation(50, 400);
		DireccPanel.setForeground(Color.gray);
		DireccPanel.setFont(new Font("belanosima", Font.BOLD, 26));
		DireccPanel.setHorizontalAlignment(JTextField.CENTER);
		DireccPanel.setBackground(Color.decode("#E8E2DD"));
		DireccPanel.setOpaque(false);
		DireccPanel.setBorder(null);
		panel.add(DireccPanel);

		// Campo direccion 1
		JLabel tituloDirecc1 = new JLabel("Dirección 1");
		tituloDirecc1.setSize(300, 40);
		tituloDirecc1.setLocation(50, 50);
		tituloDirecc1.setFont(new Font("belanosima", Font.BOLD, 28));
		tituloDirecc1.setOpaque(false);
		DireccPanel.add(tituloDirecc1);

		// Campo calle y num
		JLabel tituloCalleyNum = new JLabel("Calle y número ");
		tituloCalleyNum.setSize(300, 40);
		tituloCalleyNum.setLocation(50, 120);
		tituloCalleyNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCalleyNum.setOpaque(false);
		DireccPanel.add(tituloCalleyNum);

		RoundedTextField textCalleyNum = new RoundedTextField(20, 20);
		textCalleyNum.setSize(675, 50);
		textCalleyNum.setLocation(50, 170);
		textCalleyNum.setText("Av. Insurgentes Sur 123");
		textCalleyNum.setForeground(Color.gray);
		textCalleyNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textCalleyNum.setBackground(Color.decode("#D4CEC7"));
		textCalleyNum.setOpaque(false);
		textCalleyNum.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCalleyNum);

		// Campo ciudad
		JLabel tituloCiudad = new JLabel("Ciudad");
		tituloCiudad.setSize(300, 40);
		tituloCiudad.setLocation(50, 250);
		tituloCiudad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCiudad.setOpaque(false);
		DireccPanel.add(tituloCiudad);

		RoundedTextField textCiudad = new RoundedTextField(20, 20);
		textCiudad.setSize(300, 50);
		textCiudad.setLocation(50, 300);
		textCiudad.setText("CDMX");
		textCiudad.setForeground(Color.gray);
		textCiudad.setFont(new Font("belanosima", Font.BOLD, 20));
		textCiudad.setBackground(Color.decode("#D4CEC7"));
		textCiudad.setOpaque(false);
		textCiudad.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCiudad);

		// Campo codigo
		JLabel tituloCodigo = new JLabel("Codigo");
		tituloCodigo.setSize(300, 40);
		tituloCodigo.setLocation(420, 250);
		tituloCodigo.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCodigo.setOpaque(false);
		DireccPanel.add(tituloCodigo);

		RoundedTextField textCodigo = new RoundedTextField(20, 20);
		textCodigo.setSize(300, 50);
		textCodigo.setLocation(420, 300);
		textCodigo.setText("06600");
		textCodigo.setForeground(Color.gray);
		textCodigo.setFont(new Font("belanosima", Font.BOLD, 20));
		textCodigo.setBackground(Color.decode("#D4CEC7"));
		textCodigo.setOpaque(false);
		textCodigo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCodigo);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 850);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 850);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		panel.add(btnCancelar);

		ventana.setVisible(true);

	}

	public void verClienteMarta() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

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
		opciones.setBounds(0, 0, 270, 800);
		ventana.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 900));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ventana.add(scrollPrincipal);

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

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a Clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		btnAgregar.setForeground(Color.black);

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 750);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Marta Meza");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("martahabla67@gmail.com");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		JLabel tituloDetalle1 = new JLabel("5523456789");
		tituloDetalle1.setSize(300, 40);
		tituloDetalle1.setLocation(50, 110);
		tituloDetalle1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle1.setForeground(Color.decode("#756B64"));
		tituloDetalle1.setOpaque(false);
		panel.add(tituloDetalle1);

		// boton editar
		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img11 = icon11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon11);
		btnEditar.setSize(160, 50);
		btnEditar.setLocation(680, 50);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		panel.add(btnEditar);

		// Boton de ordenes
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/órdenesN.png"));
		Image img12 = icon12.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon12 = new ImageIcon(img12);
		RoundedButton btnPreparado = new RoundedButton("Órdenes ", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 150);
		btnPreparado.setLocation(50, 200);
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 26));
		btnPreparado.setForeground(Color.decode("#000000"));
		btnPreparado.setBackground(Color.decode("#E8E2DD"));
		btnPreparado.setLayout(null);
		btnPreparado.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnPreparado);

		// Boton direcciones
		ImageIcon icon13 = new ImageIcon(getClass().getResource("/images/direcciones.png"));
		Image img13 = icon13.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon13 = new ImageIcon(img13);
		RoundedButton btnDirecciones = new RoundedButton("Direcciones", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnDirecciones.setSize(250, 150);
		btnDirecciones.setLocation(315, 200);
		btnDirecciones.setFont(new Font("belanosima", Font.BOLD, 26));
		btnDirecciones.setForeground(Color.decode("#000000"));
		btnDirecciones.setBackground(Color.decode("#E8E2DD"));
		btnDirecciones.setLayout(null);
		btnDirecciones.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnDirecciones);

		// Boton Total
		RoundedButton btnTotal = new RoundedButton("Total gastado", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.decode("#D44B28"));
				g2.drawString("$85", 90, 100);

				g2.dispose();
			}
		};
		btnTotal.setSize(250, 150);
		btnTotal.setLocation(580, 200);
		btnTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		btnTotal.setForeground(Color.decode("#000000"));
		btnTotal.setBackground(Color.decode("#E8E2DD"));
		btnTotal.setLayout(null);
		btnTotal.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnTotal);

		// Campo direcciones registradas
		JLabel tituloPlatillos = new JLabel("Direcciones registradas");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 400);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto direccion
		RoundedTextField textDirecc = new RoundedTextField(20, 20);
		textDirecc.setSize(800, 90);
		textDirecc.setLocation(40, 450);
		textDirecc.setText("Blvd. Ávila Camacho 789");
		textDirecc.setForeground(Color.black);
		textDirecc.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc.setHorizontalAlignment(JTextField.LEFT);
		textDirecc.setBackground(Color.decode("#E8E2DD"));
		textDirecc.setOpaque(false);
		textDirecc.setBorder(null);
		textDirecc.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc);

		JLabel tituloDatos = new JLabel("Naucalpan, CP 55370");
		tituloDatos.setSize(300, 40);
		tituloDatos.setLocation(60, 40);
		tituloDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos.setForeground(Color.decode("#756B64"));
		tituloDatos.setOpaque(false);
		textDirecc.add(tituloDatos);

		// imagen de dirrecion
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/direccionesR.png"));
		Image imgEscalada = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imgEscalada);
		JLabel etiquetaImagen = new JLabel(iconoFinal);
		etiquetaImagen.setBounds(10, 20, 50, 50);
		textDirecc.add(etiquetaImagen);

		// Campo historial
		JLabel tituloHistorial = new JLabel("Historial de pedidos");
		tituloHistorial.setSize(300, 40);
		tituloHistorial.setLocation(40, 575);
		tituloHistorial.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloHistorial.setOpaque(false);
		panel.add(tituloHistorial);

		// Texto direccion
		RoundedTextField textDirecc1 = new RoundedTextField(20, 20);
		textDirecc1.setSize(800, 90);
		textDirecc1.setLocation(40, 625);
		textDirecc1.setText("Orden #2");
		textDirecc1.setForeground(Color.black);
		textDirecc1.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc1.setHorizontalAlignment(JTextField.LEFT);
		textDirecc1.setBackground(Color.decode("#E8E2DD"));
		textDirecc1.setOpaque(false);
		textDirecc1.setBorder(null);
		textDirecc1.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc1);

		JLabel tituloDatos1 = new JLabel("5 de abril, 2026");
		tituloDatos1.setSize(300, 40);
		tituloDatos1.setLocation(60, 40);
		tituloDatos1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos1.setForeground(Color.decode("#756B64"));
		tituloDatos1.setOpaque(false);
		textDirecc1.add(tituloDatos1);

		JLabel tituloDatos2 = new JLabel("$85");
		tituloDatos2.setSize(300, 40);
		tituloDatos2.setLocation(700, 12);
		tituloDatos2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos2.setForeground(Color.black);
		tituloDatos2.setOpaque(false);
		textDirecc1.add(tituloDatos2);

		JLabel tituloDatos3 = new JLabel("Entregado");
		tituloDatos3.setSize(300, 40);
		tituloDatos3.setLocation(635, 40);
		tituloDatos3.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos3.setForeground(Color.decode("#756B64"));
		tituloDatos3.setOpaque(false);
		textDirecc1.add(tituloDatos3);

		ventana.setVisible(true);

	}

	public void editarClienteMarta() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

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
		opciones.setBounds(0, 0, 270, 800);
		ventana.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 1200));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ventana.add(scrollPrincipal);

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

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		btnAgregar.setForeground(Color.black);

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 950);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textEditarCliente = new JLabel("Editar cliente");
		textEditarCliente.setSize(300, 50);
		textEditarCliente.setLocation(50, 40);
		textEditarCliente.setFont(new Font("belanosima", Font.BOLD, 36));
		textEditarCliente.setOpaque(false);
		panel.add(textEditarCliente);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre completo");
		tituloNombre.setSize(300, 50);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 50);
		textNombre.setLocation(50, 150);
		textNombre.setText("Marta Meza");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		panel.add(textNombre);

		// Campo telefono
		JLabel tituloTelefono = new JLabel("Telefono");
		tituloTelefono.setSize(300, 50);
		tituloTelefono.setLocation(500, 110);
		tituloTelefono.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTelefono.setOpaque(false);
		panel.add(tituloTelefono);

		RoundedTextField textTelefono = new RoundedTextField(20, 20);
		textTelefono.setSize(300, 50);
		textTelefono.setLocation(500, 150);
		textTelefono.setText("5523456789");
		textTelefono.setForeground(Color.gray);
		textTelefono.setFont(new Font("belanosima", Font.BOLD, 20));
		textTelefono.setBackground(Color.decode("#E8E2DD"));
		textTelefono.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		textTelefono.setOpaque(false);
		panel.add(textTelefono);

		// Campo email
		JLabel tituloEmail = new JLabel("Email");
		tituloEmail.setSize(300, 200);
		tituloEmail.setLocation(50, 140);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloEmail.setOpaque(false);
		panel.add(tituloEmail);

		RoundedTextArea textEmail = new RoundedTextArea(20);
		textEmail.setSize(750, 50);
		textEmail.setLocation(50, 260);
		textEmail.setText("martahabla67@gmail.com");
		textEmail.setForeground(Color.gray);
		textEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		textEmail.setBackground(Color.decode("#E8E2DD"));
		textEmail.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 0));
		textEmail.setOpaque(false);
		panel.add(textEmail);

		// Campo direccion
		JLabel tituloDirecc = new JLabel("Direcciones");
		tituloDirecc.setSize(300, 40);
		tituloDirecc.setLocation(50, 330);
		tituloDirecc.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDirecc.setOpaque(false);
		panel.add(tituloDirecc);

		// Boton agregar direccion
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar dirección", 20);
		btnAgregaring.setSize(260, 30);
		btnAgregaring.setLocation(550, 330);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 24));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// funcion de panel de dirreciones
		RoundedTextField DireccPanel = new RoundedTextField(20, 20);
		DireccPanel.setSize(750, 400);
		DireccPanel.setLocation(50, 400);
		DireccPanel.setForeground(Color.gray);
		DireccPanel.setFont(new Font("belanosima", Font.BOLD, 26));
		DireccPanel.setHorizontalAlignment(JTextField.CENTER);
		DireccPanel.setBackground(Color.decode("#E8E2DD"));
		DireccPanel.setOpaque(false);
		DireccPanel.setBorder(null);
		panel.add(DireccPanel);

		// Campo direccion 1
		JLabel tituloDirecc1 = new JLabel("Dirección 1");
		tituloDirecc1.setSize(300, 40);
		tituloDirecc1.setLocation(50, 50);
		tituloDirecc1.setFont(new Font("belanosima", Font.BOLD, 28));
		tituloDirecc1.setOpaque(false);
		DireccPanel.add(tituloDirecc1);

		// Campo calle y num
		JLabel tituloCalleyNum = new JLabel("Calle y número ");
		tituloCalleyNum.setSize(300, 40);
		tituloCalleyNum.setLocation(50, 120);
		tituloCalleyNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCalleyNum.setOpaque(false);
		DireccPanel.add(tituloCalleyNum);

		RoundedTextField textCalleyNum = new RoundedTextField(20, 20);
		textCalleyNum.setSize(675, 50);
		textCalleyNum.setLocation(50, 170);
		textCalleyNum.setText("Blvd. Ávila Camacho 789");
		textCalleyNum.setForeground(Color.gray);
		textCalleyNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textCalleyNum.setBackground(Color.decode("#D4CEC7"));
		textCalleyNum.setOpaque(false);
		textCalleyNum.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCalleyNum);

		// Campo ciudad
		JLabel tituloCiudad = new JLabel("Ciudad");
		tituloCiudad.setSize(300, 40);
		tituloCiudad.setLocation(50, 250);
		tituloCiudad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCiudad.setOpaque(false);
		DireccPanel.add(tituloCiudad);

		RoundedTextField textCiudad = new RoundedTextField(20, 20);
		textCiudad.setSize(300, 50);
		textCiudad.setLocation(50, 300);
		textCiudad.setText("Naucalpan");
		textCiudad.setForeground(Color.gray);
		textCiudad.setFont(new Font("belanosima", Font.BOLD, 20));
		textCiudad.setBackground(Color.decode("#D4CEC7"));
		textCiudad.setOpaque(false);
		textCiudad.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCiudad);

		// Campo codigo
		JLabel tituloCodigo = new JLabel("Codigo");
		tituloCodigo.setSize(300, 40);
		tituloCodigo.setLocation(420, 250);
		tituloCodigo.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCodigo.setOpaque(false);
		DireccPanel.add(tituloCodigo);

		RoundedTextField textCodigo = new RoundedTextField(20, 20);
		textCodigo.setSize(300, 50);
		textCodigo.setLocation(420, 300);
		textCodigo.setText("53370");
		textCodigo.setForeground(Color.gray);
		textCodigo.setFont(new Font("belanosima", Font.BOLD, 20));
		textCodigo.setBackground(Color.decode("#D4CEC7"));
		textCodigo.setOpaque(false);
		textCodigo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCodigo);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 850);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 850);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		panel.add(btnCancelar);

		ventana.setVisible(true);

	}

	public void verClienteSalma() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

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
		opciones.setBounds(0, 0, 270, 800);
		ventana.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 1000));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ventana.add(scrollPrincipal);

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

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a Clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		btnAgregar.setForeground(Color.black);

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 900);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Salma Castillo");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("sss.alma@gmail.com");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		JLabel tituloDetalle1 = new JLabel("5534567890");
		tituloDetalle1.setSize(300, 40);
		tituloDetalle1.setLocation(50, 110);
		tituloDetalle1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle1.setForeground(Color.decode("#756B64"));
		tituloDetalle1.setOpaque(false);
		panel.add(tituloDetalle1);

		// boton editar
		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img11 = icon11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon11);
		btnEditar.setSize(160, 50);
		btnEditar.setLocation(680, 50);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		panel.add(btnEditar);

		// Boton de ordenes
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/órdenesN.png"));
		Image img12 = icon12.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon12 = new ImageIcon(img12);
		RoundedButton btnPreparado = new RoundedButton("Órdenes ", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("1", 120, 100);

				g2.dispose();
			}
		};
		btnPreparado.setSize(250, 150);
		btnPreparado.setLocation(50, 200);
		btnPreparado.setFont(new Font("belanosima", Font.BOLD, 26));
		btnPreparado.setForeground(Color.decode("#000000"));
		btnPreparado.setBackground(Color.decode("#E8E2DD"));
		btnPreparado.setLayout(null);
		btnPreparado.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnPreparado);

		// Boton direcciones
		ImageIcon icon13 = new ImageIcon(getClass().getResource("/images/direcciones.png"));
		Image img13 = icon13.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon13 = new ImageIcon(img13);
		RoundedButton btnDirecciones = new RoundedButton("Direcciones", 20, scaledIcon12) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.black);
				g2.drawString("2", 120, 100);

				g2.dispose();
			}
		};
		btnDirecciones.setSize(250, 150);
		btnDirecciones.setLocation(315, 200);
		btnDirecciones.setFont(new Font("belanosima", Font.BOLD, 26));
		btnDirecciones.setForeground(Color.decode("#000000"));
		btnDirecciones.setBackground(Color.decode("#E8E2DD"));
		btnDirecciones.setLayout(null);
		btnDirecciones.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnDirecciones);

		// Boton Total
		RoundedButton btnTotal = new RoundedButton("Total gastado", 20) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2 = (Graphics2D) g.create();
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setColor(Color.decode("#DEDEDE"));
				g2.setStroke(new BasicStroke(2));
				g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

				g2.setFont(new Font("belanosima", Font.BOLD, 20));
				g2.setColor(Color.decode("#756B64"));

				g2.setFont(new Font("belanosima", Font.BOLD, 30));
				g2.setColor(Color.decode("#D44B28"));
				g2.drawString("$240", 90, 100);

				g2.dispose();
			}
		};
		btnTotal.setSize(250, 150);
		btnTotal.setLocation(580, 200);
		btnTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		btnTotal.setForeground(Color.decode("#000000"));
		btnTotal.setBackground(Color.decode("#E8E2DD"));
		btnTotal.setLayout(null);
		btnTotal.setBorder(BorderFactory.createEmptyBorder(-35, -5, 0, 0));
		panel.add(btnTotal);

		// Campo direcciones registradas
		JLabel tituloPlatillos = new JLabel("Direcciones registradas");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 400);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto direccion
		RoundedTextField textDirecc = new RoundedTextField(20, 20);
		textDirecc.setSize(800, 90);
		textDirecc.setLocation(40, 450);
		textDirecc.setText("Periférico Sur 234");
		textDirecc.setForeground(Color.black);
		textDirecc.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc.setHorizontalAlignment(JTextField.LEFT);
		textDirecc.setBackground(Color.decode("#E8E2DD"));
		textDirecc.setOpaque(false);
		textDirecc.setBorder(null);
		textDirecc.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc);

		JLabel tituloDatos = new JLabel("CDMX, CP 14000");
		tituloDatos.setSize(300, 40);
		tituloDatos.setLocation(60, 40);
		tituloDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos.setForeground(Color.decode("#756B64"));
		tituloDatos.setOpaque(false);
		textDirecc.add(tituloDatos);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/direccionesR.png"));
		Image imgEscalada = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imgEscalada);
		JLabel etiquetaImagen = new JLabel(iconoFinal);
		etiquetaImagen.setBounds(10, 20, 50, 50);
		textDirecc.add(etiquetaImagen);

		// Texto direccion
		RoundedTextField textDirecc1 = new RoundedTextField(20, 20);
		textDirecc1.setSize(800, 90);
		textDirecc1.setLocation(40, 575);
		textDirecc1.setText("Calle Reforma 456");
		textDirecc1.setForeground(Color.black);
		textDirecc1.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc1.setHorizontalAlignment(JTextField.LEFT);
		textDirecc1.setBackground(Color.decode("#E8E2DD"));
		textDirecc1.setOpaque(false);
		textDirecc1.setBorder(null);
		textDirecc1.setBorder(BorderFactory.createEmptyBorder(-25, 60, 0, 0));
		panel.add(textDirecc1);

		JLabel tituloDatos1 = new JLabel("CDMX, CP 06000");
		tituloDatos1.setSize(300, 40);
		tituloDatos1.setLocation(60, 40);
		tituloDatos1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos1.setForeground(Color.decode("#756B64"));
		tituloDatos1.setOpaque(false);
		textDirecc1.add(tituloDatos1);

		// imagen de dirrecion
		ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/images/direccionesR.png"));
		Image imgEscalada1 = originalIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal1 = new ImageIcon(imgEscalada1);
		JLabel etiquetaImagen1 = new JLabel(iconoFinal1);
		etiquetaImagen1.setBounds(10, 20, 50, 50);
		textDirecc1.add(etiquetaImagen1);

		// Campo historial
		JLabel tituloHistorial = new JLabel("Historial de pedidos");
		tituloHistorial.setSize(300, 40);
		tituloHistorial.setLocation(40, 700);
		tituloHistorial.setFont(new Font("belanosima", Font.BOLD, 22));
		tituloHistorial.setOpaque(false);
		panel.add(tituloHistorial);

		// Texto direccion
		RoundedTextField textDirecc2 = new RoundedTextField(20, 20);
		textDirecc2.setSize(800, 90);
		textDirecc2.setLocation(40, 750);
		textDirecc2.setText("Orden #3");
		textDirecc2.setForeground(Color.black);
		textDirecc2.setFont(new Font("belanosima", Font.BOLD, 20));
		textDirecc2.setHorizontalAlignment(JTextField.LEFT);
		textDirecc2.setBackground(Color.decode("#E8E2DD"));
		textDirecc2.setOpaque(false);
		textDirecc2.setBorder(null);
		textDirecc2.setBorder(BorderFactory.createEmptyBorder(-25, 30, 0, 0));
		panel.add(textDirecc2);

		JLabel tituloDatos2 = new JLabel("5 de abril, 2026");
		tituloDatos2.setSize(300, 40);
		tituloDatos2.setLocation(30, 40);
		tituloDatos2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos2.setForeground(Color.decode("#756B64"));
		tituloDatos2.setOpaque(false);
		textDirecc2.add(tituloDatos2);

		JLabel tituloDatos3 = new JLabel("$240");
		tituloDatos3.setSize(300, 40);
		tituloDatos3.setLocation(700, 12);
		tituloDatos3.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos3.setForeground(Color.black);
		tituloDatos3.setOpaque(false);
		textDirecc2.add(tituloDatos3);

		JLabel tituloDatos4 = new JLabel("Listo");
		tituloDatos4.setSize(300, 40);
		tituloDatos4.setLocation(700, 40);
		tituloDatos4.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDatos4.setForeground(Color.decode("#756B64"));
		tituloDatos4.setOpaque(false);
		textDirecc2.add(tituloDatos4);

		ventana.setVisible(true);

	}

	public void editarClienteSalma() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

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
		opciones.setBounds(0, 0, 270, 800);
		ventana.add(opciones);

		JPanel contenido = new JPanel();
		contenido.setLayout(null);
		contenido.setBackground(Color.decode("#FEF9F3"));
		contenido.setPreferredSize(new Dimension(930, 1400));

		JScrollPane scrollPrincipal = new JScrollPane(contenido);
		scrollPrincipal.setBounds(270, 0, 930, 800);
		scrollPrincipal.setBorder(null);
		scrollPrincipal.getViewport().setBackground(Color.decode("#FEF9F3"));
		scrollPrincipal.getVerticalScrollBar().setUnitIncrement(20);
		scrollPrincipal.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		ventana.add(scrollPrincipal);

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

		opciones.add(btnCerrar);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		btnAgregar.setForeground(Color.black);

		contenido.add(btnAgregar);

		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g.create();

				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				int arc = 40;

				g2d.setColor(Color.WHITE);
				g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.setColor(Color.decode("#DEDEDE"));
				g2d.setStroke(new BasicStroke(2));

				g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);

				g2d.dispose();
			}
		};

		panel.setOpaque(false);
		panel.setSize(850, 1300);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textEditarCliente = new JLabel("Editar cliente");
		textEditarCliente.setSize(300, 50);
		textEditarCliente.setLocation(50, 40);
		textEditarCliente.setFont(new Font("belanosima", Font.BOLD, 36));
		textEditarCliente.setOpaque(false);
		panel.add(textEditarCliente);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre completo");
		tituloNombre.setSize(300, 50);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 50);
		textNombre.setLocation(50, 150);
		textNombre.setText("Salma Castillo");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		panel.add(textNombre);

		// Campo telefono
		JLabel tituloTelefono = new JLabel("Telefono");
		tituloTelefono.setSize(300, 50);
		tituloTelefono.setLocation(500, 110);
		tituloTelefono.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTelefono.setOpaque(false);
		panel.add(tituloTelefono);

		RoundedTextField textTelefono = new RoundedTextField(20, 20);
		textTelefono.setSize(300, 50);
		textTelefono.setLocation(500, 150);
		textTelefono.setText("5534567890");
		textTelefono.setForeground(Color.gray);
		textTelefono.setFont(new Font("belanosima", Font.BOLD, 20));
		textTelefono.setBackground(Color.decode("#E8E2DD"));
		textTelefono.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		textTelefono.setOpaque(false);
		panel.add(textTelefono);

		// Campo email
		JLabel tituloEmail = new JLabel("Email");
		tituloEmail.setSize(300, 200);
		tituloEmail.setLocation(50, 140);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloEmail.setOpaque(false);
		panel.add(tituloEmail);

		RoundedTextArea textEmail = new RoundedTextArea(20);
		textEmail.setSize(750, 50);
		textEmail.setLocation(50, 260);
		textEmail.setText("sss.alma@gmail.com");
		textEmail.setForeground(Color.gray);
		textEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		textEmail.setBackground(Color.decode("#E8E2DD"));
		textEmail.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 0));
		textEmail.setOpaque(false);
		panel.add(textEmail);

		// Campo direccion
		JLabel tituloDirecc = new JLabel("Direcciones");
		tituloDirecc.setSize(300, 40);
		tituloDirecc.setLocation(50, 330);
		tituloDirecc.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDirecc.setOpaque(false);
		panel.add(tituloDirecc);

		// Boton agregar direccion
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar dirección", 20);
		btnAgregaring.setSize(260, 30);
		btnAgregaring.setLocation(550, 330);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 24));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// funcion de panel de dirreciones
		RoundedTextField DireccPanel = new RoundedTextField(20, 20);
		DireccPanel.setSize(750, 350);
		DireccPanel.setLocation(50, 400);
		DireccPanel.setForeground(Color.gray);
		DireccPanel.setFont(new Font("belanosima", Font.BOLD, 26));
		DireccPanel.setHorizontalAlignment(JTextField.CENTER);
		DireccPanel.setBackground(Color.decode("#E8E2DD"));
		DireccPanel.setOpaque(false);
		DireccPanel.setBorder(null);
		panel.add(DireccPanel);

		// Campo direccion 1
		JLabel tituloDirecc1 = new JLabel("Dirección 1");
		tituloDirecc1.setSize(300, 40);
		tituloDirecc1.setLocation(50, 20);
		tituloDirecc1.setFont(new Font("belanosima", Font.BOLD, 28));
		tituloDirecc1.setOpaque(false);
		DireccPanel.add(tituloDirecc1);

		// Campo calle y num
		JLabel tituloCalleyNum = new JLabel("Calle y número ");
		tituloCalleyNum.setSize(300, 40);
		tituloCalleyNum.setLocation(50, 80);
		tituloCalleyNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCalleyNum.setOpaque(false);
		DireccPanel.add(tituloCalleyNum);

		RoundedTextField textCalleyNum = new RoundedTextField(20, 20);
		textCalleyNum.setSize(675, 50);
		textCalleyNum.setLocation(50, 130);
		textCalleyNum.setText("Blvd. Ávila Camacho 789");
		textCalleyNum.setForeground(Color.gray);
		textCalleyNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textCalleyNum.setBackground(Color.decode("#D4CEC7"));
		textCalleyNum.setOpaque(false);
		textCalleyNum.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCalleyNum);

		// Campo ciudad
		JLabel tituloCiudad = new JLabel("Ciudad");
		tituloCiudad.setSize(300, 40);
		tituloCiudad.setLocation(50, 210);
		tituloCiudad.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCiudad.setOpaque(false);
		DireccPanel.add(tituloCiudad);

		RoundedTextField textCiudad = new RoundedTextField(20, 20);
		textCiudad.setSize(300, 50);
		textCiudad.setLocation(50, 260);
		textCiudad.setText("Naucalpan");
		textCiudad.setForeground(Color.gray);
		textCiudad.setFont(new Font("belanosima", Font.BOLD, 20));
		textCiudad.setBackground(Color.decode("#D4CEC7"));
		textCiudad.setOpaque(false);
		textCiudad.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCiudad);

		// Campo codigo
		JLabel tituloCodigo = new JLabel("Codigo");
		tituloCodigo.setSize(300, 40);
		tituloCodigo.setLocation(420, 210);
		tituloCodigo.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCodigo.setOpaque(false);
		DireccPanel.add(tituloCodigo);

		RoundedTextField textCodigo = new RoundedTextField(20, 20);
		textCodigo.setSize(300, 50);
		textCodigo.setLocation(420, 260);
		textCodigo.setText("53370");
		textCodigo.setForeground(Color.gray);
		textCodigo.setFont(new Font("belanosima", Font.BOLD, 20));
		textCodigo.setBackground(Color.decode("#D4CEC7"));
		textCodigo.setOpaque(false);
		textCodigo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel.add(textCodigo);

		// Campo direccion 2

		RoundedTextField DireccPanel1 = new RoundedTextField(20, 20);
		DireccPanel1.setSize(750, 350);
		DireccPanel1.setLocation(50, 800);
		DireccPanel1.setForeground(Color.gray);
		DireccPanel1.setFont(new Font("belanosima", Font.BOLD, 26));
		DireccPanel1.setHorizontalAlignment(JTextField.CENTER);
		DireccPanel1.setBackground(Color.decode("#E8E2DD"));
		DireccPanel1.setOpaque(false);
		DireccPanel1.setBorder(null);
		panel.add(DireccPanel1);

		JLabel tituloDirecc2 = new JLabel("Dirección 2");
		tituloDirecc2.setSize(300, 40);
		tituloDirecc2.setLocation(50, 20);
		tituloDirecc2.setFont(new Font("belanosima", Font.BOLD, 28));
		tituloDirecc2.setOpaque(false);
		DireccPanel1.add(tituloDirecc2);

		// Campo calle y num
		JLabel tituloCalleyNum1 = new JLabel("Calle y número ");
		tituloCalleyNum1.setSize(300, 40);
		tituloCalleyNum1.setLocation(50, 80);
		tituloCalleyNum1.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCalleyNum1.setOpaque(false);
		DireccPanel1.add(tituloCalleyNum1);

		RoundedTextField textCalleyNum1 = new RoundedTextField(20, 20);
		textCalleyNum1.setSize(675, 50);
		textCalleyNum1.setLocation(50, 130);
		textCalleyNum1.setText("Calle Reforma 456");
		textCalleyNum1.setForeground(Color.gray);
		textCalleyNum1.setFont(new Font("belanosima", Font.BOLD, 20));
		textCalleyNum1.setBackground(Color.decode("#D4CEC7"));
		textCalleyNum1.setOpaque(false);
		textCalleyNum1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel1.add(textCalleyNum1);

		// Campo ciudad
		JLabel tituloCiudad1 = new JLabel("Ciudad");
		tituloCiudad1.setSize(300, 40);
		tituloCiudad1.setLocation(50, 210);
		tituloCiudad1.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCiudad1.setOpaque(false);
		DireccPanel1.add(tituloCiudad1);

		RoundedTextField textCiudad1 = new RoundedTextField(20, 20);
		textCiudad1.setSize(300, 50);
		textCiudad1.setLocation(50, 260);
		textCiudad1.setText("CDMX");
		textCiudad1.setForeground(Color.gray);
		textCiudad1.setFont(new Font("belanosima", Font.BOLD, 20));
		textCiudad1.setBackground(Color.decode("#D4CEC7"));
		textCiudad1.setOpaque(false);
		textCiudad1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel1.add(textCiudad1);

		// Campo codigo
		JLabel tituloCodigo1 = new JLabel("Codigo");
		tituloCodigo1.setSize(300, 40);
		tituloCodigo1.setLocation(420, 210);
		tituloCodigo1.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloCodigo1.setOpaque(false);
		DireccPanel1.add(tituloCodigo1);

		RoundedTextField textCodigo1 = new RoundedTextField(20, 20);
		textCodigo1.setSize(300, 50);
		textCodigo1.setLocation(420, 260);
		textCodigo1.setText("06000");
		textCodigo1.setForeground(Color.gray);
		textCodigo1.setFont(new Font("belanosima", Font.BOLD, 20));
		textCodigo1.setBackground(Color.decode("#D4CEC7"));
		textCodigo1.setOpaque(false);
		textCodigo1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		DireccPanel1.add(textCodigo1);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 1200);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 1200);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			ClientsViews backClient = new ClientsViews();
			backClient.clientes();
			ventana.dispose();
		});

		panel.add(btnCancelar);

		ventana.setVisible(true);

	}

	public void agregarCliente() {
		JFrame ventana = new JFrame();
		ventana.setSize(1200, 839);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setMinimumSize(new Dimension(200, 200));
		ventana.setMaximumSize(new Dimension(1000, 1000));
		ventana.setLocationRelativeTo(null);
		ventana.setLayout(null);
		ventana.setTitle("La casa del maiz");

		ventana.setVisible(true);

	}
}
