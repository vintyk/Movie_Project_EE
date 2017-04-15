package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vinty on 14.04.2017.
 */
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameUser = req.getParameter("nameUser");
        String familyUser = req.getParameter("familyUser");
        String sNameUser = req.getParameter("sNameUser");
        String passwordUser = req.getParameter("passwordUser");
        String privilegeUser = req.getParameter("privilegeUser");
        String eMailUser = req.getParameter("eMailUser");

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (nameUser == null
                || familyUser == null
                || sNameUser == null
                || passwordUser == null
                || privilegeUser == null
                || eMailUser == null) {
            writer.write("Не все обязательные параметры определены!");
        } else {
            writer.write(nameUser + " "
                    + familyUser + " "
                    + sNameUser + " "
                    + passwordUser + " "
                    + privilegeUser + " "
                    + eMailUser);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String nameUser = reader.readLine();
        String familyUser = reader.readLine();
        String sNameUser = reader.readLine();
        String passwordUser = reader.readLine();
        String privilegeUser = reader.readLine();
        String eMailUser = reader.readLine();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (nameUser == null
                || familyUser == null
                || sNameUser == null
                || passwordUser == null
                || privilegeUser == null
                || eMailUser == null) {
            writer.write("Не все обязательные параметры определены!");
        } else {
            writer.write(nameUser + " "
                    + familyUser + " "
                    + sNameUser + " "
                    + passwordUser + " "
                    + privilegeUser + " "
                    + eMailUser);
        }
    }
}

//http://localhost:8080/AddUser?nameUser=Петр&familyUser=Воронцов&sNameUser=Львович&passwordUser=1234&privilegeUser=2&eMailUser=vp@ecp.by