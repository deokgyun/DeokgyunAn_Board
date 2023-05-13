package com.example.service;

import com.example.domain.BoardDto;
import com.example.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardMapper dao;

    @Autowired
    public BoardServiceImpl(BoardMapper dao) {
        this.dao = dao;
    }

    public String getTime() {
        return dao.getTime();
    }

    public int save(BoardDto boardDto) {
        int boardNum = dao.getMaxBoardNum();
        boardDto.setBoardNum(++boardNum);
        return dao.save(boardDto);
    }

    public int getMaxBoardNum() {
        return dao.getMaxBoardNum();
    }

    public List<BoardDto> getBoardList() {
        List<BoardDto> list = dao.getBoardList();

        for (BoardDto b : list) {
            b.getCreatedDate().substring(0, 16);
        }
        return list;
    }

    public BoardDto getBoardDetail(int boardNum) {
        return dao.getBoardDetail(boardNum);
    }

    public List<BoardDto> getRelationBoard(BoardDto boardDto) {
        List<BoardDto> list = dao.getBoardList();
        int boardCount = dao.getCountBoard();
        int boardNum = boardDto.getBoardNum();
        BoardDto dto = dao.getBoardDetail(boardNum);
        List<String> searchValue = new ArrayList<>();

        // 전체 게시글 내용 Map
        Map<String, Integer> allBoard = new HashMap<>();
        // 선택한 글 내용 Map
        Map<String, Integer> selBoard = new HashMap<>();

        // 선택한 게시글의 내용 배열 처리
        String selectStr = dto.getContent();
        String newSelectStr = selectStr.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", " ");
        String[] newSplitStr = newSelectStr.split(" ");

        for (int i = 0; i < newSplitStr.length; i++) {
            if (selBoard.containsKey(newSplitStr[i])) {
                selBoard.put(newSplitStr[i], selBoard.get(newSplitStr[i]) + 1);
            } else {
                selBoard.put(newSplitStr[i], 1);
            }
        }


        // 전체 게시글의 내용 배열 처리
        for (BoardDto b : list) {
            String str = b.getContent();
            String newStr = str.replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]", " ");
            String[] splitStr = newStr.split(" ");

            for (int i = 0; i < splitStr.length; i++) {

                if (allBoard.containsKey(splitStr[i])) {
                    allBoard.put(splitStr[i], allBoard.get(splitStr[i]) + 1);
                } else {
                    allBoard.put(splitStr[i], 1);
                }
            }

        }

        // 60%이상에서 발견되는 단어 삭제
        for (String k : allBoard.keySet()) {
            float duplicateValue = (float) allBoard.get(k) / boardCount;
            if(duplicateValue >= 0.6){
                selBoard.remove(k);
            }
        }

        // 선택한 게시글 내용의 배열과 전체 게시글의 배열을 비교하여 2개 이상일 시 검색값 배열에 추가
        for (String key : selBoard.keySet()) {
            int fre = Collections.frequency(allBoard.keySet(), key);
            if (fre == 1) {
                if (allBoard.get(key) > 2) {
                    searchValue.add(key);
                }
            }
        }

        // 글의 빈도수 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(allBoard.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 검색값 배열 DTO로 전달
        boardDto.setSearch(searchValue.stream().toArray(String[]::new));

        // 서치값이 1이상이면 검색값에 추가 아닐 시 null값 return
        if (searchValue.size() >= 1) {
            List<BoardDto> relationBoard = dao.getRelationBoard(boardDto);
            return relationBoard;
        } else {
            return null;
        }
    }

    public int getCountBoard() {
        return dao.getCountBoard();
    }

}
