package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AuthModel {
	private final String URL = "jdbc:mysql://127.0.0.1:3306/ids-p3-tv";
	private final String USER = "root";
	private final String PASS = "";

	public AuthModel() {

	}

	public boolean access(String email, String password) {
	    String query = "SELECT * FROM `login` WHERE `email` = ? AND `password` = ?";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ids-p3-tv", "root", "");
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            
	            ps.setString(1, email);
	            ps.setString(2, password);
	            
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    return true;
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean register(String email, String password, String name) {
	    String query = "INSERT INTO `login` (`email`, `password`, `Nombre`) VALUES (?, ?, ?)";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ids-p3-tv", "root", "");
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            
	            ps.setString(1, email);
	            ps.setString(2, password);
	            ps.setString(3, name);
	            
	            int rows = ps.executeUpdate();
	            return rows > 0;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public ArrayList<ClientsModel> obtenerClientes() {
	    ArrayList<ClientsModel> lista = new ArrayList<>();
	    String query = "SELECT * FROM clientes";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ids-p3-tv", "root", "");
	             PreparedStatement ps = conn.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {
	            
	            while (rs.next()) {
	                lista.add(new ClientsModel( 
	                    rs.getString("nombre"),
	                    rs.getString("email"),
	                    rs.getString("telefono"),
	                    rs.getString("direccion")
	                ));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return lista;
	}
}
