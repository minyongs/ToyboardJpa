package org.example.jpaboard.repository;

import org.assertj.core.api.Assertions;
import org.example.jpaboard.Entity.Board;
import org.example.jpaboard.Entity.Member;
import org.example.jpaboard.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class) // 스프링 통합 테스트
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BoardRepository boardRepository;

    @Test
    void 게시판_등록(){
        boardRepository.deleteAll(); // 일단 먼저 게시글 다 지우기


        //given
        String title = "제목";
        String content = "내용";

        List<Member> memberList = memberRepository.findAll();
        Member member = memberList.get(0);

        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("제목");
        boardDto.setContent("내용"); //제목과 내용을 정해서 글을 만듬
        Board board = boardDto.toEntity(member); // 맴버 객체랑 같이 보냄 ( 이미 JPA 에선 매핑되어있음)
        boardRepository.save(board);


        //when
        List<Board> boards = boardRepository.findAll();

        //then
        Board findBoard = boards.get(0);
        Assertions.assertThat(findBoard.getTitle()).isEqualTo(title);

    }

}