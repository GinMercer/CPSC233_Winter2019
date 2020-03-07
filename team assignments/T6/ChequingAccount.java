public class ChequingAccount extends BankAccount{
  private double overdraftFee;
  private double overdraftAmount;

  //Constructors
  public ChequingAccount(Customer newAccountHolder, double startingBalance, double newOverdraftFee){
    super(newAccountHolder, startingBalance);
    if (newOverdraftFee >= 0)
      this.overdraftFee = newOverdraftFee;
    else
      this.overdraftFee = 1.0;
  }

  //Methods
  /**
  @param newFee amount of the new overdraft fee
  */
  public void setOverdraftFee(double newFee){
    if (newFee >= 0)
      this.overdraftFee = newFee;
  }

  /**
  @param newOverdraftAmount percent charged when overdrafting account
  */
  public void setOverdraftAmount(double newOverdraftAmount){
    if (newOverdraftAmount >= 0)
      this.overdraftAmount = newOverdraftAmount;
  }

  public double getOverdraftAmount(){
    return this.overdraftAmount;
  }

  public double getOverdraftFee(){
    return this.overdraftFee;
  }


  public double getMonthlyFeesAndInterest(){
    if (this.getBalance() > 0)
      return 0.0;

    else
      return (this.getBalance() * 0.2);
  }

  /**
  @param checkAmount the amount customer is trying to withdraw, gets checked against their overdraft limit
  @return true if the customer is allowed to withdraw this amount, false otherwise
  */
  public boolean sufficientFunds(double checkAmount){
    if (checkAmount <= (this.getBalance() + overdraftAmount))
			return true;

		else
			return false;
  }

  /**
  This method subtracts the amount from the customer's account
  @param amountToWithdraw the amount the customer wants to take from account
  */
  public void withdraw(double amountToWithdraw){
    //only positive withdrawl amounts allowed
    if (amountToWithdraw < 0.0){
			System.out.println("You cannot withdraw a negative amount from your account.");
		}

    //checks to make sure the customer is allowed to withdraw this amount
		else if (sufficientFunds(amountToWithdraw) == true){
			if ((this.getBalance() - amountToWithdraw) < 0 ){    //the customer is overdrafting their account, the amountToWithdraw will make balance negative
        super.withdraw(amountToWithdraw + overdraftFee);
        System.out.println("Your account has been overdrafted and you have been charged " + overdraftFee + " extra.");
      }

      else {
        super.withdraw(amountToWithdraw);  
        System.out.println("You have withdrawn " + amountToWithdraw + " from your account");
      }
		}

		else{
			System.out.println("The amount you are trying to withdraw is greater than the amount in your account.");
		}
	}


}
