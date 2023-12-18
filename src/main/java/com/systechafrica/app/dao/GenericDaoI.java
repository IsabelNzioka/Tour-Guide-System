package com.systechafrica.app.dao;

import com.systechafrica.database.MysqlDatabaseTodelete;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable{

//    List<T> list(Class<?> entity);
//   List<T> list(Class<?> entity, String searchItem);
//
//    void addOrUpdateEntity(T entity);
//
//    void deleteEntity(Class<?> clazz,Long id);
//
//    MysqlDatabaseTodelete getDatabase();
//    void setDatabase(MysqlDatabaseTodelete database) ;

    List<T> list(T entity);
    public void deleteEntity(Class<?> clazz, Long id);
    void delete(T entity);
    public long getEntityCount(Class<?> entityClass);
//    public List<T> select(Class<T> filter, String searchItem);
    void addOrUpdateEntity(T entity);
    T findById(Class<T> entity, Long id);
    T findByUserName(Class<T> entity, String userName);
    EntityManager getEm();
    void setEm(EntityManager em);
    
}
