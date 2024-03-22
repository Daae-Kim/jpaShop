package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//junit에게 나 스프링과 관련된걸로 테스트할거야 라고 알려줌.
@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional // test 에 transaction 이 있으면 test 이후 db 롤백해서 데이터가 남아있지 않도록한다.
    @Rollback(value = false)
    public void testMember() throws Exception{
        //given
        Member member = new Member();
        member.setUsername("memberA");
        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

    }
}