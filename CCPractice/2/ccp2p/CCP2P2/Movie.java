import javax.lang.model.util.ElementScanner6;

class Movie {
    private String title;
    private int rating;

    Movie(String t, int r){
        String a = t.toUpperCase();
        this.title = a;
        if (r > 10)
            this.rating = 0;
        else if (r < 0)
            this.rating = 0;
        else
            this.rating = r;
    }

    Movie(Movie m){
        this(m.getTitle(), m.getRating());
    }

    public String getTitle(){
        return this.title;
    }

    public int getRating(){
        return this.rating;
    }

    public void setTitle(String t){
        String a = t.toUpperCase();
        this.title = a;
    }

    public void setRating(int r){
        if (r > 10)
            ;
        else if (r < 0)
            ;
        else
            this.rating = r;
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