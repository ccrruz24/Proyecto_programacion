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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class OrdersView {

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

	public OrdersView() {

	}

	public void ordenes() {

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
		JLabel Titulo = new JLabel("Ordenes");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("belanosima", Font.BOLD, 38));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Nueva orden", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 150);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);
		
		btnAgregar.addActionListener(e -> {
			OrdersView neworden = new OrdersView();
			neworden.nuevaOrden();
			ventana.dispose();
		});
		
		contenido.add(btnAgregar);

		// Datos
		String[] colOrdenes = { "#", "Cliente", "Fecha", "Total", "Estado", "Acciones" };
		Object[][] datosOrdenes = { { "#1", "Grady Rodríguez", "5 de abril, 2026", "$355", "Preparando", "" },
				{ "#2", "Marta Meza", "5 de abril, 2026", "$85", "Entregado", "" },
				{ "#3", "Salma Castillo", "5 de abril, 2026", "$240", "Listo", "" } };

		// Permite edicion columna 5
		DefaultTableModel modeloOrdenes = new DefaultTableModel(datosOrdenes, colOrdenes) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 5;
			}
		};

		JTable tablaOrdenes = new JTable(modeloOrdenes);
		tablaOrdenes.setRowHeight(60);
		tablaOrdenes.setShowGrid(false);
		tablaOrdenes.setBackground(Color.WHITE);

		// Encabrzado
		JTableHeader headerO = tablaOrdenes.getTableHeader();
		headerO.setPreferredSize(new Dimension(0, 45));
		headerO.setBackground(new Color(245, 240, 230));
		headerO.setForeground(new Color(100, 100, 100));
		headerO.setFont(new Font("belanosima", Font.BOLD, 13));

		// Renderer de estado pills
		tablaOrdenes.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel label = new JLabel(v.toString(), SwingConstants.CENTER);
				label.setOpaque(true);
				label.setFont(new Font("belanosima", Font.BOLD, 11));
				label.setBorder(BorderFactory.createEmptyBorder(4, 12, 4, 12));

				if ("Preparando".equals(v)) {
					label.setBackground(Color.decode("#FAEAEA"));
					label.setForeground(Color.decode("#C62828"));
				} else if ("Entregado".equals(v)) {
					label.setBackground(Color.decode("#F5F0E9"));
					label.setForeground(Color.decode("#8D6E53"));
				} else if ("Listo".equals(v)) {
					label.setBackground(Color.decode("#EAEFE4"));
					label.setForeground(Color.decode("#558B2F"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(label);
				return p;
			}
		});

		// Renderer y editor de acciones
		class AccionesOrdenes extends JPanel {
			JButton btnVer, btnEdit, btnDel;

			public AccionesOrdenes(int fila, JTable tabla) { // Recibe fila y tabla
				setLayout(new FlowLayout(FlowLayout.CENTER, 8, 15));
				setBackground(Color.WHITE);
				btnVer = crearBoton("/images/detalles.png");
				btnEdit = crearBoton("/images/editar.png");
				btnDel = crearBoton("/images/borrar.png");

				// BOTÓN VER
				btnVer.addActionListener(e -> {
					if (tabla.isEditing())
						tabla.getCellEditor().stopCellEditing();

					String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "").trim();
					String cliente = tabla.getValueAt(fila, 1).toString().replace(" ", "").trim();

					// Instancias tu vista (ejemplo OrdersView) y llamas al método manual
					OrdersView ov = new OrdersView();

					if (idOrden.equals("1")) {
						ov.verOrdenesGrady();
						if (ventana != null)
							ventana.dispose();
					} else if (cliente.equalsIgnoreCase("Grady")) {
						ov.verOrdenesGrady();
						if (ventana != null)
							ventana.dispose();
					}
					
					if (idOrden.equals("2")) {
						ov.verOrdenesMarta();
						if (ventana != null)
							ventana.dispose();
					} else if (cliente.equalsIgnoreCase("Marta")) {
						ov.verOrdenesMarta();
						if (ventana != null)
							ventana.dispose();
					}
					
					if (idOrden.equals("3")) {
						ov.verOrdenesSalma();
						if (ventana != null)
							ventana.dispose();
					} else if (cliente.equalsIgnoreCase("Salma")) {
						ov.verOrdenesSalma();
						if (ventana != null)
							ventana.dispose();
					}
				});
				

				// BOTÓN EDITAR (Llamada Manual)
				btnEdit.addActionListener(e -> {
					if (tabla.isEditing())
						tabla.getCellEditor().stopCellEditing();

					String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "").trim();
					OrdersView ov = new OrdersView();

					if (idOrden.equals("1")) {
						ov.editarOrdenesGrady();
						if (ventana != null)
							ventana.dispose();
					}
				});
				
				btnEdit.addActionListener(e -> {
					if (tabla.isEditing())
						tabla.getCellEditor().stopCellEditing();

					String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "").trim();
					OrdersView ov = new OrdersView();

					if (idOrden.equals("2")) {
						ov.editarOrdenesMarta();
						if (ventana != null)
							ventana.dispose();
					}
				});
				
				btnEdit.addActionListener(e -> {
					if (tabla.isEditing())
						tabla.getCellEditor().stopCellEditing();

					String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "").trim();
					OrdersView ov = new OrdersView();

					if (idOrden.equals("3")) {
						ov.editarOrdenesSalma();
						if (ventana != null)
							ventana.dispose();
					}
				});

				add(btnVer);
				add(btnEdit);
				add(btnDel);
			}

			private JButton crearBoton(String ruta) {
				JButton btn;
				try {
					ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
					btn = new JButton(new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
				} catch (Exception e) {
					btn = new JButton("?");
				}
				btn.setPreferredSize(new Dimension(25, 25));
				btn.setContentAreaFilled(false);
				btn.setBorderPainted(false);
				btn.setFocusPainted(false);
				btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				return btn;
			}
		}

		// Aplicar renderer
		tablaOrdenes.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				return new AccionesOrdenes(r, t); // Pasamos r y t
			}
		});

		// Aplicar editor
		tablaOrdenes.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				AccionesOrdenes botones = new AccionesOrdenes(r, t); // Creamos panel con la fila actual

				// Configurar eliminar aquí mismo para mayor precisión
				botones.btnDel.addActionListener(e -> {
					stopCellEditing();
					String id = t.getValueAt(r, 0).toString();
					int confirm = JOptionPane.showConfirmDialog(t, "¿Eliminar orden " + id + "?", "Confirmar",
							JOptionPane.YES_NO_OPTION);
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

		// Centrar texto
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i <= 3; i++) {
			tablaOrdenes.getColumnModel().getColumn(i).setCellRenderer(centro);
		}

		// Agregar panel
		JScrollPane scroll = new JScrollPane(tablaOrdenes);
		scroll.setBounds(350, 250, 800, 250);
		scroll.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scroll.getViewport().setBackground(Color.WHITE);
		contenido.add(scroll);

		ventana.setVisible(true);
	}

	public void verOrdenesGrady() {
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView orders = new OrdersView();
			orders.ordenes();
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
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/preparando.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo orden
		JLabel tituloNombre = new JLabel("Orden #1");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("5 de abril, 2026 a las 15:32");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Información del cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(50, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 150);
		textDatos.setLocation(50, 200);
		textDatos.setText("Grady  Rodríguez");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-90, 20, 0, 0)); // Los valores son arriba, izquierda,abajo,
																				// derecha
		panel.add(textDatos);

		JLabel tituloEmail = new JLabel("grady4217@gmail.com");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(20, 50);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloEmail.setForeground(Color.decode("#756B64"));
		tituloEmail.setOpaque(false);
		textDatos.add(tituloEmail);

		JLabel tituloNumero = new JLabel("5512345678");
		tituloNumero.setSize(300, 40);
		tituloNumero.setLocation(20, 95);
		tituloNumero.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNumero.setForeground(Color.decode("#756B64"));
		tituloNumero.setOpaque(false);
		textDatos.add(tituloNumero);

		// Campo resumen
		JLabel tituloResumen = new JLabel("Resumen");
		tituloResumen.setSize(300, 40);
		tituloResumen.setLocation(500, 150);
		tituloResumen.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloResumen.setOpaque(false);
		panel.add(tituloResumen);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(350, 200);
		textDatosResu.setLocation(480, 200);
		textDatosResu.setText("Platillos");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-200, 20, -50, 10)); // Los valores son arriba,
																						// izquierda, abajo, derecha
		panel.add(textDatosResu);

		JLabel tituloNum = new JLabel("2");
		tituloNum.setSize(300, 40);
		tituloNum.setLocation(300, 5);
		tituloNum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum.setForeground(Color.decode("#756B64"));
		tituloNum.setOpaque(false);
		textDatosResu.add(tituloNum);

		JLabel tituloItems = new JLabel("Items totales");
		tituloItems.setSize(300, 40);
		tituloItems.setLocation(20, 50);
		tituloItems.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloItems.setForeground(Color.decode("#756B64"));
		tituloItems.setOpaque(false);
		textDatosResu.add(tituloItems);

		JLabel tituloNum2 = new JLabel("3");
		tituloNum2.setSize(300, 40);
		tituloNum2.setLocation(300, 50);
		tituloNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum2.setForeground(Color.decode("#756B64"));
		tituloNum2.setOpaque(false);
		textDatosResu.add(tituloNum2);

		JPanel linea3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea3.setBounds(20, 100, 300, 1);
		linea3.setOpaque(false);
		textDatosResu.add(linea3);

		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(20, 120);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal.setForeground(Color.decode("#000000"));
		tituloTotal.setOpaque(false);
		textDatosResu.add(tituloTotal);

		JLabel tituloTotalnum = new JLabel("$355");
		tituloTotalnum.setSize(300, 40);
		tituloTotalnum.setLocation(270, 120);
		tituloTotalnum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotalnum.setForeground(Color.decode("#D44B28"));
		tituloTotalnum.setOpaque(false);
		textDatosResu.add(tituloTotalnum);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 450);
		tituloPlatillos.setFont(new Font("Arial", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(700, 90);
		textEnchilada.setLocation(40, 500);
		textEnchilada.setText("Enchiladas rojas");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textEnchilada);

		JLabel tituloCantidad = new JLabel("$105 x 1");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad.setForeground(Color.decode("#756B64"));
		tituloCantidad.setOpaque(false);
		textEnchilada.add(tituloCantidad);

		JLabel tituloTotal1 = new JLabel("$105");
		tituloTotal1.setSize(300, 40);
		tituloTotal1.setLocation(630, 25);
		tituloTotal1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal1.setForeground(Color.decode("#756B64"));
		tituloTotal1.setOpaque(false);
		textEnchilada.add(tituloTotal1);

		// Texto pozole verde
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(700, 90);
		textPozole.setLocation(40, 600);
		textPozole.setText("Pozole verde");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textPozole);

		JLabel tituloCantidad1 = new JLabel("$125 x 2");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad1.setForeground(Color.decode("#756B64"));
		tituloCantidad1.setOpaque(false);
		textPozole.add(tituloCantidad1);

		JLabel tituloTotal2 = new JLabel("$125");
		tituloTotal2.setSize(300, 40);
		tituloTotal2.setLocation(630, 25);
		tituloTotal2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal2.setForeground(Color.decode("#756B64"));
		tituloTotal2.setOpaque(false);
		textPozole.add(tituloTotal2);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(220, 50);
		btnDescargar.setLocation(50, 730);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		ventana.setVisible(true);
	}

	public void editarOrdenesGrady() {
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

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView orders = new OrdersView();
			orders.ordenes();
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
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Grady  Rodríguez");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("Preparando");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(380, 60);
		textEnchilada.setLocation(40, 400);
		textEnchilada.setText("Enchiladas rojas - $105");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textEnchilada);

		RoundedTextField textEnchiladaNum = new RoundedTextField(20, 20);
		textEnchiladaNum.setSize(100, 60);
		textEnchiladaNum.setLocation(450, 400);
		textEnchiladaNum.setText("1");
		textEnchiladaNum.setForeground(Color.black);
		textEnchiladaNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum.setForeground(Color.decode("#756B64"));
		textEnchiladaNum.setOpaque(false);
		textEnchiladaNum.setBorder(null);
		textEnchiladaNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum);

		RoundedTextField textEnchiladaNum2 = new RoundedTextField(20, 20);
		textEnchiladaNum2.setSize(150, 60);
		textEnchiladaNum2.setLocation(580, 400);
		textEnchiladaNum2.setText("$105");
		textEnchiladaNum2.setForeground(Color.black);
		textEnchiladaNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum2.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum2.setForeground(Color.decode("#756B64"));
		textEnchiladaNum2.setOpaque(false);
		textEnchiladaNum2.setBorder(null);
		textEnchiladaNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum2);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(50, 50);
		btnImagen.setLocation(750, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setBorder(null);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Texto pozole
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(380, 60);
		textPozole.setLocation(40, 500);
		textPozole.setText("Pozole verde - $125");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textPozole);

		RoundedTextField textPozoleNum = new RoundedTextField(20, 20);
		textPozoleNum.setSize(100, 60);
		textPozoleNum.setLocation(450, 500);
		textPozoleNum.setText("2");
		textPozoleNum.setForeground(Color.black);
		textPozoleNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum.setForeground(Color.decode("#756B64"));
		textPozoleNum.setOpaque(false);
		textPozoleNum.setBorder(null);
		textPozoleNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum);

		RoundedTextField textPozoleNum2 = new RoundedTextField(20, 20);
		textPozoleNum2.setSize(150, 60);
		textPozoleNum2.setLocation(580, 500);
		textPozoleNum2.setText("$125");
		textPozoleNum2.setForeground(Color.black);
		textPozoleNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum2.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum2.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum2.setForeground(Color.decode("#756B64"));
		textPozoleNum2.setOpaque(false);
		textPozoleNum2.setBorder(null);
		textPozoleNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum2);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		JButton btnImagen2 = new JButton(scaledIcon10);
		btnImagen2.setSize(50, 50);
		btnImagen2.setLocation(750, 500);
		btnImagen2.setBackground(Color.decode("#E8E2DD"));
		btnImagen2.setForeground(Color.white);
		btnImagen2.setIconTextGap(10);
		btnImagen2.setBorder(null);
		btnImagen2.setFocusPainted(false);
		panel.add(btnImagen2);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 600, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 620);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$355");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 620);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 720);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);
		
		btnGuardar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});

		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 720);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);
		
		btnCancelar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});

		panel.add(btnCancelar);

		ventana.setVisible(true);
	}

	public void verOrdenesMarta() {
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView orders = new OrdersView();
			orders.ordenes();
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

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/entregado.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo orden
		JLabel tituloNombre = new JLabel("Orden #2");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("5 de abril, 2026 a las 13:02");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Información del cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(50, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 150);
		textDatos.setLocation(50, 200);
		textDatos.setText("Marta Meza");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-90, 20, 0, 0)); // Los valores son arriba, izquierda,abajo,
																				// derecha
		panel.add(textDatos);

		JLabel tituloEmail = new JLabel("martahabla67@gmail.com");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(20, 50);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloEmail.setForeground(Color.decode("#756B64"));
		tituloEmail.setOpaque(false);
		textDatos.add(tituloEmail);

		JLabel tituloNumero = new JLabel("5523456789");
		tituloNumero.setSize(300, 40);
		tituloNumero.setLocation(20, 95);
		tituloNumero.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNumero.setForeground(Color.decode("#756B64"));
		tituloNumero.setOpaque(false);
		textDatos.add(tituloNumero);

		// Campo resumen
		JLabel tituloResumen = new JLabel("Resumen");
		tituloResumen.setSize(300, 40);
		tituloResumen.setLocation(500, 150);
		tituloResumen.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloResumen.setOpaque(false);
		panel.add(tituloResumen);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(350, 200);
		textDatosResu.setLocation(480, 200);
		textDatosResu.setText("Platillos");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-200, 20, -50, 10)); // Los valores son arriba,
																						// izquierda, abajo, derecha
		panel.add(textDatosResu);

		JLabel tituloNum = new JLabel("1");
		tituloNum.setSize(300, 40);
		tituloNum.setLocation(300, 5);
		tituloNum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum.setForeground(Color.decode("#756B64"));
		tituloNum.setOpaque(false);
		textDatosResu.add(tituloNum);

		JLabel tituloItems = new JLabel("Items totales");
		tituloItems.setSize(300, 40);
		tituloItems.setLocation(20, 50);
		tituloItems.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloItems.setForeground(Color.decode("#756B64"));
		tituloItems.setOpaque(false);
		textDatosResu.add(tituloItems);

		JLabel tituloNum2 = new JLabel("1");
		tituloNum2.setSize(300, 40);
		tituloNum2.setLocation(300, 50);
		tituloNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum2.setForeground(Color.decode("#756B64"));
		tituloNum2.setOpaque(false);
		textDatosResu.add(tituloNum2);

		JPanel linea3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea3.setBounds(20, 100, 300, 1);
		linea3.setOpaque(false);
		textDatosResu.add(linea3);

		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(20, 120);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal.setForeground(Color.decode("#000000"));
		tituloTotal.setOpaque(false);
		textDatosResu.add(tituloTotal);

		JLabel tituloTotalnum = new JLabel("$85");
		tituloTotalnum.setSize(300, 40);
		tituloTotalnum.setLocation(270, 120);
		tituloTotalnum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotalnum.setForeground(Color.decode("#D44B28"));
		tituloTotalnum.setOpaque(false);
		textDatosResu.add(tituloTotalnum);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 450);
		tituloPlatillos.setFont(new Font("Arial", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(700, 90);
		textEnchilada.setLocation(40, 500);
		textEnchilada.setText("Tacos al pastor");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textEnchilada);

		JLabel tituloCantidad = new JLabel("$85 x 1");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad.setForeground(Color.decode("#756B64"));
		tituloCantidad.setOpaque(false);
		textEnchilada.add(tituloCantidad);

		JLabel tituloTotal1 = new JLabel("$85");
		tituloTotal1.setSize(300, 40);
		tituloTotal1.setLocation(630, 25);
		tituloTotal1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal1.setForeground(Color.decode("#756B64"));
		tituloTotal1.setOpaque(false);
		textEnchilada.add(tituloTotal1);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(220, 50);
		btnDescargar.setLocation(50, 650);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		ventana.setVisible(true);
	}

	public void editarOrdenesMarta() {
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

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView orders = new OrdersView();
			orders.ordenes();
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
		panel.setSize(850, 700);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Marta Meza");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("Entregado");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(380, 60);
		textEnchilada.setLocation(40, 400);
		textEnchilada.setText("Tacos al pastor - $85");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textEnchilada);

		RoundedTextField textEnchiladaNum = new RoundedTextField(20, 20);
		textEnchiladaNum.setSize(100, 60);
		textEnchiladaNum.setLocation(450, 400);
		textEnchiladaNum.setText("1");
		textEnchiladaNum.setForeground(Color.black);
		textEnchiladaNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum.setForeground(Color.decode("#756B64"));
		textEnchiladaNum.setOpaque(false);
		textEnchiladaNum.setBorder(null);
		textEnchiladaNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum);

		RoundedTextField textEnchiladaNum2 = new RoundedTextField(20, 20);
		textEnchiladaNum2.setSize(150, 60);
		textEnchiladaNum2.setLocation(580, 400);
		textEnchiladaNum2.setText("$85");
		textEnchiladaNum2.setForeground(Color.black);
		textEnchiladaNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum2.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum2.setForeground(Color.decode("#756B64"));
		textEnchiladaNum2.setOpaque(false);
		textEnchiladaNum2.setBorder(null);
		textEnchiladaNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum2);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(50, 50);
		btnImagen.setLocation(750, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setBorder(null);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 500, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 520);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$85");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 520);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 620);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});
		
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 620);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);
		
		btnCancelar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});

		panel.add(btnCancelar);

		ventana.setVisible(true);
	}

	public void verOrdenesSalma() {
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
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView orders = new OrdersView();
			orders.ordenes();
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
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/listo.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo orden
		JLabel tituloNombre = new JLabel("Orden #3");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo detalles
		JLabel tituloDetalle = new JLabel("5 de abril, 2026 a las 15:24");
		tituloDetalle.setSize(300, 40);
		tituloDetalle.setLocation(50, 80);
		tituloDetalle.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDetalle.setForeground(Color.decode("#756B64"));
		tituloDetalle.setOpaque(false);
		panel.add(tituloDetalle);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Información del cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(50, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 150);
		textDatos.setLocation(50, 200);
		textDatos.setText("Salma Castillo");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-90, 20, 0, 0)); // Los valores son arriba, izquierda,abajo,
																				// derecha
		panel.add(textDatos);

		JLabel tituloEmail = new JLabel("sss.alma@gmail.com");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(20, 50);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloEmail.setForeground(Color.decode("#756B64"));
		tituloEmail.setOpaque(false);
		textDatos.add(tituloEmail);

		JLabel tituloNumero = new JLabel("553456789");
		tituloNumero.setSize(300, 40);
		tituloNumero.setLocation(20, 95);
		tituloNumero.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNumero.setForeground(Color.decode("#756B64"));
		tituloNumero.setOpaque(false);
		textDatos.add(tituloNumero);

		// Campo resumen
		JLabel tituloResumen = new JLabel("Resumen");
		tituloResumen.setSize(300, 40);
		tituloResumen.setLocation(500, 150);
		tituloResumen.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloResumen.setOpaque(false);
		panel.add(tituloResumen);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(350, 200);
		textDatosResu.setLocation(480, 200);
		textDatosResu.setText("Platillos");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-200, 20, -50, 10)); // Los valores son arriba,
																						// izquierda, abajo, derecha
		panel.add(textDatosResu);

		JLabel tituloNum = new JLabel("2");
		tituloNum.setSize(300, 40);
		tituloNum.setLocation(300, 5);
		tituloNum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum.setForeground(Color.decode("#756B64"));
		tituloNum.setOpaque(false);
		textDatosResu.add(tituloNum);

		JLabel tituloItems = new JLabel("Items totales");
		tituloItems.setSize(300, 40);
		tituloItems.setLocation(20, 50);
		tituloItems.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloItems.setForeground(Color.decode("#756B64"));
		tituloItems.setOpaque(false);
		textDatosResu.add(tituloItems);

		JLabel tituloNum2 = new JLabel("2");
		tituloNum2.setSize(300, 40);
		tituloNum2.setLocation(300, 50);
		tituloNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNum2.setForeground(Color.decode("#756B64"));
		tituloNum2.setOpaque(false);
		textDatosResu.add(tituloNum2);

		JPanel linea3 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea3.setBounds(20, 100, 300, 1);
		linea3.setOpaque(false);
		textDatosResu.add(linea3);

		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(20, 120);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal.setForeground(Color.decode("#000000"));
		tituloTotal.setOpaque(false);
		textDatosResu.add(tituloTotal);

		JLabel tituloTotalnum = new JLabel("$240");
		tituloTotalnum.setSize(300, 40);
		tituloTotalnum.setLocation(270, 120);
		tituloTotalnum.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotalnum.setForeground(Color.decode("#D44B28"));
		tituloTotalnum.setOpaque(false);
		textDatosResu.add(tituloTotalnum);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 450);
		tituloPlatillos.setFont(new Font("Arial", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(700, 90);
		textEnchilada.setLocation(40, 500);
		textEnchilada.setText("Sopes");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textEnchilada);

		JLabel tituloCantidad = new JLabel("$115 x 1");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad.setForeground(Color.decode("#756B64"));
		tituloCantidad.setOpaque(false);
		textEnchilada.add(tituloCantidad);

		JLabel tituloTotal1 = new JLabel("$115");
		tituloTotal1.setSize(300, 40);
		tituloTotal1.setLocation(630, 25);
		tituloTotal1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal1.setForeground(Color.decode("#756B64"));
		tituloTotal1.setOpaque(false);
		textEnchilada.add(tituloTotal1);

		// Texto pozole verde
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(700, 90);
		textPozole.setLocation(40, 600);
		textPozole.setText("Pozole verde");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textPozole);

		JLabel tituloCantidad1 = new JLabel("$125 x 1");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCantidad1.setForeground(Color.decode("#756B64"));
		tituloCantidad1.setOpaque(false);
		textPozole.add(tituloCantidad1);

		JLabel tituloTotal2 = new JLabel("$125");
		tituloTotal2.setSize(300, 40);
		tituloTotal2.setLocation(630, 25);
		tituloTotal2.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloTotal2.setForeground(Color.decode("#756B64"));
		tituloTotal2.setOpaque(false);
		textPozole.add(tituloTotal2);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(220, 50);
		btnDescargar.setLocation(50, 730);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		ventana.setVisible(true);
	}

	public void editarOrdenesSalma() {
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

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView orders = new OrdersView();
			orders.ordenes();
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
		panel.setSize(850, 800);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Editar orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("Salma Castillo");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("Listo");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Texto enchiladas
		RoundedTextField textEnchilada = new RoundedTextField(20, 20);
		textEnchilada.setSize(380, 60);
		textEnchilada.setLocation(40, 400);
		textEnchilada.setText("Sopes - $115");
		textEnchilada.setForeground(Color.black);
		textEnchilada.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchilada.setHorizontalAlignment(JTextField.LEFT);
		textEnchilada.setBackground(Color.decode("#E8E2DD"));
		textEnchilada.setForeground(Color.decode("#756B64"));
		textEnchilada.setOpaque(false);
		textEnchilada.setBorder(null);
		textEnchilada.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textEnchilada);

		RoundedTextField textEnchiladaNum = new RoundedTextField(20, 20);
		textEnchiladaNum.setSize(100, 60);
		textEnchiladaNum.setLocation(450, 400);
		textEnchiladaNum.setText("1");
		textEnchiladaNum.setForeground(Color.black);
		textEnchiladaNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum.setForeground(Color.decode("#756B64"));
		textEnchiladaNum.setOpaque(false);
		textEnchiladaNum.setBorder(null);
		textEnchiladaNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum);

		RoundedTextField textEnchiladaNum2 = new RoundedTextField(20, 20);
		textEnchiladaNum2.setSize(150, 60);
		textEnchiladaNum2.setLocation(580, 400);
		textEnchiladaNum2.setText("$115");
		textEnchiladaNum2.setForeground(Color.black);
		textEnchiladaNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.LEFT);
		textEnchiladaNum2.setBackground(Color.decode("#E8E2DD"));
		textEnchiladaNum2.setForeground(Color.decode("#756B64"));
		textEnchiladaNum2.setOpaque(false);
		textEnchiladaNum2.setBorder(null);
		textEnchiladaNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textEnchiladaNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textEnchiladaNum2);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(50, 50);
		btnImagen.setLocation(750, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setBorder(null);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Texto pozole
		RoundedTextField textPozole = new RoundedTextField(20, 20);
		textPozole.setSize(380, 60);
		textPozole.setLocation(40, 500);
		textPozole.setText("Pozole verde - $125");
		textPozole.setForeground(Color.black);
		textPozole.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozole.setHorizontalAlignment(JTextField.LEFT);
		textPozole.setBackground(Color.decode("#E8E2DD"));
		textPozole.setForeground(Color.decode("#756B64"));
		textPozole.setOpaque(false);
		textPozole.setBorder(null);
		textPozole.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textPozole);

		RoundedTextField textPozoleNum = new RoundedTextField(20, 20);
		textPozoleNum.setSize(100, 60);
		textPozoleNum.setLocation(450, 500);
		textPozoleNum.setText("1");
		textPozoleNum.setForeground(Color.black);
		textPozoleNum.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum.setForeground(Color.decode("#756B64"));
		textPozoleNum.setOpaque(false);
		textPozoleNum.setBorder(null);
		textPozoleNum.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum);

		RoundedTextField textPozoleNum2 = new RoundedTextField(20, 20);
		textPozoleNum2.setSize(150, 60);
		textPozoleNum2.setLocation(580, 500);
		textPozoleNum2.setText("$125");
		textPozoleNum2.setForeground(Color.black);
		textPozoleNum2.setFont(new Font("belanosima", Font.BOLD, 20));
		textPozoleNum2.setHorizontalAlignment(JTextField.LEFT);
		textPozoleNum2.setBackground(Color.decode("#E8E2DD"));
		textPozoleNum2.setForeground(Color.decode("#756B64"));
		textPozoleNum2.setOpaque(false);
		textPozoleNum2.setBorder(null);
		textPozoleNum2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textPozoleNum2.setHorizontalAlignment(JTextField.CENTER);
		panel.add(textPozoleNum2);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		JButton btnImagen2 = new JButton(scaledIcon10);
		btnImagen2.setSize(50, 50);
		btnImagen2.setLocation(750, 500);
		btnImagen2.setBackground(Color.decode("#E8E2DD"));
		btnImagen2.setForeground(Color.white);
		btnImagen2.setIconTextGap(10);
		btnImagen2.setBorder(null);
		btnImagen2.setFocusPainted(false);
		panel.add(btnImagen2);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 600, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 620);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$240");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 620);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnGuardar = new RoundedButton("Guardar cambios", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 720);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);
		
		btnGuardar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});

		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 720);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);
		
		btnCancelar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});

		panel.add(btnCancelar);

		ventana.setVisible(true);
	}
	
	public void nuevaOrden() {
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

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a ordenes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		
		btnAgregar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
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
		panel.setSize(850, 600);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Nueva orden");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Cliente");
		tituloInformacion.setSize(300, 40);
		tituloInformacion.setLocation(40, 150);
		tituloInformacion.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloInformacion.setOpaque(false);
		panel.add(tituloInformacion);

		// Texto datos
		RoundedTextField textDatos = new RoundedTextField(20, 20);
		textDatos.setSize(350, 60);
		textDatos.setLocation(40, 200);
		textDatos.setText("");
		textDatos.setForeground(Color.black);
		textDatos.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatos.setHorizontalAlignment(JTextField.LEFT);
		textDatos.setBackground(Color.decode("#E8E2DD"));
		textDatos.setForeground(Color.decode("#756B64"));
		textDatos.setOpaque(false);
		textDatos.setBorder(null);
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // derecha
		panel.add(textDatos);

		// Campo estado
		JLabel tituloEstado = new JLabel("Estado");
		tituloEstado.setSize(300, 40);
		tituloEstado.setLocation(460, 150);
		tituloEstado.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEstado.setOpaque(false);
		panel.add(tituloEstado);

		RoundedTextField textDatosResu = new RoundedTextField(20, 20);
		textDatosResu.setSize(320, 60);
		textDatosResu.setLocation(460, 200);
		textDatosResu.setText("");
		textDatosResu.setForeground(Color.black);
		textDatosResu.setFont(new Font("belanosima", Font.BOLD, 20));
		textDatosResu.setHorizontalAlignment(JTextField.LEFT);
		textDatosResu.setBackground(Color.decode("#E8E2DD"));
		textDatosResu.setForeground(Color.decode("#756B64"));
		textDatosResu.setOpaque(false);
		textDatosResu.setBorder(null);
		textDatosResu.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));
		panel.add(textDatosResu);

		// Campo platillo
		JLabel tituloPlatillos = new JLabel("Platillos");
		tituloPlatillos.setSize(300, 40);
		tituloPlatillos.setLocation(40, 300);
		tituloPlatillos.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPlatillos.setOpaque(false);
		panel.add(tituloPlatillos);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar platillo", 20);
		btnAgregarP.setSize(200, 50);
		btnAgregarP.setLocation(600, 300);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#BFBDBD"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(50, 380, 730, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo total
		JLabel tituloTotal = new JLabel("Total");
		tituloTotal.setSize(300, 40);
		tituloTotal.setLocation(40, 420);
		tituloTotal.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotal.setOpaque(false);
		panel.add(tituloTotal);

		// Campo numero total
		JLabel tituloTotalNum = new JLabel("$0.00");
		tituloTotalNum.setSize(300, 40);
		tituloTotalNum.setLocation(720, 420);
		tituloTotalNum.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloTotalNum.setForeground(Color.decode("#DC542B"));
		tituloTotalNum.setOpaque(false);
		panel.add(tituloTotalNum);

		// Botones guardar y cancelar
		RoundedButton btnCrear = new RoundedButton("Crear orden", 20);
		btnCrear.setSize(200, 50);
		btnCrear.setLocation(50, 500);
		btnCrear.setBackground(Color.decode("#DC542B"));
		btnCrear.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCrear.setForeground(Color.white);
		
		btnCrear.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});
		
		panel.add(btnCrear);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(280, 500);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			OrdersView backOrden = new OrdersView();
			backOrden.ordenes();
			ventana.dispose();
		});
		
		panel.add(btnCancelar);
		
		ventana.setVisible(true);
		
		
	}
}
