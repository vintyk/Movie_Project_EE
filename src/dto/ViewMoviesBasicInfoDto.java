package dto;

/**
 * Created by Vinty on 01.05.2017.
 */
public class ViewMoviesBasicInfoDto {
    private long id;
    private String nameMovie;

    public ViewMoviesBasicInfoDto(long id, String nameMovie) {
        this.id = id;
        this.nameMovie = nameMovie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }
}
