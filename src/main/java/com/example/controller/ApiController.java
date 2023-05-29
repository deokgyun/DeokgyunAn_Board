package com.example.controller;

import com.example.domain.board.Notice;
import com.example.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final BoardService boardService;

    @GetMapping("/api/v1/notice/{id}")
    public Notice noticeList(@PathVariable Long id){
        return boardService.getNoticeDetail(id);
    }




}
