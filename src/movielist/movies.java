

package movielist;

/**
 * This class creates the movies object. Each movies object will contain four
 * data members: String movieName, String movieRating, int movieYear, and int
 * movieRuntime.
 * @author Grigor Sargsyan
 * Date: 2/19/2018
 */
public class movies 
{
    // Data members of movies
    private String movieName;
    final private String movieRating;
    final private int movieYear;
    final private int movieRuntime;
    
    /**
     * This is the default constructor.
     */
    public movies()
    {
        this.movieName = "";
        this.movieRating = "";
        this.movieYear = 0;
        this.movieRuntime = 0;
    }
    
    /**
     * This constructor takes in all four data members as arguments and creates 
     * a complete movies object to be used in MovieList.java
     * @param movieName
     * @param movieRating
     * @param movieYear
     * @param movieRuntime
     */
    public movies(String movieName, String movieRating, int movieYear, int movieRuntime)
    {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieYear = movieYear;
        this.movieRuntime = movieRuntime;
    }
    
    /**
     * Accessor used to retrieve the name of a movies object
     * @return String movieName
     */
    public String getName()
    {
        return this.movieName;
    }
    
    /**
     * Mutator used to set a movies object's name.
     * @param name
     */
    public void setName(String name)
    {
        movieName = name;
    }
    
    /**
     * Accessor used to retrieve the name of a movies object
     * @return String movieName
     */
    public int getYear()
    {
        return this.movieYear;
    }
    
    /**
     * Returns a print statement of the object's contents.
     * @return String
     */
    @Override
    public String toString()
    {
        return "The movie name is: " + movieName +
                "\nmovie rating is: " + movieRating +
                "\nmovie year is: " + movieYear +
                "\nmovie runtime is: " + movieRuntime;
    }
    
}
