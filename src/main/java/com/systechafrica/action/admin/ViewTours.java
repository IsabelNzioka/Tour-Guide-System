package com.systechafrica.action.admin;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.html.AdminPage;
import com.systechafrica.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-tours")
public class ViewTours extends HttpServlet  {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Database database = Database.getDbInstance();

        StringBuilder toursList = new StringBuilder("<h2></h2><table class='TourList'>");
        toursList.append("<tr><th>Tour Name</th><th>Price</th><th>DurationInDays</th><th>Availability</th></tr>");
        for (Tour tour : database.getTours()) {
            toursList.append("<tr>")
                    .append("<td>").append(tour.getName()).append("</td>")
                    .append("<td>").append(tour.getPrice()).append("</td>")
                    .append("<td>").append(tour.getDurationindays()).append("</td>")
                    .append("<td>").append(tour.getTourCategories().toString().toLowerCase()).append("</td>")
                    .append("<td> 100 Slots</td>")
                    .append("</tr>");
        }
        toursList.append("</table>");

        new AdminPage().renderAdmin(req, res, 1, toursList.toString());
    }

}
