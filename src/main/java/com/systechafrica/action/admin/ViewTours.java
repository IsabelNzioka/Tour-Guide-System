package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.HtmlComponent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/admin-tours")
public class ViewTours extends BaseAction  {
    private Tour tour = new Tour();
    private final TourBeanI tourBean = new TourBean();


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        TourBeanI tourBean = new TourBean();
//        renderAdminPage(req, res, 1,  HtmlComponent.tourStatCard() + tourBean.availableTours());

        req.setAttribute("statContent", HtmlComponent.tourStatCard());
        renderAdminPage(req, res, 1, Tour.class, tourBean.list());
    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        serializeForm(tour, req.getParameterMap());
        tourBean.addOrUpdateTour(tour);
        res.sendRedirect("./admin-tours");
    }

}
