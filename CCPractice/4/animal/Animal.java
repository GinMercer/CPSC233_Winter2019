public abstract class Animal {
	private char type;
	private int health;
	public abstract double getRelativeHealth();
	
	public Animal(char type, int health){
		if(type == 'm' || type == 'b' || type == 'f'||type == 'r'||type == 'n'||type == 'a'){
			this.type = type;	
		}else{
			this.type = 'n';
		}
		if(health > 0){
			this.health = health;
		}else{
			this.health = 50;
		}
	}
	
	public Animal(Animal a){
		this(a.getType(),a.getHealth());
	}
	
	public char getType(){
		return this.type;
	}
	protected void setType(char type){
		if(type == 'm' || type == 'b' || type == 'f'||type == 'r'||type == 'n'||type == 'a'){
			this.type = type;	
		}else{
			this.type = 'n';
		}	
	}
	public int getHealth(){
		return this.health;
	}
	public void setHealth(int health){
		if(health > 0){
			this.health = health;
		}else{
			this.health = 50;
		}
	}
	public String getStatus(){
		if (getRelativeHealth() < 75 && this.getRelativeHealth() >= 50)
			return "good";
		else if (getRelativeHealth() <50 && this.getRelativeHealth() >= 25)
			return "tenuous";
		else if (getRelativeHealth() < 25)
			return "critical";
		else
			return "excellent";
	}
	
	public String toString(){
		return "Type: "+ this.getType()+" Health: "+ this.getRelativeHealth();
	}
}