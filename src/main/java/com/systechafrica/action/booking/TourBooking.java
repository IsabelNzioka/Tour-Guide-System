package com.systechafrica.action.booking;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.BookingBeanI;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.HtmlComponent;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/tour-booking")
public class TourBooking  extends BaseAction {
    @EJB
    BookingBeanI bookingBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long tourId = Long.parseLong(req.getParameter("id"));

        req.setAttribute("content", HtmlComponent.form(Booking.class));

        RequestDispatcher dispatcher = req.getRequestDispatcher("./app/tourDetails.jsp");
        dispatcher.forward(req, res);


    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        bookingBean.addOrUpdateEntity(serializeForm(Booking.class, req.getParameterMap()));
        res.sendRedirect("./my-bookings");
    }

}
