package servlet;
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
@WebServlet("/people-full-info2")
public class ActorsServletDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", PeopleServices.getInstance().getAllPeople());
        req.setAttribute("people_full", PeopleServices.getInstance().getFullInfo(Integer.valueOf(req.getParameter("peopleListDropdown"))));
        //resp.sendRedirect("/WEB-INF/jsp/moviesProject");
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/actors.jsp").forward(req, resp);

    }
}