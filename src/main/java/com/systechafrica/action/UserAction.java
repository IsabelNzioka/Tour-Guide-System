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
import java.util.Date;

@WebServlet("/account-register")
public class UserAction  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        new SignupPage().renderSignup(req, res, 2,
                "<h2> LOGIN</h2>");

    }


//    check if user exists
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    Database database = Database.getDbInstance();
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String confirmPassword = req.getParameter("confirmPassword");

    if (password.equals(confirmPassword)) {
        User user = new User(100L, username, password); // create a new User object
        database.getUsers().add(user); // add the user to the database
        httpSession.setAttribute("loggedInId", new Date().getTime() + "");
        httpSession.setAttribute("user", user);
        res.sendRedirect("./my-account");
    } else {
        res.sendRedirect("./account-login");
    }
}

}
