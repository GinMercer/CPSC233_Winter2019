import java.util.Random;

public abstract class BankAccount{

	private String accountNumber;
	private double balance;
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

	protected abstract double getMonthlyFeesAndInterest();

	/**
	checks to see if the customer's account has enough to withdraw a particular amount
	@param checkAmount amount customer wishes to withdraw
	@return true if customer can withdraw this amount, false otherwise
	*/
	public boolean sufficientFunds(double checkAmount){
		if (checkAmount <= this.getBalance())
			return true;

		else
			return false;
	}

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

	public void monthEndUpdate(){
		this.balance += getMonthlyFeesAndInterest();
	}

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
		boolean fundsAmount = this.sufficientFunds(withdrawAmount);
		if (withdrawAmount < 0.0){
			System.out.println("You cannot withdraw this amount from your account.");
		}

		else if (fundsAmount == true){
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
		boolean fundsAmount = this.sufficientFunds(transferAmount);
		if (fundsAmount == true){		//transferer must have enough money to complete transaction
			withdraw(transferAmount);
			transferToAccount.deposit(transferAmount);
		//	System.out.println("Successfully transfered " + transferAmount + " to " + transferToAccount.getAccountHolder().getName() + ".");
		}
	}

	/** returns all account information for a user */
	public String toString(){
		return("(" + accountHolder.toString() + ") " + accountNumber + ": " + balance);
		//return ("("+ accountHolder.name + " " + accountHolder.customerID + ") " + accountNumber + ": " + balance);
	}
}
