package servlet;
import Services.PeopleServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/people-full-info")
public class PeopleFullInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people_full", PeopleServices.getInstance().getFullInfo(Integer.valueOf(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/people-full-info.jsp").forward(req, resp);
    }
}