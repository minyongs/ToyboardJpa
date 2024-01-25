package org.example.jpaboard.repository;

import org.example.jpaboard.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
//엔티티 객체 member 와 그 키를 사용하는 리포지토리 생성
public interface MemberRepository extends JpaRepository<Member,Long> {
}
