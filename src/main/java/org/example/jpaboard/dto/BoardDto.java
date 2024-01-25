package org.example.jpaboard.dto;

import lombok.*;
import org.example.jpaboard.Entity.Board;
import org.example.jpaboard.Entity.Member;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private long id;
    private String title;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime updtDate;
    private long viewCount;

    public BoardDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toEntity(Member member){
        return new Board(title,content,member);


    }



    }

