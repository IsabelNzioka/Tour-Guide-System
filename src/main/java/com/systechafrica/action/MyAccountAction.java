package com.systechafrica.action;

import com.systechafrica.action.user.Bookings;
import com.systechafrica.action.user.Favourites;
import com.systechafrica.app.view.html.AccountDetailsPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/my-account")
public class MyAccountAction extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();


            String requestUri = req.getRequestURI();

            if (requestUri.equals("/my-bookings")) {
                new Bookings().doGet(req, res);

            }
            else if (requestUri.equals("/my-favourites")) {
                new Favourites().doGet(req, res);

            } else if (requestUri.equals("/help")) {
                new AccountDetailsPage().renderAccountDetails(req, res, 2,
                        "<h2> Help</h2>"
                );

            } else {
                new AccountDetailsPage().renderAccountDetails(req, res, 4,
                        "<h2> Account Details - change/update </h2>"
                );
            }


    }

}
