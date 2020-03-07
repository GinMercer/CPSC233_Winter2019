class Point{
    private int xcoord;
    private int ycoord;

    Point(int x, int y){
        if (x < 0)
            this.xcoord = 0;
        else
            this.xcoord = x;
        if (y < 0)
            this.ycoord = 0;
        else
            this.ycoord = y;
    }

    Point(Point p){
        this(p.getXCoord(), p.getYCoord());
    }

    public int getXCoord(){
        return this.xcoord;
    }

    public int getYCoord(){
        return this.ycoord;        
    }

    public void setXCoord(int x){
        if(x < 0)
            ;
        else
            this.xcoord = x;
    }

    public void setYCoord(int y){
        if(y < 0)
            ;
        else
            this.ycoord = y;
    }

    public void moveDown(int vertical){
        if (vertical < 0)
            ;
        else
            this.ycoord += vertical;
    }

    public void moveUp(int vertical){
        if (this.ycoord - vertical < 0)
            this.ycoord = 0;
        else
            this.ycoord -= vertical;
    }

    public void moveRight(int horizontal){
        if (horizontal < 0)
            ;
        else
            this.xcoord += horizontal;
    }

    public void moveLeft(int horizontal){
        if (this.xcoord - horizontal < 0)
            this.xcoord = 0;
        else
            this.xcoord -= horizontal;
    }

    public double distance(Point p2){
        return Math.sqrt(Math.pow(this.xcoord - p2.getXCoord(), 2)+(Math.pow(this.ycoord - p2.getYCoord(), 2)));
    }

    public boolean equals(Point p2){
        return this.xcoord == p2.getXCoord() && this.ycoord == p2.getYCoord();
    }
}