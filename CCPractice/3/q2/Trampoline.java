
class Trampoline extends Bouncer {
    private int weightOfJumper;

    public Trampoline(int weightOfJumper, double bounciness, int height) {
        super(bounciness, height);
        if(weightOfJumper>= 50 && weightOfJumper<=300){
            this.weightOfJumper = weightOfJumper;
        }
        else{
            this.weightOfJumper = 140;
        }
    }

    public Trampoline(Trampoline t) {
        this(t.getWeightOfJumper(), t.getBounciness(), t.getHeight());
    }


    public int getWeightOfJumper() {
        return this.weightOfJumper;
    }

    public void setWeightOfJumper(int weightOfJumper) {
        if(weightOfJumper>= 50 && weightOfJumper<=300){
            this.weightOfJumper = weightOfJumper;
        }
        else{
            this.weightOfJumper = 140;
        }
    }

    @Override
    public double getBounciness(){
        double result = 0.0;
        if (this.weightOfJumper < 100){
            //super.setBounciness(super.getBounciness() * 0.75);
            return result = super.getBounciness() * 0.75 > 0.99 ? 0.99 : super.getBounciness() * 0.75;
        }
        else if (this.weightOfJumper > 200){
            //super.setBounciness(super.getBounciness() * 1.20);
            return result = super.getBounciness() * 1.2 > 0.99 ? 0.99 : super.getBounciness() * 1.2;
        }
        else if (this.weightOfJumper > 150){
            //super.setBounciness(super.getBounciness() * 1.10);
            return result = super.getBounciness() * 1.1 > 0.99 ? 0.99 : super.getBounciness() * 1.1;
        }
        else{
            return result = super.getBounciness() > 0.99 ? 0.99 : super.getBounciness();
        }
    }


    public static void main(String[] args) {
        Trampoline c = new Trampoline(300, .84, 12345);
        System.out.println(c.numberOfBounces());
    }

}