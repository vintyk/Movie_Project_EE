package servlet;

import dto.ArtistDto;

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
@WebServlet("/test03")
public class test03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtistDto artistDto = new ArtistDto("Madonna");
        String artist = req.getParameter("name");
        System.out.println(artist);
        RequestDispatcher requestDispatcher
                =getServletContext().getRequestDispatcher("/WEB-INF/jsp/save-artist.jsp");
        requestDispatcher.forward(req, resp);
    }
}
