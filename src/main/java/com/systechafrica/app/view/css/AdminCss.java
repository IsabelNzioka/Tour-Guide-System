package com.systechafrica.app.view.css;

import java.io.Serializable;

public class AdminCss implements Serializable {

    private String style = "<style>" +
            ".Content {" +
            "   display: flex;" +
            "   justify-content: space-between;" +
            "   align-items: flex-start;" +
            "     width: 100%;" +
            "min-height: 100vh;" +
            "}" +
            ".Content span{ " +
              "font-family: 'Fjalla One', sans-serif;" +
            "  padding-left: 2.7rem;" +
            "Margin-bottom: 3rem;" +
            "  font-size: 2.6rem;" +
            "   color: #F3FBF1; "+
            "}" +
            ".ContentLinks {" +
            "  padding: 2rem;" +
            "  flex: 0 0 25%;" +
             "height: 100vh;" +
            "   display: flex;" +
            "   flex-direction: column;" +
            "    background-color: #363062;" +
            "   color: #FAAB78; "+
            "}" +
            ".ContentLinks  a{" +
                "font-size: 1.2rem;" +
                "  padding-left: 2.6rem;" +
                "  padding-top: 1rem;" +
                "  text-decoration: none;" +
                "   color: #F3FBF1; "+
                "}" +
            ".ContentLinks  a.active {" +
            " text-decoration: underline #7F669D;" +
            "}" +
            ".ContentLinkContent {" +
                "padding: 2rem;" +
                "height: 100vh;" +
                "  flex: 1;" +
                "}" +
            ".TourList {" +
                "list-style-type: none;" +
                "margin-top: 3rem;" +
                "padding: .1rem;" +
                "}" +
            ".TourList li {" +
               " background-color: #f9f9f9;" +
                "margin: 0.5em 0;" +
               " padding: 0.5em;" +
               " border-bottom: 1px solid #ddd;" +
                "border-radius: 5px;" +
          " }" +
            "table {" +
                "  width: 100%;" +
                "    border-collapse: collapse;" +
                "  margin-top: 4rem;" +
                "}" +
            "th, td {" +
                "  border: 1px solid #D1E4D1;" +
                "  text-align: left;" +
                "  padding: 1.2rem;" +
                "}" +
            "th {" +
                "  background-color: #f2f2f2;" +
                "}" +
            ".AddToursPage{" +
                " margin: 4rem;" +
                "}" +
            ".AddToursPage form{" +
                " width: 100%;" +
//                "background-color: red;" +
                "}" +
            ".AddToursPage input {" +
            "    box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 5px 0px, rgba(0, 0, 0, 0.1) 0px 0px 1px 0px;" +
            "    color: #1F1717;" +
            "    padding: 0.5rem 1rem;" +
            "    margin-bottom: .7rem;" +
            "    width: 100%;" +
            "    border: 1px solid #64868E;" +
            "    background-color: white;" +
            "    box-sizing: border-box;" +
            "    display: block;" +
            "}" +
            ".AddToursPage input:focus {" +
            "    outline: none;" +
            "    background-color: #ccc;" +
            "    box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;" +
            "}" +
            ".SubmitButton {" +
            "    padding:  0.8rem 1rem;" +
            "    font-weight: 500;" +
            "    margin-top: 0.9rem;" +
            "    width: 50%;" +
            "    font-size: 1rem;" +
            "    letter-spacing: 1px;" +
            "    border-radius: 0.5rem;" +
            "    outline: none;" +
            "    border: 1px solid #b3967e;" +
            "    background-color: #2a2f4f;" +
            "    color: aliceblue;" +
            "    transition: all 2s;" +
            "}" +
//            //////////////////////////////////////////

            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
