package com.systechafrica.app.view.navbar;

import com.systechafrica.app.model.view.NavigationItemLInk;

import java.io.Serializable;
import java.util.List;

public class Navbar  implements  Menu, Serializable {
    @Override
    public String menu(List<NavigationItemLInk> links) {
        String navbarLinks =    "<div class='topnav'>\n" ;
        return navbarLinks;
    }
}
