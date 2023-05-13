package com.example.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    // 게시글 번호
    private int boardNum;
    // 글 제목
    private String title;
    // 글 내용
    private String content;
    // 작성자
    private String writer;
    // 작성일자
    private String createdDate;


    private String[] search;
}
