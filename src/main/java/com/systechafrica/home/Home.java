package com.systechafrica.home;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home  extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String homeInfo = (String) req.getAttribute("homeInfo");

        RequestDispatcher dispatcher = req.getRequestDispatcher("./app");
        dispatcher.forward(req, res);

         PrintWriter print = res.getWriter();
            print.write("<html><body></a></body></html>");


    }
}
