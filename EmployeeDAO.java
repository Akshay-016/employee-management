import java.sql.*;

public class EmployeeDAO {

    public void addEmployee(String name, String email, double salary) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllEmployees() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getDouble("salary")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String name, String email, double salary) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE employees SET name=?, email=?, salary=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Employee updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
