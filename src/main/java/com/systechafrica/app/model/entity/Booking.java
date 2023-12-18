package com.systechafrica.app.model.entity;

import java.util.Date;

import com.systechafrica.app.view.helper.*;
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



    @HtmlCard(name = "", className = "TourTitle")
    @TableColHeader(headerLabel = "Tour Name")
    @Formula("(select t.name from tours t where t.id=tour_id)")
    private String tourName;

    @HtmlCard(name = "Tour Image", className = "TourImage")
    @Formula("(select t.image from tours t where t.id=tour_id)")
    private String imageurl;



    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @TableColHeader(headerLabel = "CreatedAt", dateFormat = "dd-MM-yyyy")
    @HtmlFormField(label = "CreatedAt", type = HtmlFormFieldType.DATE)
    private Date createdAt;

    @Column(name = "status")
    @TableColHeader(headerLabel = "Status")
    @HtmlFormField(label = "Status")
    private String status;

    @Column(name = "payment_status")
    @TableColHeader(headerLabel = "Payment Status")
    @HtmlFormField(label = "Payment Status")
    private String fullPayment;

    public Booking() {

    }
    public String getBookingNo() {
        return bookingNo;
    }
    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "Booking{" +
                "bookingNo='" + bookingNo + '\'' +
                ", user=" + user +
                ", tour=" + tour +
                ", tourName='" + tourName + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", fullPayment='" + fullPayment + '\'' +
                '}';
    }
}
