package servlet;
import Services.MovieServices;
import video.Entity.Review;
import video.dao.ReviewDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Vinty on 14.04.2017.
 */
@WebServlet("/reviews")
public class Reviews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = String.valueOf(session.getAttribute("userId"));
        String movieId = req.getParameter("moviesId");
        String rank = req.getParameter("rank");
        String commentUser = req.getParameter("comment_user");

        System.out.println(commentUser);
        ReviewDao.getInstance().create(new Review(
                (Integer.valueOf(movieId)),
                (Integer.valueOf(userId)),
                (Integer.valueOf(rank)),
                commentUser));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("movies", MovieServices.getInstance().getAllMovies());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/reviews.jsp").forward(req, resp);
    }
}