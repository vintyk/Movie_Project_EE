package servlet;
import Services.PeopleServices;
import dto.CreatePeopleDto;

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
        showPage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PeopleServices.getInstance().createNewPeople(getRequestForCrtPeople(req));
        showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", PeopleServices.getInstance().getAllPeople());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/actors.jsp").forward(req, resp);
    }

    private CreatePeopleDto getRequestForCrtPeople(HttpServletRequest request) {
        return new CreatePeopleDto(
                request.getParameter("namePeople"),
                request.getParameter("familyPeople"),
                request.getParameter("sNamePeople"),
                request.getParameter("dateOfBirthPeople"),
                Long.valueOf(request.getParameter("rolesId")));
    }

}