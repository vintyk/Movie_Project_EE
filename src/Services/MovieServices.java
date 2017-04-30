package Services;

import dto.CreateMoviesDto;
import video.Entity.Movies;
import video.Entity.People;
import video.dao.MoviesDao;
import video.dao.PeopleDao;

/**
 * Created by Vinty on 13.04.2017.
 */
public class MovieServices {
    private static final Object LOCK = new Object();
    private static MovieServices INSTANCE = null;

    private MovieServices() {
    }

    public static MovieServices getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieServices();
                }
            }
        }
        return INSTANCE;
    }

    public void createNewMovie(CreateMoviesDto dto) {
        MoviesDao.getInstance().create(new Movies(
                dto.getNameMovies(),
                dto.getDateMovies()),
                dto.getGenreMovies(),
                dto.getCountrieMovies());
    }
}