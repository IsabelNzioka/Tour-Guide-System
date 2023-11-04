package com.systechafrica.app.model;

import java.io.Serializable;

public class Tour  implements Serializable {
    private String code;
    private String name;
    private String summary;
    private int durationInDays;
    private int price;

//    ratings
//    cancellation - free?
//    image - love button?
//    from - price details if they vary by the size of the group
//    duration - HOurs??




    public  Tour() {

    }

    public Tour(String code, String name, String summary, int durationInDays, int price) {
        this.code = code;
        this.name = name;
        this.summary = summary;
        this.durationInDays = durationInDays;
        this.price = price;
    }

    public Tour(String code, String name, String summary, int price) {
        this.code = code;
        this.name = name;
        this.summary = summary;

        this.price = price;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        price = price;
    }



    public  String tourCard(){
        StringBuilder cardBuilder = new StringBuilder();
        cardBuilder.append("<div class='Divs'>");
        cardBuilder.append("<p>").append(getName().trim()).append("</p>");
        cardBuilder.append("<p>").append(getPrice() == 0 ? "..." : getPrice()).append("</p>");
        cardBuilder.append("<p>").append(getSummary().trim()).append("</p>");
        cardBuilder.append("</div>");

        return cardBuilder.toString();
    }


}
