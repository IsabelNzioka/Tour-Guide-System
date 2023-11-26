package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.HtmlComponent;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/admin-tours")
public class ViewTours extends BaseAction  {

//    private final TourBeanI tourBean = new TourBean();
    @EJB
    TourBeanI tourBean;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("statContent", HtmlComponent.tourStatCard());
        renderAdminPage(req, res, 1, Tour.class, tourBean.list(Tour.class));

    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        tourBean.addOrUpdateEntity(serializeForm(Tour.class, req.getParameterMap()));
        res.sendRedirect("./admin-tours");
    }

}
