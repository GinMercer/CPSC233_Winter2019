public class BankAccount {
		double balance;
		String accountNumber;
	//constractors
	public BankAccount(){
		balance = 0.0;
		accountNumber = "0001";
	}
	public BankAccount(double startBalance){
		balance = startBalance;
		accountNumber = "0001";
	}
	public BankAccount(double startBalance, String startAccountnum){
		balance = startBalance;
		accountNumber = startAccountnum; 
	}	

	//get
	public String getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	
	
	public String toString(){
		return accountNumber + ": " + balance;
	}
	
	public void deposit(double amount){
		if(amount >= 0)
			balance += amount;
	}
	public void withdraw(double amount){
		if(amount >=0 && amount <= balance)
			balance = balance - amount;
	}
	
}