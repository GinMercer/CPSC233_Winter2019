import java.util.Random;

/**creates a class called Customer which has a customer name and an integer account number*/
public class Customer{
	private String name;
	private int customerID;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Constructors

	public Customer(String name, int customerID){
		this.name = name;
		this.customerID = customerID;
	}

	public Customer(String name){
		this(name, 0);
	}

	public Customer(){
		this("Blank", 0);
	}


	public Customer(Customer account){	//copy constructor
		this.name = account.name;
		this.customerID = account.customerID;
	}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Methods

	/**returns all variables for a Customer object*/
	public String toString(){		
		return(name + " " + customerID);
	}

	public String getName(){ 	
		return name;
	}

	public int getID(){	
		return customerID;
	}

	public void changeID(int newID){		
		customerID = newID;
	}

	public void setName(String newName){
		name = newName;
	}

}