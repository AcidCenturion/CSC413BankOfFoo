import java.time.LocalDate;
public class Account implements AccountInterface, Comparable<Account>{
    // FIELDS
    private String accountName;
    private Customer accountHolder;
    private double balance;
    private LocalDate dateOfCreation;
    private LinkedPriorityQueue history = new LinkedPriorityQueue();

    // CONSTRUCTORS
    public Account(){}
    /**
     * Create an account. The account holder should be the user of the function. Local date should be determined
     * during creation. Balance and history should start with nothing.
     */
    public Account(String newAccountName, Customer user){
        accountName = newAccountName;
        accountHolder = user;
        //assign the current date
        dateOfCreation = LocalDate.now();
        //an empty account has a balance of 0
        balance = 0;
        //a new account has no transaction history
    }

    // GETTERS AND SETTERS
    public String getAccountName(){
        return accountName;
    }
    public Customer getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }
    public LocalDate getDateOfCreation(){
        return dateOfCreation;
    }
    public LinkedPriorityQueue getHistory(){
        return history;
    }
    public void setAccountName(String newName){
        accountName = newName;
    }
    public void setAccountHolder(Customer newAccountHolder){
        accountHolder = newAccountHolder;
    }
    public void setBalance(double newBalance){
        balance = newBalance;
    }

    // OTHER METHODS
    /**
     * For comparing Accounts, compare by date of creation and balance.
     */
    public int compareTo(Account otherAcc){
        //if the dates are the same, compare by balance
        if(dateOfCreation.compareTo(otherAcc.getDateOfCreation()) == 0){
            if(balance > otherAcc.getBalance()){
                return 1;
            }
            else if(balance == otherAcc.getBalance()){
                return 0;
            }
            else{
                return -1;
            }
        }
        //for most of the time, compare by dates
        else{
            return dateOfCreation.compareTo(otherAcc.getDateOfCreation());
        }
    }

    /**
     * Overload the .equals() function to check by name
     */
    public boolean equals(String name){
        return accountName.equals(name);
    }

    public void makeTransaction(Transaction newTransaction){
        //add the transaction to the history of transactions
        history.add(newTransaction);
    }
}
