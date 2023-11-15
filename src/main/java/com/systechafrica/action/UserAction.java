package com.systechafrica.action;

import com.systechafrica.app.bean.UserBean;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.User;

import com.systechafrica.database.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/account-register")
public class UserAction extends BaseAction {
    UserBeanI userBean = new UserBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
        req.setAttribute("activeMenu", 2);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./app/signupPage.jsp");
        dispatcher.forward(req, res);
    }


//    check if user exists
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("userRole", null);

        User registerUser = new User();
        serializeForm(registerUser, req.getParameterMap());

        User userDetails = userBean.register(registerUser);
        if(userDetails != null ) {
            httpSession.setAttribute("loggedInId", new Date().getTime() + "");
            // httpSession.setAttribute("user", userDetails);

            httpSession.setAttribute("userRole", userDetails.getRole()); 
            httpSession.setAttribute("userName", userDetails.getUsername()); 
            res.sendRedirect("./my-account");
        }
           PrintWriter print = res.getWriter();
           print.write("<html><head><style>" +
                "body { display: flex; justify-content: center; align-items: center; height: 100vh; }" +
            ".card { padding: 20px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); max-width: 400px; margin: auto; text-align: center; }" +
            "</style></head><body><div class='card'><p>Passwords don't match <a href='./account-register'> Register again!! </a></p></div></body></html>");


}

}
