package com.systechafrica.action;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.html.LoginPage;
import com.systechafrica.app.view.html.SignupPage;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/account-register")
public class UserAction  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        new SignupPage().renderSignup(req, res, 2,
                "<h2> LOGIN</h2>");

    }


//    check if user exists
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
            Database database = Database.getDbInstance();
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String confirmPassword = req.getParameter("confirmPassword");

            if(password.equals(confirmPassword))
                database.getUsers().add(new User(100L, username, password));

            res.sendRedirect("./my-account");
        }
        else {
            res.sendRedirect("./");
        }
    }

}
