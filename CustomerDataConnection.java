import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDataConnection {
    // FIELDS
    private static final String URL = "jdbc:mysql://localhost:3306/BankOfFoo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "michael4Hire";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    private static final String INSERT_SQL = "INSERT INTO Customer (name, username, email) VALUES (?, ?, ?)";
    private static final String SELECT_SQL_BY_ID = "SELECT * FROM Customer WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Customer SET " +
            "name = ?, username = ?, email = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Customer WHERE id = ?";

    // CONSTRUCTORS
    public CustomerDataConnection(){}

    // GETTERS AND SETTERS
    public static String getURL() {
        return URL;
    }
    public static String getUsername() {
        return USERNAME;
    }
    public static String getPWD() {
        return PASSWORD;
    }

    public static Connection getDBConnection() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public static String getInsert() {
        return INSERT_SQL;
    }
    public static String getSelect() {
        return SELECT_SQL_BY_ID;
    }
    public static String getUpdate() {
        return UPDATE_SQL;
    }
    public static String getDelete() {
        return DELETE_SQL;
    }
}
