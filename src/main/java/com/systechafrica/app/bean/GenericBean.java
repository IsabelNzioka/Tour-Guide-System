package com.systechafrica.app.bean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.Database;

public class GenericBean<T> implements GenericBeanI<T> {

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list() {
         Class clazz = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);

        if (clazz.equals(Tour.class))
            return (List<T>) Database.getDbInstance().getTours();

        if (clazz.equals(User.class))
            return (List<T>) Database.getDbInstance().getUsers();

        if (clazz.equals(Booking.class))
            return (List<T>) Database.getDbInstance().getBookings();

        return  new ArrayList<>();
    }

    @Override
    public T addOrUpdateEntity(T entity) {
        Database database = Database.getDbInstance();

        if (entity instanceof Tour)
            database.getTours().add((Tour) entity);

        else if (entity instanceof User)
            database.getUsers().add((User) entity);

        else if (entity instanceof Booking)
            database.getBookings().add((Booking) entity);
     
        return entity;
    }

    @Override
    public void deleteEntity(T entity) {
     
    }
    
}
