package com.systechafrica.app.api.rest.endpoints;

import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.User;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestApi extends BaseRestApi  {
    @EJB
    private UserBeanI userBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(userBean.list(new User()));
    }


    @Path("/adduser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(User user) {
        userBean.addOrUpdateEntity(user);
        return respond();
    }

    @Path("/list/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response user(@PathParam("userId") Long userId){
        return respond(userBean.findById(User.class, userId));
    }


    @Path("/user/{userId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("bookingId") Long userId){
        userBean.deleteEntity(User.class, userId);
        return respond(new RestResponseWrapper("Deleted Successfully"));
    }
}
