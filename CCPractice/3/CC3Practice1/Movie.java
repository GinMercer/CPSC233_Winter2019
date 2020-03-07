import java.util.Date;
import java.util.Calendar;

public class Movie extends Theatre{
	private String director;
	private Date releaseDate;
	private Date d = new Date();
	private Calendar c = Calendar.getInstance();
	
	public Movie(String aTitle, int aRating,String aDirector, Date aReleaseDate){
		super(aTitle,aRating);
		this.director=aDirector;
		c.add(Calendar.YEAR, 1);
		if(aReleaseDate.after(c.getTime())){
			this.releaseDate=d;
		}else{
			this.releaseDate=aReleaseDate;
		}
	}
	
	public Movie(Movie m){
		this(m.getTitle(),m.getRating(),m.getDirector(), m.getReleaseDate());
	}
	
	public String getCategory(){
		return releaseDate + "-" + super.getCategory();
	}
	
	public String getDirector(){
		return this.director;
	}
	
	public void setDirector(String aDirector){
		this.director=aDirector;
	}
	
	public Date getReleaseDate(){
		return this.releaseDate;
	}
	
	
	public void setReleaseDate(Date aReleaseDate){
		if(aReleaseDate.after(c.getTime())){
			this.releaseDate=d;
		}else{
			this.releaseDate=aReleaseDate;
		}
	}
}