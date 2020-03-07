public class Bouncer {
	private int height;
	private double bounciness;
	
	public Bouncer(double bounciness, int height){
		if(height<=0)
			this.height=1;
		else
			this.height=height;
		if(bounciness>0.00 && bounciness<1.00)
			this.bounciness=bounciness;
		else
			this.bounciness=0.50;			
	}
	public Bouncer(Bouncer b){
		this(b.getBounciness(),b.getHeight());
	}
	public void setHeight(int height){
		if(height<=0)
			this.height=1;
		else
			this.height=height;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setBounciness(double bounciness){
		if(bounciness>0.00 && bounciness<1.00){
			this.bounciness=bounciness;
		}else{
			this.bounciness=0.50;
		}	
	}
	
	public double getBounciness(){
		return this.bounciness;
	}
	
	public void bounce(){
		double height=this.getBounciness()*this.getHeight();
		this.height=(int)height;
	}
	public int numberOfBounces(){
		int counter = 0;
		if(this.getHeight() < 1)
			return counter;
		else{
			int n = this.getHeight();
			while(n!=0){
				n = (int)(this.getBounciness() * n);
				counter++;
			}
			return counter;
		}
	}
	public boolean equals(Bouncer b2){
		return this.bounciness==b2.getBounciness() && this.height==b2.getHeight();
	}
}