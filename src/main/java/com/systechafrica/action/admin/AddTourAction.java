package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.html.AdminPage;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/add-tour")
public class AddTourAction  extends BaseAction {
    private Tour tour = new Tour();
    private TourBeanI tourBean = new TourBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        new AdminPage().renderAdmin(req, res, 0,
                "<div class='AddToursPage'>" +
                        "<form action=\"./add-tour\" method=\"post\">" +
                        "  <label for=\"code\">Account Code:</label><br>" +
                        "  <input type=\"text\" id=\"code\" name=\"code\" ><br>" +
                        "  <label for=\"name\">Tour name:</label><br>" +
                        "  <input type=\"text\" id=\"name\" name=\"name\" ><br>" +
                        "  <label for=\"summary\">Tour summary:</label><br>" +
                        "  <input type=\"text\" id=\"summary\" name=\"summary\" ><br>" +
                        "  <label for=\"price\">Tour Price:</label><br>" +
                        "  <input type=\"number\" id=\"price\" name=\"price\" ><br>" +
                        "  <label for=\"durationindays\">Duration In Days:</label><br>" +
                        "  <input type=\"text\" id=\"durationindays\" name=\"durationindays\" ><br>" +
                        "  <label for=\"imageurl\">Image URL:</label><br>" +
                        "  <input type=\"text\" id=\"imageurl\" name=\"imageurl\" ><br>" +
                        "  <button type=\"submit\" class=\"SubmitButton\">Submit</button>" +
                        "</form><br/>" +
                        "</div>");
    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        serializeForm(tour, req.getParameterMap());
        System.out.println(tour);
        tourBean.addOrUpdateTour(tour);

        res.sendRedirect("./admin");
    }
}
