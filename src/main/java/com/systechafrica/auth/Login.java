package com.systechafrica.auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

@WebServlet("/login")
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId"))))
            res.sendRedirect("./home");
        else
             res.sendRedirect("./");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("loggedInId", new Date().getTime() + "");

        ServletContext ctx = getServletContext();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter print = res.getWriter();

        if (username.equals(ctx.getInitParameter("username"))
                && password.equals(ctx.getInitParameter("password"))) {

          httpSession.setAttribute("username", username);

//            RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
//            dispatcher.forward(req, res);
            res.sendRedirect("./home");

        }
        else {
            print.write("<html><body>Invalid login details <a href=\".\"> Login again!! </a></body></html>");
        }

    }
}
