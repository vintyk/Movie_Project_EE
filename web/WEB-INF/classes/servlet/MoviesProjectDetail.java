package servlet;
import Services.CountryServices;
import Services.GenresServices;
import Services.MovieServices;
import Services.PeopleServices;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vinty on 14.04.2017.
 */
@WebServlet("/movies-full-info2")
public class MoviesProjectDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genres", GenresServices.getInstance().getAllGenres());
        req.setAttribute("countries", CountryServices.getInstance().getAllCountries());
        req.setAttribute("movies", MovieServices.getInstance().getAllMovies());
        req.setAttribute("year", MovieServices.getInstance().getAllMoviesYear());
        req.setAttribute("movies_year", MovieServices.getInstance().getAllMoviesByYear(req.getParameter("yearSelect")));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/moviesProject.jsp").forward(req, resp);
    }
}