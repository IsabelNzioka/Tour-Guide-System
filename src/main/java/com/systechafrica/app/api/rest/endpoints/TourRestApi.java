package com.systechafrica.app.api.rest.endpoints;

import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

@Path("/tours")
public class TourRestApi extends BaseRestApi {


    @EJB
    private TourBeanI tourBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(tourBean.list(new Tour()));
    }

    @Path("/tour/{tourId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response tour(@PathParam("tourId") Long userId){
        return respond(tourBean.findById(Tour.class, userId));
    }

    @Path("/tour/{tourId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTour(@PathParam("tourId") Long userId){
        tourBean.deleteEntity(Tour.class, userId);
        return respond(new RestResponseWrapper("Deleted Successfully"));
    }

    @Path("/bookings-per-tour")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookingsPerTour(){
        return respond(tourBean.tourBookingsCount());
    }
    @Path("/most-popular")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response mostPopularTours(){
        return respond(tourBean.getToursWithHighestBookings());
    }

    @Path("/tours-price")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchToursWithinPriceRange(@QueryParam("minPrice")BigDecimal minPrice,@QueryParam("maxPrice")BigDecimal maxPrice ){
        return respond(tourBean.getToursWithinPriceRange(minPrice, maxPrice));
    }


}
