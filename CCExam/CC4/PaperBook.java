public class PaperBook extends Book {
	private int numPages;
	
	public PaperBook(String title, int numOfWords, int numOfPages){
		super(title, numOfWords);
		if(numOfPages > 0)
			this.numPages = numOfPages;
		else
			this.numPages = 1;	
	}
	public PaperBook(PaperBook p){
		super(p);
		this.numPages = p.numPages;
	}
	
	public int getNumPages(){
		return this.numPages;
	}
	public void setNumPages(int numPages){
		if(numPages > 0)
			this.numPages = numPages;
		else
			this.numPages = 1;
	}
	
	public int minutesToConsume(){
		int c;
		int ratio = super.getNumberOfWords() / this.numPages;
		if (ratio < 20){
			c = (int) (this.numPages * 0.5); 
		}else if (ratio >= 20 && ratio < 100){
			c = (int)(this.numPages * 1.0);
		}else if (ratio >= 100 && ratio < 250){
			c = (int)(this.numPages * 2.0);
		}else{
			c = (int)(this.numPages * 4.0);
		}
		return c;
	}
	
	public String toString(){
		return super.toString() + " Pages: " + this.getNumPages();
	}
}