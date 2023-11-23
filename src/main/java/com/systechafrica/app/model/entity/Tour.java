package com.systechafrica.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.systechafrica.app.view.helper.*;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

@DbTable(name = "tours")
@HtmlTable(addUrl = "./admin-tours?action=add")
@HtmlForm(label = "Tour", url = "./admin-tours")
public class Tour  extends BaseEntity {



    @DbTableColumn(name = "Name")
    @HtmlCard(name = "", className = "TourTitle")
    @TableColHeader(headerLabel = "Tour Name")
    @HtmlFormField(label = "Tour Name")
    private String name;

    @DbTableColumn(name = "Price")
    @HtmlCard(name = "$", className = "Price")
    @TableColHeader(headerLabel = "Tour Price")
    @HtmlFormField(label = "Tour price", type = HtmlFormFieldType.NUMBER)
    private BigDecimal price;


    @TableColHeader(headerLabel = "Start Date" , dateFormat = "dd-MM-yyyy")
    @HtmlFormField(label = "Start Date", type = HtmlFormFieldType.DATE)
    private Date startDate;

    @TableColHeader(headerLabel = "End Date" , dateFormat = "dd-MM-yyyy")
    @HtmlFormField(label = "End Date", type = HtmlFormFieldType.DATE)
    private Date endDate;

   


    @HtmlCard(name = "Days: ", className = "TourDetails")
    private int durationindays;

    @TableColHeader(headerLabel = "Tour Category")
    @HtmlFormField(label = "Tour Category")
    private TourCategory tourCategories;

    private String summary;

    @HtmlCard(name = "Tour Image", className = "TourImage")
    @HtmlFormField(label = "Tour Image")
    private String imageurl;

    private int ratings;





//  Todo - database details
//    start date - end date
//    ratings
//    cancellation - free?
//    image - love button?
//    from - price details if they vary by the size of the group
//    duration - HOurs?? days?? - Can be calculated using the start date and the end dta




    public  Tour() {

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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


     public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }




}
