package com.systechafrica.app.bean;

import com.systechafrica.app.model.entity.Tour;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateless
public class TourBean extends GenericBean<Tour> implements TourBeanI {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Tour> getToursWithHighestBookings() {
        String jpql = "SELECT t FROM Tour t ORDER BY SIZE(t.bookings) DESC";

        TypedQuery<Tour> query = em.createQuery(jpql, Tour.class);
        query.setMaxResults(6);
        return query.getResultList();
    }

    @Override
    public Map<String, Integer> tourBookingsCount() {
        String sql = "SELECT t.name, COUNT(b.id) " +
                "FROM tours t " +
                "LEFT JOIN bookings b ON t.id = b.tour_id " +
                "GROUP BY t.name " +
                "ORDER BY COUNT(b.id) DESC";

        Query query = em.createNativeQuery(sql);
        query.setMaxResults(6);

        List<Object[]> resultList = query.getResultList();

        Map<String, Integer> result = resultList.stream()
                .collect(Collectors.toMap(
                        row -> (String) row[0],
                        row -> ((Number) row[1]).intValue()
                ));

        return result;

    }

    @Override
    public List<Tour> getLatestTours() {
        String jpql = "FROM Tour t ORDER BY t.createdAt DESC";

        TypedQuery<Tour> query = em.createQuery(jpql, Tour.class);
        query.setMaxResults(10);
        return query.getResultList();
    }

    @Override
    public List<Tour> getToursWithinPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {

        String jpql = "FROM Tour t WHERE t.price BETWEEN :minPrice AND :maxPrice ORDER BY t.price ASC";

        TypedQuery<Tour> query = em.createQuery(jpql, Tour.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);

        return query.getResultList();
    }

    @Override
    public Long getToursWithBookingsCount() {
        Query query = em.createQuery("SELECT COUNT(DISTINCT t.id) FROM Tour t JOIN t.bookings b");
        return (Long) query.getSingleResult();
    }


}