package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

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
        renderPage(req, res, 1, HtmlComponent.card(Database.getDbInstance().getTours()));
 
    }


}
