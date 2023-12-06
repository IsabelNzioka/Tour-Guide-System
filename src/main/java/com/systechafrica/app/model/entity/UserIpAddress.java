package com.systechafrica.app.model.entity;

import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user_ipAddress")
public class UserIpAddress  extends BaseEntity{

    @Column(name = "userIpAddress")
    private String userIpAddress;

    @Column(name = "timestamp")
    private Timestamp timestamp;



    public String getUserIpAddress() {
        return userIpAddress;
    }

    public void setUserIpAddress(String userIpAddress) {
        this.userIpAddress = userIpAddress;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
