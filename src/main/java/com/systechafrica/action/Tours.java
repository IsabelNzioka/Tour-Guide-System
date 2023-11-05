package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.html.AdminPage;
import com.systechafrica.app.view.html.AppPage;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/tours")
public class Tours extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Database database = Database.getDbInstance();

        StringBuilder toursList = new StringBuilder("<div class='TourList'>");
        for (Tour tour : database.getTours()) {
            toursList.append("<div class='card'>")
                    .append("<img src='" + tour.getImageUrl() + "' alt='Tour Image' >")
                    .append("<h3>").append(tour.getName()).append("</h3>")
                    .append("<p class='Price'>").append("$").append(tour.getPrice()).append("</p>")
                    .append("<p>").append("Duration in Days: ").append(tour.getDurationInDays()).append("</p>")
                    .append("<p>").append("Slots left: ").append(tour.getDurationInDays()).append("</p>")
                    .append("</div>");
        }
        toursList.append("</div>");

        new AppPage().renderHtml(req, res, 1, toursList.toString());
    }


}
