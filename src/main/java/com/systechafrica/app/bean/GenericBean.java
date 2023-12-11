package com.systechafrica.app.bean;

import java.util.List;

import com.systechafrica.app.dao.GenericDao;
import com.systechafrica.app.dao.GenericDaoI;
import com.systechafrica.database.MysqlDatabaseTodelete;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class GenericBean<T> implements GenericBeanI<T> {
    @PersistenceContext
    private EntityManager em;

    @Inject
    private GenericDaoI<T> genericDao;

    @Override
    public List<T> list(T entity) {
        genericDao.setEm(em);
        return genericDao.list(entity);

    }

//@Override
//public List<T> list(Class<?> entity, String searchItem) {
//    genericDao.setDatabase(database);
//        return genericDao.list(entity, searchItem);
//}


    @Override
    public void addOrUpdateEntity(T entity) {
        genericDao.setEm(em);
        genericDao.addOrUpdateEntity(entity);

    }

    @Override
    public T findById(Class<T> entity, Long id) {
        return genericDao.findById(entity, id);
    }


    @Override
    public T findByUserName(Class<T> entity, String userName) {
        return genericDao.findByUserName(entity, userName);
    }


    @Override
    public void deleteEntity(Class<?> clazz, Long id) {
//        genericDao.setDatabase(database);
//        genericDao.deleteEntity(clazz, id);

    }

    public GenericDao<T> getDao() {
        genericDao.setEm(em);
        return (GenericDao<T>) genericDao;
    }
    
}
