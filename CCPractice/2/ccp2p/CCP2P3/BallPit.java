import java.util.ArrayList;

class BallPit{
    private String name;
    private ArrayList<Ball> ballList = new ArrayList<Ball>();

    BallPit(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Ball> getBallList(){
        ArrayList<Ball> m3 = new ArrayList<Ball>();
        for (Ball a : this.ballList) {
            Ball b = new Ball(a);
            m3.add(b);
        }
        return m3;
    }

    public void addBall(Ball b){
        Ball b2 = new Ball(b);
        this.ballList.add(b2);
    }

    public Ball getBallWithMostBounces(){
        if (this.ballList.isEmpty())
            return null;
        else{
        Ball l = this.ballList.get(0);
        for (Ball m : this.getBallList()) {
            if (m.numberOfBounces() > l.numberOfBounces())
                l = m; 
        }
        Ball z = new Ball(l);
        return z;
        }
    }
}