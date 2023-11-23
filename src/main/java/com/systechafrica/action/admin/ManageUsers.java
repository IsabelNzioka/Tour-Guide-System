package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;

import com.systechafrica.app.bean.UserBean;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin-users")
public class ManageUsers extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserBeanI userBean = new UserBean();

       req.setAttribute("statContent", HtmlComponent.statCard());
        renderAdminPage(req, res, 2, User.class, userBean.list(User.class));
    }
}
