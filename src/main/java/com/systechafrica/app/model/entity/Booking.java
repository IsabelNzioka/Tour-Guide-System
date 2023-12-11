package com.systechafrica.app.model.entity;

import java.util.Date;

import com.systechafrica.app.view.helper.HtmlForm;
import com.systechafrica.app.view.helper.HtmlFormField;
import com.systechafrica.app.view.helper.HtmlFormFieldType;
import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.app.view.helper.TableColHeader;

import javax.persistence.*;


@Entity
@Table(name = "bookings")
@HtmlTable(addUrl = "./admin-bookings?action=add",searchUrl = "./admin-bookings?action=searchUrl",deleteUrl = "./admin-bookings?action=delete")
@HtmlForm(label = "Booking", url = "./tour-booking")
public class Booking  extends BaseEntity {

    @Column(name = "booking_no")
    @TableColHeader(headerLabel = "Booking Number")
    private String bookingNo;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tour tour;

//
//    @Column(name = "tour_name")
//    @TableColHeader(headerLabel = "Tour Name")
//    @HtmlFormField(label = "Tour Name")
//    private String tourName;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @TableColHeader(headerLabel = "CreatedAt" , dateFormat = "dd-MM-yyyy")
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

//    public String getTourName() {
//        return tourName;
//    }
//    public void setTourName(String tourName) {
//        this.tourName = tourName;
//    }
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
    public String getFullPayment() {
        return fullPayment;
    }
    public void setFullPayment(String fullPayment) {
        this.fullPayment = fullPayment;
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
}
