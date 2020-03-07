class Ball {
	private double bounciness;
	private int height;
	
	Ball(double bounciness,int height){
		this.bounciness=bounciness;
		this.height=height;
	}
	Ball(Ball b){
		//this.bounciness=b.getBounciness();
		//this.height=b.getHeight();
		this(b.getBounciness(), b.getHeight());
	}
	
	public double getBounciness(){
		return this.bounciness;
	}
	public void setBounciness(double bounciness){
		if(bounciness<=0.0 || bounciness>=1.0){
			this.bounciness=0.5;
		}else{
			this.bounciness=bounciness;
		}
	}
	
	public int getHeight(){
		return this.height;
	}
	public void setHeight(int height){
		if(height<=0){
			this.height=1;
		}else{
			this.height=height;
		}
	}
	
	public int numberOfBounces(){
		int number=0;
		do{
			height=(int)(height*bounciness);
			number++;
		}while(height==0);
		return number;
	}
	
	public void bounce(){
		height=(int)(this.getHeight()*this.getBounciness());
		this.setHeight(height);	
	}
	
	public boolean equals(Ball b2){
		return this.bounciness==b2.getBounciness() && this.height==b2.getHeight();
	}
}