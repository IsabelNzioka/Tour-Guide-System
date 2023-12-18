package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/tours")
public class ToursAction extends BaseAction {

    @EJB
    TourBeanI tourBean;


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String filter = req.getParameter("filter");
        if ("popular".equals(filter)) {
            renderTourPage(req, res, 1, HtmlComponent.card(tourBean.getToursWithHighestBookings()));
        }
        if ("latest".equals(filter)) {
            renderTourPage(req, res, 1, HtmlComponent.card(tourBean.getLatestTours()));
        }
        if ("price".equals(filter)) {

            String minPriceStr = req.getParameter("minPrice");
            String maxPriceStr = req.getParameter("maxPrice");

            BigDecimal minPrice = StringUtils.isNotBlank(minPriceStr) ? new BigDecimal(minPriceStr) : BigDecimal.ZERO;
            BigDecimal maxPrice = StringUtils.isNotBlank(maxPriceStr) ? new BigDecimal(maxPriceStr) : BigDecimal.valueOf(Double.MAX_VALUE);

            renderTourPage(req, res, 1, HtmlComponent.card(tourBean.getToursWithinPriceRange(minPrice,maxPrice)));
        }
        renderTourPage(req, res, 1, HtmlComponent.card(tourBean.list(new Tour())));
    }


}
