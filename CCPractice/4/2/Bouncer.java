public abstract class Bouncer {
	private double height;
	public abstract double heightAfterBounces(int numOfBounces);
	
	
	public Bouncer(double height){
		if(height > 0)
			this.height = height;
		else
			this.height = 1.0;	
	}
	
	public Bouncer(Bouncer b){
		this.height = b.height;
	}
	
	protected void setHeight(double height){
		if(height > 0)
			this.height = height;
		else
			this.height = 1.0;
	}
	
	protected double getHeight(){
		return this.height;
	}
	
	public void bounce(){
		double h = heightAfterBounces(1);
		this.height = h;
	}

	public int numberOfBounces(){
		int numOfBounces = 0;
		double h = this.getHeight();
		while(h >= 1.0){
			numOfBounces++;
			h = heightAfterBounces(numOfBounces);
		}
		return numOfBounces;
	}
	
		
	public String toString(){
		return "Height: " + this.getHeight() +" Number of bounces: " + this.numberOfBounces();
	}
}