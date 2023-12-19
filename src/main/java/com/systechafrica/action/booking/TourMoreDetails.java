package com.systechafrica.action.booking;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.helper.HtmlComponent;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/tour-details")
public class TourMoreDetails extends BaseAction {

    @EJB
    TourBeanI tourBean;



    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();


        if(StringUtils.isNotBlank((String) session.getAttribute(("loggedInId")))) {

            Long tourId = Long.parseLong(req.getParameter("id"));

            Tour tour = tourBean.findById(Tour.class, tourId);
            req.getSession().setAttribute("tour", tour);

            req.setAttribute("content", HtmlComponent.form(Booking.class));

            req.setAttribute("tourDetails", tourBean.findById(Tour.class,  tourId) );
            RequestDispatcher dispatcher = req.getRequestDispatcher("./app/tourDetails.jsp");
            dispatcher.forward(req, res);
        } else {
            res.sendRedirect("./account-login");
        }





    }

}
