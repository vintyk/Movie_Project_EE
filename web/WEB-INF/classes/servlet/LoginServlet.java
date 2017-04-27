package servlet;

        import Services.PeopleServices;
        import Services.UserServices;
        import dto.ViewUserByEmailDto;
        import video.Entity.Users;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInputEmail = req.getParameter("inputEmail");
        String userInputPassword = req.getParameter("inputPassword");
        //req.setAttribute("message", "");

        if (userInputEmail.isEmpty() || userInputPassword.isEmpty()) {
            req.setAttribute("message", "Поля Логина и Пароля должны быть заполнены.");
            doGet(req, resp);
            return;
        } else {
            ViewUserByEmailDto user = UserServices.getInstance().getUserByEmail(userInputEmail);
            String nameUser = user.getName();
            String eMail = user.geteMail();
            String password = user.getPassword();
            int privilege = user.getPrivilege();
            if ((eMail != null) && (password.equals(userInputPassword))){
                req.getSession().setAttribute("userLoggedIn", true);
                req.getSession().setAttribute("user", nameUser);
                req.getSession().setAttribute("privilege", privilege);
                req.setAttribute("message", "Все ОК!");
                resp.sendRedirect("/moviesProject");
            }else {
                req.setAttribute("message", "Вы ошиблись в имени пользователя или пароля.");
                doGet(req, resp);
            }
        }
    }
}
