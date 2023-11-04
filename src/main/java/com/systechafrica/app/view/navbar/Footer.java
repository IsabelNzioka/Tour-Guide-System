package com.systechafrica.app.view.navbar;

import com.systechafrica.app.model.view.NavigationItemLInk;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

public class Footer  implements  Menu, Serializable {
    @Override
    public String menu(int activeLinkIndex) {
        return StringUtils.EMPTY;
    }
}
