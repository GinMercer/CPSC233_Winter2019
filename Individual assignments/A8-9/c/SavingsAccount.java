import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class SavingsAccount extends BankAccount {
    private double annualInterestRate;
    private double minimumBalance;

    SavingsAccount(double m, double a){
        super(m);
        this.annualInterestRate = a;
    }
    SavingsAccount(Customer c, double a, double m){
        super(c, a);
        this.annualInterestRate = m;
    }
    SavingsAccount(){
        this.annualInterestRate = 0.05;
        this.minimumBalance = 0.00;
    }
    SavingsAccount(double a){
        this.annualInterestRate = a;
        this.minimumBalance = 0.0;
    }
    SavingsAccount(Customer c, double b){
        super(c, b);
        this.annualInterestRate = 0.05;
    }
    
    
    public SavingsAccount(BufferedReader bufferedReader) throws IOException {
        super(bufferedReader);
        this.annualInterestRate = Double.parseDouble(bufferedReader.readLine());
        this.minimumBalance = Double.parseDouble(bufferedReader.readLine());
    }
    public SavingsAccount(double annualInterestRate, double minimumBalance, BankAccount account, double balance, String accountNumber, Customer accountHolder) {
        super(balance);
        if ((annualInterestRate >= 0 ) && (annualInterestRate <= 1)){
            this.annualInterestRate = annualInterestRate;
            if ((getBalance()-minimumBalance >= 0 ) && (minimumBalance >= 1)){
                this.minimumBalance = minimumBalance;
            }
        }
    }
    
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate >= 0 && annualInterestRate <= 1) {
            this.annualInterestRate = annualInterestRate;
        }
        else if (annualInterestRate < 0) {
            this.annualInterestRate = 0.05;
        }
        else if (annualInterestRate > 1){
            this.annualInterestRate = 0.05;
        }
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public void withdraw(double amount) {
        if (getBalance() - amount >= minimumBalance){
            super.withdraw(amount);
        }
    }

    protected double getMonthlyFeesAndInterest(){
        if (super.getBalance() > 0)
            return annualInterestRate*100/12;
        else
            return 0;
    }

    public void saveToTextFile(String fileName) throws IOException{
        super.saveToTextFile(fileName);
        PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
        pw.println(this.annualInterestRate);
        pw.println(this.minimumBalance);
        pw.close();
    }
}