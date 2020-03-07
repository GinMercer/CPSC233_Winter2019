public class Prey extends Animal {
	private String defence = "stampede";
	private int herdSize=1;
	
	public Prey(char type, int health, String defence){
		super(type,health);
		if(defence.equals("stampede") ||defence.equals("huddle")||defence.equals("hide")){
			this.defence = defence;	
		}
	}
	public Prey(Prey p){
		super(p);
		this.defence = p.defence;
		this.herdSize = p.herdSize;
	}
	
	public String getDefence(){
		return this.defence;
	}
	public void setDefence(String defence){
		if(defence.equals("stampede") ||defence.equals("huddle")||defence.equals("hide")){
			this.defence = defence;	
		}
	}
	public int getHerdSize(){
		return this.herdSize;
	}
	public void setHerdSize(int herdSize){
		if (herdSize >= 1) {
			this.herdSize = herdSize;
		}
	}
	public double getRelativeHealth(){
		double n = 0;
		if(defence.equals("hide")){
			n = super.getHealth();
		}else{
			n = super.getHealth() * this.herdSize * 0.1;
		}
		return n;
	}
		
	public String toString(){
		return "[Prey] " + super.toString() +" Defence: "+ this.getDefence();
	}
}