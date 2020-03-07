class Movie {
	private String title;
	private int rating;
	
	Movie(String t, int r){
		String a=t.toUpperCase();
		this.title=a;
		
		if(r>10){
			this.rating=0;
		}else if(r<0){
			this.rating=0;
		}else{
			this.rating=r;
		}	
	}
	
	Movie(Movie m){
		
	}
	
	public String getTitle(){
		return this.title;
	}
	public int getRating(){
		return this.rating;
	}
	
	public void setTitle(String t){
		this.title=t.toUpperCase();
	}
	public int setRating(int rating){
		if(r>10){
			this.rating=0;
		}else if(r<0){
			this.rating=0;
		}else{
			this.rating=r;
		}	
	}
	
	public char getCategory(){
		if (this.rating >= 9)
			return 'A';
		else if (this.rating >= 7)
			return 'B';
		else if (this.rating >= 5)
			return 'C';
		else if (this.rating >= 3)
			return 'D';
		else
			return 'F';
	}
}