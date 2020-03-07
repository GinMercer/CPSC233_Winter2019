public class Play extends Theatre{
    private String writer;
    private int yearWritten;

    public Play(String aTtitle, int aRating, String writer, int yearWritten) {
        super(aTtitle, aRating);
        this.writer = writer;
        if (yearWritten >= 2019)
            this.yearWritten = 2018;
        else
            this.yearWritten = yearWritten;
    }

    public String getWriter() {
        return this.writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getYearWritten() {
        return this.yearWritten;
    }

    public void setYearWritten(int yearWritten) {
        if (yearWritten >= 2019)
            this.yearWritten = 2018;
        else
            this.yearWritten = yearWritten;
    }

    public String getCategory(){
        if(2018 - this.getYearWritten() >= 200)
            return "Classic";
        else if(2018 - this.getYearWritten() >= 50)
            return "Contemporary";
        else
            return "Modern";
    }

}