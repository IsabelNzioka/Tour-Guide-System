package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;

import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-users")
public class ManageUsers extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        renderAdminPage(req, res, 2, HtmlComponent.table(Database.getDbInstance().getUsers()));
    }
}
