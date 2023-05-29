package com.example.controller;

import com.example.domain.board.Board;
import com.example.domain.member.Member;
import com.example.service.BoardService;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BoardApiController {

    private BoardService boardService;
    private MemberService memberService;

    @Autowired
    public BoardApiController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @PostMapping("/board/write")
    public void insert(@RequestBody Board board, Principal principal){
        String userId = principal.getName();
        Member member = memberService.getUserId(userId);
        board.setM_no(member.getM_no());
        boardService.boardInsert(board);
    }

    @PostMapping("/notice/write")
    public void noticeInsert(@RequestBody Board board, Principal principal){
        String userId = principal.getName();
        Member member = memberService.getUserId(userId);
        board.setM_no(member.getM_no());

        boardService.boardInsert(board);
    }

}
