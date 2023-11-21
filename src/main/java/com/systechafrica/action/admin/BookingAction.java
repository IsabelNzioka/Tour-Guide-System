package com.systechafrica.action.admin;

import java.io.IOException;
import java.util.Date;

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
    private final BookingBeanI bookingBean = new BookingBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BookingBeanI bookingBean = new BookingBean();

        renderAdminPage(req, res, 3, Booking.class, bookingBean.list());
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        req.getParameterMap().put("date", new String[]{new Date().toString()});
        bookingBean.addOrUpdateEntity(serializeForm(Booking.class, req.getParameterMap()));
        res.sendRedirect("./admin-bookings");
    }
    
}
