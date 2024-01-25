package org.example.jpaboard.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

    @Id
    @Column(name = "member_id")
    private Long id;

    private String username;
    int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Authority authority;

    @OneToMany(mappedBy = "member")
    private List<Member> boards = new ArrayList<>();

    @Builder
    public Member(String username, int age, Authority authority) {
        this.username = username;
        this.age = age;
        this.authority = authority;
    }
}
