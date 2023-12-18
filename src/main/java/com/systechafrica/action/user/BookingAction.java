package com.systechafrica.action.user;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.BookingBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;

import com.systechafrica.app.view.helper.HtmlComponent;

import java.io.IOException;

@WebServlet("my-bookings")
public class BookingAction extends BaseAction {

    @EJB
    BookingBeanI bookingBean;


public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession session = req.getSession();
    Long userId = (Long) session.getAttribute("userId");
    String userName = (String) session.getAttribute("userName");

    renderUserAccountPage(req, res, 3, HtmlComponent.card(bookingBean.getBookingByUserId(userId)));

}
}
