public abstract class StreamingMedia {
	private String title;
	private int length=10;
	public abstract int getRating();
	
	public StreamingMedia(String aTitle, int aLength){
		this.title = aTitle.toUpperCase();
		if(aLength > 0)
			this.length = aLength;	
	}
	
	public StreamingMedia(StreamingMedia s){
		this(s.getTitle(), s.getLength());
	}
	
	public String getTitle(){
		return this.title.toUpperCase();
	}
	
	protected void setTitle(String aTitle){
		this.title = aTitle.toUpperCase();
	}
	
	public int getLength(){
		return this.length;
	}
	
	protected void setLength(int aLength){
		if(aLength > 0)
			this.length = 10;
	}
	
	public char getCategory(){
		if (getRating() >= 9)
			return 'A';
		else if (getRating() >= 7)
			return 'B';
		else if (getRating() >= 5)
			return 'C';
		else if (getRating() >= 3)
			return 'D';
		else
			return 'F';
	}
	
	public String toString(){
		return "Title: "+this.getTitle()+ " Length: "+this.getLength();
	}
}