public class Ball extends Bouncer {
	private int bounciness;
	
	public Ball(int bounciness, double height){
		super(height);
		if(bounciness > 0 && bounciness < 100)
			this.bounciness = bounciness;
		else
			this.bounciness = 50;	
	}
	
	public Ball(Ball a){
		this(a.getBounciness(),a.getHeight());
	}
	
	public void setBounciness(int bounciness){
		if(bounciness > 0 && bounciness < 100)
			this.bounciness = bounciness;
		else
			this.bounciness = 50;
	}
	
	public int getBounciness(){
		return this.bounciness;
	}
	
	public double heightAfterBounces(int numOfBounces){
		double h = super.getHeight();
		for(int i = 0; i <= numOfBounces-1; i++){
			if(h <= 1){
				h = 0;	
			}else {
				h = h * this.bounciness * 0.01;
			}
		}
		return h;
	}
	
	public String toString(){
		return "[Ball] " + super.toString()+" Bounciness: "+ this.getBounciness()+"%";
	}
}