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
//    String searchItem = req.getParameter("searchItem");

    Long totalTours = tourBean.getEntityCount(Tour.class);
    req.setAttribute("statContent", HtmlComponent.tourStatCard(totalTours));

        renderAdminPage(req, res, 1, Tour.class, tourBean.list(new Tour()));


}



    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        tourBean.addOrUpdateEntity(serializeForm(Tour.class, req.getParameterMap()));
        res.sendRedirect("./admin-tours");
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws  IOException{
        String action = req.getParameter("action");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + action);

        if ("delete".equals(action)) {
            String idParam = req.getParameter("id");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + idParam);

            if (idParam != null && !idParam.isEmpty()) {
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2" + idParam);

                Long id = Long.parseLong(idParam);
                tourBean.deleteEntity(Tour.class, id);
                res.setStatus(HttpServletResponse.SC_NO_CONTENT);

            }

            res.sendRedirect("./admin-tours");

        }
    }

}

