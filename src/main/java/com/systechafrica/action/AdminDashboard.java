package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.view.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin")
public class AdminDashboard extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

//        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {

//        create,update and delete tours,users
//        change roles
//            .....


//            TourBeanI tourBean = new TourBean();

            new AppPage().renderHtml(req, res, 0,
                    "<h2> Manage Tour Bookings, Users and Employees</h2>" +
                            "<br/>Add Account<br/><form action=\"./add-tour\" method=\"post\">" +
                            "  <label for=\"code\">Account Code:</label><br>" +
                            "  <input type=\"text\" id=\"code\" name=\"code\" ><br>" +
                            "  <label for=\"name\">Tour name:</label><br>" +
                            "  <input type=\"text\" id=\"name\" name=\"name\" ><br><br>" +
                            "  <label for=\"summary\">Tour summary:</label><br>" +
                            "  <input type=\"text\" id=\"summary\" name=\"summary\" ><br><br>" +
                            "  <label for=\"price\">Tour Price:</label><br>" +
                            "  <input type=\"number\" id=\"price\" name=\"price\" ><br><br>" +
                            "  <input type=\"submit\" value=\"Submit\">" +
                            "</form><br/>");
//                            + tourBean.availableTours());
//        }
//        else {
//            res.sendRedirect("./");
//        }
    }
}
