package servlet;

import video.Entity.MoviePeopleRole;
import video.dao.MoviePeopleRoleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 04.05.2017.
 */
@WebServlet("/moviesAddPeople")
public class MovieAddPeopleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String moviesId = req.getParameter("moviesId");
        String peopleId = req.getParameter("peopleId");
        String roleId = req.getParameter("roleId");
        MoviePeopleRoleDao.getInstance().create(new MoviePeopleRole(
                (Integer.valueOf(moviesId)),
                (Integer.valueOf(peopleId)),
                (Integer.valueOf(roleId))));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/WEB-INF/jsp/moviesProject.jsp").forward(req, resp);
        resp.sendRedirect("/moviesProject");
    }
}
