public class SavingsAccount extends BankAccount {
	private double annualInterestRate;
	private double minimumBalance;
	
	public SavingsAccount(){
		super();
		this.annualInterestRate=0.05;
		this.minimumBalance=0.0;
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
}


