package com.systechafrica.app.model.view;

import java.io.Serializable;

public class NavigationItemLInk implements Serializable {
    private String url;
    private String label;

    private NavigationItemLinkStatus status;


    public String getUrl() {
        return url;
    }

    public void setUrl(String link) {
        this.url = link;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public NavigationItemLinkStatus getStatus() {
        return status;
    }

    public void setStatus(NavigationItemLinkStatus status) {
        this.status = status;
    }

}
