package com.example.service;

import com.example.domain.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public String getTime();

    public int save(BoardDto boardDto);

    public int getMaxBoardNum();

    public List<BoardDto> getBoardList();

    public BoardDto getBoardDetail(int boardNum);
    public List<BoardDto> getRelationBoard(BoardDto boardDto);
    public int getCountBoard();

}
