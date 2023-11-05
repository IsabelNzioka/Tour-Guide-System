package com.systechafrica.action;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.view.html.AppPage;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/my-account")
public class UserAccountDetails  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String requestUrl = req.getRequestURI();

        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
//        if (httpSession.getAttribute("loggedInId") == null) {

            res.sendRedirect("./");
        }
        else {
            res.sendRedirect("./account-login");
        }
    }
}
