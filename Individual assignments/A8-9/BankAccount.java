import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BankAccount {
	private double balance;
	private String accountNumber;
	private Customer accountHolder;
	protected abstract double getMonthlyFeesAndInterest();
	
	public BankAccount(){
		this.balance = 0.0;
		this.accountNumber = "1111";
		//Customer accountHolder = new Customer();
	}
	
	public BankAccount(double newBalance){
		this.balance = newBalance;
		this.accountNumber = "1111";
	}
	
	public BankAccount(double newBalance, String newAccountnum){
		this.balance = newBalance;
		this.accountNumber = newAccountnum; 
	}
	public BankAccount(Customer accountHolder, double balance){
		this.balance = balance;
		this.accountNumber = "1111";
		this.accountHolder = accountHolder;
		//setAccountHolder(accountHolder);
	}
	public BankAccount(BankAccount b){
		this.accountHolder = b.getAccountHolder();
		this.balance = b.getBalance();
		this.accountNumber = b.getAccountNumber();	
	}	
	
	public BankAccount(BufferedReader br) throws IOException {
		String line;
		line = br.readLine(); 
		if (line == null) {
			throw new IOException();
		}else {
			this.balance = Double.parseDouble(line);
			line = br.readLine(); 
			if (line == null)
				throw new IOException();
			else
				this.accountNumber = line;
			try {
				this.accountHolder = new Customer(br);
			} catch(IOException io){
				this.accountHolder = null;
			}
		}
	}	
	
	public String getAccountNumber(){
		return this.accountNumber;
	}
	public double getBalance(){
		return this.balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getAccountHolder(){
		return this.accountHolder;
	}
	public void setAccountHolder(Customer a){
		this.accountHolder = a;
	}
	
	public String toString(){
		return   "(" + accountHolder.getName() + " " + accountHolder.getID() + ") " + this.accountNumber + ": " + this.balance;
	}
	public void deposit(double amount){
		if(amount >= 0)
			this.balance = balance + amount;
	}
	public void withdraw(double amount){
		if(amount >=0 && ((this.balance - amount) >= 0))
			this.balance = balance - amount;
	}
	
	public void transfer(double amount, BankAccount account){
		if (amount <= this.getBalance()){
			this.withdraw(amount);
			account.deposit(amount);
		}
	}
	public void monthEndUpdate(){
		if (this.balance - getMonthlyFeesAndInterest() < 0)
			setBalance(this.balance);
		else
			setBalance(this.balance + getMonthlyFeesAndInterest());
	}
	public void saveToTextFile(String filename) throws IOException {
		PrintWriter pw = new PrintWriter(filename);
		pw.println(this.balance);
		pw.println(this.accountNumber);
		if (accountHolder == null){
			pw.println("null");
		}else{
			this.accountHolder.save(pw);
		}
		pw.close();
	}
}