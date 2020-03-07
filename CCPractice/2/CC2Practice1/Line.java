public class Line {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end){
		this.start=start;
		this.end=end;
	}
	public Point getStart(){
		return start;
	}
	public Point getEnd(){
		return end;
	}
	public void setStart(Point start){
		this.start=start;
	} 
	public void setEnd(Point end){
		this.end=end;
	}
	public double getLength(){
		double length=start.getDistance(end);
		return length;
	}
}