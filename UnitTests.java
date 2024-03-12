public class UnitTests {
    public static void main(String[]args){
        System.out.println("-----TESTING CUSTOMER CONSTRUCTOR AND GETTERS-----");

        Customer customer1 = new Customer("Michael", "microphone", "mleong6@sfsu.edu", 1);

        System.out.println("Name:     " + customer1.getName());
        System.out.println("Username: " + customer1.getUsername());
        System.out.println("Email:    " + customer1.getEmail());
        System.out.println("Id:       " + customer1.getId());

        System.out.println();
        System.out.println("-----TESTING CUSTOMER SETTERS AND TOSTRING-----");

        customer1.setName("NotMichael");
        customer1.setUsername("boomstand");
        customer1.setEmail("lmichael9@edu.sfsu");
        customer1.setId(2);

        System.out.println(customer1);

        System.out.println();
        System.out.println("-----TESTING ACCOUNT CONSTRUCTOR AND GETTERS-----");

        Account account1 = new Account("Savings", customer1);

        System.out.println("Name:    " + account1.getAccountName());
        System.out.println("Holder:  " + account1.getAccountHolder().getName());
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Date:    " + account1.getDateOfCreation());

        System.out.println();
        System.out.println("-----TESTING ACCOUNT SETTERS-----");

        account1.setAccountName("Checking");
        account1.setBalance(0.01);

        System.out.println(account1);

        System.out.println();
        System.out.println("-----TESTING ACCOUNT COMPARING FUNCTIONS-----");

        Account account2 = new Account("Savings", customer1);

        System.out.println("Should print 1: " + account1.compareTo(account2));
        System.out.println("Should print -1: " + account2.compareTo(account1));
        System.out.println("Should print 0: " + account1.compareTo(account1));

        System.out.println("Should print true: " + account1.equals("Checking"));

        System.out.println();
        System.out.println("-----TESTING CUSTOMER - ACCOUNT RELATIONS-----");

        customer1.viewAccounts();
        System.out.println();

        customer1.closeAccount(account1);
        customer1.viewAccounts();
        System.out.println();
        // ACCOUNT1 NOW UNUSABLE

        Customer customer2 = new Customer("Edward", "Kiwi", "elau30@notsfsu.edu", 2);
        account2.setAccountHolder(customer2);
        customer1.viewAccounts();
        customer2.viewAccounts();
        System.out.println();

        customer1.createAccount("For Fun Funds");  /** until i get the getAccount function working
         you cant actually use this account */
        customer1.viewAccounts();
        //customer2.viewAccounts();

        System.out.println("-----SUCCESS-----");

        System.out.println();
        System.out.println("-----TESTING TRANSACTION - ACCOUNT RELATIONS-----");

        Transaction transaction1 = new Transaction();

        transaction1.deposit(account2, 1.1);
        System.out.println(account2);
        account2.viewTransactions();
        System.out.println();

        //transaction1.deposit(account2, 2);

        Transaction transaction2 = new Transaction();
        transaction2.withdraw(account2, .6);
        //transaction2.withdraw(account2,10);
        System.out.println(account2);
        account2.viewTransactions();
        System.out.println();

        Account account3 = new Account("Michael Funds", customer2);
        Transaction transaction3 = new Transaction();
        transaction3.transfer(account2, account3, .4);
        System.out.println(account2);
        account2.viewTransactions();
        System.out.println(account3);
        account3.viewTransactions();

        System.out.println("-----SUCCESS-----");
    }
}
