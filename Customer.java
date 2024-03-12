public class Customer implements CustomerInterface{
    // FIELDS
    private String name;
    private String username;
    private String email;
    private int id;
    private LinkedPriorityQueue accounts = new LinkedPriorityQueue();

    // CONSTRUCTORS
    public Customer(){}
    /**
     * Create a new Customer using given credentials.
     */
    public Customer(String inpName, String inpUsername, String inpEmail,  int inpId){
        name = inpName;
        username = inpUsername;
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
    public LinkedPriorityQueue getAccounts(){
        return accounts;
    }

    public void setName(String newName){
        name = newName;
    }
    public void setUsername(String newUsername){
        username = newUsername;
    }
    public void setEmail(String newEmail){
        email = newEmail;
    }
    public void setId(int newId){
        id = newId;
    }

    // OTHER METHODS
    public void createAccount(String newAccountName){
        Account temp = new Account(newAccountName, this);
        //accounts.add(temp);    constructor does this now
    }

    public void closeAccount(Account account){
        accounts.remove(account);
    }

    /*
    public Account getAccountNamed(String accountName){
        Account curr = (Account)accounts.getEntryOf(accountName);
        return curr;
    }
     */

    public void viewAccounts(){
        accounts.view();
    }

    public String toString(){
        String temp = "Name: " + name +
                ", Username: " + username +
                ", Email: " + email +
                ", Id: " + id;
        return temp;
    }
}
