package com.example.service;

import com.example.domain.Page.Criteria;
import com.example.domain.board.FreeBoard;
import com.example.domain.board.Notice;
import com.example.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardMapper dao;


    @Autowired
    public BoardServiceImpl(BoardMapper dao) {
        this.dao = dao;
    }

    public Notice getNoticeDetail(Long id) {
        return dao.getNoticeDetail(id);
    }

    public List<Notice> getNoticeList(Criteria criteria) {
        List<Notice> list = dao.getNoticeList(criteria);
        return getNotice(list);
    }

    private static List<Notice> getNotice(List<Notice> list) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Notice l : list) {
            LocalDateTime noticeTime = LocalDateTime.parse(l.getCreatedDate(), formatter);
            boolean betweenDays = noticeTime.toLocalDate().isEqual(today.toLocalDate());
            if (betweenDays) {
                l.setCreatedDate(l.getCreatedDate().substring(11, 16));
            } else {
                l.setCreatedDate(l.getCreatedDate().substring(0, 10));
            }
        }
        return list;
    }

    public List<FreeBoard> getFreeList(Criteria criteria) {
        List<FreeBoard> list = dao.getFreeList(criteria);
        return getFreeBoards(list);
    }

    private static List<FreeBoard> getFreeBoards(List<FreeBoard> list) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (FreeBoard l : list) {
            LocalDateTime getTime = LocalDateTime.parse(l.getCreatedDate(), formatter);
            boolean betweenDays = getTime.toLocalDate().isEqual(today.toLocalDate());
            if (betweenDays) {
                l.setCreatedDate(l.getCreatedDate().substring(11, 16));
            } else {
                l.setCreatedDate(l.getCreatedDate().substring(0, 10));
            }
        }
        return list;
    }

    @Transactional
    public void boardInsert(FreeBoard freeBoard) {
        dao.boardInsert(freeBoard);
    }

    public FreeBoard getBoardDetail(Long id) {
        FreeBoard board = dao.getBoardDetail(id);
        System.out.println("board = " + board);
        return board;
    }

    public void readCount(Long id, String tableName) {
        dao.readCount(id, tableName);
    }

    public int totalRecord(String tableName) {
        return dao.totalRecord(tableName);
    }

    public void noticeInsert(Notice notice){
        dao.noticeInsert(notice);
    }

}
