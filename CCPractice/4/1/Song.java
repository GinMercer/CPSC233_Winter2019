public class Song extends StreamingMedia{
	private int numOfLikes = 0;
	
	public Song(String aTitle, int aLength){
		super(aTitle,aLength);
		
	}
	public Song(Song g){
		super(g);
		this.numOfLikes = g.numOfLikes;
	}
	
	public void addLikes(int amount){
		if(amount > 0){
			this.numOfLikes += amount;
		}
	}
	
	public int getRating(){
		if (getNumOfLikes() >= 5000)
			return 9;
		else if (getNumOfLikes() >= 500)
			return 7;
		else if (getNumOfLikes() >= 50)
			return 5;
		else if (getNumOfLikes() >= 10)
			return 3;
		else
			return 1;	
	}
	
	public int getNumOfLikes(){
		return this.numOfLikes;
	}
	
	public String toString(){
		return super.toString()+ " Likes: "+ this.getNumOfLikes();
	}
}