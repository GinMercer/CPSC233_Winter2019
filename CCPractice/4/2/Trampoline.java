public class Trampoline extends Bouncer {
	private int weightOfJumper = 140;
	
	public Trampoline(int weightOfJumper, double height){
		super(height);
		if(weightOfJumper >= 50 && weightOfJumper <= 300){
			this.weightOfJumper = weightOfJumper;
		}else{
			this.weightOfJumper = 140;
		}	
	}
	
	public Trampoline(Trampoline t){
		super(t);
		this.weightOfJumper = t.weightOfJumper;
	}
	
	public void setWeightOfJumper(int weight){
		if(weight >= 50 && weight <= 300){
			this.weightOfJumper = weight;
		}else{
			this.weightOfJumper = 140;
		}
	}
	
	public int getWeightOfJumper(){
		return this.weightOfJumper;
	}
	
	public double heightAfterBounces(int numOfBounces){
		double s = 0;
		s = ((weightOfJumper+super.getHeight())/(3.5 * super.getHeight()))*0.01; 
		double h = super.getHeight();
		for(int i = 0; i <= numOfBounces-1; i++){
			if(h <= 1){
				h = 0;	
			}else {
				h = h * s;
			}
		}
		return h;
	}
	
	public String toString(){
		return "[Trampoline] "+ super.toString();
	}
}