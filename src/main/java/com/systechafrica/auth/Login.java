package com.systechafrica.auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter print = res.getWriter();

        if(username.equals("Bella") && password.equals("Nzioka")) {

            req.setAttribute("homeInfo", "Welcome to Tatu Tours Home page");

            RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
//            dispatcher.include(req, res); //include the home.html in the same route
            dispatcher.forward(req, res); //

//            res.sendRedirect("./app/home.html");  //changes  url
        }
        else {
            print.write("<html><body>Invalid login details <a href=\".\"> Login again </a></body></html>");
        }

    }
}
