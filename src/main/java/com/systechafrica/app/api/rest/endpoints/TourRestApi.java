package com.systechafrica.app.api.rest.endpoints;

import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
