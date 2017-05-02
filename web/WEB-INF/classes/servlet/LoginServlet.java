package servlet;

        import Services.UserServices;
        import dto.ViewUserByEmailDto;

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
        req.getSession().setAttribute("message", "messageEnter");
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInputEmail = req.getParameter("inputEmail");
        String userInputPassword = req.getParameter("inputPassword");
        String userLang = req.getParameter("lang");
        req.getSession().setAttribute("localLang", userLang);
        //req.setAttribute("message", "");

        if (userInputEmail.isEmpty() || userInputPassword.isEmpty()) {
            req.getSession().setAttribute("message", "messageMustFull");
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
                req.setAttribute("message", "errorPass");
                doGet(req, resp);
            }
        }
    }
}
