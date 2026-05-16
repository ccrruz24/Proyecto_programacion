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
import java.util.ArrayList;

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

import controllers.ClientController;
import models.ClientsModel;

public class ClientsViews {

	private Font belanosima;

    public static class RoundedTextField extends JTextField {
        private int arc;
        public RoundedTextField(int columns, int arc) {
            super(columns); this.arc = arc; setOpaque(false); setBorder(null);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground()); g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.dispose(); super.paintComponent(g);
        }
    }

    public static class RoundedPasswordField extends JPasswordField {
        private int arc;
        public RoundedPasswordField(int columns, int arc) {
            super(columns); this.arc = arc; setOpaque(false); setBorder(null);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground()); g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.dispose(); super.paintComponent(g);
        }
    }

    public static class RoundedButton extends JButton {
        private int arc;
        public RoundedButton(String text, int arc) { super(text); setup(arc); }
        public RoundedButton(String text, int arc, Icon icon) { super(text, icon); setup(arc); }
        private void setup(int arc) {
            this.arc = arc; setOpaque(false); setBorderPainted(false); setFocusPainted(false); setContentAreaFilled(false);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground()); g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            super.paintComponent(g); g2.dispose();
        }
    }

    public static class RoundedTextArea extends JTextArea {
        private int arc;
        public RoundedTextArea(int arc) {
            this.arc = arc; setOpaque(false); setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            setLineWrap(true); setWrapStyleWord(true);
        }
        @Override protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground()); g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.setColor(new Color(220, 220, 220)); g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.dispose(); super.paintComponent(g);
        }
    }

    class AccionesClientes extends JPanel {
        JButton btnVer, btnEdit, btnDel;
        public AccionesClientes() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); setBackground(Color.WHITE);
            btnVer = crearBoton("/images/detalles.png"); btnEdit = crearBoton("/images/edit.png"); btnDel = crearBoton("/images/borrar.png");
            add(btnVer); add(btnEdit); add(btnDel);
        }
        private JButton crearBoton(String ruta) {
            JButton btn;
            try {
                Image img = new ImageIcon(getClass().getResource(ruta)).getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
                btn = new JButton(new ImageIcon(img));
            } catch (Exception e) { btn = new JButton("?"); }
            btn.setPreferredSize(new Dimension(28, 28)); btn.setContentAreaFilled(false);
            btn.setBorderPainted(false); btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); return btn;
        }
    }

    public void clientes() {
        ClientController control = new ClientController(this); //
        control.iniciar(); //
    }

    public void clientes(ArrayList<ClientsModel> lista, ClientController controller) {
        JFrame ventana = new JFrame();
        ventana.setSize(1200, 839);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setTitle("La casa del maiz");

        JPanel opciones = new JPanel() {
            private Image fondo = new ImageIcon(getClass().getResource("/images/sidebar.png")).getImage();
            @Override protected void paintComponent(Graphics g) {
                super.paintComponent(g); g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        opciones.setBackground(Color.decode("#FEF9F3")); opciones.setLayout(null); opciones.setSize(270, 800);
        ventana.add(opciones);

        agregarLinea(opciones, 100); agregarLinea(opciones, 620);
        
        ImageIcon iconLogo = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));
        JLabel logoLabel = new JLabel(new ImageIcon(iconLogo.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH)));
        logoLabel.setBounds(30, 10, 220, 80); opciones.add(logoLabel);

        configurarBotonSidebar(opciones, "Panel de control", "/images/dashboard.png", 160, e -> { new HomeViews().panelControl(); ventana.dispose(); });
        configurarBotonSidebar(opciones, "Platillos", "/images/platillos.png", 250, e -> { new DishesView().platillos(); ventana.dispose(); });
        configurarBotonSidebar(opciones, "Órdenes", "/images/órdenes.png", 340, e -> { new OrdersView().ordenes(); ventana.dispose(); });
        configurarBotonSidebar(opciones, "Clientes", "/images/clientes.png", 430, e -> { controller.iniciar(); ventana.dispose(); });
        configurarBotonSidebar(opciones, "Inventario", "/images/inventario.png", 520, e -> { new InventoryView().inventario(); ventana.dispose(); });
        configurarBotonSidebar(opciones, "Correo electrónico", "/images/user.png", 650, null);
        configurarBotonSidebar(opciones, "Cerrar sesión", "/images/logout.png", 720, e -> { new AuthViews().inicioSesion(); ventana.dispose(); });

        JPanel contenido = new JPanel(null);
        contenido.setSize(1200, 800); contenido.setBackground(Color.decode("#FEF9F3"));
        ventana.add(contenido);

        JLabel Titulo = new JLabel("Clientes");
        Titulo.setBounds(350, -10, 250, 100); Titulo.setFont(new Font("belanosima", Font.BOLD, 38));
        contenido.add(Titulo);

        RoundedButton btnAgregar = new RoundedButton("+ Agregar cliente", 40);
        btnAgregar.setBounds(900, 150, 250, 50); btnAgregar.setBackground(Color.decode("#DC542B"));
        btnAgregar.setFont(new Font("belanosima", Font.BOLD, 26)); btnAgregar.setForeground(Color.white);
        btnAgregar.addActionListener(e -> { this.agregarCliente(); ventana.dispose(); });
        contenido.add(btnAgregar);

        String[] columnas = { "Nombre", "Email", "Teléfono", "Dirección", "Acciones" };
        Object[][] datos = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            ClientsModel c = lista.get(i);
            datos[i][0] = c.getNombre();
            datos[i][1] = c.getEmail();
            datos[i][2] = c.getTelefono();
            datos[i][3] = c.getDireccion();
            datos[i][4] = "";
        }

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
            @Override public boolean isCellEditable(int r, int c) { return c == 4; }
        };

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(60); tabla.setShowGrid(false); tabla.setSelectionBackground(new Color(250, 245, 245));
        
        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(0, 50)); header.setBackground(new Color(245, 240, 230));
        header.setFont(new Font("belanosima", Font.BOLD, 14));

        tabla.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override public Component getTableCellRendererComponent(JTable t, Object v, boolean s, boolean f, int r, int c) {
                return new AccionesClientes();
            }
        });

        tabla.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            @Override public Component getTableCellEditorComponent(JTable t, Object v, boolean s, int r, int c) {
                AccionesClientes ac = new AccionesClientes();
                ac.btnVer.addActionListener(e -> { stopCellEditing(); controller.verDetalles(lista.get(r)); ventana.dispose(); });
                ac.btnEdit.addActionListener(e -> { stopCellEditing(); controller.editar(lista.get(r)); ventana.dispose(); });
                return ac;
            }
        });

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(350, 250, 800, 400); scroll.getViewport().setBackground(Color.WHITE);
        contenido.add(scroll);

        ventana.setVisible(true);
    }

    private void agregarLinea(JPanel panel, int y) {
        JPanel linea = new JPanel() {
            @Override protected void paintComponent(Graphics g) {
                super.paintComponent(g); g.setColor(Color.WHITE); g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
            }
        };
        linea.setBounds(0, y, 270, 1); linea.setOpaque(false); panel.add(linea);
    }

    private void configurarBotonSidebar(JPanel panel, String texto, String ruta, int y, java.awt.event.ActionListener accion) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
        JButton btn = new JButton(texto, new ImageIcon(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        btn.setBounds(30, y, 230, 50); btn.setFont(new Font("belanosima", Font.BOLD, 16)); btn.setForeground(Color.WHITE);
        btn.setContentAreaFilled(false); btn.setBorder(null); btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(10); if (accion != null) btn.addActionListener(accion); panel.add(btn);
    }

	public void verDetallesGenerico(ClientsModel c, ClientController controller) {
		JFrame v = crearVentanaBase();
		v.add(new JLabel("Viendo a: " + c.getNombre()));
		v.setVisible(true);
	}

	public void editarGenerico(ClientsModel c, ClientController controller) {
		JFrame v = crearVentanaBase();
		v.add(new JLabel("Editando a: " + c.getNombre()));
		v.setVisible(true);
	}

	private JFrame crearVentanaBase() {
	    JFrame v = new JFrame("La Casa del Maíz");
	    v.setSize(1200, 839);
	    v.setLayout(null);
	    v.setLocationRelativeTo(null);
	    v.getContentPane().setBackground(Color.decode("#FEF9F3"));

	    try {
	        ImageIcon icon = new ImageIcon(getClass().getResource("/images/LOGO SIDEBAR.png"));

	        v.setIconImage(icon.getImage());

	        Image img = icon.getImage().getScaledInstance(220, 80, Image.SCALE_SMOOTH);
	        JLabel logoLabel = new JLabel(new ImageIcon(img));

	        logoLabel.setBounds(30, 10, 220, 80);
	        v.add(logoLabel);
	        
	    } catch (Exception e) {
	        System.err.println("No se pudo cargar el logo en la ventana base: " + e.getMessage());
	    }

	    return v;
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

		// Boton de inventario
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

		// Boton de cerrar sesión
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

		// Boton de volver
		RoundedButton btnAgregar = new RoundedButton("<- Volver a clientes", 40);
		btnAgregar.setSize(300, 40);
		btnAgregar.setLocation(30, 10);
		btnAgregar.setOpaque(false);
		btnAgregar.setBackground(Color.decode("#FEF9F3"));
		btnAgregar.setFont(new Font("belanosima", Font.BOLD, 22));
		btnAgregar.setForeground(Color.black);

		btnAgregar.addActionListener(e -> {
			ClientsViews back = new ClientsViews();
			back.clientes();
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
		panel.setSize(850, 600);
		panel.setLocation(30, 90);
		panel.setLayout(null);
		panel.setBorder(null);
		contenido.add(panel);

		// Campo orden
		JLabel tituloNombre = new JLabel("Nueva cliente");
		tituloNombre.setSize(300, 40);
		tituloNombre.setLocation(40, 50);
		tituloNombre.setFont(new Font("belanosima", Font.BOLD, 34));
		tituloNombre.setOpaque(false);
		panel.add(tituloNombre);

		// Campo informacion de cliente
		JLabel tituloInformacion = new JLabel("Nombre completo");
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
		textDatos.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0));

		panel.add(textDatos);

		// Campo telefono
		JLabel tituloEstado = new JLabel("Telefono");
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

		// Campo email
		JLabel tituloEmail = new JLabel("Email");
		tituloEmail.setSize(300, 40);
		tituloEmail.setLocation(40, 280);
		tituloEmail.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloEmail.setOpaque(false);
		panel.add(tituloEmail);

		// Texto datos
		RoundedTextField textEmail = new RoundedTextField(20, 20);
		textEmail.setSize(600, 60);
		textEmail.setLocation(40, 320);
		textEmail.setText("");
		textEmail.setForeground(Color.black);
		textEmail.setFont(new Font("belanosima", Font.BOLD, 20));
		textEmail.setHorizontalAlignment(JTextField.LEFT);
		textEmail.setBackground(Color.decode("#E8E2DD"));
		textEmail.setForeground(Color.decode("#756B64"));
		textEmail.setOpaque(false);
		textEmail.setBorder(null);
		textEmail.setBorder(BorderFactory.createEmptyBorder(-5, 20, 0, 0)); // Los valores son arriba, izquierda,abaj,
																			// // // derecha
		panel.add(textEmail);

		// Campo dirrecion
		JLabel tituloDirecciones = new JLabel("Dirrecciones");
		tituloDirecciones.setSize(300, 40);
		tituloDirecciones.setLocation(40, 400);
		tituloDirecciones.setFont(new Font("belanosima", Font.BOLD, 24));
		tituloDirecciones.setOpaque(false);
		panel.add(tituloDirecciones);

		// Botone de agregar
		RoundedButton btnAgregarP = new RoundedButton("+ Agregar dirección", 20);
		btnAgregarP.setSize(260, 50);
		btnAgregarP.setLocation(550, 400);
		btnAgregarP.setBackground(Color.decode("#FFFFFF"));
		btnAgregarP.setFont(new Font("belanosima", Font.BOLD, 24));
		btnAgregarP.setForeground(Color.decode("#DC542B"));
		btnAgregarP.setOpaque(false);
		panel.add(btnAgregarP);

		// Botones guardar y cancelar
		RoundedButton btnCrear = new RoundedButton("Crear cliente", 20);
		btnCrear.setSize(200, 50);
		btnCrear.setLocation(50, 500);
		btnCrear.setBackground(Color.decode("#DC542B"));
		btnCrear.setFont(new Font("belanosima", Font.BOLD, 20));
		btnCrear.setForeground(Color.white);

		btnCrear.addActionListener(e -> {
			//ClientsViews backOrden = new ClientsViews();
			this.clientes();
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
			//ClientsViews backOrden = new ClientsViews();
			this.clientes();
			ventana.dispose();
		});

		panel.add(btnCancelar);

		ventana.setVisible(true);

	}
}