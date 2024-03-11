import java.time.LocalDateTime;

public class Transaction implements TransactionInterface, Comparable<Transaction>{
    // FIELDS
    private String type;
    private String description;
    private LocalDateTime dateOfOccurrence;
    private boolean completion;

    // CONSTRUCTORS
    public Transaction(){
        dateOfOccurrence = LocalDateTime.now();
        completion = false;
    }

    // GETTERS AND SETTERS
    public String getType(){
        return type;
    }
    public String getDescription(){
        return description;
    }
    public LocalDateTime getDateOfOccurrence(){
        return dateOfOccurrence;
    }

    // OTHER METHODS
    /**
     * For comparing Transactions, compare the date-time to each other
     */
    public int compareTo(Transaction other){
        return dateOfOccurrence.compareTo(getDateOfOccurrence());
    }

    public void deposit(Account target, double amount){
        //ensure that a transaction has not already occurred with this instance.
        if(completion){
            throw new IllegalStateException("Attempted to reuse a finished Transaction");
        }

        //define transaction
        type = "Deposit";
        description = "Made a Deposit of $"+amount+" into "+target.getAccountName();

        //handle transaction of money
        double newBalance = target.getBalance() + amount;
        target.setBalance(newBalance);

        //record the Transaction in the Account
        target.makeTransaction(this);

        completion = true;
    }

    public void withdraw(Account target, double amount){
        //ensure that a transaction has not already occurred with this instance.
        if(completion){
            throw new IllegalStateException("Attempted to reuse a finished Transaction");
        }
        //ensure that the necessary funds are there
        if(target.getBalance() < amount){
            throw new IllegalStateException("Attempted to withdraw more than amount in balance");
        }

        //define transaction
        type = "Withdraw";
        description = "Made a Withdrawal of $"+amount+" from "+target.getAccountName();

        //handle transaction of money
        double newBalance = target.getBalance() - amount;
        target.setBalance(newBalance);

        //record the Transaction in the Account
        target.makeTransaction(this);

        completion = true;
    }

    public void transfer(Account provider, Account recipient, double amount){
        //ensure that a transaction has not already occurred with this instance.
        if(completion){
            throw new IllegalStateException("Attempted to reuse a finished Transaction");
        }
        //ensure that the necessary funds are there
        if(provider.getBalance() < amount){
            throw new IllegalStateException("Attempted to withdraw more than amount in balance");
        }

        //define transaction
        type = "Transfer";
        description = "Made a Transfer of $"+amount+" from "+provider.getAccountName()+" to "+recipient.getAccountName();

        //handle transaction of money
        double newBalance = provider.getBalance() - amount;
        provider.setBalance(newBalance);
        newBalance = recipient.getBalance() + amount;
        recipient.setBalance(newBalance);

        //record the Transaction in the Account
        provider.makeTransaction(this);
        recipient.makeTransaction(this);

        completion = true;
    }
}
