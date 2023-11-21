package com.systechafrica.app.view.navbar;

import com.systechafrica.app.model.entity.UserRole;
import com.systechafrica.app.model.view.NavigationItemLInk;
import com.systechafrica.app.model.view.NavigationItemLinkStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Navbar  implements  Menu, Serializable {
    private String menu;

    private int activeLink;
    private UserRole userRole;

 

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getActiveLink() {
        return activeLink;
    }

    public void setActiveLink(int activeLink) {
        this.activeLink = activeLink;
    }

    private final List<NavigationItemLInk> links = new ArrayList<>();
    {
        links.add(new NavigationItemLInk("./home", "Home", NavigationItemLinkStatus.ACTIVE));
        links.add(new NavigationItemLInk("./tours", "tours", NavigationItemLinkStatus.NOT_ACTIVE));
        links.add(new NavigationItemLInk("./account-login", "account", NavigationItemLinkStatus.NOT_ACTIVE));
//        links.add(new NavigationItemLInk("./admin", "admin",NavigationItemLinkStatus.NOT_ACTIVE));
    }

    public String getMenu() {
    //    Check for the roles of the users to display the links accordingly
        if (getUserRole() != null && (getUserRole() ==   UserRole.ADMIN)) {
            links.add(new NavigationItemLInk("./admin", "admin", NavigationItemLinkStatus.NOT_ACTIVE));
        }
        
        this.activateLink(getActiveLink());
        String navbarLinks =    "<div class='topnav'>" ;

        for(NavigationItemLInk link : links)
            navbarLinks += "<a " + (link.getStatus() == NavigationItemLinkStatus.ACTIVE? "class=\"active\"" : "")
                    + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a>";

        navbarLinks += "</div>";
        return navbarLinks;
    }

    


    private void activateLink(int linkIndex) {
        for(int index = 0; index < links.size(); index++) {
            if(index == linkIndex)
                links.get(index).setStatus(NavigationItemLinkStatus.ACTIVE);
            else
                links.get(index).setStatus(NavigationItemLinkStatus.NOT_ACTIVE);
        }
    }


    @Override
    public String menu(int activeLinkIndex) {
       return null;
    }
}
