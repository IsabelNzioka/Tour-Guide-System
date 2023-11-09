package com.systechafrica.app.model.entity;

import com.systechafrica.app.view.html.HtmlForm;
import com.systechafrica.app.view.html.HtmlFormField;
import com.systechafrica.app.view.html.TableColHeader;

import java.io.Serializable;

@HtmlForm(label = "Tour", url = "./add-tour")
public class Tour  implements Serializable {
    @TableColHeader(headerLabel = "Tour code")
    @HtmlFormField(label = "Tour Code") //override default name
    private String code;
    @TableColHeader(headerLabel = "Tour Name")
    @HtmlFormField(label = "Tour Name")
    private String name;

    @TableColHeader(headerLabel = "Tour Price")
    @HtmlFormField(label = "Tour price", type = "number")
    private int price;
    private int durationindays;

    @TableColHeader(headerLabel = "Tour Category")
    @HtmlFormField(label = "Tour Category")
    private TourCategory tourCategories;
    private String summary;
    private String imageurl;

    private int ratings;





//  Todo - database details
//    start date - end date
//    ratings
//    cancellation - free?
//    image - love button?
//    from - price details if they vary by the size of the group
//    duration - HOurs??




    public  Tour() {

    }




    public Tour(String code, String name, int price, int durationindays, TourCategory tourCategories, String summary, String imageurl, int ratings) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.durationindays = durationindays;
        this.tourCategories = tourCategories;
        this.summary = summary;
        this.imageurl = imageurl;
        this.ratings = ratings;
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


    public TourCategory getTourCategories() {
        return tourCategories;
    }

    public void setTourCategories(TourCategory tourCategories) {
        this.tourCategories = tourCategories;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

//    public  String tourCard(){
//        StringBuilder cardBuilder = new StringBuilder();
//        cardBuilder.append("<div class='Divs'>");
//        cardBuilder.append("<p>").append(getName().trim()).append("</p>");
//        cardBuilder.append("<p>").append(getPrice() == 0 ? "..." : getPrice()).append("</p>");
//        cardBuilder.append("<p>").append(getSummary().trim()).append("</p>");
//        cardBuilder.append("</div>");
//
//        return cardBuilder.toString();
//    }


}
