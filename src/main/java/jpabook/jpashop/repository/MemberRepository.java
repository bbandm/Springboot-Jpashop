package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
//데이터베이스와 상호작용하는 레포지토리임을 나타냄
//스프링이 이 클래스를 감지하고 bean으로 등록
public class MemberRepository {

    @Autowired
    //JPA의 EntityManager(JPA에서 데베와의 상호작용 담당하는 객체)를 주입받기 위한 애노테이션
    //이 객체를 통해 데이터베이스와의 상호작용 처리
    private EntityManager em;
    //이 객체 통해 SQL 쿼리와 JPA 메서드 호출함

    // 주어진 Member 객체를 데베에 저장하는 메서드
    public void save(Member member) {
        em.persist(member);
        // EntityManager의 persist 메서드 사용하여
        // method 객체를 데베에 추가
    }

    // 주어진 ID에 해당하는 Memeber 객체 찾아 반환하는 메서드
    public Member findOne(Long id) {
        return em.find(Member.class, id);
        // EntityManager의 find 메서드를 사용하여 ID로 Member 조회, 찾지 못하면 null 반환
    }

    // 데베에 저장된 모든 Member 객체를 조회하여 리스트로 반환하는 메서드
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
        // em.createQuery(...) : JPQL을 사용하여 Member 엔티티 조회하는 쿼리 작성
        // getResultList() : 쿼리의 결과를 리스트로 가져옴
    }

    // 이름으로 Member 객체 조회하여 리스트로 반환하는 메서드
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        // 이름을 기준으로 Member 조회하는 JPQL 쿼리 작성하여 쿼리의 결과를 리스트로 가져옴

    }
}

