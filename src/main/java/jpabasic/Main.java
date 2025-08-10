package jpabasic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.domain.Member;
import jpabasic.domain.Order;
import jpabasic.domain.OrderItem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction ts = entityManager.getTransaction();
        ts.begin();

        try {
            Order order = new Order();
            entityManager.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            entityManager.persist(orderItem);

            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            entityManager.close();
        }

    }
}