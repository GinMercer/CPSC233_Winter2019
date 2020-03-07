public class Theatre {
	private String title;
	private int rating;
	
	
	public Theatre(String aTitle, int aRating){
		String a = aTitle.toUpperCase();
		this.title=a;
		if (aRating > 10)
			this.rating = 0;
		else if (aRating < 0)
			this.rating = 0;	
		else
			this.rating = aRating;
	}
	
	public Theatre(Theatre t){
		this(t.getTitle(), t.getRating());
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setTitle(String aTitle){
		this.title=aTitle.toUpperCase();
	}
	
	public String getCategory(){
		if (this.rating >= 9)
			return "A";
		else if (this.rating >= 7)
			return "B";
		else if (this.rating >= 5)
			return "C";
		else if (this.rating >= 3)
			return "D";
		else
			return "F";
	}
	
	public int getRating(){
		return this.rating;
	}
	
	public void setRating(int aRating){
		if (aRating > 10)
			;
		else if (aRating < 0)
			;	
		else
			this.rating = aRating;
	}
}