package com.systechafrica.filter;



import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest =  (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse)  servletResponse;
        HttpSession httpSession = httpRequest.getSession();

        String servletPath = httpRequest.getServletPath();

        if(servletPath.equals("/account-login") || servletPath.equals("/account-register") ) {
            if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/my-account");
                    servletResponse.getWriter().flush();
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
        } else {
            if( servletPath.equals("/home")  || servletPath.equals("/")  || servletPath.equals("/tours") || servletPath.contains(".jsp")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else if(httpSession.isNew()) {
                httpSession.invalidate();
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/account-login");
            }else if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else {
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/account-login");
                }

        }
    }








    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}