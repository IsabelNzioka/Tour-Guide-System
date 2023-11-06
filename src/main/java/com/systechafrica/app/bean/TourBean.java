package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.database.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TourBean implements TourBeanI, Serializable {
//    Business logic only

    public String availableTours() {
        Database database = Database.getDbInstance();

        StringBuilder toursList = new StringBuilder("<div class='ToursList'>");
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

        return toursList.toString();
    }

    public Tour addOrUpdateTour(Tour tour) {
         Database database = Database.getDbInstance();
         database.getTours().add(tour);

        return tour;
    }

    public void deleteAccount(Tour tour) {

    }

}
