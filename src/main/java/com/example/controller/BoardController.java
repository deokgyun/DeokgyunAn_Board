package com.example.controller;

import com.example.domain.Page.Criteria;
import com.example.domain.Page.PageDto;
import com.example.domain.board.FreeBoard;
import com.example.domain.board.Notice;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/notice")
    public ModelAndView notice(ModelAndView mv, Criteria criteria) {
        List<Notice> list = boardService.getNoticeList(criteria);
        String tableName = "TB_NOTICE";
        PageDto pageMaker = getPageDto(criteria, tableName);
        mv.addObject("pageMaker", pageMaker);
        mv.addObject("noticeList", list);
        mv.setViewName("board/noticeList");
        return mv;
    }

    @GetMapping("/board")
    public ModelAndView board(ModelAndView mv, Criteria criteria) {
        List<FreeBoard> list = boardService.getFreeList(criteria);
        String tableName = "TB_BOARD";
        PageDto pageMaker = getPageDto(criteria, tableName);
        System.out.println("tableName = " + tableName);
        mv.addObject("pageMaker", pageMaker);
        mv.addObject("freeList", list);
        mv.setViewName("/board/boardList");
        return mv;
    }

    private PageDto getPageDto(Criteria criteria, String tableName) {
        int totalRecord = boardService.totalRecord(tableName);
        PageDto pageMaker = new PageDto(criteria, totalRecord);
        return pageMaker;
    }

    @GetMapping("/board/write")
    public String boardwrite() {
        return "board/boardWrite";
    }

    @GetMapping("/notice/write")
    public String noticewrite() {
        return "board/noticeWrite";
    }

    @GetMapping("/board/{id}")
    public ModelAndView boardDetail(@PathVariable Long id, ModelAndView mv) {
        String tableName = "TB_BOARD";
        boardService.readCount(id, tableName);
        FreeBoard board = boardService.getBoardDetail(id);
        mv.addObject("board", board);
        mv.setViewName("board/boardDetail");
        return mv;
    }

    @GetMapping("/notice/{id}")
    public ModelAndView noticeDetail(@PathVariable Long id, ModelAndView mv) {
        String tableName = "TB_NOTICE";
        boardService.readCount(id, tableName);
        Notice notice = boardService.getNoticeDetail(id);
        mv.addObject("notice", notice);
        mv.setViewName("board/noticeDetail");
        return mv;
    }
}
