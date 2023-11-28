package com.systechafrica.app.dao;

import com.systechafrica.database.MysqlDatabase;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable{

//    List<T> list(Class<?> entity);
   List<T> list(Class<?> entity, String searchItem);

    void addOrUpdateEntity(T entity);

    void deleteEntity(Class<?> clazz,Long id);

    MysqlDatabase getDatabase();
    void setDatabase(MysqlDatabase database) ;
    
}
