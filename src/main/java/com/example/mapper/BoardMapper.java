package com.example.mapper;

import com.example.domain.Page.Criteria;
import com.example.domain.board.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<Board> getNoticeList(Criteria criteria);
    int totalRecord(String boardType);
    List<Board> getBoardList(@Param("criteria") Criteria criteria, @Param("boardType") String boardType);
    void viewCount(Long id);
    Board getBoardDetail(Long id);
    void boardInsert(Board board);
    Long findByEmail(String userId);
    void boardDelete(Long id);




}
