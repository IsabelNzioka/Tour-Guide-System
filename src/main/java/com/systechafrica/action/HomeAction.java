package com.systechafrica.action;

import com.systechafrica.app.view.html.AppPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class HomeAction extends HttpServlet {
//    TourBeanI tourBean = new TourBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

            new AppPage().renderHtml(req, res, 0,
                    "<div class='HomePage'>" +
                            "</div>" );

    }

}