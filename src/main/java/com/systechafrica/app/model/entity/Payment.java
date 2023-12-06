package com.systechafrica.app.model.entity;


import com.systechafrica.app.view.helper.HtmlTable;
import com.systechafrica.database.helper.DbTable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments")
@HtmlTable(addUrl = "./admin-payments?action=add")
public class Payment extends  BaseEntity{

    private String paymentNo;
    private BigDecimal paymentAmount;
    private Date paymentDate;
    private String paymentStatus;
//    private String paymentMethod;  Todo - use utils
//    private String transactionReference;
//    private String currency;
//    private Booking booking;
//    private User user;
//    private Tour tour;
//
//    private String tourId;
//    private String userId;


    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
