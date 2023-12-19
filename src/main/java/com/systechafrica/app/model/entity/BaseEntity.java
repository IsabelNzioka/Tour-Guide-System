package com.systechafrica.app.model.entity;

import com.systechafrica.app.view.helper.TableColHeader;
import com.systechafrica.database.helper.DbTableColumn;
import com.systechafrica.database.helper.DbTableId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity  implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
