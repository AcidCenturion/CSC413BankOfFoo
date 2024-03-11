/**
 * This is a class for a Customer. Customers may have multiple Accounts.
 * Customers should be able to create and manage their Accounts.
 * Customers should also be able to view Account balance and Transaction history.
 */
public interface CustomerInterface {
    /**
     * To create an Account, take in a name to call the new account as a parameter. Then, call the Account
     * parameterized constructor using the name from call param and the current Customer as the constructor params.
     * The constructor will set all the default values. Add the account to the Customer's list of Accounts. The
     * Linked List should be a Priority Queue ordered via Date of Creation and Balance.
     */
    public void createAccount(String newAccountName);

    /**
     * By providing the name of an Account, attempt to remove an Account of the same name under the Customer's
     * list of Accounts.
     */
    public void closeAccount(String accountName);

    /**
     * Get the Account object from the linked list using the name of the Account as a String param
     */
    public Account getAccountNamed(String accountName);
}
