import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BankAccount{
    private double balance;
    private String accountNumber;
    private Customer accountHolder;
    protected abstract double getMonthlyFeesAndInterest();
    
    public BankAccount(Customer c, double a){
        this.accountHolder = c;
        this.balance = a;
        this.accountNumber = "1111";
    }
    public BankAccount(){
        this.balance = 0.0;
        this.accountNumber = "1111";
    }

    public BankAccount(double a){
        this.balance = a;
        this.accountNumber = "1111";
    }

    public BankAccount(double a, String b){
        this.balance = a;
        this.accountNumber = b;
    }

    public BankAccount(BankAccount b){
        this.accountHolder = b.getAccountHolder();
        this.balance = b.getBalance();
        this.accountNumber = b.getAccountNumber();
    }
    public BankAccount(BufferedReader bufferedReader) throws IOException {
        String line;
        line = bufferedReader.readLine(); 
        if (line == null) {
            throw new IOException();
        }else {
            this.balance = Double.parseDouble(line);
            line = bufferedReader.readLine(); 
            if (line == null)
                throw new IOException();
            else
                this.accountNumber = line;
            try {
                this.accountHolder = new Customer(bufferedReader);
            } catch(IOException io){
                this.accountHolder = null;
            }
        }
    }


    public Customer getAccountHolder(){
        return this.accountHolder;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public String toString(){
        return "("+accountHolder.getName() + " "+accountHolder.getID()+") "+this.accountNumber + ": " + this.balance;
    }
    
    public void setAccountHolder(Customer c){
        this.accountHolder = c;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    public void deposit(double amount){
        if (amount < 0){
            System.out.println("Negative amount cannot be deposited.");
        } else {
        this.balance += amount;
        }
    }
    public void withdraw(double amount){
        if ((amount < 0) || (this.balance - amount < 0)){
            System.out.println("Out of fund.");
        }else {
            this.balance -= amount;
        }
    }
    
    
    public void transfer(double amount, BankAccount a){
        if(amount > this.getBalance())
            System.out.println("Insufficient funds to transfer");
        else{
            this.withdraw(amount);
            a.deposit(amount);
        }
    }
    
    
    public void monthEndUpdate(){
        if (this.balance - getMonthlyFeesAndInterest() < 0)
            setBalance(this.balance);
        else
            setBalance(this.balance + getMonthlyFeesAndInterest());
    }
    
    public void saveToTextFile(String fileName) throws IOException{
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.println(this.balance);
        printWriter.println(this.accountNumber);
        if (accountHolder == null){
            printWriter.println("null");
        }else
            this.accountHolder.save(printWriter);
        printWriter.close();
    }
}