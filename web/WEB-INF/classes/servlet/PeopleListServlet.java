package servlet;
import Services.PeopleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/people-list")
public class PeopleListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", PeopleServices.getInstance().getAllPeople());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/people-list.jsp").forward(req, resp);
    }
}
