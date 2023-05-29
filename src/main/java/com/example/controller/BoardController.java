package com.example.controller;

import com.example.domain.Page.Criteria;
import com.example.domain.Page.PageDto;
import com.example.domain.board.Board;
import com.example.service.BoardService;
import com.example.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;
    private MemberService memberService;

    @Autowired
    public BoardController(BoardService boardService, MemberService memberService) {
        this.boardService = boardService;
        this.memberService = memberService;
    }

    @GetMapping("/notice")
    public ModelAndView notice(ModelAndView mv, Criteria criteria) {
        List<Board> list = boardService.getBoardList(criteria, BoardName.NOTICE.getValue());
        PageDto pageMaker = getPageDto(criteria, BoardName.NOTICE.getValue());
        mv.addObject("pageMaker", pageMaker);
        mv.addObject("freeList", list);
        mv.addObject("boardType", BoardName.NOTICE.getValue());
        mv.setViewName("board/boardList");
        return mv;
    }

    @GetMapping("/board")
    public ModelAndView board(ModelAndView mv, Criteria criteria) {
        List<Board> list = boardService.getBoardList(criteria, BoardName.FREE.getValue());
        PageDto pageMaker = getPageDto(criteria, BoardName.FREE.getValue());
        mv.addObject("pageMaker", pageMaker);
        mv.addObject("freeList", list);
        mv.addObject("boardType", BoardName.FREE.getValue());
        mv.setViewName("/board/boardList");
        return mv;
    }

    @GetMapping("/board/write")
    public String boardWrite() {
        return "board/boardWrite";
    }

    @GetMapping("/notice/write")
    public String noticeWrite() {
        return "board/noticeWrite";
    }

    @GetMapping("/board/{id}")
    public ModelAndView boardDetail(@PathVariable Long id, ModelAndView mv) {
        boardService.viewCount(id);
        Board board = boardService.getBoardDetail(id);
        mv.addObject("board", board);
        mv.setViewName("board/boardDetail");
        return mv;
    }

    @GetMapping("/notice/{id}")
    public ModelAndView noticeDetail(@PathVariable Long id, ModelAndView mv) {
        boardService.viewCount(id);
        Board board = boardService.getBoardDetail(id);
        mv.addObject("board", board);
        mv.setViewName("board/boardDetail");
        return mv;
    }

    @DeleteMapping("/board/{id}")
    public String boardDelete(@PathVariable Long id, HttpServletRequest request) {

        boardService.boardDelete(id);
        String address = request.getHeader("Referer");
        if(address.indexOf("notice") != -1){
            return "redirect:/notice";
        } else {
            return "redirect:/board";
        }
    }

    private PageDto getPageDto(Criteria criteria, String boardType) {
        int totalRecord = boardService.totalRecord(boardType);
        PageDto pageMaker = new PageDto(criteria, totalRecord);
        return pageMaker;
    }

    public enum BoardName {
        NOTICE("공지"), FREE("자유");
        private final String value;

        private BoardName(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

}
