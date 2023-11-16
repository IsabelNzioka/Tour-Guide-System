package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import java.io.Serializable;
import java.util.List;


public class TourBean implements TourBeanI, Serializable {
//    Business logic only

//    public String availableTours() {
//        return HtmlComponent.table(Database.getDbInstance().getTours());
//    }
    public List<Tour> list(){
        return Database.getDbInstance().getTours();
    }

    public String availableToursCard() {
        return HtmlComponent.card(Database.getDbInstance().getTours());
    }

    public Tour addOrUpdateTour(Tour tour) {
         Database database = Database.getDbInstance();
         database.getTours().add(tour);

        return tour;
    }

    public void deleteTour(Tour tour) {

    }

}
