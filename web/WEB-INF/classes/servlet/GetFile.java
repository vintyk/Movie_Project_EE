package servlet;

import Services.MovieServices;
import Services.ReviewServices;
import dto.ViewReviewDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06.05.2017.
 */
@WebServlet("/getFile")
public class GetFile extends HttpServlet{
    String movieId;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        movieId = String.valueOf(req.getSession().getAttribute("moviesId"));
        List<ViewReviewDto> list = new ArrayList<>(ReviewServices.getInstance().getAllReviewByMovieID(Long.parseLong(movieId)));
        resp.setHeader("Content-Disposition", "attachment; filename=\"report_" + dateTime() + ".html\"");
        resp.getWriter().write(htmlHead());
        resp.getWriter().write("<body>");

        for (int i = 0; i < list.size(); i++) {
            String nameUser = list.get(i).getNameUser();
            String familyUser = list.get(i).getFamilyUser();
            long rank = list.get(i).getRank();
            String comment = list.get(i).getComment_user();
            int k = i + 1;
            resp.getWriter().write("<h4>" + k + ". Отзыв пользователя:" + nameUser + " " + familyUser + "</h4>");
            resp.getWriter().write("<p>Его оценка фильму: <strong>" + String.valueOf(rank) + "</strong></p>");
            resp.getWriter().write("<p>Комментарий к фильму: <em>" + comment + "</em></p>");
        }
        resp.getWriter().write("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
        }

    public String dateTime(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        String formatedTime = localTime.format(DateTimeFormatter.ofPattern("hh-mm-ss"));
        return String.valueOf(localDate + "_" + formatedTime);
    }

    public String htmlHead(){
        String head;
        return  head = "<!DOCTYPE html>\n" +
                "<HTML>\n" +
                "<HEAD>\n" +
                "<META charset=\"utf-8\">\n" +
                "<TITLE>Отчет</TITLE></h3>" +
                "</HEAD>";
    }
    private void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/reviews.jsp").forward(req, resp);
    }
}
