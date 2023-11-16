package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import java.util.List;

public interface TourBeanI {
//    public String availableTours();
    List<Tour> list();
    public String availableToursCard();
    public Tour addOrUpdateTour(Tour tour);

    public void deleteTour(Tour tour);

}
