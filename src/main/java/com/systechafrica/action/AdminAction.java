package com.systechafrica.action;

import com.systechafrica.action.admin.AddTourAction;
import com.systechafrica.action.admin.ViewTours;
import com.systechafrica.app.view.helper.AdminPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin")
public class AdminAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


            String requestUri = req.getRequestURI();

            if (requestUri.equals("/add-tour")) {
                new AddTourAction().doGet(req, res);

            }   else if (requestUri.equals("/admin-tours")) {
                new ViewTours().doGet(req, res);
//            );

            }

            else if (requestUri.equals("/admin-users")) {
                new AdminPage().renderAdmin(req, res, 2,
                        "<h2> View and Manage Users</h2>"
                );

            } else if (requestUri.equals("/admin-bookings")) {
                new AdminPage().renderAdmin(req, res, 3,
                        "<h2> View and Manage Users</h2>"
                );

            } else {
                new AdminPage().renderAdmin(req, res, 4,
                        "<h2> Default page</h2>"
                );
//            default page - display statistics data - Happy customers, tours done this year, bookings done, etc

            }


    }
}
