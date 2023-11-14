package com.systechafrica.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;

@WebServlet("/admin-bookings")
public class BookingAction extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        TourBeanI tourBean = new TourBean();

        renderAdminPage(req, res, 3, tourBean.availableTours());
    }
    
}
