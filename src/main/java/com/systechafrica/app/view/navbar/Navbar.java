package com.systechafrica.app.view.navbar;

import com.systechafrica.app.model.view.NavigationItemLInk;
import com.systechafrica.app.model.view.NavigationItemLinkStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Navbar  implements  Menu, Serializable {

    private final List<NavigationItemLInk> links = new ArrayList<>();

    {
        links.add(new NavigationItemLInk("./home", "Home", NavigationItemLinkStatus.ACTIVE));
        links.add(new NavigationItemLInk("./tours", "tours", NavigationItemLinkStatus.NOT_ACTIVE));
        links.add(new NavigationItemLInk("./account", "account", NavigationItemLinkStatus.NOT_ACTIVE));
        links.add(new NavigationItemLInk("./admin", "admin",NavigationItemLinkStatus.NOT_ACTIVE));
    }
    @Override
    public String menu(int activeLinkIndex) {
        this.activateLink(activeLinkIndex);

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
}
