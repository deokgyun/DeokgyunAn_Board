package com.example.service;

import com.example.domain.Page.Criteria;
import com.example.domain.board.FreeBoard;
import com.example.domain.board.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    Notice getNoticeDetail(Long id);

    List<Notice> getNoticeList(Criteria criteria);

    List<FreeBoard> getFreeList(Criteria criteria);

    void boardInsert(FreeBoard freeBoard);

    FreeBoard getBoardDetail(Long id);

    void readCount(Long id, String tableName);

    int totalRecord(String tableName);

    void noticeInsert(Notice notice);
}
