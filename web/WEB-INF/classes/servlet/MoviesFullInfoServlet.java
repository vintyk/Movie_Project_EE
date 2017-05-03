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

@WebServlet("/movies-full-info")
public class MoviesFullInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("moviesPeople_full", MovieServices.getInstance().getAllMoviesPeopleByMovieID(Integer.valueOf(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movies-full-info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("moviesPeople_full", MovieServices.getInstance().getAllMoviesPeopleByMovieID(Integer.valueOf(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/movies-full-info.jsp").forward(req, resp);
    }
}