package jpabasic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.domain.Member;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction ts = entityManager.getTransaction();
        ts.begin();

        try {
            // 생성
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            entityManager.persist(member);

            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            entityManager.close();
        }

    }
}