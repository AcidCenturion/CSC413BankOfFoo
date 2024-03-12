import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO implements DAOInterface<Customer>{
    // FIELDS
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;

    // CONSTRUCTORS
    public CustomerDAO(){
        //when creating an instance of a Customer DAO using the constructor, attempt to make a connection to db
        try{
            connection = CustomerDataConnection.getDBConnection();
        } catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }

    // OTHER METHODS

    /**
     * Disconnect form db
     */
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public int insert(Customer emp) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, emp.getUsername());
        pStatement.setString(2, emp.getEmail());
        res = pStatement.executeUpdate();
        disconnect();

        return res;
    }

    public Customer get(int anID) throws SQLException {
        pStatement = connection.prepareStatement(CustomerDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();

        Customer updatedEmp = null;
        if (result.next()) {
            Customer e = new Customer();
            updatedEmp = new Customer(result.getString("name"), result.getString("username"), result.getString("email"), result.getInt("id"));
        }

        return updatedEmp;
    }

    public int update(Customer emp) throws SQLException {

        int result = -1;

        pStatement = connection.prepareStatement(CustomerDataConnection.getUpdate());
        pStatement.setString(1, emp.getName());
        pStatement.setString(2, emp.getUsername());
        pStatement.setString(3, emp.getEmail());
        pStatement.setInt(4, emp.getId());
        result = pStatement.executeUpdate();

        return result;
    }

    public int delete(Customer emp) throws SQLException {

        int res = -1;

        pStatement = connection.prepareStatement(CustomerDataConnection.getDelete());
        pStatement.setInt(1,emp.getId());
        res = pStatement.executeUpdate();

        return res;
    }
}
