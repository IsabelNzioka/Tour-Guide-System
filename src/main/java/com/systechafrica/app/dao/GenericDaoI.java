package com.systechafrica.app.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable{

    List<T> list(Class<?> entity);

    void addOrUpdateEntity(T entity);

    void deleteEntity(T entity);
    
}
