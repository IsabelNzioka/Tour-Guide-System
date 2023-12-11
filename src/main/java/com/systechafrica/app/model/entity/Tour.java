package com.systechafrica.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.systechafrica.app.view.helper.*;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tours")
@HtmlTable(addUrl = "./admin-tours?action=add",searchUrl = "./admin-tours?action=searchUrl", deleteUrl = "./admin-tours?action=delete", url ="./admin-tours")
@HtmlForm(label = "Tour", url = "./admin-tours")
public class Tour  extends BaseEntity {

//TODO - REMOVE - TESTING
@Column(name = "booking_no")
@TableColHeader(headerLabel = "Booking Number")
private String bookingNo;

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    @Column(name = "name")
    @HtmlCard(name = "", className = "TourTitle")
    @TableColHeader(headerLabel = "Tour Name")
    @HtmlFormField(label = "Tour Name")
    private String name;

    @Column(name = "price")
    @HtmlCard(name = "$", className = "Price")
    @TableColHeader(headerLabel = "Tour Price")
    @HtmlFormField(label = "Tour price", type = HtmlFormFieldType.NUMBER)
    private BigDecimal price;


    @Column(name = "start_date")
    @TableColHeader(headerLabel = "Start Date" , dateFormat = "dd-MM-yyyy")
    @HtmlFormField(label = "Start Date", type = HtmlFormFieldType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @TableColHeader(headerLabel = "End Date" , dateFormat = "dd-MM-yyyy")
    @HtmlFormField(label = "End Date", type = HtmlFormFieldType.DATE)
    private Date endDate;




    @Transient
    @HtmlCard(name = "Days: ", className = "TourDetails")
    private int durationindays;

    @Transient
    @TableColHeader(headerLabel = "Tour Category")
    @HtmlFormField(label = "Tour Category")
    private TourCategory tourCategories;

    @Transient
    private String summary;

    @Column(name = "image")
    @HtmlCard(name = "Tour Image", className = "TourImage")
    @HtmlFormField(label = "Tour Image")
    private String imageurl;

    @Transient
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


    @Override
    public String toString() {
        return "Tour{" +
                "bookingNo='" + bookingNo + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", durationindays=" + durationindays +
                ", tourCategories=" + tourCategories +
                ", summary='" + summary + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
