public class Customer implements CustomerInterface{
    // FIELDS
    private String name;
    private String email;
    private String username;
    private String password;
    private LinkedPriorityQueue accounts = new LinkedPriorityQueue();

    // CONSTRUCTORS
    public Customer(){}
    /**
     * Create a new Customer using given credentials.
     */
    public Customer(String inpName, String inpEmail, String inpUsername, String inpPassword){
        name = inpName;
        email = inpEmail;
        username = inpUsername;
        password = inpPassword;
    }

    // GETTERS AND SETTERS
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setEmail(String newEmail){
        email = newEmail;
    }
    public void setUsername(String newUsername){
        username = newUsername;
    }
    public void setPassword(String newPassword){
        password = newPassword;
    }

    // OTHER METHODS
    public void createAccount(String newAccountName){
        Account temp = new Account(newAccountName, this);
        accounts.add(temp);
    }

    public void closeAccount(String accountName){
        accounts.remove(accountName);
    }

    public Account getAccountNamed(String accountName){
        LinkedPriorityQueue tempCopy = accounts;
        //get and remove the top node, repeating until what we got has the account name
        Account curr = (Account)tempCopy.remove();
        while(curr.getAccountName() != accountName){
            curr = (Account)tempCopy.remove();
        }
        return curr;
    }
}
