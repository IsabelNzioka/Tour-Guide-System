package com.systechafrica.action.user;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.helper.HtmlComponent;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user-account")
public class MyAccountDetails extends BaseAction {

    @EJB
    UserBeanI userBean;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        User user = userBean.find((Long) httpSession.getAttribute("userId"));
        req.getSession().setAttribute("user", user);

//        System.out.println("User>>>>>>>>>>>>>>>>>>>>>>>>>>>" +  user);

        renderUserAccountDetails(req, res, 3, "Hello >>>>>>>>>>>>>>>>>>>>>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User usr = (User) req.getSession().getAttribute("user");
        System.out.println("User>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + usr);

        usr.setUsername(req.getParameter("username"));
        usr.setPhonenumber(req.getParameter("phonenumber"));
        usr.setEmail(req.getParameter("email"));

        userBean.addOrUpdateEntity(usr);
        res.sendRedirect("./user-account");
    }
}
