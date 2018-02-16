/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movielist;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Scanner;

public class MovieList 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        boolean isMovie;
        boolean continueInterface = true;
        int choice = 0;
        movies newMovie;
        isMovie = addMovie();
        ArrayList<movies> userMovies = new ArrayList<>();
        Scanner choiceValue = new Scanner(System.in);
        //Iterator<movies> itr = userMovies.iterator();
        
        while ( isMovie )
        {
            newMovie = createMovie();
            userMovies.add(newMovie);
            
            isMovie = addMovie();
        }
        
        while ( continueInterface ) // starts off as true
        {
            System.out.println("What would you like to do with your movie list?");
            System.out.println("1: Add Movie\n2: Remove Movie\n3: Find Movie" +
                               "\n4: Print Movies\n5: Exit");
            String choiceString = choiceValue.nextLine();
            try 
            {
                choice = Integer.parseInt(choiceString);
            }
            catch(NumberFormatException e) { }
            
            switch (choice) // starts off as 0
            {
                case 1: userMovies.add(createMovie());
                        break;
                case 2: removeMovie(userMovies);
                        break;
                case 3: movieSearch(userMovies);
                        break;
                case 4: printMovies(userMovies);
                        break;
                case 5: continueInterface = false;
                        break;     
                default: System.out.println("Not a valid choice!");
                         break;
            }
        }
        System.out.println("You have a great taste in movies. Goodbye!");
    }
    
    //public static 
    //Determines if there is a movie to be added
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
    
    public static movies createMovie()
    { 
        System.out.println("What is the name of the movie you wish to add?");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine();
        
        System.out.println("What is the rating of the movie you wish to add? (G/PG/PG-13/R)");
        Scanner ra = new Scanner(System.in);
        String rating = ra.nextLine();
        while (!(rating.equals("G") || rating.equals("PG") || 
                rating.equals("PG-13") || rating.equals("R")))
        {
            System.out.println("Please enter a valid rating! (G/PG/PG-13/R)");
            rating = ra.nextLine();
        }
        
        System.out.println("What is the year of the movie you wish to add?");
        int year = 0;
        Scanner y = new Scanner(System.in);
        while (year == 0)
        {
            String yearString = y.nextLine();
            try {
                year = Integer.parseInt(yearString);
            }
            catch(NumberFormatException e){
                System.out.println("Not a valid value for year! Please enter movie year.");
            }
        //int year = y.nextInt();
        }
        
        System.out.println("What is the runtime of the movie you wish to add?");
        Scanner rt = new Scanner(System.in);
        int runtime = 0;
        while ( runtime == 0)
        {
            String runtimeString = rt.nextLine();
            try {
                runtime = Integer.parseInt(runtimeString);
            }
            catch (NumberFormatException e){
                System.out.println("Not a valid value for runtime! Please enter movie runtime.");
            }
        }
        movies movie = new movies(name, rating, year, runtime);
        return movie;
    }
    
    public static void movieSearch(ArrayList<movies> moviesToSearch)
    {
        System.out.println("What is the name of the movie you are looking for?");
        Scanner search = new Scanner(System.in);
        String title = search.nextLine();
        
        for( movies m : moviesToSearch)
        {
            if (m.getName().equalsIgnoreCase(title))
            {
                System.out.println("Your movie is number " + 
                (moviesToSearch.indexOf(m)+1) + " in the list.");
            }
            else 
                System.out.println("This movie is not in the list.");
        }
    }
    
    public static void printMovies(ArrayList<movies> moviesToPrint)
    {
        int movieNum = 0;
        for ( movies m : moviesToPrint )
        {
            movieNum++;
            System.out.println("Movie #" + movieNum);
            System.out.println(m.toString());
        }
    }
    
    public static void removeMovie(ArrayList<movies> moviesToRemove)
    {
        System.out.println("What is the name of the movie you want to remove?");
        Scanner toRemove = new Scanner(System.in);
        String removeName = toRemove.nextLine();
        
        for ( movies m : moviesToRemove )
        {
            if (m.getName().equalsIgnoreCase(removeName))
                moviesToRemove.remove(m);
            else 
                System.out.println("This movie is not in the list.");
        }
    }
}
