package com.systechafrica.app.bean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.systechafrica.app.dao.GenericDao;
import com.systechafrica.app.dao.GenericDaoI;
import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;

import javax.ejb.EJB;

public abstract class GenericBean<T> implements GenericBeanI<T> {

    @EJB
    MysqlDatabase database;

    private final GenericDaoI<T> genericDao = new GenericDao<>();


    @Override
    public List<T> list(Class<?> entity) {
        genericDao.setDatabase(database);
        return genericDao.list(entity);

    }

    @Override
    public void addOrUpdateEntity(T entity) {
        genericDao.setDatabase(database);
        genericDao.addOrUpdateEntity(entity);

    }

    @Override
    public void deleteEntity(T entity) {

    }

    public GenericDao<T> getDao() {
        genericDao.setDatabase(database);
        return  (GenericDao<T>) genericDao;
    }
    
}
