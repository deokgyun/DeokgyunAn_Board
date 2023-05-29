package com.example.controller;

import com.example.domain.board.FreeBoard;
import com.example.domain.board.Notice;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;



    @PostMapping("/board/write")
    public void insert(@RequestBody FreeBoard freeBoard, Principal principal){
        freeBoard.setUserId(principal.getName());
        boardService.boardInsert(freeBoard);
    }

    @PostMapping("/notice/write")
    public void noticeInsert(@RequestBody Notice notice, Principal principal){
        notice.setUserId(principal.getName());
        boardService.noticeInsert(notice);
    }
}
