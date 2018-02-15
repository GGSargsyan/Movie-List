/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movielist;
//import java.util.Iterator;

/**
 *
 * @author Grigor Sargsyan
 */
public class movies 
{
    private String movieName;
    private String movieRating;
    private int movieYear;
    private int movieRuntime;
    
    //Iterator<movies> itr = userMovies.iterator();
    public movies()
    {
        this.movieName = "";
        this.movieRating = "";
        this.movieYear = 0;
        this.movieRuntime = 0;
    }
    
    public movies(String movieName, String movieRating, int movieYear, int movieRuntime)
    {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieYear = movieYear;
        this.movieRuntime = movieRuntime;
    }
    
    /**
     *
     * @return
     */
    public String getName()
    {
        return this.movieName;
    }
    
    public void setName(String name)
    {
        movieName = name;
    }
    
    @Override
    public String toString()
    {
        return "The movie name is: " + movieName +
                "\nmovie rating is: " + movieRating +
                "\nmovie year is: " + movieYear +
                "\nmovie runtime is: " + movieRuntime;
    }
    
}
