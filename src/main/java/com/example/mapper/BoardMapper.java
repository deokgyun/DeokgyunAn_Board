package com.example.mapper;

import com.example.domain.Page.Criteria;
import com.example.domain.board.FreeBoard;
import com.example.domain.board.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    Notice getNoticeDetail(Long id);

    List<Notice> getNoticeList(Criteria criteria);

    List<FreeBoard> getFreeList(Criteria criteria);

    FreeBoard getBoardDetail(Long id);

    void boardInsert(FreeBoard freeBoard);

    void readCount(@Param("id")Long id, @Param("tableName") String tableName);

    int totalRecord(String tableName);

    void noticeInsert(Notice notice);

}
