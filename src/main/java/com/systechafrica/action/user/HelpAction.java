package com.systechafrica.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systechafrica.action.BaseAction;

@WebServlet("/help")
public class HelpAction  extends BaseAction{

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        renderUserAccountPage(req, res, 2,  "<div class='UserPage'>" +
         "<h2> Help</h2>" +
        "</div>");

    }
    
}
