import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Customer {
	int customerID;
	String name;
	

	Customer(){
		name = new String(); 
	}
	Customer(String name,int customerID){
		this.name = name;
		this.customerID = customerID; 
	}
	Customer(Customer oldCustomer){
		this.name = oldCustomer.name;
		this.customerID = oldCustomer.customerID;
	}	
	
	Customer(BufferedReader br) throws IOException{
		if (br == null) {
			customerID = 0;
			name = "";
		} else {
			name = br.readLine();
			if (name == null){
				throw new IOException("Customer is null in file");
			}else{
				this.name = name;
			}
			
			customerID = br.read();
			if (customerID == -1){
				throw new IOException("No customer ID found in file");
			}else{
				this.customerID = customerID;
			}
		}
	}
	
	public void save(PrintWriter pw) throws IOException{
		pw.println(this.getName());
		pw.println(this.getID());
		pw.flush();
		pw.close();
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getID(){
		return customerID;
	}	
	public void setID(int customerID){
		this.customerID = customerID;
	}
	public String toString(){
		return  name + " " + customerID;
	}
}