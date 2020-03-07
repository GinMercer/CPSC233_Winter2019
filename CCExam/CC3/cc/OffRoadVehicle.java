public class OffRoadVehicle extends Vehicle{
	private String classification;
	
	public OffRoadVehicle(String make, String model, int mileage, String classification){
		super(make,model,mileage);
		if(classification=="Motorcycle"||classification=="Truck"||classification=="ATV")
			this.classification=classification;
		else
			this.classification=null;	
	}
	public OffRoadVehicle(OffRoadVehicle c){
		this(c.getMake(),c.getModel(),c.getMileage(),c.getClassification());
	}
	
	public String getClassification(){
		return this.classification;
	}
	public void setClassification(String classification){
		if(classification=="Motorcycle"||classification=="Truck"||classification=="ATV")
			this.classification=classification;
		else
			this.classification=null;
	}
	public String getFuelEfficiencyCategory(){
		String a; 
		if(super.getFuelEfficiencyCategory()=="best"){
			if(this.classification=="Motorcycle")
				a = "average";
			else if(this.classification=="ATV")
				a = "good";
			else if(this.classification=="Truck")
				a = "amazing";
			else
				a="best";
		}else if(super.getFuelEfficiencyCategory()=="average"){
			if(this.classification=="Motorcycle")
				a = "poor";
			else if(this.classification=="ATV")
				a = "average";
			else if(this.classification=="Truck")
				a = "good";
			else
				a="average";	
		}else{
			if(this.classification=="Motorcycle")
				a = "dismal";
			else if(this.classification=="ATV")
				a = "poor";
			else if(this.classification=="Truck")
				a = "average";
			else
				a="worst";	
		}
		return a ;
	}
}