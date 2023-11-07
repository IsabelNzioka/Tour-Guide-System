package com.systechafrica.app.model.entity;

import java.io.Serializable;

public class Tour  implements Serializable {
    private String code;
    private String name;

    private int price;
    private int durationindays;
    private TourCategories tourCategories;
    private String summary;
    private String imageurl;





//  Todo - database details
//    ratings
//    cancellation - free?
//    image - love button?
//    from - price details if they vary by the size of the group
//    duration - HOurs??




    public  Tour() {

    }

//    public Tour(String code, String name, String summary, int durationindays, int price, String imageurl) {
//        this.code = code;
//        this.name = name;
//        this.summary = summary;
//        this.durationindays = durationindays;
//        this.price = price;
//        this.imageurl = imageurl;
//    }

    public Tour(String code, String name, String summary, int price, int durationindays, String imageurl, TourCategories tourCategories) {
        this.code = code;
        this.name = name;
        this.summary = summary;
        this.price = price;
        this.durationindays = durationindays;
        this.imageurl = imageurl;
        this.tourCategories = tourCategories;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDurationindays() {
        return durationindays;
    }

    public void setDurationindays(int durationindays) {
        this.durationindays = durationindays;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }


    public TourCategories getTourCategories() {
        return tourCategories;
    }

    public void setTourCategories(TourCategories tourCategories) {
        this.tourCategories = tourCategories;
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
