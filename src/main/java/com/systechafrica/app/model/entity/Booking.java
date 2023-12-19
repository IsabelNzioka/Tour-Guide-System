package com.systechafrica.app.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.systechafrica.app.view.helper.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;


@Entity
@Table(name = "bookings")
@HtmlTable(addUrl = "./admin-bookings?action=add", editUrl = "./admin-bookings?action=update", deleteUrl = "./admin-bookings?action=delete")
@HtmlForm(label = "Booking", url = "./tour-booking")
public class Booking extends BaseEntity {
    @Column(name = "booking_no")
    @TableColHeader(headerLabel = "Booking Number")
    private String bookingNo;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "tour_id")
    private Tour tour;


    @Formula("tour_id")
    private Long tourId;

    @Formula("user_id")
    private Long userId;



    @Column(name = "noOfPeople")
    @TableColHeader(headerLabel = "NumberOfPeople")
    @HtmlFormField(label = "NumberOfPeople", id = "numberOfPeople")
    private Integer noOfPeople;

    @HtmlCard(name = "", className = "TourTitle")
    @TableColHeader(headerLabel = "Tour Name")
    @Formula("(select t.name from tours t where t.id=tour_id)")
    private String tourName;

    @HtmlCard(name = "Tour Image", className = "TourImage")
    @Formula("(select t.image from tours t where t.id=tour_id)")
    private String imageurl;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;


    @Column(name = "created_at")
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonIgnore
    private LocalDateTime createdAt;

    @Column(name = "status")
    @TableColHeader(headerLabel = "Status")
    private String status;

    @Column(name = "payment_status")
    @TableColHeader(headerLabel = "Payment Status")
    private String fullPayment;

    public Booking() {

    }

    public String getBookingNo() {
        return bookingNo;
    }
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }
     public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getFullPayment() {
        return fullPayment;
    }

    public void setFullPayment(String fullPayment) {
        this.fullPayment = fullPayment;
    }

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        this.noOfPeople = noOfPeople;
    }



    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    @PrePersist
    public void calculateTotalPriceBeforePersist() {
        if (noOfPeople != null && tour != null && tour.getPrice() != null) {
            totalPrice = tour.getPrice().multiply(new BigDecimal(noOfPeople));
        } else {
            totalPrice = BigDecimal.ZERO;
        }
    }
}
