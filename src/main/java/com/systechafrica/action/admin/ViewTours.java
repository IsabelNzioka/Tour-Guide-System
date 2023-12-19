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
import java.util.List;


@WebServlet("/admin-tours")
public class ViewTours extends BaseAction  {

    @EJB
    TourBeanI tourBean;

public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    Long totalTours = tourBean.getEntityCount(Tour.class);
    long toursWithBookingsCount = tourBean.getToursWithBookingsCount();
       req.setAttribute("statContent", HtmlComponent.tourStatCard(totalTours, toursWithBookingsCount));
        renderAdminPage(req, res, 1, Tour.class, tourBean.list(new Tour()));

}


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        tourBean.addOrUpdateEntity(serializeForm(Tour.class, req.getParameterMap()));
        res.sendRedirect("./admin-tours");
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            String idParam = req.getParameter("id");

            if (idParam != null && !idParam.isEmpty()) {
                try {
                    Long id = Long.parseLong(idParam);
                    tourBean.deleteEntity(Tour.class, id);

                    res.setContentType("application/json");
                    res.setCharacterEncoding("UTF-8");
                    res.getWriter().write("{\"id\": " + id + "}");
                    res.setStatus(HttpServletResponse.SC_OK);
                    res.sendRedirect("./admin-tours");
                } catch (Exception e) {
                    // Log the exception stack trace
                    e.printStackTrace();
                    res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                return;
            }
        }

        res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return;
    }

}

