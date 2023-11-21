package com.systechafrica.action.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.model.entity.Tour;

import com.systechafrica.app.view.helper.HtmlComponent;

import java.io.IOException;

@WebServlet("my-bookings")
public class BookingAction extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        renderUserAccountPage(req, res, 0,  "<div class='UserPage'>" +
                        "<h2> My Bookings</h2>" +
                        "</div>");

    }
}
