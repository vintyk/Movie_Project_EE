package dto;

/**
 * Created by Vinty on 30.04.2017.
 */
public class CreateMoviesDto {
        private String nameMovies;
        private String dateMovies;
        private long genreMovies;
        private long countriesMovies;

    public CreateMoviesDto(String nameMovies, String dateMovies, long genreMovies, long countriesMovies) {
        this.nameMovies = nameMovies;
        this.genreMovies = genreMovies;
        this.countriesMovies = countriesMovies;
        this.dateMovies = dateMovies;
    }

    public String getNameMovies() {
        return nameMovies;
    }

    public void setNameMovies(String nameMovies) {
        this.nameMovies = nameMovies;
    }

    public String getDateMovies() {
        return dateMovies;
    }

    public void setDateMovies(String dateMovies) {
        this.dateMovies = dateMovies;
    }

    public long getGenreMovies() {
        return genreMovies;
    }

    public void setGenreMovies(long genreMovies) {
        this.genreMovies = genreMovies;
    }

    public long getCountriesMovies() {
        return countriesMovies;
    }

    public void setCountriesMovies(long countriesMovies) {
        this.countriesMovies = countriesMovies;
    }
}
