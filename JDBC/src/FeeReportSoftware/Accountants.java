package FeeReportSoftware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Accountants {
	Connection con;
	public Accountants(Connection con) {
		this.con=con;
	}

	public void newAccountants(int id, String name, String email, String phone, String password) throws SQLException {
	       String query = "INSERT INTO accountant (id, name, email, phone, password) VALUES (?, ?, ?, ?, ?)";
	       PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, id);
	            pst.setString(2, name);
	            pst.setString(3, email);
	            pst.setString(4, phone);
	            pst.setString(5, password);
	            int count = pst.executeUpdate();
	            if (count> 0) {
	                System.out.println("Accountant added successfully.");
	            } else {
	                System.out.println("Failed to add accountant.");
	            }
	        	}

	public void existingAccountants() throws SQLException {
		String query = "SELECT id, name, email, phone FROM accountant";
		PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
           System.out.println(rs.getInt("id") + " | " +
                              rs.getString("name") + " | " +
                              rs.getString("email") + " | " +
                              rs.getString("phone"));
       }
	}

	public void editAccountantDetails(int id3, String field, String newValue) throws SQLException {
		String query = "UPDATE accountant SET " + field + " = ? WHERE id = ?";
		PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newValue);
            pst.setInt(2, id3);
            int count = pst.executeUpdate();
            if (count > 0) {
                System.out.println("Accountant details updated successfully.");
            } else {
                System.out.println("No accountant found with the given ID.");
            }		
	}

	public void deleteAccountants(int id) throws SQLException {
		String query = "DELETE FROM accountant WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int count = ps.executeUpdate();
        if (count > 0) {
                System.out.println("Accountant deleted successfully.");
            } else {
                System.out.println("No accountant found with the given ID.");
            }
	}

}
