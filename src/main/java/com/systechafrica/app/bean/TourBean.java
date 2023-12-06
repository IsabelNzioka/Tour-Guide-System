package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import com.systechafrica.app.utility.BookingNo;
import com.systechafrica.app.utility.TransactionNoGenerator;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class TourBean extends GenericBean<Tour> implements TourBeanI {


//TODO - Delete - Testing

    @Inject
    @BookingNo
    private TransactionNoGenerator txnNoGenerator;

    @Override
    public void addOrUpdateEntity(Tour tour) {
        if (tour.getStartDate() == null)
            tour.setStartDate(new Date());

        tour.setBookingNo(txnNoGenerator.generate());
        getDao().addOrUpdateEntity(tour);


    }
}