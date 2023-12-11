package com.systechafrica.action.booking;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.BookingBeanI;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
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


@WebServlet("/tour-booking")
public class TourBooking  extends BaseAction {
    @EJB
    BookingBeanI bookingBean;
    @EJB
    TourBeanI tourBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();


        if(StringUtils.isNotBlank((String) session.getAttribute(("loggedInId")))) {
            Long tourId = Long.parseLong(req.getParameter("id"));
            Tour tour = tourBean.findById(Tour.class, tourId);
            req.getSession().setAttribute("tour", tour);


            req.setAttribute("content", HtmlComponent.form(Booking.class));
            RequestDispatcher dispatcher = req.getRequestDispatcher("./app/tourDetails.jsp");
            dispatcher.forward(req, res);
        } else {
            res.sendRedirect("./account-login");
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        Tour tour = (Tour) req.getSession().getAttribute("tour");

        Booking booking = serializeForm(Booking.class, req.getParameterMap());

        bookingBean.addOrUpdateBooking(booking, tour, userName);
        res.sendRedirect("./my-bookings");
    }

}
