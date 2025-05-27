import java.sql.*;

public class TransactionExample {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void transferMoney(int fromAccountId, int toAccountId, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {

            conn.setAutoCommit(false); // Start transaction

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            int debitResult = debitStmt.executeUpdate();

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);
            int creditResult = creditStmt.executeUpdate();

            if (debitResult == 1 && creditResult == 1) {
                conn.commit();
                System.out.println("Transfer successful.");
            } else {
                conn.rollback();
                System.out.println("Transfer failed, transaction rolled back.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("Rolling back transaction...");
                DriverManager.getConnection(URL, USER, PASSWORD).rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        transferMoney(1, 2, 500.0);
    }
}
