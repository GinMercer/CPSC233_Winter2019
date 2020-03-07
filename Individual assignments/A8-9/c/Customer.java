import java.io.*;
import java.io.IOException;

public class Customer {
    private String name;
    private int customerID;


    Customer(){
        
    } 
    Customer(String a, int b){
        this.name = a;
        this.customerID = b;
    }
    Customer(Customer c){
        this(c.name, c.customerID);
    }
    
    public Customer(BufferedReader bufferedReader) throws IOException{
        String line;
        if (bufferedReader.ready()) {
            this.name = "Bob";
            this.customerID = 1234;
        }
        line = bufferedReader.readLine(); 
        if (line.equals("null")) {
            throw new IOException("Customer is null in file");
        }else{
            this.name = line;
            line = bufferedReader.readLine();
            if (line == null){
                throw new IOException("No customer ID found in file");
            }else{
                this.customerID = Integer.parseInt(line);
            } 
        }
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.customerID;
    }

    public void setName(String a){
        this.name = a;
    }

    public void setId(int b){
        this.customerID = b;
    }

    public String toString(){
        return this.name + " " + this.customerID;
    }

    public void save(PrintWriter printWriter) throws IOException{
        printWriter.println(this.name);
        printWriter.println(this.customerID);
        printWriter.close();
    }
}