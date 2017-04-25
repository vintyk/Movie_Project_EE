package servlet;
import Services.PeopleServices;

import javax.servlet.HttpConstraintElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vinty on 14.04.2017.
 */
@WebServlet("/actors")
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", PeopleServices.getInstance().getAllPeople());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/actors.jsp").forward(req, resp);
        //        RequestDispatcher requestDispatcher
//                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actors.jsp");
//        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/actors.jsp");
        requestDispatcher.forward(req, resp);
    }

}