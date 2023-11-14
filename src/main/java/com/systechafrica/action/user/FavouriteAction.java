package com.systechafrica.action.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systechafrica.action.BaseAction;

import java.io.IOException;

@WebServlet("/my-favourites")
public class FavouriteAction extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderUserAccountPage(req, res, 1,  "<div class='UserPage'>" +
         "<h2> My Favourites</h2>" +
        "</div>");

    }
}
