import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Redbox {

    private List<Movie> movies;

    public List<Movie> getMovies() {
        return this.movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    // 1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy

    public void readMoviesFromFile(String movieFilePath) {
        try {
            File file = new File(movieFilePath);
            Scanner fileScan = new Scanner(file);
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                Movie movie = getMovieFromCsvLine(line);
                this.movies.add(movie);
            }
            fileScan.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("failed to read movies list");
        }
    }

    public Movie getMovieFromCsvLine(String line) { // year is last 6 chars
        // 1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy

        String[] splitString = line.split(",");
        Integer id = Integer.parseInt(splitString[0]);
        String title = splitString[1].substring(0, splitString[1].length() - 7);
        Integer year = Integer
                .parseInt(splitString[1].substring(splitString[1].length() - 5, splitString[1].length() - 1));
        Movie movie = new Movie(id, title, year);
        String encodedGenres = splitString[2];

        for (String genre : encodedGenres.split("\\|")) {
            movie.addGenre(genre);
        }
        return movie;

    }

    public void movieSearch() {
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(
                        "\nWelcome to Redbox!\nEnter 1 to rent by movie title.\nnter 2 to rent by year.\nEnter 3 to rent by genre.\nEnter q to quit.\n");
                String userChoice = scanner.nextLine();
                if (userChoice.equals("1")) {
                    System.out.println("Enter the movie title:");
                    String movieTitle = scanner.nextLine();
                    movieTitle = movieTitle.strip(); // Read user input
                    List<Movie> results = new ArrayList<>();
                    for (Movie movie : getMovies()) {
                        if (movie.getTitle().contains(movieTitle)) {
                            results.add(movie);
                        }
                    }
                    System.out.println("Here are the movies we found:");
                    if (results.isEmpty()) {
                        System.out.println("No Movies Found!");
    
                    } else {
                        for (Movie movie : results) {
                            System.out.println(movie.getTitle());
                        }
                    }
    
                } else if (userChoice.equals("2")) {
                    System.out.println("Enter the movie year:");
                    String line = scanner.nextLine();
                    Integer movieYear = Integer.parseInt(line.strip()); // Read user input
                    List<Movie> results = new ArrayList<>();
                    for (Movie movie : getMovies()) {
                        if (movie.getYear().equals(movieYear)) {
                            results.add(movie);
                        }
                    }
                    System.out.println("Here are the movies we found:");
                    if (results.isEmpty()) {
                        System.out.println("No Movies Found!");
    
                    } else {
                        for (Movie movie : results) {
                            System.out.println(movie.getTitle());
                        }
                    }
    
                } else if (userChoice.equals("3")) {
                    System.out.println("Enter the movie genre:");
                    String movieGenre = scanner.nextLine().strip(); // Read user input
                    List<Movie> results = new ArrayList<>();
                    for (Movie movie : getMovies()) {
                        if (movie.getGenre().contains(movieGenre)) {
                            results.add(movie);
                        }
                    }
                    System.out.println("Here are the movies we found:");
                    if (results.isEmpty()) {
                        System.out.println("No Movies Found!");
    
                    } else {
                        for (Movie movie : results) {
                            System.out.println(movie.getTitle());
                        }
                    }
    
                } else if (userChoice.equals("q")) {
                    scanner.close();
                    return;
                } else {
                    System.out.println("Invalid Choice.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("failure in redbox program");
            }
        }

    }

    public Redbox() {
        movies = new ArrayList<Movie>();
    }

}
