package com.likelion.PBL.config;

import com.likelion.PBL.repository.MemberRepository;
import com.likelion.PBL.repository.MemoryMemberRepository;
import com.likelion.PBL.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository(); // 개발자가 직접 new로 생성
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); // 수동 조립 화살표 연결!
    }
}