package com.systechafrica.action;

import com.systechafrica.action.user.BookingAction;
import com.systechafrica.action.user.FavouriteAction;
import com.systechafrica.action.user.HelpAction;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/my-account")
public class MyAccountAction extends BaseAction {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

            String requestUri = req.getRequestURI();

            if (requestUri.equals("/my-bookings")) {
                new BookingAction().doGet(req, res);

            }
            else if (requestUri.equals("/my-favourites")) {
                new FavouriteAction().doGet(req, res);

            } else if (requestUri.equals("/help")) {
                 new HelpAction().doGet(req, res);

            } else {
               renderUserAccountPage(req, res, 0,  "<div class='UserPage'>" +
                     "<h2> My account</h2>" +
                    "</div>");
            
                
            }


    }

}
