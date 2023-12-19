package com.systechafrica.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

    List<T> list(T entity);

    void addOrUpdateEntity(T entity);
    T findById(Class<T> entity, Long id);
    T findByUserName(Class<T> entity, String userName);
    public long getEntityCount(Class<?> entityClass);


    void deleteEntity(Class<?> clazz, Long id);

    
}
