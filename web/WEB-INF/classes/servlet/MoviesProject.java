package servlet;
import Services.*;
import dto.CreateMoviesDto;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Vinty on 20.04.2017.
 */
@WebServlet("/moviesProject")
public class MoviesProject extends HttpServlet {
//    private final static Logger log = Logger.getLogger(MoviesProject.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  this.process(req, resp);
            req.getSession().setAttribute("message", "Заполните все поля.");
            showPage(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this.process(req, resp);
        String userInputMovies = req.getParameter("nameMovie");
        String userInputDate = req.getParameter("dateOfMovie");
        if (userInputMovies.isEmpty() || userInputDate.isEmpty()) {
            doGet(req, resp);
            return;
        } else {
            MovieServices.getInstance().createNewMovie(getRequestForCrtMovies(req));
        }showPage(req, resp);
    }

    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genres", GenresServices.getInstance().getAllGenres());
        req.setAttribute("countries", CountryServices.getInstance().getAllCountries());
        req.setAttribute("movies", MovieServices.getInstance().getAllMovies());
        req.setAttribute("year", MovieServices.getInstance().getAllMoviesYear());
        req.setAttribute("people", PeopleServices.getInstance().getAllPeople());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/moviesProject.jsp").forward(req, resp);
    }

    private CreateMoviesDto getRequestForCrtMovies (HttpServletRequest request) {
        return new CreateMoviesDto(
                request.getParameter("nameMovie"),
                request.getParameter("dateOfMovie"),
                Long.valueOf(request.getParameter("genres")),
                Long.valueOf(request.getParameter("countries")));
    }

//    private String responseTemplate =
//            "<html>\n" +
//                    "<body>\n" +
//                    "<h2>Hello from Simple Servlet</h2>\n" +
//                    "</body>\n" +
//                    "</html>";
//
//    private void process(HttpServletRequest request, HttpServletResponse response)
//            throws IOException {
//        response.setStatus(200);
//        response.getWriter().write(responseTemplate);
//    }

}