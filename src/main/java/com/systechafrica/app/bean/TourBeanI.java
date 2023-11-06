package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

public interface TourBeanI {
    public String availableTours();
    public Tour addOrUpdateTour(Tour tour);

    public void deleteAccount(Tour tour);

}
