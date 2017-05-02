package servlet;
import Services.UserServices;
import video.Entity.Users;
import video.dao.UsersDao;

import javax.servlet.RequestDispatcher;
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
        RequestDispatcher requestDispatcher
                =getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType ("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        String nameJSP = "";
        PrintWriter writer = resp.getWriter();
        String eMailUser = req.getParameter("inputEmail");
        String passwordUser = req.getParameter("inputPassword");
        String nameUser = req.getParameter("inputName");
        String familyUser = req.getParameter("inputFamily");
        String sNameUser = req.getParameter("inputSname");
//        String privilegeUser = req.getParameter("privilegeUser");
        if        (nameUser.equals("")
                || familyUser.equals("")
                || passwordUser.equals("")
                || eMailUser.equals("")) {
        nameJSP = "registration.jsp";
        }else {
            UsersDao.getInstance().addUser(new Users(
                    nameUser,
                    familyUser,
                    sNameUser,
                    passwordUser,
                    eMailUser
            ));
            nameJSP = "regOK.jsp";
        }
        RequestDispatcher requestDispatcher
                = getServletContext().getRequestDispatcher("/WEB-INF/jsp/" + nameJSP);
        requestDispatcher.forward(req, resp);
        }
    }
