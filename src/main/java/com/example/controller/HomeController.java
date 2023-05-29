package com.example.controller;

import com.example.domain.Page.Criteria;
import com.example.domain.board.FreeBoard;
import com.example.domain.board.Notice;
import com.example.service.BoardService;
import com.example.service.MemberService;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {


    private MemberService memberService;
    private BoardService boardService;

    @Autowired
    public HomeController(MemberService memberService, BoardService boardService) {
        this.memberService = memberService;
        this.boardService = boardService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView mv,
                             @CookieValue(value = "remember-me", required = false) Cookie readCookie) {
        if (readCookie != null) {
            mv.setViewName("redirect:/main");
        } else {
            mv.setViewName("member/login");
        }
        return mv;
    }

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mv, Criteria criteria) {
        criteria.setAmount(5);
        List<Notice> noticeList = boardService.getNoticeList(criteria);
        List<FreeBoard> boardList = boardService.getFreeList(criteria);
        mv.addObject("noticeList", noticeList);
        mv.addObject("boardList", boardList);
        mv.setViewName("index");
        return mv;
    }


}
