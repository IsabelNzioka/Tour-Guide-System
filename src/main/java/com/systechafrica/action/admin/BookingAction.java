package com.systechafrica.action.admin;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.BookingBean;
import com.systechafrica.app.bean.BookingBeanI;

import com.systechafrica.app.model.entity.Booking;


@WebServlet("/admin-bookings")
public class BookingAction extends BaseAction {
    @EJB
    BookingBeanI bookingBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        renderAdminPage(req, res, 3, Booking.class, bookingBean.list(new Booking()));
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getParameterMap().put("date", new String[]{new Date().toString()});
        bookingBean.addOrUpdateEntity(serializeForm(Booking.class, req.getParameterMap()));
        res.sendRedirect("./admin-bookings");
    }
    
}
