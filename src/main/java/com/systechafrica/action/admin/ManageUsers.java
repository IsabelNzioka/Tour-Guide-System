package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;

import com.systechafrica.app.bean.UserBean;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import javax.ejb.EJB;
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
        String searchItem = req.getParameter("searchItem");
        List<User> users;

        if (searchItem != null && !searchItem.isEmpty()) {
            users = userBean.list(User.class, searchItem);
        } else {
            users = userBean.list(User.class, null);
        }

        req.setAttribute("statContent", HtmlComponent.statCard());
        renderAdminPage(req, res, 2, User.class, users);
    }


    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws  IOException{
//        TODO - Use baseAction
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            String idParam = req.getParameter("id");
            System.out.println("Deletediiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + idParam);

            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.parseLong(idParam);
                userBean.deleteEntity(User.class, id);

//                res.sendRedirect("./admin-tours");
                res.setStatus(HttpServletResponse.SC_OK);
                res.sendRedirect("./admin-tours");



            }
        }


    }


}
