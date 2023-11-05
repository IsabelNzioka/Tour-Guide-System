package com.systechafrica.app.view.html;

import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.User;
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
                "</head>" +
                "<body>" +
                "<div class=\"NavbarContent\"> " +
                "<span>Nata Travels</span>" +
                   new Navbar().menu(activeMenu, user) +
                "</div>" +

//                "<h3>" + ctx.getInitParameter("AppName") + "<h3>" +
                "<div class=\"Content\">"  );
                    print.write(content);
                    print.write( "</div>\n" +
                            "</body>\n" +
                            "</html>");


    }
}
