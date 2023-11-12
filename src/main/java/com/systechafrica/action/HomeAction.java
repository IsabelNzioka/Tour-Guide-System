package com.systechafrica.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.systechafrica.app.view.helper.AppPage;

import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends BaseAction{
//    TourBeanI tourBean = new TourBean();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        renderPage(req, res, 0, "<div class='HomePage'> Home content, to be removed </div>");

    }

}