package com.systechafrica.action.admin;

import com.systechafrica.action.BaseAction;
import com.systechafrica.app.bean.TourBean;
import com.systechafrica.app.bean.TourBeanI;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.view.helper.HtmlComponent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/add-tour")
public class AddTourAction  extends BaseAction {
    private Tour tour = new Tour();
    private TourBeanI tourBean = new TourBean();
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
