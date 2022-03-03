import java.util.ArrayList;
import java.util.List;

public class Movie {

    // 1,Toy Story (1995),Adventure|Animation|Children|Comedy|Fantasy
    // Instance Variables:
    // a unique id,
    // a title,
    // a year,
    // and an ArrayList of genres where each genre is a String.
    private Integer id;
    private String title;
    private Integer year;
    private List<String> genre;

    public Movie() {
    }

    public Movie(Integer id, String title, Integer year) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = new ArrayList<String>();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getGenre() {
        return this.genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public void addGenre(String genre) {
        this.genre.add(genre);
    }





}
