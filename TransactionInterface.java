/**
 * The Transaction class handles the exchange of money. It has a type of transaction, as well as a description
 * of the specific transaction made. Any given instance of a Transaction should not be making more than one
 * transaction (aka, should not call more than one function per instance)
 */
public interface TransactionInterface {
    /**
     * Set the type and description to aptly describe the Transaction. Handle the account's balance by adding
     * the amount to the targets balance. Call the Account's function to record this Transaction instance
     */
    public void deposit(Account target, double amount);

    /**
     * Set the type and description to aptly describe the Transaction. Check that the Account has the balance to
     * withdraw the determined amount. If so, remove the correct amount from the target Account's balance. Record
     * the Transaction in the target's history using the Account's function. Otherwise, do nothing and inform the
     * user that the Account did not have the balance.
     */
    public void withdraw(Account target, double amount);

    /**
     * Set the type and description to aptly describe the Transaction. Check that the Account has the balance to
     * withdraw the determined amount. If so, remove the correct amount from the provider Account's balance and add
     * the same amount to the recipient Account. Record the Transaction in the both Account's history. Otherwise,
     * do nothing and inform the user that the Account did not have the balance.
     */
    public void transfer(Account provider, Account recipient, double amount);
}
