package servlet;

import Services.CountryServices;
import Services.GenresServices;
import Services.MovieServices;
import Services.PeopleServices;
import dto.CreateMoviesDto;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vinty on 20.04.2017.
 */
@WebServlet("/moviesProject")
public class MoviesProject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieServices.getInstance().createNewMovie(getRequestForCrtMovies(req));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genres", GenresServices.getInstance().getAllGenres());
        req.setAttribute("countries", CountryServices.getInstance().getAllCountries());
        req.setAttribute("movies", MovieServices.getInstance().getAllMovies());
        req.setAttribute("year", MovieServices.getInstance().getAllMoviesYear());
        //req.setAttribute("movies_full", MovieServices.getInstance().getFullInfo(Integer.valueOf(req.getParameter("moviesListDropdown"))));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/moviesProject.jsp").forward(req, resp);
    }
    private CreateMoviesDto getRequestForCrtMovies (HttpServletRequest request) {
        return new CreateMoviesDto(
                request.getParameter("nameMovie"),
                request.getParameter("dateOfMovie"),
                Long.valueOf(request.getParameter("genres")),
                Long.valueOf(request.getParameter("countries")));
    }
}