package com.systechafrica.app.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable{

    List<T> list(T entity);
    public void deleteEntity(Class<?> clazz, Long id);
    void delete(T entity);
    public long getEntityCount(Class<?> entityClass);

    void addOrUpdateEntity(T entity);
    T findById(Class<T> entity, Long id);
    T findByUserName(Class<T> entity, String userName);
    EntityManager getEm();
    void setEm(EntityManager em);
    
}
