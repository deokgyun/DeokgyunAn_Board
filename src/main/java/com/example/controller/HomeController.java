package com.example.controller;

import com.example.domain.BoardDto;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private BoardService boardService;

    @Autowired
    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView mv) {
        List<BoardDto> list = boardService.getBoardList();
        mv.setViewName("home");
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "save";
    }

    @GetMapping("/posts/{boardNum}")
    public String postsDetail(@PathVariable int boardNum, BoardDto boardDto, Model model) {
        BoardDto dto = boardService.getBoardDetail(boardNum);
        List<BoardDto> list = boardService.getRelationBoard(boardDto);

        model.addAttribute("post", dto);
        model.addAttribute("list", list);
        return "detail";
    }
}
