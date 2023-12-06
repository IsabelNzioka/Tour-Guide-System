package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.AuditLog;
import com.systechafrica.database.MysqlDatabaseTodelete;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import java.io.Serializable;

@Singleton
public class AuditLogBean implements Serializable {

    @EJB
    MysqlDatabaseTodelete database;
    public void log(@Observes AuditLog auditLog){
        database.saveOrUpdate(auditLog);
    }

}
