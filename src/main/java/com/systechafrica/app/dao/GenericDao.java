package com.systechafrica.app.dao;

import java.util.List;

import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;

public class GenericDao<T> implements GenericDaoI<T> {
  

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {
        return (List<T>) Database.getDbInstance().getData(entity);

    }

    @Override
    public void addOrUpdateEntity(T entity) {
        MysqlDatabase.saveOrUpdate(entity);
//        Database database = Database.getDbInstance();
//        database.getData().add(entity);

    }

    @Override
    public void deleteEntity(T entity) {

    }
    
}