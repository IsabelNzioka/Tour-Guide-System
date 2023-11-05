package com.systechafrica.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    private String style = "<style>" +
            "body,  * {" +
            "  margin: 0;" +
            "  padding: 0;" +
            "font-family: 'Lato', sans-serif;" +
            " font-size: 1rem;" +
            "}" +
            ".NavbarContent {" +
            "  display: flex;" +
            "  justify-content: space-between;" +
            "  background-color: #363062;" +
            " align-items: center;" +
            "color: #F1EAFF; "+
            "}" +
            ".NavbarContent span{ " +
            "font-family: 'Fjalla One', sans-serif;" +
            "  padding-left: 2.6rem;" +
            "  font-size: 2.6rem;" +
            "}" +
            ".topnav {" +
            "  display: flex;" +
            "  padding: 2.6rem;" +
            "  margin-bottom: 10px;" +
            "}" +
            ".topnav a {" +
            "  margin-right: 20px; " +
            "  text-decoration: none;" +
            "  color: #F1EAFF; "+
            "font-size: 1.1rem;" +
            "}" +
            ".topnav a:hover {" +
            "  color: ##7F669D;" +
            "}" +
            ".topnav a.active {" +
            " text-decoration: underline #7F669D;" +
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
