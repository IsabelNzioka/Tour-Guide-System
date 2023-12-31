package com.systechafrica.app.model.entity;

import java.io.Serializable;

public class Email implements Serializable {

    private String recipient;
    private String subject;
    private String message;

    public Email() {
    }


    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}