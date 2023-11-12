package com.systechafrica.action.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systechafrica.app.view.helper.AccountDetailsPage;
import com.systechafrica.app.view.helper.AdminPage;

import java.io.IOException;

@WebServlet("/my-favourites")
public class FavouriteAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        new AccountDetailsPage().renderAccountDetails(req, res, 1,
                "<div class='UserPage'>" +
                        "<h2> My Favourites</h2>" +
                        "</div>");
    }
}
