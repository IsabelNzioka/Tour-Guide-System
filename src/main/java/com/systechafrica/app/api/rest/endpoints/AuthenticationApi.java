package com.systechafrica.app.api.rest.endpoints;

import com.systechafrica.app.api.rest.auth.JwtAuthHandler;
import com.systechafrica.app.bean.AuthBeanI;
import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.User;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/auth")
@PermitAll
public class AuthenticationApi extends BaseRestApi{

    @EJB
    UserBeanI userBean;

    @EJB
    AuthBeanI authBean;
    
    @Inject
    JwtAuthHandler jwtAuthHandler;

    @POST @Path("/register")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user){
        User newUser = userBean.register(user);
        return respond(newUser);
    }

    @POST @Path("/login")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User loginUser) throws SQLException {
        User user = authBean.authenticate(loginUser);
        if(user!=null) {
            String token = jwtAuthHandler.generateToken(user);
            System.out.println("token = " + token);
            boolean isValidToken = jwtAuthHandler.isValidToken(token);
            System.out.println("isValidToken = " + isValidToken);
            return respond(token);
        }
        return respond("Authentication failed");
    }
}
