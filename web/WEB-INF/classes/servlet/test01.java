package servlet;

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
@WebServlet("/test01")
public class test01 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher
                =getServletContext().getRequestDispatcher("/WEB-INF/jsp/regOK.jsp");
        requestDispatcher.forward(req, resp);
    }
}
