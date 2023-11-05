package com.systechafrica.action.admin;

import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/add-tour")
public class AddTourAction  extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if(StringUtils.isNotBlank((String) httpSession.getAttribute(("loggedInId")))) {
            Database database = Database.getDbInstance();
            int tourPrice = Integer.parseInt(req.getParameter("price"));
            String tourName = req.getParameter("name");
            String tourSummary = req.getParameter("summary");
            String tourCode = req.getParameter("code");

            database.getTours().add(new Tour(tourCode, tourName, tourSummary ,tourPrice));

            res.sendRedirect("/Tours-system/admin");
        }
        else {
            res.sendRedirect("./");
        }
    }
}
