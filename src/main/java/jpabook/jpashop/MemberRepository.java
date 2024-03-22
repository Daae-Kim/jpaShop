package jpabook.jpashop;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;
    //스프링 부트가 엔티티매니저를 주입해준다.

    public Long save(Member member){
        em.persist(member);
        return member.getId();
        // 왜 아이디만 반환 ? -> 저장하고 나면 id 정보만 있어도 조회가능 하기 때문에
        // 사이드 이펙트 방지
    }
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
