package org.example.jpaboard;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.jpaboard.Entity.Member;

import org.example.jpaboard.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.example.jpaboard.Entity.Authority.ADMIN;


    @Component
    @RequiredArgsConstructor // final 붙은것 의존성 주입해줌
    public class InitDB {

        private final InitService initService;

        @PostConstruct // 빈이 초기화될때 메서드 실행
        public void init() {
            initService.userDBInit();
        }

        @Component
        @Transactional
        @RequiredArgsConstructor
        static class InitService {

            private final MemberRepository memberRepository;//의존성 주입


            public void userDBInit() {

                List<Member> memberList = memberRepository.findAll();
                if (memberList.isEmpty()) {
                    Member member = Member.builder()
                            .username("관리자")
                            .age(29)
                            .authority(ADMIN)
                            .build();// 멤버 객체 생성
                    //member 저장
                    memberRepository.save(member);
                }
            }
        }
    }

