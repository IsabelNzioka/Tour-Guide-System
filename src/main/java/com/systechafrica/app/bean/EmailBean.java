package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.AuditLog;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import java.io.Serializable;

@Singleton
public class EmailBean implements Serializable {

    public void email(@Observes AuditLog log) {
        System.out.println("Emailing");
    }
}
