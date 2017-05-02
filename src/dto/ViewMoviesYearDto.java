package dto;

/**
 * Created by Vinty on 01.05.2017.
 */
public class ViewMoviesYearDto {
    private long id;
    private String name;
    private String dateReleaseMovie;

    public ViewMoviesYearDto(long id, String dateReleaseMovie) {
        this.id = id;
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public ViewMoviesYearDto(String name, String dateReleaseMovie) {
        this.dateReleaseMovie = dateReleaseMovie;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateReleaseMovie() {
        return dateReleaseMovie;
    }

    public void setDateReleaseMovie(String dateReleaseMovie) {
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
