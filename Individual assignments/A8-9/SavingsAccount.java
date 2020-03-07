import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;


public class SavingsAccount extends BankAccount {
	private double annualInterestRate;
	private double minimumBalance;
	
	public SavingsAccount(){
		super();
		//getBalance();
		this.annualInterestRate=0.05;
		//this.minimumBalance=0.0;
	}
	public SavingsAccount(double annualInterestRate){
		//super();
		//getBalance();
		this.annualInterestRate = annualInterestRate;

	}
	public SavingsAccount(double balance,double annualInterestRate){
		super(balance);
		this.annualInterestRate = annualInterestRate;
		//this.minimumBalance = minimumBalance;
	}
	public SavingsAccount(Customer accountHolder, double balance){
		super(accountHolder,balance);
		//getBalance();
		this.annualInterestRate = 0.05;
		//getAccountHolder().getName();
		//this.minimumBalance = minimumBalance;
	}
	public SavingsAccount(Customer accountHolder, double balance,double annualInterestRate){
		super(accountHolder,balance);
		//getBalance();
		this.annualInterestRate = annualInterestRate;
		//getAccountHolder().getName();
		//this.minimumBalance = minimumBalance;
	}
	
	public SavingsAccount(BufferedReader br)throws IOException{
		super(br);
		String a = br.readLine();
		annualInterestRate= Double.parseDouble(a);
		String b = br.readLine();
		minimumBalance= Double.parseDouble(b);
	}
	
	public double getAnnualInterestRate(){
		return this.annualInterestRate;
	}
	public void setAnnualInterestRate(double rate){
		if(rate<0.0||rate>1.0){
			this.annualInterestRate=0.05;
		}else{
			this.annualInterestRate=rate;
		}
	}
	public double getMinimumBalance(){
		return this.minimumBalance;
	}
	/*public void depositMonthlyInterest(){
		double bal=super.getBalance();
		balance+=bal*annualInterestRate/12;
	}*/
	
	public void withdraw(double amount){
		double bal=super.getBalance();
		if(amount<=(bal-minimumBalance)){
			super.withdraw(amount);
		}
	}
	
	public void setMinimumBalance(double rate){
		this.minimumBalance=rate;
	}
	
	protected double getMonthlyFeesAndInterest(){
		double bal=super.getBalance();
		return bal*getAnnualInterestRate()/12;
	}
	
	public void saveToTextFile(String Filename) throws IOException {
		super.saveToTextFile(Filename);
		FileWriter file=new FileWriter(Filename,true);
		PrintWriter pw= new PrintWriter(file);
		pw.println(getAnnualInterestRate());
		pw.println(getMinimumBalance());
		pw.flush();
		pw.close();
	}
}


