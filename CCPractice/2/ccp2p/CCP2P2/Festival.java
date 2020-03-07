import java.util.*;

class Festival{
    private String name;
    private ArrayList<Movie> movieList = new ArrayList<Movie>();

    Festival(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Movie> getMovieList(){
        ArrayList<Movie> m3 = new ArrayList<Movie>();
        for (Movie a : this.movieList) {
            Movie b = new Movie(a);
            m3.add(b);
        }
        return m3;
    }

    public void addMovie(Movie m){
        Movie m2 = new Movie(m);
        this.movieList.add(m2);
    }

    public Movie getMovieWithLowestRating(){
        if (this.movieList.isEmpty())
            return null;
        else{
        Movie l = this.movieList.get(0);
        for (Movie m : this.movieList) {
            if (m.getRating() < l.getRating()){
                l = m;
            }
        }
        Movie z = new Movie(l);
        return z;
        }
    }
    /*
    public static void main(String[] args) {
        Festival c = new Festival("Test");
			Movie m1 = new Movie("MOVIE1", 7);
			Movie m2 = new Movie("MOVIE2", 7);
			Movie m3 = new Movie("MOVIE3", 5);
			Movie m4 = new Movie("MOVIE4", 10);
			Movie m5 = new Movie("MOVIE5", 9);
			Movie m6 = new Movie("MOVIE6", 4);
			c.addMovie(m1);
			c.addMovie(m2);
			c.addMovie(m3);
			c.addMovie(m4);
			c.addMovie(m5);
			c.addMovie(m6);
			
			ArrayList<Movie> list = c.getMovieList();
			
			list.get(0).setTitle("Changed1");
			list.get(1).setTitle("Changed2");
			list.get(2).setTitle("Changed3");
			list.get(3).setTitle("Changed4");
			list.get(4).setTitle("Changed5");
			list.get(5).setTitle("Changed6");
			
            list = c.getMovieList();
            
            for (Movie a : list) {
                System.out.println(a.getTitle());
                
            }
            
    }
    */
}