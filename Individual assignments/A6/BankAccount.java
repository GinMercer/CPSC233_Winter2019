public abstract class BankAccount {
	private double balance;
	private String accountNumber;
	private Customer accountHolder;
	protected abstract double getMonthlyFeesAndInterest();
		
	public String getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	
	
	public Customer getAccountHolder(){
		return accountHolder;
	}
	public void setAccountHolder(Customer a){
		accountHolder = a;
	}
	
	
	public String toString(){
		return "("+accountHolder.toString()+") " + accountNumber + ": " + balance;
	}
	public void deposit(double amount){
		if(amount >= 0)
			balance = balance + amount;
	}
	public void withdraw(double amount){
		if(amount >=0 && amount <= balance)
			balance = balance - amount;
	}
	
	public void transfer(double amount, BankAccount account){
		if (amount <= this.balance){
			account.deposit(amount);
			this.withdraw(amount);
		}
	}

	public BankAccount(){
		balance = 0.0;
		accountNumber = new String("0001");
		Customer accountHolder = new Customer();
	}
	
	public BankAccount(double newBalance){
		balance = newBalance;
		accountNumber = new String("0001");
	}
	
	public BankAccount(double newBalance, String newAccountnum){
		balance = newBalance;
		accountNumber = newAccountnum; 
	}
	public BankAccount(Customer accountHolder){
		this.accountHolder.setName(accountHolder.getName());
		this.accountHolder.setID(accountHolder.getID());
	}
	public BankAccount(Customer accountHolder, double balance){
		this.balance = balance;
		setAccountHolder(accountHolder);
	}
	public BankAccount(BankAccount oldBankAccount){
		balance = oldBankAccount.getBalance();
		accountNumber = oldBankAccount.getAccountNumber();
		accountHolder = oldBankAccount.getAccountHolder();
	}	
		
	public void monthEndUpdate(){
		balance=balance+getMonthlyFeesAndInterest();
	}
}