package com.systechafrica.app.bean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;
import com.systechafrica.database.MysqlDatabase;

public class GenericBean<T> implements GenericBeanI<T> {

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
