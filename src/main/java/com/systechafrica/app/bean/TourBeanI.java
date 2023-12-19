package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import javax.ejb.Remote;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Remote
public interface TourBeanI  extends GenericBeanI<Tour>{

    List<Tour> getToursWithHighestBookings();
    Map<String, Integer> tourBookingsCount();
    List<Tour> getLatestTours();
    List<Tour> getToursWithinPriceRange(BigDecimal minPrice, BigDecimal maxPrice);


    Long getToursWithBookingsCount();
}
