package com.systechafrica.action.admin;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.html.AdminPage;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-tour")
public class AddTourAction  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        new AdminPage().renderAdmin(req, res, 0,
                "<div class='AddToursPage'>" +
                        "<form action=\"./add-tour\" method=\"post\">" +
                        "  <label for=\"code\">Account Code:</label><br>" +
                        "  <input type=\"text\" id=\"code\" name=\"code\" ><br>" +
                        "  <label for=\"name\">Tour name:</label><br>" +
                        "  <input type=\"text\" id=\"name\" name=\"name\" ><br><br>" +
                        "  <label for=\"summary\">Tour summary:</label><br>" +
                        "  <input type=\"text\" id=\"summary\" name=\"summary\" ><br><br>" +
                        "  <label for=\"price\">Tour Price:</label><br>" +
                        "  <input type=\"number\" id=\"price\" name=\"price\" ><br><br>" +
                        "  <button type=\"submit\" class=\"SubmitButton\">Submit</button>" +

//                        "  <input type=\"submit\" value=\"Submit\" class=\"SubmitButton\">" +
                        "</form><br/>" +
                        "</div>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
            Database database = Database.getDbInstance();
            int tourPrice = Integer.parseInt(req.getParameter("price"));
            String tourName = req.getParameter("name");
            String tourSummary = req.getParameter("summary");
            String tourCode = req.getParameter("code");

//          Check if some fields are null  - isEmpty() - todo
            if (tourCode != null && tourSummary != null ) {
                database.getTours().add(new Tour(tourCode, tourName, tourSummary, tourPrice));
            }


            res.sendRedirect("./admin");
        }
        else {
            res.sendRedirect("./");
        }
    }
}
