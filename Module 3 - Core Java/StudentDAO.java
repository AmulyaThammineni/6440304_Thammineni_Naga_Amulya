import java.sql.*;

public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/your_database";
    private final String user = "root";
    private final String password = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(int id, String name, int age) {
        String insertSQL = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);

            int rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentAge(int id, int newAge) {
        String updateSQL = "UPDATE students SET age = ? WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);

            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(1, "Alice", 20);
        dao.updateStudentAge(1, 21);
    }
}
