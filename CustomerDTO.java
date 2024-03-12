import java.sql.SQLException;

public class CustomerDTO {
    // FIELDS
    private String name;
    private String username;
    private String email;
    private int id;

    static CustomerDAO dbAccess = new CustomerDAO();

    // CONSTRUCTORS
    public CustomerDTO(){}
    public CustomerDTO(String inpName, String inpUserN, String inpEmail, int inpId) {
        name = inpName;
        username = inpUserN;
        email = inpEmail;
        id = inpId;
    }

    // GETTERS AND SETTERS
    public String getName(){
        return name;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public int getId(){
        return id;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setUsername(String newUserN){
        username = newUserN;
    }
    public void setEmail(String newEmail){
        email = newEmail;
    }
    public void setId(int newId){
        id = newId;
    }

    // OTHER METHODS
    public static Customer employeeByID(int anId) {

        Customer temp = null;

        try {
            temp = dbAccess.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(temp != null) System.out.println(temp);

        System.out.println("\nFetched Customer with ID: " + anId + " Customer Details:\n" + temp.toString());
        return temp;

    }

    public static int performUpdate(Customer target) {

        int updateResult = -1;

        try {
            updateResult = dbAccess.update(target);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }

        if(updateResult != -1) System.out.println("\nUpdate Successful");
        System.out.println("Employee Details:\n" + target);
        return updateResult;
    }
}
