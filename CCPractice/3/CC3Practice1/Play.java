public class Play extends Theatre {
	private String writer;
	private int yearWritten;
	
	public Play(String aTitle, int aRating, String aWriter, int aYearWritten){
		super(aTitle,aRating);
		this.writer=aWriter;
		if(aYearWritten>=2019)
			this.yearWritten=2018;
		else
			this.yearWritten=aYearWritten;
	}
	
	public Play(Play p){
		this(p.getTitle(),p.getRating(),p.getWriter(), p.getYearWritten());
	}
	
	public String getWriter(){
		return this.writer;
	}
	
	public void setWriter(String aWriter){
		this.writer=aWriter;
	}
	
	public int getYearWritten(){
		return this.yearWritten;
	}
	
	public void setYearWritten(int aYearWritten){
		if(aYearWritten>=2019)
			this.yearWritten=2018;
		else
			this.yearWritten=aYearWritten;
	}
	
	public String getCategory(){
		if(2019-yearWritten>200)
			return "Classic";
		else if(2019-yearWritten>50)
			return "Contemporary";
		else
			return "Modern";
	}
}