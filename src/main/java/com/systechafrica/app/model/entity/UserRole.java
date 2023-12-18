package com.systechafrica.app.model.entity;

public enum UserRole {
    ADMIN("Admin"),
    MANAGER("Manager"),
    GUIDES("Guides"),
    USER("User");

    private String value;
    UserRole( String value) {
        this.value = value;

    }
}
