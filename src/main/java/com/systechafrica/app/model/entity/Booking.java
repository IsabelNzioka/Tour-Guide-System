package com.systechafrica.app.model.entity;

import java.util.Date;

import com.systechafrica.app.view.helper.HtmlForm;
import com.systechafrica.app.view.helper.HtmlFormField;
import com.systechafrica.app.view.helper.HtmlFormFieldType;
import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.app.view.helper.TableColHeader;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;


@DbTable(name = "bookings")
@HtmlTable(addUrl = "./admin-bookings?action=add")
@HtmlForm(label = "Tour", url = "./admin-bookings")
public class Booking  extends BaseEntity {

//    @DbTableColumn(name = "Booking_code")
//    @TableColHeader(headerLabel = "Booking Code")
//    @HtmlFormField(label = "Booking Code")
//    private String code;

    @DbTableColumn(name = "Customer_name")
    @TableColHeader(headerLabel = "Customer Name")
    @HtmlFormField(label = "Customer Name")
    private String customerName;

    @TableColHeader(headerLabel = "Tour Name")
    @HtmlFormField(label = "Tour Name")
    private String tourName;

    @TableColHeader(headerLabel = "CreatedAt" , dateFormat = "dd-MM-yyyy")
    @HtmlFormField(label = "CreatedAt", type = HtmlFormFieldType.DATE)
    private Date createdAt;

    @TableColHeader(headerLabel = "Status")
    @HtmlFormField(label = "Status")
    private String status;

    @TableColHeader(headerLabel = "Payment Status")
    @HtmlFormField(label = "Payment Status")
    private String fullPayment;
    

    public Booking() {
        
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
