public class Predator extends Animal {
	private String huntStyle;
	
	public Predator(char type, int health, String huntStyle){
		super(type, health);
		if(huntStyle.equals("ambush") || huntStyle.equals("stalk")){
			this.huntStyle = huntStyle;
		}else{
			this.huntStyle = "ambush";
		}
	}
	public Predator(Predator d){
		super(d);
		this.huntStyle = d.huntStyle;
	}
	public String getHuntStyle(){
		return this.huntStyle;
	}
	public void setHuntStyle(String huntStyle){
		if(huntStyle.equals("ambush") || huntStyle.equals("stalk")){
			this.huntStyle = huntStyle;
		}else{
			this.huntStyle = "ambush";
		}
	}
	public double getRelativeHealth(){
		double a = 0;
		if(huntStyle.equals("ambush"))
			a = 1.5 * super.getHealth();
		else
			a =  0.75 * super.getHealth();
		return a;	
	}
	public String toString(){
			return "[Predator] " + super.toString() +" Hunt style: "+ this.getHuntStyle();
		}	
}