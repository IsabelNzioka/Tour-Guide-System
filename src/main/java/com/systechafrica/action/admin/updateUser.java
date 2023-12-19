package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.model.entity.UserRole;
import com.systechafrica.app.view.helper.HtmlComponent;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-update-user")
public class updateUser extends BaseAction {

    @EJB
    UserBeanI userBean;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("update".equals(action)) {
            User user = userBean.find(Long.parseLong(req.getParameter("id")));
            req.getSession().setAttribute("user", user);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("./app/editUser.jsp");
        dispatcher.forward(req, res);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User usr = (User) req.getSession().getAttribute("user");

        String roleString = req.getParameter("role");
        UserRole role = UserRole.valueOf(roleString);

        usr.setRole(role);

        usr.setUsername(req.getParameter("username"));
        usr.setEmail(req.getParameter("email"));

        userBean.addOrUpdateEntity(usr);
      res.sendRedirect("./admin-users");
    }

}
