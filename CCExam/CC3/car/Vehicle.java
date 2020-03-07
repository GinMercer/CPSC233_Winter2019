public class Vehicle {
    private String make;
    private String model;
    private int mileage;
    private Vehicle vehicle;

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

    public String getMake() {
        return make.toLowerCase();
    }

    public void setMake(String make) {
        this.make = make.toLowerCase();
    }

    public String getModel() {
        return model.toUpperCase();
    }

    public void setModel(String model) {
        this.model = model.toUpperCase();
    }

    public int getMileage() {
        return mileage;
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
        }else if(this.mileage >= 8 && this.mileage <= 13){
            x = "average";
        }else{
            x = "worst";
        }
        return x;
    }
}
