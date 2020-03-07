import java.util.Calendar;
import java.util.Date;

class Movie extends Theatre {
    private String director;
    private Date releaseDate;
    private Date currenDate = new Date();
    private Calendar currentCalendar = Calendar.getInstance();

    Movie(String aTitle, int aRating, String aDirector, Date aReleaseDate){
        super(aTitle, aRating);
        this.director = aDirector;
        currentCalendar.add(Calendar.YEAR, 1);
        if(aReleaseDate.after(currentCalendar.getTime()))
            this.releaseDate = currenDate;
        else
            this.releaseDate = aReleaseDate;
    }

    Movie(Movie aCopy){
        this(aCopy.getTitle(), aCopy.getRating(), aCopy.getDirector(), aCopy.getReleaseDate());
    }

    public String getCategory(){
       return this.getReleaseDate() + "-"+ super.getCategory();
    }

    public String getDirector(){
        return this.director;
    }

    public Date getReleaseDate(){
        return this.releaseDate;
    }

    public void setDirector(String aDirector){
        this.director = aDirector;
    }

    public void setReleaseDate(Date aReleaseDate){
        if(aReleaseDate.after(currentCalendar.getTime()))
            this.releaseDate = currenDate;
        else
            this.releaseDate = aReleaseDate;
    }

    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


    public static void main(String[] args) {

        /*
        Date d = new Date();
        System.out.println(d);

        Calendar c = toCalendar(d);
        
        System.out.println(c.getTime());

        c.add(Calendar.YEAR, 1);

        System.out.println(c.getTime());

        Date e = c.getTime();


        if (e.after(d))
            System.out.println("yessss");
        */
       }
}