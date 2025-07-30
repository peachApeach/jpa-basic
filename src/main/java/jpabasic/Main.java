package jpabasic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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

        // 수정
        ts.begin();

        try {
//            Member findMember = entityManager.find(Member.class, 1L);
//            System.out.println("id = " + findMember.getId());
//            System.out.println("name = " + findMember.getName());
//
//            //삭제
//            //entityManager.remove(findMember);
//
//            // 저장하지 않아도 저장
//            findMember.setName("jpa");
//
//            // jpql
//            // DB가 아닌 객체에 대한 쿼리
//            List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)      // 범위 조정 가능
//                    .getResultList();

            //// 영속성 컨텍스트
            // 비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HELLOJPA");
            //영속 상태
            entityManager.persist(member);

            ts.commit();
        } catch (Exception e) {
            ts.rollback();
        } finally {
            entityManager.close();
        }

        System.out.println("Hello, World!");
    }

}