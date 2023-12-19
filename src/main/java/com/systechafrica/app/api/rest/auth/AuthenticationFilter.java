package com.systechafrica.app.api.rest.auth;


import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


@Provider
@Priority(1)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;
    private static final String SCHEME = "Bearer";

    @Inject
    JwtAuthHandler jwtAuthHandler;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method method = resourceInfo.getResourceMethod();

        if (method.isAnnotationPresent(PermitAll.class)) {
            return;
        }
        if (method.isAnnotationPresent(DenyAll.class)) {
            abort(requestContext, "Endpoint Not Accessible");
            return;
        }

        final MultivaluedMap<String, String> headers = requestContext.getHeaders();
        List<String> authorization = headers.get("Authorization");
        if (authorization == null || authorization.isEmpty() || authorization.get(0) == null) {
            abort(requestContext, "Authentication is required");
            return;
        }

        String bearerAuth = authorization.get(0);

        if (!bearerAuth.contains("Bearer")) {
            abort(requestContext, "Bearer authentication is required!");
            return;
        }

        String token = authorization.get(0)
                .substring(SCHEME.length()).trim();

        try {
            validateToken(token);
        } catch (Exception e) {
            abort(requestContext, "Invalid Token");
        }

    }


    private void abort(ContainerRequestContext requestContext, String message) {
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity(message)
                        .build());
    }

    private void validateToken(String token) throws Exception {

        jwtAuthHandler.isValidToken(token);
    }
}


