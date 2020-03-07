import java.util.Random;

public class BankAccount{

	private String accountNumber;
	protected double balance;
	private Customer accountHolder;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Constructors

	public BankAccount(double balance, String accountNumber, Customer accountHolder){	//constructor for all variables
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
	}	

	public BankAccount(double balance, String accountNumber){
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public BankAccount(Customer accountHolder, double balance){
		this(balance, generateAccountNumber(), accountHolder);
	}

	public BankAccount(double balance){
		this.balance = balance;
		this.accountNumber = generateAccountNumber();
	}

	public BankAccount(){	//constructor with no parameters
		this(0.0, generateAccountNumber());
	}

	public BankAccount(BankAccount old){	//copy constructor
		this.balance = old.balance;
		this.accountNumber = old.accountNumber;
		this.accountHolder = old.accountHolder;
	}


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Methods

	/**creates a 4-digit string between 0000 and 9999 to use as account number */
	private static String generateAccountNumber(){
		
		Random rand = new Random();		//generates random number between 1 and 9999 to use as account number
		int temp = rand.nextInt(9999) + 1;

		String randomAccountNumber = "" + temp;		//turns random number into 4-digit string
		while (randomAccountNumber.length() < 4){
			randomAccountNumber = "0" + randomAccountNumber; 
		}

		return randomAccountNumber;
	} 

	/**getter methods that return information about account*/

	public double getBalance(){
		return balance;
	}

	public String getAccountNumber(){
		return accountNumber;
	}

	public Customer getAccountHolder(){
		return accountHolder;
	}

	public String getName(){
		String name = accountHolder.getName();
		return name;
	}

	public int getID(){
		int accountID = accountHolder.getID();
		return accountID;
	}

	/**setter methods to change individual attributes*/


	  /** 
    * this setter method takes one double type parameter called "amount" which will be withdrawn.
    * from an account's balance. However, negative balance is prevented from the withdrawing 
    * and will send out error message. It returns nothing as void type method.
    * @param the amount of money that is needed to be withdrawn from an account
    */

	public void deposit(double depositAmount){		//essentially a 'setBalance' for increasing balance
		if (depositAmount >= 0){
			System.out.println("You have deposited $" + depositAmount + " in your account.");
			balance += depositAmount;
		}
		else{
			System.out.println("You cannot deposit a negative amount.");
		}
	}


	  /** 
    * this setter method takes one double type parameter called "amount" which will be withdrawn.
    * from an account's balance. However, negative balance is prevented from the withdrawing 
    * and will send out error message. It returns nothing as void type method.
    * @param the amount of money that is needed to be withdrawn from an account
    */

	public void withdraw(double withdrawAmount){	//corresponding 'setBalance' method for decreasing balance
		if (withdrawAmount < 0.0){
			System.out.println("You cannot withdraw a negative amount from your account.");
		}

		else if (withdrawAmount <= balance){
			System.out.println("You have withdrawn $" + withdrawAmount + " from your account.");
			balance -= withdrawAmount;
		}

		else{
			System.out.println("The amount you are trying to withdraw is greater than the amount in your account.");
		}	
	}

	public void setAccountHolder(Customer newAccountHolder){
		accountHolder = newAccountHolder;
	}

	/**transfers a set amount from the current account to another account*/
	public void transfer(double transferAmount, BankAccount transferToAccount){
		if (balance >= transferAmount){		//transferer must have enough money to complete transaction
			withdraw(transferAmount);
			transferToAccount.deposit(transferAmount);
			System.out.println("Successfully transfered " + transferAmount + " to " + transferToAccount.getAccountHolder().getName() + ".");
		}
	}


	   /** 
    * this method takes no parameter and returns the account's balance and number
    * in "Account number : balance" format.
    * @return the information of accounnt number and balance
    */
	/** returns all account information for a user */
	public String toString(){
		return("(" + accountHolder.toString() + ")" + accountNumber + ": " + balance);
		//return ("("+ accountHolder.name + " " + accountHolder.customerID + ") " + accountNumber + ": " + balance);	
	}
}