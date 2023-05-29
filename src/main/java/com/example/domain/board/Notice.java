package com.example.domain.board;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Notice {

    private Long noticeNum;
    private String userId;
    private String noticeSubject;
    private String noticeContent;
    private String noticeFile;
    private String noticeOriginal;
    private String noticeReRef;
    private Long noticeReLev;
    private Long noticeReSeq;
    private Long noticeReadCount;
    private String createdDate;
    private String updatedDate;
    private String userName;


}
