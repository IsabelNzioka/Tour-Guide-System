package com.systechafrica.action;

import com.systechafrica.action.admin.AddTourAction;
import com.systechafrica.action.admin.ManageUsers;
import com.systechafrica.action.admin.ViewTours;
import com.systechafrica.action.admin.BookingAction;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.HtmlComponent;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin")
public class AdminAction extends BaseAction {
    @EJB
    TourBeanI tourBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
            String requestUri = req.getRequestURI();

            if (requestUri.equals("/add-tour")) {
                new AddTourAction().doGet(req, res);

            }   else if (requestUri.equals("/admin-tours")) {
                new ViewTours().doGet(req, res);
            }

            else if (requestUri.equals("/admin-users")) {
                new ManageUsers().doGet(req, res);


            } else if (requestUri.equals("/admin-bookings")) {
              new BookingAction().doGet(req, res);

            } else {
//                TODO - Stat page
//                new ViewTours().doGet(req, res);
                req.setAttribute("statContent", HtmlComponent.tourStatCard());
                renderAdminPage(req, res, 1, Tour.class, tourBean.list(Tour.class));
            }


    }
}
