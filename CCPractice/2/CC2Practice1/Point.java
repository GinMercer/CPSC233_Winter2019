public class Point {
	private int xcoord;
	private int ycoord;
	
	public Point(int xcoord, int ycoord){
		this.xcoord=xcoord;
		this.ycoord=ycoord;
	}
	public Point(Point point){
		this.xcoord=point.xcoord;
		this.ycoord=point.ycoord;
	}
	
	
	public int getXcoord(){
		return xcoord;
	}
	public int getYcoord(){
		return ycoord;
	}
	public void setXcoord(int xcoord){
		if(xcoord>0){
			this.xcoord=xcoord;
		}else{
			System.out.println("X coordinate can't be nagetive");
		}
	}
	public void setYcoord(int ycoord){
		if(ycoord>0){
			this.ycoord=ycoord;
		}else{
			System.out.println("Y coordinate can't be nagetive");
		}
	}

	
	public void moveUp(int y){
		this.ycoord=this.ycoord-y;
	}
	public void moveDown(int y){
		this.ycoord=this.ycoord+y;	
	}
	public void moveRight(int x){
		this.xcoord=this.xcoord+x;
	}
	public void moveLeft(int x){
		this.xcoord=this.xcoord-x;
	}
	
	public double getDistance(Point point){
		int x =point.getXcoord();
		int y =point.getYcoord();
		double distance= Math.sqrt(Math.pow((this.xcoord - x), 2) + Math.pow((this.ycoord - y), 2));
		return distance;
	}	
	public boolean equals(Point point){
		if(xcoord!=point.xcoord){
			return false;
		}
		if(ycoord!=point.ycoord){
			return false;
		}
		return true;
	}
}