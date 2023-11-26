package com.systechafrica.app.dao;

import com.systechafrica.database.MysqlDatabase;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable{

    List<T> list(Class<?> entity);

    void addOrUpdateEntity(T entity);

    void deleteEntity(T entity);

    MysqlDatabase getDatabase();
    void setDatabase(MysqlDatabase database) ;
    
}
