package jpabook.jpashop.service;

import jakarta.transaction.Transactional;
import jpabook.jpashop.JpashopApplication;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        // when
        Long saveId = memberService.join(member);
        // then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given

        // when

        // then
    }
}