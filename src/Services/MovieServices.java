package Services;

import dto.*;
import video.Entity.Movies;
import video.dao.MoviesDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                dto.getCountriesMovies());
    }

    public List<ViewMoviesBasicInfoDto> getAllMovies() {
        return MoviesDao.getInstance().findAll().stream()
                .map(moviesEntity -> new ViewMoviesBasicInfoDto(
                        moviesEntity.getId(),
                        moviesEntity.getNameMovie()))
                .collect(Collectors.toList());
    }

    public List<ViewMoviesYearDto> getAllMoviesYear() {
        return MoviesDao.getInstance().findAllYear().stream()
                .map(moviesEntity -> new ViewMoviesYearDto(
                        moviesEntity.getId(),
                        moviesEntity.getDateReleaseMovie()))
                .collect(Collectors.toList());
    }

    public ViewMoviesFullInfo getFullInfo(long id) {
        Optional<Movies> moviesOptional = MoviesDao.getInstance().findById(id);
        if (!moviesOptional.isPresent()) {
            throw new IllegalArgumentException("Не существует фильма с такими параметрами!");
        }
        Movies movies = moviesOptional.get();
        return new ViewMoviesFullInfo(
                movies.getNameMovie(),
                movies.getDateReleaseMovie(),
                movies.getGenres().getName(),
                movies.getCountries().getName());
    }
}