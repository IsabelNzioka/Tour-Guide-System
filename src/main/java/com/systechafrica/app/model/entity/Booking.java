package com.systechafrica.app.model.entity;

import java.util.Date;

import com.systechafrica.app.view.helper.HtmlForm;
import com.systechafrica.app.view.helper.HtmlFormField;
import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.app.view.helper.TableColHeader;


@HtmlTable(addUrl = "./admin-bookings?action=add")
@HtmlForm(label = "Tour", url = "./admin-bookings")
public class Booking {

    @TableColHeader(headerLabel = "Booking Code")
    @HtmlFormField(label = "Booking Code")
    private String code;

    @TableColHeader(headerLabel = "Customer Name")
    @HtmlFormField(label = "Customer Name")
    private String customerName;

    @TableColHeader(headerLabel = "Tour Name")
    @HtmlFormField(label = "Tour Name")
    private String tourName;

    @TableColHeader(headerLabel = "CreatedAt")
    // @HtmlFormField(label = "CreatedAt")
    private Date createdAt;

    @TableColHeader(headerLabel = "Status")
    @HtmlFormField(label = "Status")
    private String status;

    @TableColHeader(headerLabel = "Full Payment")
    @HtmlFormField(label = "Full Payment")
    private String fullPayment;
    

    public Booking() {
        
    }

    public Booking(String code, String customerName, String tourName) {
        this.code = code;
        this.customerName = customerName;
        this.tourName = tourName;
      
    }

    public Booking(String code, String customerName, String tourName, String status,
            String fullPayment) {
        this.code = code;
        this.customerName = customerName;
        this.tourName = tourName;
        this.createdAt =  new Date();
        this.status = status;
        this.fullPayment = fullPayment;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getTourName() {
        return tourName;
    }
    public void setTourName(String tourName) {
        this.tourName = tourName;
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
    public String getFullPayment() {
        return fullPayment;
    }
    public void setFullPayment(String fullPayment) {
        this.fullPayment = fullPayment;
    }
    

    
}
