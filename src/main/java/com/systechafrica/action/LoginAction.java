package com.systechafrica.action;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.systechafrica.app.bean.AuthBean;
import com.systechafrica.app.bean.AuthBeanI;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.helper.LoginPage;
import com.systechafrica.database.Database;

@WebServlet("/account-login")
public class LoginAction extends BaseAction {
    AuthBeanI authBean = new AuthBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
               HttpSession httpSession = req.getSession();

                    new LoginPage().renderLogin(req, res, 2,
                            "<h2> LOGIN</h2>");

    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          HttpSession httpSession = req.getSession(true); //create a new session whenever we log in.
          httpSession.setAttribute("user", null);

        User user = new User();
        serializeForm(user, req.getParameterMap());

        User userDetails = authBean.authenticate(user);
       

            if (userDetails != null) {
               

                httpSession.setAttribute("loggedInId", new Date().getTime() + "");
                httpSession.setAttribute("user", userDetails); //used to check user roles to display to navbar links accordingly

                res.sendRedirect("./my-account");
            }
            PrintWriter print = res.getWriter();
             print.write("<html><head><style>" +
                "body { display: flex; justify-content: center; align-items: center; height: 100vh; }" +
                ".card { padding: 20px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); max-width: 400px; margin: auto; text-align: center; }" +
                "</style></head><body><div class='card'><p>Invalid login details <a href='./account-login'> Login again!! </a></p></div></body></html>");

    }

}
