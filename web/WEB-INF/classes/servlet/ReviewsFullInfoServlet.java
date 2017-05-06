package servlet;

import Services.MovieServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 05.05.2017.
 */
public class ReviewsFullInfoServlet {
    @WebServlet("/reviewsFullInfo")
    public class Reviews extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            showPage(req, resp);
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            showPage(req, resp);
        }

        private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("movies", MovieServices.getInstance().getAllMovies());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/reviews.jsp").forward(req, resp);
        }
    }
}
