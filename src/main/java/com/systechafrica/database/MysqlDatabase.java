package com.systechafrica.database;

import com.systechafrica.app.model.entity.Booking;
import com.systechafrica.app.model.entity.Tour;
import com.systechafrica.app.model.entity.User;
import com.systechafrica.database.helper.DbTable;
import com.systechafrica.database.helper.DbTableColumn;
import com.systechafrica.database.helper.DbTableId;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MysqlDatabase implements Serializable {
    private static MysqlDatabase database;

    private Connection connection;

    private MysqlDatabase() throws SQLException, NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/tours");
        connection = dataSource.getConnection();
    }

    public static MysqlDatabase getInstance(){
        if (database == null) {
            try {
                database = new MysqlDatabase();

            } catch (SQLException | NamingException e) {
                throw new RuntimeException(e);
            }
        }
        return database;
    }

    public static void updateSchema(){
        try {
            Connection connection = MysqlDatabase.getInstance().getConnection();

            List<Class<?>> entities = new ArrayList<>();
            entities.add(User.class);
            entities.add(Tour.class);
            entities.add(Booking.class);


            for (Class<?> clazz : entities) {
                if (!clazz.isAnnotationPresent(DbTable.class))
                    continue;

                DbTable dbTable = clazz.getAnnotation(DbTable.class);

                StringBuilder sqlBuilder = new StringBuilder();

                sqlBuilder.append("create table if not exists ").append(dbTable.name()).append("(");

                List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

                for (Field field : fields) {
                    if (!field.isAnnotationPresent(DbTableColumn.class))
                        continue;

                    DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                    sqlBuilder.append(dbTableColumn.name()).append(" ")
                            .append(dbTableColumn.definition())
                            .append(field.isAnnotationPresent(DbTableId.class)?" NOT NULL AUTO_INCREMENT PRIMARY KEY" : "")
                            .append(",");
                }

                sqlBuilder.append(")");

                String tableCreationSql = sqlBuilder.toString().replace(",)", ")");
                System.out.println("Creating table: " + tableCreationSql);
                connection.prepareStatement(tableCreationSql).executeUpdate();

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public static void saveOrUpdate(Object entity) {

        try {

            Class<?> clazz = entity.getClass();
            if (!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);

            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPlaceHolderBuilder = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(DbTableColumn.class) || field.isAnnotationPresent(DbTableId.class))
                    continue;

                field.setAccessible(true);
                if (field.get(entity) == null)
                    continue;

                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(dbTableColumn.name()).append(",");
                paramPlaceHolderBuilder.append("?").append(",");


//                if (field.getType().isEnum()) {
//                    parameters.add(((Enum<?>) field.get(entity)).name());
//                } else {
                    parameters.add(field.get(entity));
//                }

            }

            String queryBuilder = "insert into " +
                    dbTable.name() +
                    "(" +
                    columnBuilder +
                    ")" +
                    " values(" +
                    paramPlaceHolderBuilder +
                    ")";

            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query: " + query);

            PreparedStatement sqlStmt = MysqlDatabase.getInstance().getConnection()
                    .prepareStatement(query);

            System.out.println("----------------------------Parameters:-------------------------- " + parameters);

            System.out.println("________________________query___________________________" + query);

            int paramIdx = 1;
            for (Object param : parameters) {
                if (param.getClass().isAssignableFrom(BigDecimal.class))
                    sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
                else if (param.getClass().isAssignableFrom(Long.class))
                    sqlStmt.setLong(paramIdx++, (long) param);
                else if (param.getClass().isAssignableFrom(Date.class))
                    sqlStmt.setDate(paramIdx++, new java.sql.Date(((Date) param).getTime()));
                else if (param.getClass().isEnum())
                    sqlStmt.setString(paramIdx++, ((Enum<?>) param).name());
                else
                    sqlStmt.setString(paramIdx++, (String) param);
            }

            sqlStmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }
    }



//    public <T> List<T> fetch(T entity) {
//    }

//    public static  <T> List<T> select(Class<T> filter) {
//        try {
//            Class<?> clazz = filter;
//            System.out.println();
//            System.out.println("Clazz>>>>>>>>>>" + clazz.getName());
//
//            if (!clazz.isAnnotationPresent(DbTable.class))
//                return new ArrayList<>();
//
//            DbTable dbTable = clazz.getAnnotation(DbTable.class);
//            String stringBuilder = "SELECT * FROM " +
//                    dbTable.name() + ";";
//
//            Connection connection = MysqlDatabase.getInstance().getConnection();
//
//            PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            List<T> result = new ArrayList<>();
//
//            while (resultSet.next()) {
//                T object = (T) clazz.getDeclaredConstructor().newInstance();
//
//                List<Field> fields = new ArrayList<>(Arrays.asList(filter.getSuperclass().getDeclaredFields()));
//                fields.addAll(Arrays.asList(filter.getDeclaredFields()));
//
//                for (Field field : fields) {
//                    DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
//                    if (dbColumn != null) {
//                        String columnName = dbColumn.name();
//
//                        Object value = resultSet.getObject(columnName);
//                        /*Check dates and convert to Local date.
//                         * Specific date classes may need to be handled differently
//                         * */
//                        if (value instanceof java.sql.Date && field.getType() == LocalDate.class) {
//                            value = ((java.sql.Date) value).toLocalDate();
//                        }
//                        if (field.getType().isEnum() && value instanceof String) {
//                            value = Enum.valueOf((Class<Enum>) field.getType(), (String) value);
//                        }
//                        if (field.getType() == Long.class) {
//                            assert value instanceof Integer;
//                            value = Long.valueOf((Integer) value);
//                        }
//
//                        field.setAccessible(true);
//                        field.set(object, value);
//                    }
//                }
//
//                result.add(object);
//            }
//            return result;
//
//        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException |
//                 NoSuchMethodException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    
}
