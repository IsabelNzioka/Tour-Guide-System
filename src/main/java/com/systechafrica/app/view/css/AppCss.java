package com.systechafrica.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    private String style = "<style>" +
            "body,  * {" +
            "  margin: 0;" +
            "  padding: 0;" +
            "}" +
            ".topnav {" +
            "  display: flex;" +
            "  background-color: #363062;" +
            "  padding: 2.6rem;" +
            "  margin-bottom: 10px;" +
            "}" +
            ".topnav a {" +
            "  margin-right: 20px; " +
            "  text-decoration: none;" +
            "  color: #FF6C22;" +
            "}" +
            ".topnav a:hover {" +
            "  background-color: #04AA6D;" +
            "}" +
            ".topnav a.active {" +
            "  color: #ddd;" +
            "}" +
            ".Divs {" +
            "  background-color: #f2f2f2;" +
            "  padding: 20px;" +
            "  margin-bottom: 20px;" +
            "}" +

            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
