package video.Entity;

/**
 * Created by Vinty on 06.04.2017.
 */
public class Movies {
    private long id;
    private String nameMovie;
    private long genreMovie;
    private long countrieMovie;
    private String dateReleaseMovie;
    private Genres genres;
    private Countries countries;

    public Movies(long id, String dateReleaseMovie) {
        this.id = id;
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public Movies(String nameMovie, String dateReleaseMovie) {
        this.nameMovie = nameMovie;
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public Movies(long id, String nameMovie, String dateReleaseMovie, Genres genres, Countries countries) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.dateReleaseMovie = dateReleaseMovie;
        this.genres = genres;
        this.countries = countries;
    }

    public Movies(long id, String nameMovie, long genreMovie, long countrieMovie,
                  String dateReleaseMovie) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
        this.countrieMovie = countrieMovie;
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public Movies(String nameMovie, long genreMovie, long countrieMovie, String dateReleaseMovie){
        this.nameMovie = nameMovie;
        this.genreMovie = genreMovie;
        this.countrieMovie = countrieMovie;
        this.dateReleaseMovie = dateReleaseMovie;
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

    public long getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(long genreMovie) {
        this.genreMovie = genreMovie;
    }

    public long getCountrieMovie() {
        return countrieMovie;
    }

    public void setCountrieMovie(long countrieMovie) {
        this.countrieMovie = countrieMovie;
    }

    public String getDateReleaseMovie() {
        return dateReleaseMovie;
    }

    public void setDateReleaseMovie(String dateReleaseMovie) {
        this.dateReleaseMovie = dateReleaseMovie;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }
}
