package com.systechafrica.app.model.entity;

import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "UserIpAddressCount",
                query = "SELECT COUNT(u) FROM UserIpAddress u"
        )
})
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
