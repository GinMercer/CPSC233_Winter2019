public class Movie extends StreamingMedia{
	private int rating;
	
	public Movie(String aTitle, int aLength, int aRating){
		super(aTitle,aLength);
		if (aRating > 10)
			this.rating = 0;
		else if (aRating < 0)
			this.rating = 0;
		else
			this.rating = aRating;
	}
	
	public Movie(Movie m){
		super(m);
		this.rating = m.rating;
		
	}
	
	public void setRating(int aRating){
		if (aRating > 10)
			this.rating = 5;
		else if (aRating < 0)
			this.rating = 3;
		else
			this.rating = aRating;
	}
	
	public int getRating(){
		return this.rating;
	}
	
	public String toString(){
		return  super.toString()+ " Rating: "+ this.getRating();
	}
}