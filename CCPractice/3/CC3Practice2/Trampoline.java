public class Trampoline extends Bouncer {
	private int weightOfJumper;
	
	public Trampoline(int weightOfJumper,double bounciness,double height){
		super(bounciness,(int)height);
		if(weightOfJumper>=50 && weightOfJumper<=300){
			this.weightOfJumper=weightOfJumper;
		}else{
			this.weightOfJumper=140;
		}
	}
	public Trampoline(Trampoline t){
		this(t.getWeightOfJumper(),t.getBounciness(),t.getHeight());
	}
	
	public void setWeightOfJumper(int weight){
		if(weightOfJumper>=50 && weightOfJumper<=300){
			this.weightOfJumper=weightOfJumper;
		}else{
			this.weightOfJumper=140;
		}
	}
	public int getWeightOfJumper(){
		return this.weightOfJumper;
	}
	public double getBounciness(){
		double r=0.00;
		if(this.weightOfJumper<100){
			return r=super.getBounciness()*0.75;
		}else if(this.weightOfJumper>200){
			return r=super.getBounciness()*1.2;
		}else if(this.weightOfJumper>150) {
			return r=super.getBounciness()*1.1;
		}else{
			return r=super.getBounciness();
		}
	}
}