package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.view.html.AppPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tours")
public class ToursAction extends HttpServlet {
    TourBeanI tourBean = new TourBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        new AppPage().renderHtml(req, res, 1, tourBean.availableTours());
    }


}
