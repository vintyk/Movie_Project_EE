package dto;

/**
 * Created by Vinty on 01.05.2017.
 */
public class ViewMoviesFullInfo {
    private String nameMovies;
    private String genreMovies;
    private String countryMovies;
    private String yearMovies;

    public ViewMoviesFullInfo(String nameMovies, String genreMovies, String countryMovies, String yearMovies) {
        this.nameMovies = nameMovies;
        this.genreMovies = genreMovies;
        this.countryMovies = countryMovies;
        this.yearMovies = yearMovies;
    }

    public String getNameMovies() {
        return nameMovies;
    }

    public void setNameMovies(String nameMovies) {
        this.nameMovies = nameMovies;
    }

    public String getGenreMovies() {
        return genreMovies;
    }

    public void setGenreMovies(String genreMovies) {
        this.genreMovies = genreMovies;
    }

    public String getCountryMovies() {
        return countryMovies;
    }

    public void setCountryMovies(String countryMovies) {
        this.countryMovies = countryMovies;
    }

    public String getYearMovies() {
        return yearMovies;
    }

    public void setYearMovies(String yearMovies) {
        this.yearMovies = yearMovies;
    }
}
