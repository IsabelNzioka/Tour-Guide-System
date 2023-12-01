package com.systechafrica.app.bean;

import java.util.Date;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.utility.BookingNo;
import com.systechafrica.app.utility.BookingNoGenerator;
import com.systechafrica.app.utility.TransactionNoGenerator;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BookingBean extends GenericBean<Booking> implements BookingBeanI{



    @Inject
    @BookingNo
    private TransactionNoGenerator txnNoGenerator;

    @Override
    public void addOrUpdateEntity(Booking booking) {
        if(booking.getCreatedAt() == null)
            booking.setCreatedAt(new Date());

        booking.setBookingNo(txnNoGenerator.generate());
        getDao().addOrUpdateEntity(booking);
    }
    
}
