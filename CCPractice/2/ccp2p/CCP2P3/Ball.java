class Ball {
    private double bounciness;
    private int height;

    Ball(double b, int h){
        if (b <= 0.00 || b >= 1.00)
            this.bounciness = 0.50;
        else
            this.bounciness = b;
        if(h <= 0)
            this.height = 1;
        else
            this.height = h;
    }

    Ball(Ball b){
        this(b.getBounciness(), b.getHeight());
    }

    public double getBounciness(){
        return this.bounciness;
    }

    public int getHeight(){
        return this.height;
    }

    public void setBounciness(double b){
        if (b <= 0.00 || b >= 1.01)
            this.bounciness = 0.50;
        else
            this.bounciness = b;
    }

    public void setHeight(double h){
        if(h <= 0)
            this.height = 1;
        else if (h > 0 && h < 1)
            this.height = 0;
        else
            this.height = (int) h;
    }

    public int numberOfBounces(){
        if(this.getHeight() < 1)
            return 0;
        else{
        int n = this.getHeight();
       
        int counter = 0;
        while(n != 0){
            n = n*  this.getBounciness();
            counter++;
        }


        return counter;
        }
    }

    public void bounce(){
        double r = this.getHeight() * this.getBounciness();
        this.setHeight(r);
    }

    public boolean equals(Ball b2){
        return this.bounciness == b2.getBounciness() && this.height == b2.getHeight();
    }

    /*
    public static void main(String[] args) {
        Ball c = new Ball(.99,1);
        System.out.println(c.getHeight());
        c.bounce();
        System.out.println(c.numberOfBounces());
        System.out.println(c.getHeight());
        
        /*
        Ball d = new Ball(.50,1);
        d.bounce();
        System.out.println(c.numberOfBounces());
        System.out.println(d.getHeight());
        

    }
    */
}