package com.systechafrica.action.admin;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.html.AdminPage;
import com.systechafrica.app.view.html.HtmlComponent;
import com.systechafrica.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/admin-tours")
public class ViewTours extends HttpServlet  {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        TourBeanI tourBean = new TourBean();
        new AdminPage().renderAdmin(req, res, 1, tourBean.availableTours());
    }

}
