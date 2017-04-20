package servlet;

import Services.UserServices;
import video.Entity.Users;
import video.dao.UsersDao;

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
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType ("text/html;charset=utf-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        String eMailUser = req.getParameter("inputEmail");
        String passwordUser = req.getParameter("inputPassword");
        String nameUser = req.getParameter("inputName");
        String familyUser = req.getParameter("inputFamily");
        String sNameUser = req.getParameter("inputSname");
//        String privilegeUser = req.getParameter("privilegeUser");

        if        (nameUser == null
                || familyUser == null
                || passwordUser == null
                || eMailUser == null) {
            writer.write("Не все обязательные параметры определены!");
        }else
            UsersDao.getInstance().addUser(new Users(
                    nameUser,
                    familyUser,
                    sNameUser,
                    passwordUser,
                    eMailUser
            ));
            writer.write(nameUser + " "
                    + familyUser + " "
                    + sNameUser + " "
                    + passwordUser + " "
                    + eMailUser);
//        } else {
//            writer.write(nameUser + " "
//                    + familyUser + " "
//                    + sNameUser + " "
//                    + passwordUser + " "
//                    + privilegeUser + " "
//                    + eMailUser);
        }
    }


//http://localhost:8080/AddUser?nameUser=Петр&familyUser=Воронцов&sNameUser=Львович&passwordUser=1234&privilegeUser=2&eMailUser=vp@ecp.by