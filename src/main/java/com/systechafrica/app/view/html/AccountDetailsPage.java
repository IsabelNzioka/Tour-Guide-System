package com.systechafrica.app.view.html;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.css.AdminCss;
import com.systechafrica.app.view.css.AppCss;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AccountDetailsPage implements Serializable {

    public void renderAccountDetails(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content) throws IOException {

        ServletContext ctx = req.getServletContext();
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");

//        TourBeanI accountBean = new TourBean();

        PrintWriter print = res.getWriter();
        print.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap\" rel=\"stylesheet\">" +
                " <link href=\"https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap\" rel=\"stylesheet\">" +
                "<script src=\"https://kit.fontawesome.com/1211563ad5.js\" crossorigin=\"anonymous\"></script>" +
                new AppCss().getStyle() +
                new AdminCss().getStyle() +
                "</head>" +
                "<body>" +

                "<div class=\"Content\">" +
                "<div class=\"ContentLinks\">" +
                "<span>Nata Travels</span>" +
                "<h3 class=\"WelcomeUser\">Hi, " +
                user.getUsername() +
                "</h3>" +
                "<a " + (activeMenu == 0 ? "class=\"active\"" : "") + " href=\"./my-bookings\">Bookings</a> \n" +
                "<a " + (activeMenu == 1 ? "class=\"active\"" : "") + " href=\"./my-favourites\">Favourites</a> \n" +
                "<a " + (activeMenu == 2 ? "class=\"active\"" : "") + " href=\"./help\">Help</a> \n" +
                "<a href=\"./\">Site</a> \n" +
                "<a href=\"./logout\">Logout</a> \n" +
                "</div>" +
                "<div class=\"ContentLinkContent\">");
        print.write(content);

        print.write( "</div>" +
                "</div>\n" +

                "</body>\n" +
                "</html>");


    }


}
