package com.systechafrica.app.view.html;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.view.css.AppCss;
import com.systechafrica.app.view.navbar.Navbar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest req, HttpServletResponse res, int activeMenu, String content) throws IOException {

        ServletContext ctx = req.getServletContext();
        HttpSession httpSession = req.getSession();

//        TourBeanI accountBean = new TourBean();

        PrintWriter print = res.getWriter();
        print.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                     new AppCss().getStyle() +
                "</head>" +
                "<body>" +
                    new Navbar().menu(activeMenu) +
//                "<h3>" + ctx.getInitParameter("AppName") + "<h3>" +
                "<br/>&nbsp;<br/>" +
                "Welcome: " + httpSession.getAttribute("username") + "\n" +

                "<div class=\"Content\">"  );
                    print.write(content);
                    print.write( "</div>\n" +
                            "<a href=\"./logout\">Logout</a> \n" +
                            "</body>\n" +
                            "</html>");


    }
}
