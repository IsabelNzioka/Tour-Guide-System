package com.systechafrica.app.view.helper;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.view.css.AppCss;
import com.systechafrica.app.view.css.RegisterLoginCss;
import com.systechafrica.app.view.navbar.Navbar;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class LoginPage implements Serializable {

    public void renderLogin(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content) throws IOException {

        ServletContext ctx = req.getServletContext();
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");

        PrintWriter print = res.getWriter();
        print.write("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Title</title>" +
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap\" rel=\"stylesheet\">" +
                " <link href=\"https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap\" rel=\"stylesheet\">" +
                "<script src=\"https://kit.fontawesome.com/1211563ad5.js\" crossorigin=\"anonymous\"></script>" +
                new AppCss().getStyle() +
                new RegisterLoginCss().getStyle() +
                "</head>" +
                "<body>" +
                "<div class=\"NavbarContent\"> " +
                "<span>Nata Travels</span>" +
                new Navbar().menu(activeMenu, user) +
//                NavbarSingletonPattern.getInstance().menu(activeMenu, user) +
                "</div>" +
//                "<h3>" + ctx.getInitParameter("AppName") + "<h3>" +
                "<br/>&nbsp;<br/>" +
                "<div class=\"formContainer\">" +
                "<form action=\"./account-login\" method=\"post\">" +
                "<div class=\"container\">" +
                "    <label for=\"username\"><b>Username</b></label>" +
                "    <input type=\"text\" placeholder=\"Enter Username\" name=\"username\" required>" +
                "    <label for=\"password\"><b>Password</b></label>" +
                "    <input type=\"password\" placeholder=\"Enter Password\" name=\"password\" required>" +
                "    <button type=\"submit\" class=\"ButtonSubmit\">Login</button>" +
                "</div>" +
                "<div class=\"container\">" +
                "    <span class=\"psw\">Have you forgotten your <a href=\"#\">password?</a></span>" +
                "<p>Don't have an Account yet ?</p>" +
                "<a href=\"./account-register\">Create account</a>" +
                "</div>" +
                "</form>" +

                "</div>" +
                "</body>" +
                "</html>");
    }
}