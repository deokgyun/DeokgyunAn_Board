package com.example.controller;

import com.example.domain.BoardDto;
import com.example.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final BoardService boardService;

    @PostMapping("/api/v1/posts")
    public int save(@RequestBody BoardDto boardDto){
        return boardService.save(boardDto);
    }

}
