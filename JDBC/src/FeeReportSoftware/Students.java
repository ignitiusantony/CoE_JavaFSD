package FeeReportSoftware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Students {
    Connection con;

    public Students(Connection con) {
        this.con = con;
    }

    public void addStudent(String name, String email, String course, double fee, double paid, double due,
                           String address, String phone) throws SQLException {
        String query = "INSERT INTO student (name, email, course, fee, paid, due, address, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, course);
        ps.setDouble(4, fee);
        ps.setDouble(5, paid);
        ps.setDouble(6, due);
        ps.setString(7, address);
        ps.setString(8, phone);
        int count = ps.executeUpdate();
        if (count > 0) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    // View All Students
    public void viewStudents() throws SQLException {
        String query = "SELECT id, name, email, course, fee, paid, due FROM student";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("email") + " | " +
                                   rs.getString("course") + " | " +
                                   rs.getDouble("fee") + " | " +
                                   rs.getDouble("paid") + " | " +
                                   rs.getDouble("due"));
            }
    }

    public void editStudentDetails(int studentId, String field, String newValue) throws SQLException {
        String query = "UPDATE student SET " + field + " = ? WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newValue);
            pst.setInt(2, studentId);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student details updated successfully.");
            } else {
                System.out.println("No student found with the given ID.");
            }
    }

    public void deleteStudent(int delId) throws SQLException {
        String query = "DELETE FROM student WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, delId);
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("No student found with the given ID.");
        }
    }

    public void checkDueFees() throws SQLException {
        String query = "SELECT id, name, course, due FROM student WHERE due > 0";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("course") + " | " +
                                   rs.getDouble("due"));
            }
    }
}
