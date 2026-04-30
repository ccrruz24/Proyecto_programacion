package views;

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

					String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "");
					String cliente = tabla.getValueAt(fila, 1).toString().replace(" ", "");

					
				});

				// BOTÓN EDITAR
				btnEdit.addActionListener(e -> {
					if (tabla.isEditing())
						tabla.getCellEditor().stopCellEditing();
					String idOrden = tabla.getValueAt(fila, 0).toString().replace("#", "");
					
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
}
