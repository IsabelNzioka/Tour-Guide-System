package com.systechafrica.app.api.rest.endpoints;

import com.systechafrica.app.bean.BookingBeanI;
import com.systechafrica.app.model.entity.Booking;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("booking")
public class BookingRestApi extends  BaseRestApi {

    @EJB
    BookingBeanI bookingBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(bookingBean.list(new Booking()));
    }

    @Path("/booking/{bookingId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getABooking(@PathParam("bookingId") Long bookingId){
        return respond(bookingBean.findById(Booking.class, bookingId));
    }

    @Path("/list/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUserBookingsById(@PathParam("userId") Long userId){
        return respond(bookingBean.getBookingByUserId(userId));
    }
}
