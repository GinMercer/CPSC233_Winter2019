class Bouncer {
    private int height;
    private double bounciness;


    public Bouncer(double bounciness, int height) {
        if(height > 0)
            this.height = height;
        else
            this.height = 1;
        if(bounciness > 0.00 && bounciness < 1.00)
            this.bounciness = bounciness;
        else
            this.bounciness = 0.50;
    }

     Bouncer(Bouncer bouncer){
        this(bouncer.getBounciness(), bouncer.getHeight());
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if(height > 0)
            this.height = height;
        else
            this.height = 1;
    }

    public double getBounciness() {
        return this.bounciness;
    }

    public void setBounciness(double bounciness) {
        if(bounciness > 0.00 && bounciness < 1.00)
        this.bounciness = bounciness;
        else
        this.bounciness = 0.50;
    }

    public void bounce(){
        double a = this.getHeight() * getBounciness();
        this.height = (int) a;
    }

    public int numberOfBounces(){
       
        int heightCopy = this.getHeight();
        double a;
        int counter = 0;
        while(heightCopy > 0){
            a = heightCopy * this.getBounciness();
            heightCopy = (int) a;
            counter++;
        }
        
        
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Bouncer)) {
            return false;
        }
        Bouncer bouncer = (Bouncer) o;
        return height == bouncer.height && bounciness == bouncer.bounciness;
    }

    
}