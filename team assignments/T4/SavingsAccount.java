public class SavingsAccount extends BankAccount{
	/**
	* Member Variables
	* annualInterestRate: the annual interest earning rate on the account
	* minimumBalance: the minimum amount that must be left in the account
	*/
		private double annualInterestRate;
		private double minimumBalance;

	/**Constructors
	* if not otherwise specified:
	@param accountHolder = null
	@param minimumBalance = 0.0
	@param annualInterestRate = 0.05 */

		public SavingsAccount(Customer accountHolder, double balance, double annualInterestRate){
			super.setAccountHolder(accountHolder);
			this.annualInterestRate = annualInterestRate;
			super.deposit(balance);
		}

		public SavingsAccount(double annualInterestRate){
			this(null, 0.0, annualInterestRate);
		}

		public SavingsAccount(double minimumBalance, double annualInterestRate){
			this(null, minimumBalance, annualInterestRate);
		}

		public SavingsAccount(){
			this(0.0, 0.05);
		}

	/**Methods*/
		/**
		 * this method subtracts the given amount (parameter "withdrawAmount") from the cusotmers' balance (superclass: bankAccount)
		 * if the subtration results in a number that is smaller than minimum balance, it won't subtract it.
		 * @param withdrawAmount : this is a passed parameter that needs to be withdrawan from balance
		 * As it is void type method, it returns nothing.
		 */
		public void withdraw(double withdrawAmount){ 		//overwrite of withdraw method in BankAccount
			double currentBalance = super.getBalance();
			if ((currentBalance - withdrawAmount) >= minimumBalance){		//only allows withdrawls that leave at least the min balance
				super.withdraw(withdrawAmount);
			}
		}
		/**
		 * this method deposits a monthly interest of current annual interest rate to current balance
		 * it doesn't take any parameter and returns nothing.
		 * it updates current balance with the amount of interests
		 */
		public void depositMonthlyInterest(){
			double currentBalance = super.getBalance();
			double monthlyInterest = (currentBalance * (annualInterestRate/12)); 		//deposits amount based on annual interest/12 months
			super.deposit(monthlyInterest);
		}

		/**
		 * this method helps to set new interest rate.
		 * it checks if the passed parameter is within valid range of interest (0 <= interest <= 1)
		 * @param newInterestRate : this is a passed parameter for new interest rate.
		 * this method returns nothing but updates annualInterest member variable
		 */

		public void setAnnualInterestRate(double newInterestRate){
			if ((0.0 <= newInterestRate) && (newInterestRate <= 1.0)){
				annualInterestRate = newInterestRate;
			}
		}

		/**
		 * this method helps to set new minimum balance.
		 * this method returns nothing but updates minimumBalance member variable
		 * @param newMinimumBalance : this is a passed parameter for new minimum balance.
		 */
		public void setMinimumBalance(double newMinimumBalance){
			minimumBalance = newMinimumBalance;
		}

		/**
		 * this method works as "getter" method that returns member variable of current instance of object.
		 * @return it returns current annualInterestRate.
		 */
		public double getAnnualInterestRate(){
			return annualInterestRate;
		}
	
}