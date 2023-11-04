package com.systechafrica.home;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home  extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {

            ServletContext ctx = getServletContext();

            TourBeanI accountBean = new TourBean();

            PrintWriter print = res.getWriter();
            print.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <style>\n" +
                    "body,  * {\n" +
                    "  margin: 0;\n" +
                    "  padding: 0;\n" +
                    "}\n" +
                    ".topnav {\n" +
                    "  display: flex;\n" +
                    "  background-color: #363062;\n" +
                    "  padding: 2.6rem;\n" +
                    "  margin-bottom: 10px;\n" +
                    "}\n" +
                    ".topnav a {\n" +
                    "  margin-right: 20px; \n" +
                    "  text-decoration: none;\n" +
                    "  color: #FF6C22;\n" +
                    "}\n" +
                    ".topnav a:hover {\n" +
                    "  background-color: #04AA6D;\n" +
                    "}\n" +
                    ".topnav a.active {\n" +
                    "  color: #ddd;\n" +
                    "}\n" +
                    ".Divs {\n" +
                    "  background-color: #f2f2f2;\n" +
                    "  padding: 20px;\n" +
                    "  margin-bottom: 20px;\n" +
                    "}\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class='topnav'>\n" +
                    "<a class=\"active\" href=\"./home\">Home</a>\n" +
                    "<a href=\"./tours\">Tours</a>\n" +
                    "</div> " +
                    "Welcome: " + httpSession.getAttribute("username") + "\n" +
                    "<a href=\"./tours\">View all Tours </a> \n" +
                    "<a href=\"./logout\">Logout</a> \n" +
                    "<h2>Available Tours</h2>\n" +
                    "<div class=\"divs\">" +
                    accountBean.availableTours() +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>");

        }
        else {
            res.sendRedirect("./");
        }
    }

}