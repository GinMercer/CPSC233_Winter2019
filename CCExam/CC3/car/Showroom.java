import java.util.ArrayList;

public class Showroom {
    private String name;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public Showroom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vehicle> getVehicleList() {
        ArrayList<Vehicle> list = new ArrayList<>(this.vehicleList.size());
        for (int i = 0; i < this.vehicleList.size(); i++) {
            Vehicle x = new Vehicle(this.vehicleList.get(i));
            list.add(x);
        }
        return list;
    }

    public void setVehicleList(ArrayList<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void addVehicle(Vehicle x){
        this.vehicleList.add(x);
    }

    public Vehicle vehicleWithMinFuelEfficiency(){
        Vehicle x ;
        if (this.vehicleList.size() != 0) {
            x = this.vehicleList.get(0);
            for (int i = 0; i < this.vehicleList.size() - 1; i++) {
                if (this.vehicleList.get(i).getMileage() > this.vehicleList.get(i + 1).getMileage()) {
                    x = new Vehicle(this.vehicleList.get(i + 1).getMake(),this.vehicleList.get(i + 1).getModel(),this.vehicleList.get(i + 1).getMileage());
                }
            }
        }else{
            x = null;
        }
        return x;
    }

    public double getAverageMileageByMake(String x){
        double s = 0;
        double y = 0;
        for (int i = 0; i < this.vehicleList.size(); i++) {
            if (this.vehicleList.get(i).getMake() == x){
                s = s + this.vehicleList.get(i).getMileage();
                y = y + 1;
            }
        }
        if (y == 0){
            y = 1;
        }
        double c = s / y;
        return c;
    }
}
