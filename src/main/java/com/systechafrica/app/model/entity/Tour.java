package com.systechafrica.app.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.systechafrica.app.view.helper.*;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tours")
@HtmlTable(addUrl = "./admin-tours?action=add",editUrl = "./admin-tours?action=update", deleteUrl = "./admin-tours?action=delete", url ="./admin-tours")
@HtmlForm(label = "Tour", url = "./admin-tours")
@DynamicInsert
@DynamicUpdate
public class Tour  extends BaseEntity {

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
    @Temporal(TemporalType.DATE)
    @TableColHeader(headerLabel = "start_date" , dateFormat = "yyyy-MM-dd")
    @HtmlFormField(label = "Start Date", type = HtmlFormFieldType.DATE)
    private Date startDate;

    @Column(name = "created_at")
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonIgnore
    private LocalDateTime createdAt;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    @TableColHeader(headerLabel = "End_Date" , dateFormat = "yyyy-MM-dd")
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


    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Booking> bookings;

    @JsonIgnore
    public List<Booking> getBookings() {
        return bookings;
    }


    @ElementCollection
    @CollectionTable(name = "tour_images", joinColumns = @JoinColumn(name = "tour_id"))
    @Column(name = "image_url", length = 100000)
    private List<String> imageUrls;

    @Transient
    @HtmlFormField(label = "Image URLs", type = HtmlFormFieldType.TEXT)
    private String imageUrlsAsString;

    // Convert the comma-separated string to a list
    @PostLoad
    private void convertImageUrls() {
        if (imageUrlsAsString != null) {
            imageUrls = List.of(imageUrlsAsString.split(","));
        }
    }

    // Convert the list to a comma-separated string
    @PrePersist
    @PreUpdate
    private void convertImageUrlsAsString() {
        if (imageUrls != null) {
            imageUrlsAsString = String.join(",", imageUrls);
        }
    }

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


    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getImageUrlsAsString() {
        return imageUrlsAsString;
    }

    public void setImageUrlsAsString(String imageUrlsAsString) {
        this.imageUrlsAsString = imageUrlsAsString;
    }

    @Override
    public String toString() {
        return "Tour{" +
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
