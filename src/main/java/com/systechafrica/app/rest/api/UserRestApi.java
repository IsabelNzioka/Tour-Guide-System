package com.systechafrica.app.rest.api;

import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.User;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
