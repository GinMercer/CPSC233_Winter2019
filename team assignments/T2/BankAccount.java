class BankAccount{
    /**
    * declaring private member variables for class BankAccount
    * balance - a variable for a balance of an account
    * accountNumber - a variable for saving a account number
    */
    private double balance;
    private String accountNumber;

    /**
    * Constructors declaration
    */

    BankAccount(double a, String b){
        this.balance = a;
        this.accountNumber = b;
   }
    BankAccount(){
        this(0.0, "1111");
    }
    BankAccount(double a){
        this(a, "1111");     
    }

    
   /** 
    * this getter method takes no parameter and returns the account's balance.
    * @return the balance of an account
    */
    public double getBalance() {
        return this.balance;
    }

   /** 
    * this getter method takes no parameter and returns the account number.
    * @return the number of account
    */

    public String getAccountNumber() {
        return this.accountNumber;
    }

    /** 
    * this method takes no parameter and returns the account's balance and number
    * in "Account number : balance" format.
    * @return the information of accounnt number and balance
    */

    public String toString(){
        return this.accountNumber + ": " + this.balance;
    }

   /** 
    * this setter method takes one double type parameter called "amount" which will be added
    * to an account's balance. However, negative number is prevented from adding 
    * and will send out error message. It returns nothing as void type method.
    * @param the amount of money that is needed to be deposited into an account
    */
    public void deposit(double amount){
        if (amount < 0){
            System.out.println("Negative amount cannot be deposited.");
        } else {
        this.balance += amount;
        }
    }

    /** 
    * this setter method takes one double type parameter called "amount" which will be withdrawn.
    * from an account's balance. However, negative balance is prevented from the withdrawing 
    * and will send out error message. It returns nothing as void type method.
    * @param the amount of money that is needed to be withdrawn from an account
    */
    public void withdraw(double amount){
        if ((amount < 0) || (this.balance - amount < 0)){
            System.out.println("Out of fund.");
        } else {
        this.balance -= amount;
        }
    }
}