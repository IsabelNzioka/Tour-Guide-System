package com.systechafrica.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

//    List<T> list(Class<?> entity);
    public List<T> list(Class<?> entity, String searchItem);

    void addOrUpdateEntity(T entity);

    void deleteEntity(Class<?> clazz, Long id);
    
}
