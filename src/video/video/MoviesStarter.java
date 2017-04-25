package video.video;
import video.Entity.Movies;

import java.util.List;

import static video.dao.MoviesDao.getMoviesByYear;

/**
 * Created by Vinty on 09.04.2017.
 */
public class MoviesStarter {
    public static void main(String[] args) {

//        Optional<Movies> moviesOptional
//                = MoviesDao.getInstance().save(new Movies("Джанго освобожденный", 4, 1, "2015.01.01"));
//        if (moviesOptional.isPresent()) {
//            System.out.println(moviesOptional.get());
//        }
//
        List<Movies> movies = getMoviesByYear(1994);
        movies.stream().forEach(System.out::println);

        //  addMovie("От заката до рассвета", 4, 1, "1992-01-01");
    }
}
