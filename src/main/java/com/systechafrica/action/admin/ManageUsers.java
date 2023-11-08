package com.systechafrica.action.admin;

import com.systechafrica.app.view.html.AdminPage;
import com.systechafrica.app.view.html.HtmlComponent;
import com.systechafrica.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-users")
public class ManageUsers extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        new AdminPage().renderAdmin(req, res, 1, HtmlComponent.table(Database.getDbInstance().getUsers()));
    }
}
