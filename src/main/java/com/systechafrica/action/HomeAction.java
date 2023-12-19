package com.systechafrica.action;

import com.systechafrica.app.bean.UserBeanI;
import com.systechafrica.app.model.entity.UserIpAddress;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/")
public class HomeAction extends BaseAction{
    @EJB
    UserBeanI userBean;

    @Inject
    private Event<UserIpAddress> userIpAddressEvent;


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderPage(req, res, 0, "<div class='HomePage'> </div>");

    }



}