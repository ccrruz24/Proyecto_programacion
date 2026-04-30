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
import java.awt.geom.RoundRectangle2D;

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

public class DishesView {

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

	public static class RoundedImageButton extends JButton {
		private int arc;

		public RoundedImageButton(ImageIcon icon, int arc) {
			super(icon);
			this.arc = arc;
			setContentAreaFilled(false);
			setBorderPainted(false);
			setFocusPainted(false);
			setOpaque(false);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			java.awt.geom.RoundRectangle2D.Float forma = new RoundRectangle2D.Float(0, 0, getWidth() - 1,
					getHeight() - 1, arc, arc);

			g2.setClip(forma);

			g2.setColor(getBackground());
			g2.fill(forma);

			super.paintComponent(g2);

			g2.dispose();
		}

	}

	public DishesView() {

	}

	public void platillos() {

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
		JLabel Titulo = new JLabel("Platillos");
		Titulo.setBounds(350, -10, 250, 100);
		Titulo.setFont(new Font("belanosima", Font.BOLD, 38));
		contenido.add(Titulo);

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("+ Agregar platillo", 40);
		btnAgregar.setSize(250, 50);
		btnAgregar.setLocation(900, 70);
		btnAgregar.setBackground(Color.decode("#DC542B"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26));
		btnAgregar.setForeground(Color.white);

		btnAgregar.addActionListener(e -> {
			DishesView addDishes = new DishesView();
			addDishes.agregarPlatillo();
			ventana.dispose();
		});

		contenido.add(btnAgregar);

		// Datos
		String[] columnas = { "Foto", "Nombre", "Categoría", "Precio", "Estado", "Acciones" };
		Object[][] datos = { { "/images/pozole.jpg", "Pozole verde", "Pozoles", "$125", "Disponible", "" },
				{ "/images/tacos pastor.jpg", "Tacos al pastor", "Tacos", "$85", "Disponible", "" },
				{ "/images/enchiladas.jpg", "Enchiladas rojas", "Enchiladas", "$105", "No disponible", "" },
				{ "/images/sopes.jpg", "Sopes", "Sopes", "$115", "Disponible", "" } };

		// Modelo de tabla
		DefaultTableModel modeloPlatillos = new DefaultTableModel(datos, columnas) {
			@Override
			public boolean isCellEditable(int r, int c) {
				return c == 5;
			}
		};

		JTable tabla = new JTable(modeloPlatillos);

		// Estetica
		tabla.setRowHeight(110);
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
		tabla.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				try {
					java.net.URL imgURL = getClass().getResource(v.toString());
					if (imgURL != null) {
						ImageIcon icon = new ImageIcon(imgURL);
						Image img = icon.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
						return new JLabel(new ImageIcon(img), JLabel.CENTER);
					}
				} catch (Exception e) {
				}
				return new JLabel("No image", JLabel.CENTER);
			}
		});

		// Renderer
		tabla.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
				JLabel lbl = new JLabel(v.toString(), SwingConstants.CENTER);
				lbl.setOpaque(true);
				lbl.setFont(new Font("belanosima", Font.BOLD, 12));
				lbl.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

				if ("Disponible".equals(v)) {
					lbl.setBackground(Color.decode("#EAEFE4"));
					lbl.setForeground(Color.decode("#558B2F"));
				} else if ("No disponible".equals(v)) {
					lbl.setBackground(Color.decode("#FAEAEA"));
					lbl.setForeground(Color.decode("#C62828"));
				}

				JPanel p = new JPanel(new GridBagLayout());
				p.setBackground(Color.WHITE);
				p.add(lbl);
				return p;
			}
		});

		class PanelBotones extends JPanel {
		    JButton btnVer, btnEdit, btnDel;

		    public PanelBotones(int fila, JTable tabla) {
		    	setLayout(new FlowLayout(FlowLayout.CENTER, 10, 40));
		        setBackground(Color.WHITE);

		        btnVer = crearBoton("/images/detalles.png");
		        btnEdit = crearBoton("/images/editar.png");
		        btnDel = crearBoton("/images/borrar.png");

		        // Acción VER Manual
		        btnVer.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();
		            		          
		            String nombreRaw = tabla.getValueAt(fila, 1).toString(); 
		            String nombreLimpio = nombreRaw.replace(" ", "").trim();
		            
		            DishesView dv = new DishesView();
		            
		            if (nombreLimpio.equalsIgnoreCase("Tacosalpastor")) {
		                dv.verPlatilloTacos();	      
		                if(ventana != null) ventana.dispose(); 
		            } else if (nombreLimpio.equalsIgnoreCase("Enchiladasrojas")) {
		                dv.verPlatilloEnchilada();
		                if(ventana != null) ventana.dispose();
		            }
		        });

		        // ACCIÓN EDITAR: Llamada manual
		        btnEdit.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();
		            
		            String nombreRaw = tabla.getValueAt(fila, 1).toString();
		            String nombreLimpio = nombreRaw.replace(" ", "").trim();
		            
		            DishesView dv = new DishesView();
		            
		            if (nombreLimpio.equalsIgnoreCase("Tacosalpastor")) {
		                dv.editarPlatilloTacos();
		                if(ventana != null) ventana.dispose();
		            } else if (nombreLimpio.equalsIgnoreCase("Enchiladasrojas")) {
		                dv.editarPlatilloEnchilada();
		                if(ventana != null) ventana.dispose();
		            }
		        });

		        // ACCIÓN ELIMINAR
		        btnDel.addActionListener(e -> {
		            if (tabla.isEditing()) tabla.getCellEditor().stopCellEditing();
		            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		            model.removeRow(fila);
		        });

		        add(btnVer);
		        add(btnEdit);
		        add(btnDel);
		    }

		    private JButton crearBoton(String ruta) {
		        JButton btn;
		        try {
		            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
		            Image img = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
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
				return new PanelBotones(r, t);
			}
		});

		tabla.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
			@Override
			public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
				return new PanelBotones(r, t);
			}
		});

		// Alineacion final
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 1; i < 4; i++)
			tabla.getColumnModel().getColumn(i).setCellRenderer(centro);

		// Integracion panel
		JScrollPane scrollPlatillos = new JScrollPane(tabla);
		scrollPlatillos.setBounds(350, 150, 800, 500);
		scrollPlatillos.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		scrollPlatillos.getViewport().setBackground(Color.WHITE);

		contenido.add(scrollPlatillos);
		ventana.setVisible(true);
	}

	public void agregarPlatillo() {

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

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(250, 40);
		btnAgregar.setLocation(330, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));

		btnAgregar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
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
		panel.setLocation(305, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textNuevoplatillo = new JLabel("Nuevo platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("belanosima", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloImagen.setOpaque(false);
		panel.add(tituloImagen);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/upload.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(80, 80);
		btnImagen.setLocation(500, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 550);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 550);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Boton guardar cambio
		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 630);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

		panel.add(btnGuardar);

		// Boton guardar cambio
		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 630);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);
		panel.add(btnCancelar);

		btnCancelar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

		ventana.setVisible(true);

	}

	public void verPlatilloTacos() {
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

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

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
		panel.setSize(850, 1100);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo imagen
		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/tacos pastor.jpg"));
		Image img9 = icon9.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);
		RoundedImageButton btnImagen = new RoundedImageButton(scaledIcon9, 40);

		btnImagen.setSize(350, 350);
		btnImagen.setLocation(50, 50);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		panel.add(btnImagen);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/disponible.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Tacos al pastor");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(415, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo nombre tacos
		JLabel tituloNombre1 = new JLabel("Tacos");
		tituloNombre1.setSize(300, 40);
		tituloNombre1.setLocation(420, 95);
		tituloNombre1.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloNombre1.setOpaque(false);
		panel.add(tituloNombre1);

		// Campo nombre precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(420, 150);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		// Campo nombre precio
		JLabel tituloPrecio1 = new JLabel("$85");
		tituloPrecio1.setSize(300, 40);
		tituloPrecio1.setLocation(420, 190);
		tituloPrecio1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio1.setForeground(Color.decode("#DC542B"));
		tituloPrecio1.setOpaque(false);
		panel.add(tituloPrecio1);

		// Campo nombre precio
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 40);
		tituloDescripcion.setLocation(420, 250);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		// Campo nombre precio
		JLabel tituloDescripcion1 = new JLabel(
				"<html> Tres tacos con carne al pastor,<br> cilantro, cebolla y piña.</html>");
		tituloDescripcion1.setSize(300, 40);
		tituloDescripcion1.setLocation(420, 300);
		tituloDescripcion1.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloDescripcion1.setOpaque(false);
		panel.add(tituloDescripcion1);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon10);
		btnEditar.setSize(170, 50);
		btnEditar.setLocation(380, 420);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);

		btnEditar.addActionListener(e -> {
			DishesView editDishes = new DishesView();
			editDishes.editarPlatilloTacos();
			ventana.dispose();
		});

		panel.add(btnEditar);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(250, 50);
		btnDescargar.setLocation(570, 420);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#DEDEDE"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(0, 500, 1000, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Texto ingrediente tortilla
		RoundedTextField textTortilla = new RoundedTextField(20, 20);
		textTortilla.setSize(700, 90);
		textTortilla.setLocation(50, 625);
		textTortilla.setText("Tortillaz de maíz");
		textTortilla.setForeground(Color.black);
		textTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textTortilla.setHorizontalAlignment(JTextField.LEFT);
		textTortilla.setBackground(Color.decode("#E8E2DD"));
		textTortilla.setOpaque(false);
		textTortilla.setBorder(null);
		textTortilla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textTortilla);

		JLabel tituloCantidad = new JLabel("3 piezas requeridas");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad.setForeground(Color.gray);
		tituloCantidad.setOpaque(false);
		textTortilla.add(tituloCantidad);

		// Texto ingrediente carne
		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(700, 90);
		textCarne.setLocation(50, 750);
		textCarne.setText("Carne de res");
		textCarne.setForeground(Color.black);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.LEFT);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		textCarne.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCarne);

		JLabel tituloCantidad1 = new JLabel("0.2 Kg requeridos");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad1.setForeground(Color.gray);
		tituloCantidad1.setOpaque(false);
		textCarne.add(tituloCantidad1);

		// Texto ingrediente cebolla
		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(700, 90);
		textCebolla.setLocation(50, 875);
		textCebolla.setText("Cebolla");
		textCebolla.setForeground(Color.black);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.LEFT);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		textCebolla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCebolla);

		JLabel tituloCantidad2 = new JLabel("0.05 Kg requerido");
		tituloCantidad2.setSize(300, 40);
		tituloCantidad2.setLocation(15, 40);
		tituloCantidad2.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad2.setForeground(Color.gray);
		tituloCantidad2.setOpaque(false);
		textCebolla.add(tituloCantidad2);

		// Texto ingrediente cebolla
		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(700, 90);
		textCilantro.setLocation(50, 1000);
		textCilantro.setText("Cilantro");
		textCilantro.setForeground(Color.black);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.LEFT);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		textCilantro.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCilantro);

		JLabel tituloCantidad3 = new JLabel("0.25 kg requerido");
		tituloCantidad3.setSize(300, 40);
		tituloCantidad3.setLocation(15, 40);
		tituloCantidad3.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad3.setForeground(Color.gray);
		tituloCantidad3.setOpaque(false);
		textCilantro.add(tituloCantidad3);
		ventana.setVisible(true);

	}

	public void editarPlatilloTacos() {
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

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

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
		panel.setSize(850, 1100);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textNuevoplatillo = new JLabel("Editar platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("belanosima", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		textNombre.setText("Tacos al pastor");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setHorizontalAlignment(JTextField.CENTER);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setText("Tacos");
		textCategoria.setForeground(Color.gray);
		textCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		textCategoria.setHorizontalAlignment(JTextField.CENTER);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setText("Tres tacos con carne de pastor, cilantro, cebolla y piña");
		textDescripcion.setForeground(Color.gray);
		textDescripcion.setFont(new Font("belanosima", Font.BOLD, 18));
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setText("$85");
		textPrecio.setForeground(Color.gray);
		textPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		textPrecio.setHorizontalAlignment(JTextField.CENTER);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloImagen.setOpaque(false);
		panel.add(tituloImagen);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/upload.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(80, 80);
		btnImagen.setLocation(500, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 530);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Texto ingrediente tortilla
		RoundedTextField textIngTortilla = new RoundedTextField(20, 20);
		textIngTortilla.setSize(400, 60);
		textIngTortilla.setLocation(50, 625);
		textIngTortilla.setText("Tortilla de maíz (piezas)");
		textIngTortilla.setForeground(Color.gray);
		textIngTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngTortilla.setHorizontalAlignment(JTextField.CENTER);
		textIngTortilla.setBackground(Color.decode("#E8E2DD"));
		textIngTortilla.setOpaque(false);
		textIngTortilla.setBorder(null);
		panel.add(textIngTortilla);

		RoundedTextField textNumTortilla = new RoundedTextField(20, 20);
		textNumTortilla.setSize(100, 60);
		textNumTortilla.setLocation(500, 625);
		textNumTortilla.setText("3");
		textNumTortilla.setForeground(Color.gray);
		textNumTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textNumTortilla.setHorizontalAlignment(JTextField.CENTER);
		textNumTortilla.setBackground(Color.decode("#E8E2DD"));
		textNumTortilla.setOpaque(false);
		textNumTortilla.setBorder(null);
		panel.add(textNumTortilla);

		ImageIcon iconX = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX = iconX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX = new ImageIcon(imgX);

		JButton btnImagenX = new JButton(scaledIconX);
		btnImagenX.setSize(50, 50);
		btnImagenX.setLocation(625, 625);
		btnImagenX.setBackground(Color.decode("#E8E2DD"));
		btnImagenX.setForeground(Color.white);
		btnImagenX.setIconTextGap(10);
		btnImagenX.setBorder(null);
		btnImagenX.setFocusPainted(false);
		panel.add(btnImagenX);

		// Texto carne de res
		RoundedTextField textCarneRes = new RoundedTextField(20, 20);
		textCarneRes.setSize(400, 60);
		textCarneRes.setLocation(50, 725);
		textCarneRes.setText("Carne de Res (Kg)");
		textCarneRes.setForeground(Color.gray);
		textCarneRes.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarneRes.setHorizontalAlignment(JTextField.CENTER);
		textCarneRes.setBackground(Color.decode("#E8E2DD"));
		textCarneRes.setOpaque(false);
		textCarneRes.setBorder(null);
		panel.add(textCarneRes);

		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(100, 60);
		textCarne.setLocation(500, 725);
		textCarne.setText("0.2");
		textCarne.setForeground(Color.gray);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.CENTER);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		panel.add(textCarne);

		ImageIcon iconX1 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX1 = iconX1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX1 = new ImageIcon(imgX1);

		JButton btnImagenX1 = new JButton(scaledIconX1);
		btnImagenX1.setSize(50, 50);
		btnImagenX1.setLocation(625, 725);
		btnImagenX1.setBackground(Color.decode("#E8E2DD"));
		btnImagenX1.setForeground(Color.white);
		btnImagenX1.setIconTextGap(10);
		btnImagenX1.setBorder(null);
		btnImagenX1.setFocusPainted(false);
		panel.add(btnImagenX1);

		// Texto cebolla
		RoundedTextField textIngCebolla = new RoundedTextField(20, 20);
		textIngCebolla.setSize(400, 60);
		textIngCebolla.setLocation(50, 825);
		textIngCebolla.setText("Cebolla (Kg)");
		textIngCebolla.setForeground(Color.gray);
		textIngCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCebolla.setHorizontalAlignment(JTextField.CENTER);
		textIngCebolla.setBackground(Color.decode("#E8E2DD"));
		textIngCebolla.setOpaque(false);
		textIngCebolla.setBorder(null);
		panel.add(textIngCebolla);

		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(100, 60);
		textCebolla.setLocation(500, 825);
		textCebolla.setText("0.05");
		textCebolla.setForeground(Color.gray);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.CENTER);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		panel.add(textCebolla);

		ImageIcon iconX2 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX2 = iconX2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX2 = new ImageIcon(imgX2);

		JButton btnImagenX2 = new JButton(scaledIconX2);
		btnImagenX2.setSize(50, 50);
		btnImagenX2.setLocation(625, 825);
		btnImagenX2.setBackground(Color.decode("#E8E2DD"));
		btnImagenX2.setForeground(Color.white);
		btnImagenX2.setIconTextGap(10);
		btnImagenX2.setBorder(null);
		btnImagenX2.setFocusPainted(false);
		panel.add(btnImagenX2);

		// Texto cilantro
		RoundedTextField textIngCilantro = new RoundedTextField(20, 20);
		textIngCilantro.setSize(400, 60);
		textIngCilantro.setLocation(50, 925);
		textIngCilantro.setText("Cilantro (manojo)");
		textIngCilantro.setForeground(Color.gray);
		textIngCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCilantro.setHorizontalAlignment(JTextField.CENTER);
		textIngCilantro.setBackground(Color.decode("#E8E2DD"));
		textIngCilantro.setOpaque(false);
		textIngCilantro.setBorder(null);
		panel.add(textIngCilantro);

		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(100, 60);
		textCilantro.setLocation(500, 925);
		textCilantro.setText("0.02");
		textCilantro.setForeground(Color.gray);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.CENTER);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		panel.add(textCilantro);

		ImageIcon iconX3 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX3 = iconX3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX3 = new ImageIcon(imgX3);

		JButton btnImagenX3 = new JButton(scaledIconX3);
		btnImagenX3.setSize(50, 50);
		btnImagenX3.setLocation(625, 925);
		btnImagenX3.setBackground(Color.decode("#E8E2DD"));
		btnImagenX3.setForeground(Color.white);
		btnImagenX3.setIconTextGap(10);
		btnImagenX3.setBorder(null);
		btnImagenX3.setFocusPainted(false);
		panel.add(btnImagenX3);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 1025);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 1025);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);
		panel.add(btnCancelar);

		btnCancelar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

		ventana.setVisible(true);

	}

	public void verPlatilloEnchilada() {
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

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});		
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
		panel.setSize(850, 1100);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo imagen
		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/enchiladas.jpg"));
		Image img9 = icon9.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);
		RoundedImageButton btnImagen = new RoundedImageButton(scaledIcon9, 40);

		btnImagen.setSize(350, 350);
		btnImagen.setLocation(50, 50);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		panel.add(btnImagen);

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/no_disponible.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(150, 50, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(scaledImage);
		JLabel labelImagen = new JLabel(finalIcon);
		labelImagen.setBounds(690, 45, 150, 50);
		panel.add(labelImagen);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Enchiladas rojas");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(415, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo nombre tacos
		JLabel tituloNombre1 = new JLabel("Enchiladas");
		tituloNombre1.setSize(300, 40);
		tituloNombre1.setLocation(420, 95);
		tituloNombre1.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloNombre1.setOpaque(false);
		panel.add(tituloNombre1);

		// Campo nombre precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(420, 150);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		// Campo nombre precio
		JLabel tituloPrecio1 = new JLabel("$105");
		tituloPrecio1.setSize(300, 40);
		tituloPrecio1.setLocation(420, 190);
		tituloPrecio1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio1.setForeground(Color.decode("#DC542B"));
		tituloPrecio1.setOpaque(false);
		panel.add(tituloPrecio1);

		// Campo nombre precio
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 40);
		tituloDescripcion.setLocation(420, 250);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		// Campo nombre precio
		JLabel tituloDescripcion1 = new JLabel("<html> Tortilla de maíz, pollo, queso fresco y cilantro.</html>");
		tituloDescripcion1.setSize(350, 50);
		tituloDescripcion1.setLocation(420, 300);
		tituloDescripcion1.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion1.setOpaque(false);
		panel.add(tituloDescripcion1);

		ImageIcon icon10 = new ImageIcon(getClass().getResource("/images/editar.png"));
		Image img10 = icon10.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon10 = new ImageIcon(img10);

		RoundedButton btnEditar = new RoundedButton("Editar", 20, scaledIcon10);
		btnEditar.setSize(170, 50);
		btnEditar.setLocation(380, 420);
		btnEditar.setBackground(Color.decode("#DC542B"));
		btnEditar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnEditar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEditar.setVerticalTextPosition(SwingConstants.CENTER);
		btnEditar.setForeground(Color.white);
		
		btnEditar.addActionListener(e -> {
			DishesView editDishes = new DishesView();
			editDishes.editarPlatilloEnchilada();
			ventana.dispose();
		});


		panel.add(btnEditar);

		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/download.png"));
		Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon11 = new ImageIcon(img11);

		RoundedButton btnDescargar = new RoundedButton("Descargar PDF", 20, scaledIcon11);
		btnDescargar.setSize(250, 50);
		btnDescargar.setLocation(570, 420);
		btnDescargar.setBackground(Color.decode("#DC542B"));
		btnDescargar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnDescargar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDescargar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDescargar.setVerticalTextPosition(SwingConstants.CENTER);
		btnDescargar.setForeground(Color.white);
		panel.add(btnDescargar);

		JPanel linea2 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.decode("#DEDEDE"));
				g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
			}
		};
		linea2.setBounds(0, 500, 1000, 1);
		linea2.setOpaque(false);
		panel.add(linea2);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Texto ingrediente tortilla
		RoundedTextField textTortilla = new RoundedTextField(20, 20);
		textTortilla.setSize(700, 90);
		textTortilla.setLocation(50, 625);
		textTortilla.setText("Tortillaz de maíz");
		textTortilla.setForeground(Color.black);
		textTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textTortilla.setHorizontalAlignment(JTextField.LEFT);
		textTortilla.setBackground(Color.decode("#E8E2DD"));
		textTortilla.setOpaque(false);
		textTortilla.setBorder(null);
		textTortilla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textTortilla);

		JLabel tituloCantidad = new JLabel("3 piezas requeridas");
		tituloCantidad.setSize(300, 40);
		tituloCantidad.setLocation(15, 40);
		tituloCantidad.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad.setForeground(Color.gray);
		tituloCantidad.setOpaque(false);
		textTortilla.add(tituloCantidad);

		// Texto ingrediente carne
		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(700, 90);
		textCarne.setLocation(50, 750);
		textCarne.setText("Pollo");
		textCarne.setForeground(Color.black);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.LEFT);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		textCarne.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCarne);

		JLabel tituloCantidad1 = new JLabel("0.15 Kg requeridos");
		tituloCantidad1.setSize(300, 40);
		tituloCantidad1.setLocation(15, 40);
		tituloCantidad1.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad1.setForeground(Color.gray);
		tituloCantidad1.setOpaque(false);
		textCarne.add(tituloCantidad1);

		// Texto ingrediente cebolla
		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(700, 90);
		textCebolla.setLocation(50, 875);
		textCebolla.setText("Queso fresco");
		textCebolla.setForeground(Color.black);
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.LEFT);
		textCebolla.setBackground(Color.decode("#FAEAEA"));
		textCebolla.setForeground(Color.decode("#C62828"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		textCebolla.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCebolla);

		JLabel tituloCantidad2 = new JLabel("0.05 Kg requerido");
		tituloCantidad2.setSize(300, 40);
		tituloCantidad2.setLocation(15, 40);
		tituloCantidad2.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad2.setForeground(Color.decode("#C62828"));
		tituloCantidad2.setOpaque(false);
		textCebolla.add(tituloCantidad2);

		JLabel tituloInsuficiente = new JLabel("Insuficiente");
		tituloInsuficiente.setSize(300, 40);
		tituloInsuficiente.setLocation(580, 13);
		tituloInsuficiente.setFont(new Font("belanosima", Font.BOLD, 18));
		tituloInsuficiente.setForeground(Color.decode("#C62828"));
		tituloInsuficiente.setOpaque(false);
		textCebolla.add(tituloInsuficiente);

		// Texto ingrediente cebolla
		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(700, 90);
		textCilantro.setLocation(50, 1000);
		textCilantro.setText("Cilantro");
		textCilantro.setForeground(Color.black);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.LEFT);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		textCilantro.setBorder(BorderFactory.createEmptyBorder(-25, 10, 0, 0));
		panel.add(textCilantro);

		JLabel tituloCantidad3 = new JLabel("0.25 kg requerido");
		tituloCantidad3.setSize(300, 40);
		tituloCantidad3.setLocation(15, 40);
		tituloCantidad3.setFont(new Font("belanosima", Font.BOLD, 14));
		tituloCantidad3.setForeground(Color.gray);
		tituloCantidad3.setOpaque(false);
		textCilantro.add(tituloCantidad3);
		ventana.setVisible(true);

	}

	public void editarPlatilloEnchilada() {
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

		// Boton de agregar platillos
		RoundedButton btnAgregar = new RoundedButton("<- Volver a platillos", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});

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
		panel.setSize(850, 1100);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		JLabel textNuevoplatillo = new JLabel("Editar platillo");
		textNuevoplatillo.setSize(300, 50);
		textNuevoplatillo.setLocation(50, 40);
		textNuevoplatillo.setFont(new Font("belanosima", Font.BOLD, 36));
		textNuevoplatillo.setOpaque(false);
		panel.add(textNuevoplatillo);

		// Campo nombre
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(50, 110);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		RoundedTextField textNombre = new RoundedTextField(20, 20);
		textNombre.setSize(300, 40);
		textNombre.setLocation(50, 150);
		textNombre.setText("Enchiladas rojas");
		textNombre.setForeground(Color.gray);
		textNombre.setFont(new Font("belanosima", Font.BOLD, 20));
		textNombre.setHorizontalAlignment(JTextField.CENTER);
		textNombre.setBackground(Color.decode("#E8E2DD"));
		textNombre.setOpaque(false);
		textNombre.setBorder(null);
		panel.add(textNombre);

		// Campo categoria
		JLabel tituloCategoria = new JLabel("Categoria");
		tituloCategoria.setSize(300, 40);
		tituloCategoria.setLocation(500, 110);
		tituloCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloCategoria.setOpaque(false);
		panel.add(tituloCategoria);

		RoundedTextField textCategoria = new RoundedTextField(20, 20);
		textCategoria.setSize(300, 40);
		textCategoria.setLocation(500, 150);
		textCategoria.setText("Enchiladas");
		textCategoria.setForeground(Color.gray);
		textCategoria.setFont(new Font("belanosima", Font.BOLD, 20));
		textCategoria.setHorizontalAlignment(JTextField.CENTER);
		textCategoria.setBackground(Color.decode("#E8E2DD"));
		textCategoria.setOpaque(false);
		textCategoria.setBorder(null);
		panel.add(textCategoria);

		// Campo descripcion
		JLabel tituloDescripcion = new JLabel("Descripción");
		tituloDescripcion.setSize(300, 200);
		tituloDescripcion.setLocation(50, 130);
		tituloDescripcion.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloDescripcion.setOpaque(false);
		panel.add(tituloDescripcion);

		RoundedTextArea textDescripcion = new RoundedTextArea(20);
		textDescripcion.setSize(750, 80);
		textDescripcion.setLocation(50, 250);
		textDescripcion.setText("Enchiladas bañadas en salsa roja con pollo y crema");
		textDescripcion.setForeground(Color.gray);
		textDescripcion.setFont(new Font("belanosima", Font.BOLD, 18));
		textDescripcion.setBackground(Color.decode("#E8E2DD"));
		textDescripcion.setOpaque(false);
		textDescripcion.setBorder(null);
		panel.add(textDescripcion);

		// Campo precio
		JLabel tituloPrecio = new JLabel("Precio");
		tituloPrecio.setSize(300, 40);
		tituloPrecio.setLocation(50, 360);
		tituloPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloPrecio.setOpaque(false);
		panel.add(tituloPrecio);

		RoundedTextField textPrecio = new RoundedTextField(20, 20);
		textPrecio.setSize(300, 40);
		textPrecio.setLocation(50, 400);
		textPrecio.setText("$105");
		textPrecio.setForeground(Color.gray);
		textPrecio.setFont(new Font("belanosima", Font.BOLD, 20));
		textPrecio.setHorizontalAlignment(JTextField.CENTER);
		textPrecio.setBackground(Color.decode("#E8E2DD"));
		textPrecio.setOpaque(false);
		textPrecio.setBorder(null);
		panel.add(textPrecio);

		// Campo imagen
		JLabel tituloImagen = new JLabel("Imagen");
		tituloImagen.setSize(300, 40);
		tituloImagen.setLocation(500, 360);
		tituloImagen.setFont(new Font("belanosima", Font.BOLD, 20));
		tituloImagen.setOpaque(false);
		panel.add(tituloImagen);

		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/upload.png"));
		Image img9 = icon9.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon9 = new ImageIcon(img9);

		JButton btnImagen = new JButton(scaledIcon9);
		btnImagen.setSize(80, 80);
		btnImagen.setLocation(500, 400);
		btnImagen.setBackground(Color.decode("#E8E2DD"));
		btnImagen.setForeground(Color.white);
		btnImagen.setIconTextGap(10);
		btnImagen.setFocusPainted(false);
		panel.add(btnImagen);

		// Campo ingrediente
		JLabel tituloIngredientes = new JLabel("Ingredientes");
		tituloIngredientes.setSize(300, 40);
		tituloIngredientes.setLocation(50, 530);
		tituloIngredientes.setFont(new Font("belanosima", Font.BOLD, 26));
		tituloIngredientes.setOpaque(false);
		panel.add(tituloIngredientes);

		// Boton agregar ingrediente
		RoundedButton btnAgregaring = new RoundedButton("+ Agregar ingrediente", 20);
		btnAgregaring.setSize(250, 30);
		btnAgregaring.setLocation(500, 530);
		btnAgregaring.setBackground(Color.decode("#FFFFFF"));
		btnAgregaring.setOpaque(false);
		btnAgregaring.setFont(new Font("belanosima", Font.BOLD, 20));
		btnAgregaring.setForeground(Color.decode("#DC542B"));
		panel.add(btnAgregaring);

		// Texto ingrediente tortilla
		RoundedTextField textIngTortilla = new RoundedTextField(20, 20);
		textIngTortilla.setSize(400, 60);
		textIngTortilla.setLocation(50, 625);
		textIngTortilla.setText("Tortilla de maíz (piezas)");
		textIngTortilla.setForeground(Color.gray);
		textIngTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngTortilla.setHorizontalAlignment(JTextField.CENTER);
		textIngTortilla.setBackground(Color.decode("#E8E2DD"));
		textIngTortilla.setOpaque(false);
		textIngTortilla.setBorder(null);
		panel.add(textIngTortilla);

		RoundedTextField textNumTortilla = new RoundedTextField(20, 20);
		textNumTortilla.setSize(100, 60);
		textNumTortilla.setLocation(500, 625);
		textNumTortilla.setText("4");
		textNumTortilla.setForeground(Color.gray);
		textNumTortilla.setFont(new Font("belanosima", Font.BOLD, 20));
		textNumTortilla.setHorizontalAlignment(JTextField.CENTER);
		textNumTortilla.setBackground(Color.decode("#E8E2DD"));
		textNumTortilla.setOpaque(false);
		textNumTortilla.setBorder(null);
		panel.add(textNumTortilla);

		ImageIcon iconX = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX = iconX.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX = new ImageIcon(imgX);

		JButton btnImagenX = new JButton(scaledIconX);
		btnImagenX.setSize(50, 50);
		btnImagenX.setLocation(625, 625);
		btnImagenX.setBackground(Color.decode("#E8E2DD"));
		btnImagenX.setForeground(Color.white);
		btnImagenX.setIconTextGap(10);
		btnImagenX.setBorder(null);
		btnImagenX.setFocusPainted(false);
		panel.add(btnImagenX);

		// Texto carne de res
		RoundedTextField textCarneRes = new RoundedTextField(20, 20);
		textCarneRes.setSize(400, 60);
		textCarneRes.setLocation(50, 725);
		textCarneRes.setText("Pollo (Kg)");
		textCarneRes.setForeground(Color.gray);
		textCarneRes.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarneRes.setHorizontalAlignment(JTextField.CENTER);
		textCarneRes.setBackground(Color.decode("#E8E2DD"));
		textCarneRes.setOpaque(false);
		textCarneRes.setBorder(null);
		panel.add(textCarneRes);

		RoundedTextField textCarne = new RoundedTextField(20, 20);
		textCarne.setSize(100, 60);
		textCarne.setLocation(500, 725);
		textCarne.setText("0.15");
		textCarne.setForeground(Color.gray);
		textCarne.setFont(new Font("belanosima", Font.BOLD, 20));
		textCarne.setHorizontalAlignment(JTextField.CENTER);
		textCarne.setBackground(Color.decode("#E8E2DD"));
		textCarne.setOpaque(false);
		textCarne.setBorder(null);
		panel.add(textCarne);

		ImageIcon iconX1 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX1 = iconX1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX1 = new ImageIcon(imgX1);

		JButton btnImagenX1 = new JButton(scaledIconX1);
		btnImagenX1.setSize(50, 50);
		btnImagenX1.setLocation(625, 725);
		btnImagenX1.setBackground(Color.decode("#E8E2DD"));
		btnImagenX1.setForeground(Color.white);
		btnImagenX1.setIconTextGap(10);
		btnImagenX1.setBorder(null);
		btnImagenX1.setFocusPainted(false);
		panel.add(btnImagenX1);

		// Texto cebolla
		RoundedTextField textIngCebolla = new RoundedTextField(20, 20);
		textIngCebolla.setSize(400, 60);
		textIngCebolla.setLocation(50, 825);
		textIngCebolla.setText("Queso fresco (Kg)");
		textIngCebolla.setForeground(Color.decode("#C62828"));
		textIngCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCebolla.setHorizontalAlignment(JTextField.CENTER);
		textIngCebolla.setBackground(Color.decode("#E8E2DD"));
		textIngCebolla.setOpaque(false);
		textIngCebolla.setBorder(null);
		panel.add(textIngCebolla);

		RoundedTextField textCebolla = new RoundedTextField(20, 20);
		textCebolla.setSize(100, 60);
		textCebolla.setLocation(500, 825);
		textCebolla.setText("0.05");
		textCebolla.setForeground(Color.decode("#C62828"));
		textCebolla.setFont(new Font("belanosima", Font.BOLD, 20));
		textCebolla.setHorizontalAlignment(JTextField.CENTER);
		textCebolla.setBackground(Color.decode("#E8E2DD"));
		textCebolla.setOpaque(false);
		textCebolla.setBorder(null);
		panel.add(textCebolla);

		ImageIcon iconX2 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX2 = iconX2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX2 = new ImageIcon(imgX2);

		JButton btnImagenX2 = new JButton(scaledIconX2);
		btnImagenX2.setSize(50, 50);
		btnImagenX2.setLocation(625, 825);
		btnImagenX2.setBackground(Color.decode("#E8E2DD"));
		btnImagenX2.setForeground(Color.white);
		btnImagenX2.setIconTextGap(10);
		btnImagenX2.setBorder(null);
		btnImagenX2.setFocusPainted(false);
		panel.add(btnImagenX2);

		// Texto cilantro
		RoundedTextField textIngCilantro = new RoundedTextField(20, 20);
		textIngCilantro.setSize(400, 60);
		textIngCilantro.setLocation(50, 925);
		textIngCilantro.setText("Cilantro (manojo)");
		textIngCilantro.setForeground(Color.gray);
		textIngCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textIngCilantro.setHorizontalAlignment(JTextField.CENTER);
		textIngCilantro.setBackground(Color.decode("#E8E2DD"));
		textIngCilantro.setOpaque(false);
		textIngCilantro.setBorder(null);
		panel.add(textIngCilantro);

		RoundedTextField textCilantro = new RoundedTextField(20, 20);
		textCilantro.setSize(100, 60);
		textCilantro.setLocation(500, 925);
		textCilantro.setText("0.02");
		textCilantro.setForeground(Color.gray);
		textCilantro.setFont(new Font("belanosima", Font.BOLD, 20));
		textCilantro.setHorizontalAlignment(JTextField.CENTER);
		textCilantro.setBackground(Color.decode("#E8E2DD"));
		textCilantro.setOpaque(false);
		textCilantro.setBorder(null);
		panel.add(textCilantro);

		ImageIcon iconX3 = new ImageIcon(getClass().getResource("/images/x.png"));
		Image imgX3 = iconX3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIconX3 = new ImageIcon(imgX3);

		JButton btnImagenX3 = new JButton(scaledIconX3);
		btnImagenX3.setSize(50, 50);
		btnImagenX3.setLocation(625, 925);
		btnImagenX3.setBackground(Color.decode("#E8E2DD"));
		btnImagenX3.setForeground(Color.white);
		btnImagenX3.setIconTextGap(10);
		btnImagenX3.setBorder(null);
		btnImagenX3.setFocusPainted(false);
		panel.add(btnImagenX3);

		RoundedButton btnGuardar = new RoundedButton("Guardar cambio", 20);
		btnGuardar.setSize(200, 50);
		btnGuardar.setLocation(50, 1025);
		btnGuardar.setBackground(Color.decode("#DC542B"));
		btnGuardar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnGuardar.setForeground(Color.white);

		btnGuardar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});
		
		panel.add(btnGuardar);

		RoundedButton btnCancelar = new RoundedButton("Cancelar", 20);
		btnCancelar.setSize(150, 50);
		btnCancelar.setLocation(270, 1025);
		btnCancelar.setBackground(Color.decode("#E8E2DD"));
		btnCancelar.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCancelar.setForeground(Color.black);

		btnCancelar.addActionListener(e -> {
			DishesView backDishes = new DishesView();
			backDishes.platillos();
			ventana.dispose();
		});
		
		panel.add(btnCancelar);
		ventana.setVisible(true);
	}

}
