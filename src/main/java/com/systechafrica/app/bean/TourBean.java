package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.AdminPage;
import com.systechafrica.app.view.helper.HtmlComponent;
import com.systechafrica.database.Database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TourBean implements TourBeanI, Serializable {
//    Business logic only

    public String availableTours() {
        return HtmlComponent.table(Database.getDbInstance().getTours());
    }

    public Tour addOrUpdateTour(Tour tour) {
         Database database = Database.getDbInstance();
         database.getTours().add(tour);

        return tour;
    }

    public void deleteAccount(Tour tour) {

    }

}
