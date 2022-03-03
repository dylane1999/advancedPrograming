import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

public class Hw5Test {

    public static void test_redbox_readInMovies() {
        // 1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
        Redbox newRedbox = new Redbox();
        assertDoesNotThrow(() -> newRedbox.readMoviesFromFile("./moviedatabase.csv"));
        List<Movie> movies = newRedbox.getMovies();
        String expectedTitle = "Toy Story";
        Integer expectedId = 1;
        Integer expectedYear = 1995;
        Integer expectedGenreLength = 5;
        Movie firstMovie = movies.get(0);
        assertEquals(expectedTitle, firstMovie.getTitle());
        assertEquals(expectedId, firstMovie.getId());
        assertEquals(expectedYear, firstMovie.getYear());
        assertEquals(expectedGenreLength, firstMovie.getGenre().size());
    }

    public static void test_redbox_readInMovies_failureNoMovies() {
        // 1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
        Redbox newRedbox = new Redbox();
        assertThrows(
                RuntimeException.class,
                () -> newRedbox.readMoviesFromFile(""),
                "Expected redbox to throw err when no file to read.");

    }

    public static void test_redbox_readInMovies_readEmptyFile() {
        Redbox newRedbox = new Redbox();
        Integer expectedMovieLength = 0;
        assertDoesNotThrow(() -> newRedbox.readMoviesFromFile("./empty.csv"));
        assertEquals(expectedMovieLength, newRedbox.getMovies().size());
    }

    public static void main(String[] args) {
        test_redbox_readInMovies();
        test_redbox_readInMovies_failureNoMovies();
        test_redbox_readInMovies_readEmptyFile();
        Redbox newRedbox = new Redbox();
        newRedbox.readMoviesFromFile("./moviedatabase.csv");
        newRedbox.movieSearch();
        System.out.println("----- TESTS PASSED -----");
    }

}
