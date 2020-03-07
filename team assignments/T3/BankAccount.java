import java.util.Random;

public class BankAccount{

	private String accountNumber;
	private double balance;
	private Customer accountHolder;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**Constructors
		when not specified:
		@param balance = 0
		@param accountNumber = random 4-digit number
		@param accountHolder = null*/

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
		this(balance, generateAccountNumber());
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
	/**Methods*/

	/**creates a 4-digit string between 0000 and 9999 to use as account number */
	private static String generateAccountNumber(){
		Random rand = new Random();		//generates random number between 1 and 9999 to use as account number
		int temp = rand.nextInt(9999) + 1;

		String randomAccountNumber = "" + temp;		//adds leading 0's until number is 4 digits
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

	/**PRIVACY ISSUE: returns an object.
		When getAccountHolder() is invoked, it returns the address of the instance variables for accountHolder.
		If another variable (say 'hacker') is set to equal the results of getAccountHolder, it now points to the same location.
		If the attributes of hacker are changed, they will change the attributes of accountHolder too, 
		because they both refer to the same object.
		Instead the method should return a copy of accountHolder*/

	public Customer getAccountHolder(){
		//Customer copyOfCustomer = new Customer(accountHolder);
		//return copyOfCustomer;
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

	public void deposit(double depositAmount){		//essentially a 'setBalance' for increasing balance
		if (depositAmount >= 0){
			System.out.println("You have deposited $" + depositAmount + " in your account.");
			balance += depositAmount;
		}
		else{
			System.out.println("You cannot deposit a negative amount.");
		}
	}

	public void withdraw(double withdrawAmount){	//corresponding 'setBalance' method for decreasing balance
		if (withdrawAmount < 0.0){		//withdraw amount cannot be negative
			System.out.println("You cannot withdraw a negative amount from your account.");
		}

		else if (withdrawAmount <= balance){
			System.out.println("You have withdrawn $" + withdrawAmount + " from your account.");
			balance -= withdrawAmount;
		}

		else{		//withdraw amount must be less than or equal to balance in account
			System.out.println("The amount you are trying to withdraw is greater than the amount in your account.");
		}	
	}

	/**adds or changes the account holder*/
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

	/** returns all account information for a user */
	public String toString(){
		return("(" + accountHolder.toString() + ") " + accountNumber + ": " + balance);
	}
}