package com.systechafrica.app.view.navbar;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;

public class Footer  implements  Menu, Serializable {
    @Override
    public String menu(int activeLinkIndex) {
        return StringUtils.EMPTY;
    }
}
