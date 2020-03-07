public abstract class Book {
	private String title;
	private int numberOfWords;
	public abstract int minutesToConsume();
	
	public Book(String title, int numberOfWords){
		this.title = title;
		if(numberOfWords >=0 && numberOfWords <= 500000)
			this.numberOfWords = numberOfWords;
		else
			this.numberOfWords = 0;	
	}
	public Book(Book b){
		this(b.getTitle(), b.getNumberOfWords());
	}
	
	public String getTitle(){
		return this.title;
	}
	protected void setTitle(String title){
		this.title = title;
	}
	
	protected int getNumberOfWords(){
		return this.numberOfWords;
	}
	
	protected void setNumberOfWords(int wordsInBook){
		if(wordsInBook >=0 && wordsInBook <= 500000)
			this.numberOfWords = wordsInBook;
		else
			wordsInBook = 10;
	}
	
	public String difficulty(){
		String a;
		if(minutesToConsume() < 30){
			a = "Easy";
		}else if(minutesToConsume() < 120){
			a = "Moderate";
		}else if(minutesToConsume() < 240){
			a = "Hard";
		}else{
			a="Extra Challenge";
		}
		return a;		
	}
	
	public String toString(){
		return "Title: " + this.getTitle()+" Difficulty: "+ difficulty();
	}
}