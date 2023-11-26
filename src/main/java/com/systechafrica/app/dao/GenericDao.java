package com.systechafrica.app.dao;

import java.util.List;

import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;

public class GenericDao<T> implements GenericDaoI<T> {
    private MysqlDatabase database;
  

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list(Class<?> entity) {
        return (List<T>) database.select(entity);
    }

    @Override
    public void addOrUpdateEntity(T entity) {
        database.saveOrUpdate(entity);
//        Database database = Database.getDbInstance();
//        database.getData().add(entity);

    }

    @Override
    public void deleteEntity(T entity) {

    }
    public MysqlDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MysqlDatabase database) {
        this.database = database;
    }
    
}