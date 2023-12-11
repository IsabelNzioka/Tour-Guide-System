package com.systechafrica.app.rest.api;

import com.systechafrica.app.bean.BookingBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.User;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
