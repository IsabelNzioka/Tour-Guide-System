package com.systechafrica.app.bean;

import java.util.Date;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.utility.BookingNo;
import com.systechafrica.app.utility.BookingNoGenerator;
import com.systechafrica.app.utility.TransactionNoGenerator;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

@Stateless
public class BookingBean extends GenericBean<Booking> implements BookingBeanI {

    @PersistenceContext
    EntityManager em;

    @Inject
    @BookingNo
    private TransactionNoGenerator txnNoGenerator;


    public void addOrUpdateBooking(Booking booking,Tour tour, String userName) {

        User user;

        TypedQuery<User> query = em.createNamedQuery("findUserByUsername", User.class);
        query.setParameter("username", userName);


        user = query.getSingleResult();
        booking.setUser(user);
        booking.setTour(tour);

        if (booking.getCreatedAt() == null)
            booking.setCreatedAt(new Date());

        booking.setBookingNo(txnNoGenerator.generate());
        getDao().addOrUpdateEntity(booking);
    }

}
