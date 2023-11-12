package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.view.helper.AppPage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tours")
public class ToursAction extends BaseAction {
    TourBeanI tourBean = new TourBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // req.setAttribute("activeMenu", 1);
        // req.setAttribute("content", tourBean.availableTours());

         
        // RequestDispatcher dispatcher = req.getRequestDispatcher("./home.jsp");
        // dispatcher.forward(req, res);


        renderPage(req, res, 1, tourBean.availableTours());
       

        // new AppPage().renderHtml(req, res, 1, tourBean.availableTours());
    }


}
