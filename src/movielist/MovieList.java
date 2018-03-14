
package movielist;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.util.Pair;

/**
 * This class contains the main method and uses the movies objects to create a
 * program that allows the user to create a list of movies. It also contains 
 * the methods used to perform functions upon the ArrayList which contains all
 * the movies objects.
 * @author Grigor Sargsyan
 * Date: 2/19/2018
 */

public class MovieList 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // var to determine if there exists a movie to add. Initialized to false.
        boolean isMovie;
        
        // Creates the ArrayList which will store all movies objects.
        movies newMovie;
        isMovie = addMovie();
        ArrayList<movies> userMovies = new ArrayList<>();
        //ArrayList <Pair <String,Integer> > userMovies = 
                //new ArrayList <Pair <String, Integer> > ();
        
        // while loop used by user to add all inital movies to movies list.
        while ( isMovie )
        {
            // creates and adds the movie.
            newMovie = createMovie();
            userMovies.add(newMovie);
            // asks user if he/she wishes to add another movie to list.
            isMovie = addMovie();
        }
        
        // holds value to determine which switch case action to perform.
        int choice = 0;
       
        // var to determine if user wishes to continue interacting w/ program.
        boolean continueInterface = true;
        Scanner choiceValue = new Scanner(System.in);
        
        // While loop used by user user to interact with movie list. Begins as true.
        while ( continueInterface )
        {
            System.out.println("What would you like to do with your movie list?");
            System.out.println("1: Add Movie\n2: Remove Movie\n3: Find Movie" +
                               "\n4: Print All Movies\n5: Exit");
            // Collects the users choice
            String choiceString = choiceValue.nextLine();
            try 
            {
                choice = Integer.parseInt(choiceString);
            }
            catch(NumberFormatException e) { /*do nothing*/ }
            
            // Switch case to execute user choice. Deafults choice to zero.
            switch (choice)
            {
                // Adds movie to movie list
                case 1: userMovies.add(createMovie());
                        break;
                // Removes movie from movie list
                case 2: removeMovie(userMovies);
                        break;
                // Searches list for a user chosen movie       
                case 3: movieSearch(userMovies);
                        break;
                // Prints all movies in list
                case 4: printMovies(userMovies);
                        break;
                // Exists switch case and program
                case 5: continueInterface = false;
                        break;     
                default: System.out.println("Not a valid choice!");
                         break;
            }
        }
        // Ending statement of the program once while loop becomes false
        System.out.println("You have a great taste in movies. Goodbye!");
    }
    
    /**
     * Used to determine if user has a movie to add.
     * @return boolean true if there is a movie to add else returns false.
     */
    public static boolean addMovie()
    {
        System.out.println("Do you have a movie to add? (Y/N)");
        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);
        in.nextLine();
        if (c == 'Y' || c == 'y')
            return true;
        return false;
    }
    
    /**
     * This method takes a user input for the movie name, rating, year, and 
     * runtime and creates a movies object with these entries.
     * @return movies object with user chosen data members
     */
    public static movies createMovie()
    { 
        // User enters movies object name
        System.out.println("What is the name of the movie you wish to add?");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        
        // User enters movies object rating
        System.out.println("What is the rating of the movie you wish to add? (G/PG/PG-13/R)");
        Scanner ra = new Scanner(System.in);
        String rating = ra.nextLine();
        // Enters while loop if rating choice was not valid
        while (!(rating.equals("G") || rating.equals("PG") || 
                rating.equals("PG-13") || rating.equals("R")))
        {
            System.out.println("Please enter a valid rating! (G/PG/PG-13/R)");
            rating = ra.nextLine();
        }
        
        // User enters movies object year
        System.out.println("What is the year of the movie you wish to add?");
        int year = 0;
        Scanner y = new Scanner(System.in);
        // while loop keeps going until year is no longer zero
        while (year == 0)
        {
            String yearString = y.nextLine();
            // checks if year entered is positive. If not resets year to zero.
            try {
                year = Integer.parseInt(yearString);
                if (year <= 0)
                {
                    System.out.println("Not a valid value for year! "
                        + "Please enter movie year.");
                    year = 0;
                }
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid value for year! "
                        + "Please enter movie year.");
            }
        }
        
        // User enters movies object runtime
        System.out.println("What is the runtime of the movie you wish to add?");
        Scanner rt = new Scanner(System.in);
        int runtime = 0;
        // while loop keeps going until runtime is no longer zero
        while ( runtime == 0)
        {
            String runtimeString = rt.nextLine();
            // checks if year entered is positive. If not resets runtime to zero.
            try {
                runtime = Integer.parseInt(runtimeString);
                if (runtime <= 0)
                {
                    System.out.println("Not a valid value for runtime! "
                        + "Please enter movie runtime.");
                    runtime = 0;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid value for runtime! "
                        + "Please enter movie runtime.");
            }
        }
        // Creates a movies object with the users inputs and returns the object
        movies movie = new movies(name, rating, year, runtime);
        return movie;
    }
    
    /**
     * Return the position of the movie in the movie list. No functionality yet
     * for name duplicates.
     * @param moviesToSearch
     */
    public static void movieSearch(ArrayList<movies> moviesToSearch)
    {
        System.out.println("What is the name of the movie you are looking for?");
        Scanner search = new Scanner(System.in);
        String title = search.nextLine();
        System.out.println("What is the year of the movie you are looking for?");
        int year = -1;
        String yearString = "";
        while ( year == -1)
        {
            yearString = search.nextLine();
            // checks if year entered is positive. If not resets runtime to -1.
            try {
                year = Integer.parseInt(yearString);
                if (year < 0)
                {
                    System.out.println("Not a valid value for year! "
                        + "Please enter movie year.");
                    year = -1;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid value for year! "
                        + "Please enter movie year.");
            }
        }
        
        // loops through the movie list until a movie with the same name is found.
        boolean found = false;
        for( movies m : moviesToSearch)
        {
            if (m.getName().equalsIgnoreCase(title))
            {
                if ( m.getYear() == year )
                {
                    System.out.println("Your movie is number " + 
                        (moviesToSearch.indexOf(m)+1) + " in the list.");
                    found = true;
                }
                else 
                    System.out.println("This movie is not in the list.");
            }
            else 
                System.out.println("This movie is not in the list.");
            if (found)
                break;
        }
    }
    
    /**
     * Returns an output file in toString format of all the movies in the list 
     * and their positions
     * @param moviesToPrint
     */
    public static void printMovies(ArrayList<movies> moviesToPrint)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Name of output file:");
        String outputFileName = input.next();
        
        try {
            PrintWriter writer = new PrintWriter(outputFileName);
            int movieNum = 0;
            for ( movies m : moviesToPrint )
            {
                movieNum++;
                writer.println("Movie #" + movieNum);
                writer.println(m.toString());
            }
            if (movieNum == 0)
                writer.println("Your movie list is empty!");
            
            writer.close();
        }
        catch (IOException ex) {}
    
    }
    
    /**
     * Searches for the movie in the movie list and deletes the first object 
     * with the same name. No functionality yet for name duplicates.
     * @param moviesToRemove
     */
    public static void removeMovie(ArrayList<movies> moviesToRemove)
    {
        System.out.println("What is the name of the movie you want to remove?");
        Scanner toRemove = new Scanner(System.in);
        String removeName = toRemove.nextLine();
        System.out.println("What is the year of the movie you want to remove?");
        int year = -1;
        String yearString = "";
        while ( year == -1)
        {
            yearString = toRemove.nextLine();
            // checks if year entered is positive. If not resets runtime to -1.
            try {
                year = Integer.parseInt(yearString);
                if (year < 0)
                {
                    System.out.println("Not a valid value for year! "
                        + "Please enter movie year.");
                    year = -1;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid value for year! "
                        + "Please enter movie year.");
            }
        }
        
        boolean removed = false;
        // Loops through array to find the movie
        for ( movies m : moviesToRemove )
        {
            if (m.getName().equalsIgnoreCase(removeName))
                if (m.getYear() == year)
                {
                    moviesToRemove.remove(m);
                    removed = true;
                }
                else 
                    System.out.println("This movie is not in the list.");
            else 
                System.out.println("This movie is not in the list.");
            if (removed)
                break;
        }
    }
}
