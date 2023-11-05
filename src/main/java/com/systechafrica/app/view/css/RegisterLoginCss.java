package com.systechafrica.app.view.css;

import java.io.Serializable;

public class RegisterLoginCss implements Serializable {

    private String style = "<style>" +
            ".formContainer {" +
            "    display: flex;" +
            "    margin-top: 2.5rem;" +
            "    flex-direction: column;" +
            "    justify-content: center;" +
            "    align-items: center;" +
            "    font-family: 'Lato', sans-serif;" +
            "}" +
            ".container {" +
            "    display: flex;" +
            "    width: 400px;" +
            "    flex-direction: column;" +
            "    justify-content: center;" +
            "    align-items: left;" +
            "}" +
            ".container label {" +
            "    color: #1A120B;" +
            "    padding-bottom: 6px;" +
            "    font-weight: 300;" +
            "}" +
            ".container a {" +
            "    color: #7F669D;" +
            "    padding-bottom: 6px;" +
            "    font-weight: 300;" +
            "}" +
            ".container p {" +
            "    padding-top: 1rem;" +
            "    font-weight: 300;" +
            "}" +
            ".container input {" +
            "    box-shadow: rgba(0, 0, 0, 0.1) 0px 0px 5px 0px, rgba(0, 0, 0, 0.1) 0px 0px 1px 0px;" +
            "    color: #1F1717;" +
            "    padding: 0.5rem 1rem;" +
            "    margin-bottom: 1.5rem;" +
            "    width: 100%;" +
            "    border: 1px solid #64868E;" +
            "    background-color: white;" +
            "    box-sizing: border-box;" +
            "    display: block;" +
            "}" +
            ".container input:focus {" +
            "    outline: none;" +
            "    background-color: #ccc;" +
            "    box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;" +
            "}" +
            ".ButtonSubmit {" +
            "    padding:  0.8rem 1rem;" +
            "    font-weight: 500;" +
            "    margin-top: 0.9rem;" +
            "    width: 34%;" +
            "    font-size: 1rem;" +
            "    letter-spacing: 1px;" +
            "    border-radius: 0.5rem;" +
            "    outline: none;" +
            "    border: 1px solid #b3967e;" +
            "    background-color: #2a2f4f;" +
            "    color: aliceblue;" +
            "    transition: all 2s;" +
            "}" +
            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
