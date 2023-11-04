package com.systechafrica.auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login", initParams = {
        @WebInitParam(name = "username", value = "Bella"),
        @WebInitParam(name = "password", value = "Nzioka")
})
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter print = res.getWriter();

        if (username.equals(getInitParameter("username"))
                && password.equals(getInitParameter("password"))) {

            req.setAttribute("homeInfo", "Welcome to Tatu Tours Home page");

            RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
            dispatcher.forward(req, res); //

        }
        else {
            print.write("<html><body>Invalid login details <a href=\".\"> Login again!! </a></body></html>");
        }

    }
}
