package com.systechafrica.auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.html.AppPage;
import com.systechafrica.app.view.html.LoginPage;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;

@WebServlet("/account-login")
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
               HttpSession httpSession = req.getSession();

                if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId"))))
                            res.sendRedirect("./my-account");
                else {
                    new LoginPage().renderLogin(req, res, 2,
                            "<h2> LOGIN</h2>");
                }



    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Database database = Database.getDbInstance();  // will  not create a new instance, just check for a global instance and use it.

        for(User user : database.getUsers()) {
            if (username.equals(user.getUsername() ) && password.equals(user.getPassword())) {
                HttpSession httpSession = req.getSession(true); //create a new session whenever we log in.
                httpSession.setAttribute("loggedInId", new Date().getTime() + "");

                httpSession.setAttribute("username", username);
                httpSession.setAttribute("user", user);

                res.sendRedirect("./");
            }
        }
            PrintWriter print = res.getWriter();
            print.write("<html><body>Invalid login details <a href=\".\"> Login again!! </a></body></html>" + database.getUsers());
        }

}
