package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TourBean implements TourBeanI, Serializable {
//    Business logic only

    public String availableTours() {
        List<Tour> tours = new ArrayList<>();
        tours.add(new Tour(null, "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 2000));
        tours.add(new Tour("3023d", "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 9000));
        tours.add(new Tour(null, "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 10000));
        tours.add(new Tour("394h", "Bali White water rafting", "Choose between a morning or afternoon...in Bali...more", 10000));


        StringBuilder tourCardBuilder = new StringBuilder();

        for (Tour tour : tours)
            tourCardBuilder.append(tour.tourCard());

        return tourCardBuilder.toString();
    }

    public Tour addOrUpdateTour(Tour tour) throws Exception {
        return null;
    }
    public void deleteAccount(Tour tour) {

    }

}
