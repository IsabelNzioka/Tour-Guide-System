package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;

import com.systechafrica.app.bean.UserBean;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.model.entity.UserIpAddress;
import com.systechafrica.app.utility.ActiveUsers;
import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin-users")
public class ManageUsers extends BaseAction{
    @EJB
    UserBeanI userBean;



    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long allActiveUsers = userBean.countAllUserIpAddresses();
        req.setAttribute("statContent", HtmlComponent.statCard(allActiveUsers));
        renderAdminPage(req, res, 2, User.class, userBean.list(new User()));
    }



    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            String idParam = req.getParameter("id");

            if (idParam != null && !idParam.isEmpty()) {
                try {
                    Long id = Long.parseLong(idParam);
                    userBean.deleteEntity(User.class, id);

                    res.setContentType("application/json");
                    res.setCharacterEncoding("UTF-8");
                    res.getWriter().write("{\"id\": " + id + "}");
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.sendRedirect("./admin-users");
                } catch (Exception e) {
                    // Log the exception stack trace
                    e.printStackTrace();
                    res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                return;
            }
        }

        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }

}
