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

//    private final TourBeanI tourBean = new TourBean();
    @EJB
    TourBeanI tourBean;

//    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//
//        req.setAttribute("statContent", HtmlComponent.tourStatCard());
//        renderAdminPage(req, res, 1, Tour.class, tourBean.list(Tour.class));
//
//    }
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String searchItem = req.getParameter("searchItem");

    List<Tour> tours;

    if (searchItem != null && !searchItem.isEmpty()) {
        tours = tourBean.list(Tour.class, searchItem);
    } else {
        tours = tourBean.list(Tour.class, null);
    }

    req.setAttribute("statContent", HtmlComponent.tourStatCard());
    renderAdminPage(req, res, 1, Tour.class, tours);
}



    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        tourBean.addOrUpdateEntity(serializeForm(Tour.class, req.getParameterMap()));
        res.sendRedirect("./admin-tours");
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws  IOException{

//        TODO - Use baseAction
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            String idParam = req.getParameter("id");
            System.out.println("Deletediiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii" + idParam);

            if (idParam != null && !idParam.isEmpty()) {
                Long id = Long.parseLong(idParam);
                tourBean.deleteEntity(Tour.class, id);

//                res.sendRedirect("./admin-tours");
                res.setStatus(HttpServletResponse.SC_OK);
            }
        }


    }

}

