package com.example.service;

import com.example.domain.Page.Criteria;
import com.example.domain.board.Board;
import com.example.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Board> getNoticeList(Criteria criteria) {
        return dao.getNoticeList(criteria);
    }

    public int totalRecord(String boardType) {
        return dao.totalRecord(boardType);
    }

    public List<Board> getBoardList(Criteria criteria, String boardType) {
        List<Board> list = dao.getBoardList(criteria, boardType);
        return getFreeBoards(list);
    }

    public void viewCount(Long id) {
        dao.viewCount(id);
    }

    public Board getBoardDetail(Long id) {
        return dao.getBoardDetail(id);
    }

    public void boardInsert(Board board) {
        dao.boardInsert(board);
    }
    public     Long findByEmail(String userId){
        return dao.findByEmail(userId);
    }
    public     void boardDelete(Long id){
        dao.boardDelete(id);
    }


    private static List<Board> getFreeBoards(List<Board> list) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Board l : list) {
            LocalDateTime getTime = LocalDateTime.parse(l.getCreate_date(), formatter);
            boolean betweenDays = getTime.toLocalDate().isEqual(today.toLocalDate());
            if (betweenDays) {
                l.setCreate_date(l.getCreate_date().substring(11, 16));
            } else {
                l.setCreate_date(l.getCreate_date().substring(0, 10));
            }
        }
        return list;
    }

}
