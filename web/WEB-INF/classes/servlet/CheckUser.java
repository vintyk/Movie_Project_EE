package servlet;
import Services.UserServices;
import servlet.Dispatcher;
import video.Entity.Users;
import video.dao.UsersDao;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Created by Vinty on 13.04.2017.
 */
public class CheckUser extends Dispatcher {
//    public String getServletInfo(){
//        return "Проверка пользователя (servlet)";
//    }
//    public void service(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        UsersServices usersServices = UserServices.findUser(request.getParameter("user"));
//        if (usersDao == null){
//            this.forward("/registration.html", request, response);
//        } else {
//            if
//                    (!usersDao.getPassword().equals(request.getParameter("password"))){
//                this.forward("/registration.html", request, response);
//            } else {
//                this.forward("/successLogin.jsp", request, response);
//            }
//        }
//    }

}
