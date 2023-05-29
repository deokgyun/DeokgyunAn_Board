package com.example.service;

import com.example.domain.Page.Criteria;
import com.example.domain.board.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {


    List<Board> getNoticeList(Criteria criteria);

    int totalRecord(String boardType);

    List<Board> getBoardList(Criteria criteria, String boardType);

    void viewCount(Long id);

    Board getBoardDetail(Long id);

    void boardInsert(Board board);

    Long findByEmail(String userId);

    void boardDelete(Long id);
}
