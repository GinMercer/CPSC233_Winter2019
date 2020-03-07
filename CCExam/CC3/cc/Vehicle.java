public class Vehicle{
	private String make;
	private String model;
	private int mileage;
	
	public Vehicle(String make, String model, int mileage) {
		this.make = make;
		this.model = model.toUpperCase();
		if (mileage >= 25){
			this.mileage = 0;
		}else if (mileage < 0){
			this.mileage = 0;
		}else{
			this.mileage = mileage;
		}
	}
	public Vehicle(Vehicle x){
		this.make = x.getMake().toLowerCase();
		this.model = x.getModel().toUpperCase();
		this.mileage = x.getMileage();
	}
	public String getModel() {
		return this.model.toUpperCase();
	}

	public void setModel(String model) {
		this.model = model.toUpperCase();
	}

	public String getMake() {
		return this.make.toLowerCase();
	}

	public void setMake(String make) {
		this.make = make.toLowerCase();
	}

	
	public int getMileage() {
		return this.mileage;
	}

	public void setMileage(int mileage) {
		if (mileage > 25){
			this.mileage = 12;
		}else if (mileage < 0){
			this.mileage = 13;
		}else{
			this.mileage = mileage;
		}

	}

	public String getFuelEfficiencyCategory(){
		String x;
		if (this.mileage > 14){
			x = "best";
		}else if(this.mileage >= 8 && this.mileage <= 14){
			x = "average";
		}else{
			x = "worst";
		}
		return x;
	}
	
	public String toString(){
		return this.getMake()+"-"+this.getModel()+"-"+getFuelEfficiencyCategory()+ " fuel efficiency";
	}
}