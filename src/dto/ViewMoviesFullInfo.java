package dto;

/**
 * Created by Vinty on 01.05.2017.
 */
public class ViewMoviesFullInfo {
    private long moviesId;
    private String nameMovies;
    private String genreMovies;
    private String countryMovies;
    private String yearMovies;
    private long peopleId;
    private String namePeople;
    private String familyPeople;
    private String nameRole;

    public ViewMoviesFullInfo(long moviesId, String nameMovies, long peopleId, String namePeople, String familyPeople, String nameRole) {
        this.moviesId = moviesId;
        this.nameMovies = nameMovies;
        this.peopleId = peopleId;
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.nameRole = nameRole;
    }

    public ViewMoviesFullInfo(String nameMovies, String genreMovies, String countryMovies, String yearMovies) {
        this.nameMovies = nameMovies;
        this.genreMovies = genreMovies;
        this.countryMovies = countryMovies;
        this.yearMovies = yearMovies;
    }

    public long getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(long moviesId) {
        this.moviesId = moviesId;
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

    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public String getFamilyPeople() {
        return familyPeople;
    }

    public void setFamilyPeople(String familyPeople) {
        this.familyPeople = familyPeople;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
