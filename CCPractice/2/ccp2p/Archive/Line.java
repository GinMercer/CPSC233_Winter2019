class Line {
    private Point start, end;

    Line(Point a, Point b){
        this.start = new Point(a);
        this.end = new Point(b);
    }

    public Point getStart(){
        Point start2 = new Point(this.start.getXCoord(), this.start.getYCoord()); 
        return start2;
    }

    public Point getEnd(){
        Point end2 = new Point(this.end.getXCoord(), this.end.getYCoord());
        return end2;
    }

    public void setStart(Point a){
        Point b = new Point(a);
        this.start = b;
    }

    public void setEnd(Point b){
        Point c = new Point(b);
        this.end = c;
    }

    public double length(){
        return this.getStart().distance(this.getEnd());
    }
}