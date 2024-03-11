/**
 * This is a class for a Customer's Account. An account cannot exist w/o a Customer
 * Accounts should be able to deposit, withdraw, and transfer money (Transactions).
 * Account balance and Transaction history should be visible to the Customer of the Account.
 * Accounts will need to be Comparable so that they can be organized by Creation Date and Balance
 */
public interface AccountInterface {
    /**
     * Record a Transaction in the instance's history
     */
    public void makeTransaction(Transaction newTransaction);
}
