package org.example.jpaboard.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 엔티티는 기본 생성자 필수
@EntityListeners(AuditingEntityListener.class)  // 생성 날짜 자동 생성 가능
public class Board {

    @Id
    @GeneratedValue
    @Column(name = " board_id")
    private long id;


    private String title;
    private String content;

    private LocalDateTime regDate;
    private LocalDateTime uptDate;

    private Long viewCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
