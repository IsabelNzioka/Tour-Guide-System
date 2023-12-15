package com.systechafrica.app.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.*;

import com.systechafrica.database.MysqlDatabaseTodelete;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

public class GenericDao<T> implements GenericDaoI<T> {
//    private MysqlDatabaseTodelete database;
      private EntityManager em;

//    @SuppressWarnings({"unchecked"})
//    @Override
//    public List<T> list(T entity) {
//        Class<?> clazz = entity.getClass();
//
//        String simpleName = entity.getClass().getSimpleName();
//
//        String tAlias = (simpleName.charAt(0) + "_").toLowerCase();
//        String jpql  = "FROM " + entity.getClass().getSimpleName() + " " + tAlias;
//
//        StringBuilder whereClause = new StringBuilder();
//        Map<String, Object> whereParams = new HashMap<>();
//
//        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
//        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
//
//        for (Field field : fields) {
//            if (!field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Formula.class)
//                    && !field.isAnnotationPresent(Id.class))
//                continue;
//
//            field.setAccessible(true);
//
//            try {
//                if (field.get(entity) != null) {
//                    String colName = field.getName();
//
//                    whereClause
//                            .append(whereParams.isEmpty() ? "" : " AND ")
//                            .append(tAlias).append(".").append(colName).append("=:").append(colName);
//
//                    whereParams.put(colName, field.get(entity));
//                }
//
//            } catch (IllegalAccessException iEx) {
//                iEx.printStackTrace();
//
//            }
//        }
//
//        jpql = jpql + (whereParams.isEmpty() && StringUtils.isBlank(whereClause) ? "" : " WHERE " + whereClause);
//
//        jpql = jpql.replace(", FROM", " FROM");
//        System.out.println("jpql: " + jpql);
//
//        TypedQuery<T> query = (TypedQuery<T>) em.createQuery(jpql, entity.getClass());
//
//        for (Map.Entry<String, Object> entry : whereParams.entrySet()) {
//            System.out.println("param Name: " + entry.getKey() + " = " + entry.getValue() );
//            query = query.setParameter(entry.getKey(), entry.getValue());
//        }
//
//        return query.getResultList();
//
//    }
//

    @SuppressWarnings({"unchecked"})
    @Override
    public List<T> list(T entity) {
        Class<?> clazz = entity.getClass();

        String simpleName = entity.getClass().getSimpleName();

        String tAlias = (simpleName.charAt(0) + "_").toLowerCase();
        String jpql  = "FROM " + entity.getClass().getSimpleName() + " " + tAlias;

        StringBuilder whereClause = new StringBuilder();
        Map<String, Object> whereParams = new HashMap<>();

        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        for (Field field : fields) {
            if (!field.isAnnotationPresent(Column.class))
                continue;

            Column column = field.getAnnotation(Column.class);
            field.setAccessible(true);

            try {
                if (field.get(entity) != null) {
                    String colName = StringUtils.isEmpty(column.name()) ? field.getName() : column.name();

                    whereClause
                            .append(whereParams.isEmpty() ? "" : " AND ")
                            .append(tAlias).append(".").append(colName).append("=:").append(colName);

                    whereParams.put(colName, field.get(entity));
                }

            } catch (IllegalAccessException iEx) {
                iEx.printStackTrace();

            }
        }

        jpql = jpql + (whereParams.isEmpty() && StringUtils.isBlank(whereClause) ? "" : " WHERE " + whereClause);
        jpql = jpql.replace(", FROM", " FROM");
        System.out.println("jpql: " + jpql);

        TypedQuery<T> query = (TypedQuery<T>) em.createQuery(jpql, entity.getClass());

        for (Map.Entry<String, Object> entry : whereParams.entrySet()) {
            System.out.println("param Name: " + entry.getKey() + " = " + entry.getValue() );
            query = query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();

    }


    @Override
    public void addOrUpdateEntity(T entity) {
        em.merge(entity);
    }

    @Override
    public T findById(Class<T> entity, Long id) {
     return  em.find(entity, id);
    }

    @Override
    public T findByUserName(Class<T> entity, String userName) {
        try {
            String jpql = "SELECT e FROM " + entity.getSimpleName() + " e WHERE e.userName = :userName";

            TypedQuery<T> query = em.createQuery(jpql, entity);
            query.setParameter("userName", userName);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public void deleteEntity(Class<?> entity, Long id) {
        Object o = em.find(entity, id);
        em.remove(o);
    }


    @Override
    public void delete(T entity) {

    }



    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


    
}