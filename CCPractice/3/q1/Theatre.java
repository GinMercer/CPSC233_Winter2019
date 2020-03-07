

class Theatre {
    private String title;
    private int rating;

    Theatre(String aTitle, int aRating){
        this.title = aTitle.toUpperCase();
        if(aRating < 0 || aRating > 10)
            this.rating = 0;
        else
            this.rating = aRating;
    }

    Theatre(Theatre aCopy){
        this(aCopy.getTitle(), aCopy.getRating());
    }

    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        if(this.getRating() < 11 && this.getRating() > 8)
            return "A";
        else if (this.getRating() < 9 && this.getRating() > 6)
           return "B";
        else if (this.getRating() < 7 && this.getRating() > 4)
            return "C";
        else if (this.getRating() < 5 && this.getRating() > 2)
            return "D";
        else
            return "F";
    }

    public int getRating(){
        return this.rating;
    }

    public void setRating(int aRating){
        if(aRating < 0 || aRating > 10)
            ;
        else
            this.rating = aRating;
    }

    public void setTitle(String aTitle){
        this.title = aTitle.toUpperCase();
    }

    public static void main(String[] args) {
        Theatre c = new Theatre("", 0);
        System.out.println(c.getTitle());
        System.out.println(c.getRating());

    }
}