package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AuthModel {

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
}
