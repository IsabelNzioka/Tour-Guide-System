package com.systechafrica.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

    List<T> list();

    T addOrUpdateEntity(T entity);

    void deleteEntity(T entity);
    
}
