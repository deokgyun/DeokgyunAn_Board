package com.example.mapper;

import com.example.domain.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    public String getTime();

    public int save(BoardDto boardDto);

    public int getMaxBoardNum();

    public List<BoardDto> getBoardList();
    public BoardDto getBoardDetail(int boardNum);

    public List<BoardDto> getRelationBoard(BoardDto boardDto);

    public int getCountBoard();

}
