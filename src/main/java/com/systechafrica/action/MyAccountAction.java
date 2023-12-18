package com.systechafrica.action;
import com.systechafrica.action.user.BookingAction;
import com.systechafrica.action.user.FavouriteAction;
import com.systechafrica.action.user.HelpAction;
import com.systechafrica.action.user.MyAccountDetails;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/my-account")
public class MyAccountAction extends HttpServlet {

    @Inject
    private BookingAction bookingAction;

    @Inject
    private FavouriteAction favouriteAction;

    @Inject
    private HelpAction helpAction;

    @Inject
    private MyAccountDetails myAccountDetails;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String requestUri = req.getRequestURI();

        if (requestUri.equals("/my-bookings")) {
            bookingAction.doGet(req, res);
        } else if (requestUri.equals("/my-favourites")) {
            favouriteAction.doGet(req, res);
        } else if (requestUri.equals("/help")) {
            helpAction.doGet(req, res);
        } else {
            myAccountDetails.doGet(req, res);
        }
    }
}
