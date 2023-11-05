package com.systechafrica.app.view.navbar;

import com.systechafrica.app.model.entity.User;
import com.systechafrica.app.model.entity.UserRole;
import com.systechafrica.app.model.view.NavigationItemLInk;
import com.systechafrica.app.model.view.NavigationItemLinkStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NavbarSingletonPattern implements  Menu, Serializable {
    private static NavbarSingletonPattern instance;
    private final List<NavigationItemLInk> links = new ArrayList<>();

    private NavbarSingletonPattern() {
        links.add(new NavigationItemLInk("./", "Home", NavigationItemLinkStatus.ACTIVE));
        links.add(new NavigationItemLInk("./tours", "tours", NavigationItemLinkStatus.NOT_ACTIVE));
        links.add(new NavigationItemLInk("./account-login", "account", NavigationItemLinkStatus.NOT_ACTIVE));
    }


    public static NavbarSingletonPattern getInstance() {
        if (instance == null) {
            instance = new NavbarSingletonPattern();
        }
        return instance;
    }

    @Override
    public String menu(int activeLinkIndex, User user) {


//        avoid adding admin link more than once
        if (user != null && user.getRole() == UserRole.ADMIN) {
            boolean adminLinkExists = false;
            for (NavigationItemLInk link : links) {
                if (link.getUrl().equals("./admin")) {
                    adminLinkExists = true;
                    break;
                }
            }
            if (!adminLinkExists) {
                links.add(new NavigationItemLInk("./admin", "admin", NavigationItemLinkStatus.NOT_ACTIVE));
            }
        }

        this.activateLink(activeLinkIndex);

        String navbarLinks = "<div class='topnav'>";

        for (NavigationItemLInk link : links)
            navbarLinks += "<a " + (link.getStatus() == NavigationItemLinkStatus.ACTIVE ? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";

        navbarLinks += "</div>";
        return navbarLinks;
    }

    private void activateLink(int linkIndex) {
        for (int index = 0; index < links.size(); index++) {
            if (index == linkIndex)
                links.get(index).setStatus(NavigationItemLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(NavigationItemLinkStatus.NOT_ACTIVE);
        }
    }
}
