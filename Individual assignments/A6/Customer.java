public class Customer {
	int customerID;
	String name;

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
	
	Customer(){
		name = new String(); 
	}
	Customer(String name,int customerID){
		this.name = name;
		this.customerID = customerID; 
	}
	Customer(Customer oldCustomer){
		name = oldCustomer.getName();
		this.setID(oldCustomer.getID()); 
	}	
}