package servlet;
import video.Entity.Movies;
import video.connection.ConnectionManager;
import video.dao.UsersDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static video.dao.MovieDao.getMoviesByYear;
import static video.dao.PeopleDao.getPeopleByMovieId;
/**
 * Created by Vinty on 12.04.2017.
 */
@WebServlet ("/userList")
public class UserList extends HttpServlet {
    private Object List;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<table border=\"1\">");
        writer.write("<caption><h3>"+"Пользователи системы"+"</h3></caption>");
        writer.write("<tr>");
        writer.write("<th>Фамилия</th>");
        writer.write("<th>Имя</th>");
        writer.write("<th>Отчество</th>");
        writer.write("<th>Почта</th>");
        writer.write("<th>Пароль</th>");
        writer.write("<th>Id Привилегий</th>");
        writer.write("</tr>");
        // writer.write(String.valueOf(UsersDao.getInstance().getById(6L)));
        try(Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users")) {
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        writer.write("<tr>");
                        writer.write("<td>"+resultSet.getString("family")+"</th>");
                        writer.write("<td>"+resultSet.getString("name")+"</th>");
                        writer.write("<td>"+resultSet.getString("s_name")+"</th>");
                        writer.write("<td>"+resultSet.getString("e_mail")+"</th>");
                        writer.write("<td>"+resultSet.getString("password")+"</th>");
                        writer.write("<td>"+resultSet.getInt("privilege_id")+"</th>");
                    }
                    writer.write("</tr>");
                    writer.write("</table>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.write("</table>");
    }
}
