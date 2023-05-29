package com.example.domain.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class FreeBoard {

    private Long freeNum;
    private String userId;
    private String freeSubject;
    private String freeContent;
    private String freeFile;
    private String freeOriginal;
    private int freeReRef;
    private int freeReLev;
    private int freeReSeq;
    private int freeReadCount;
    private String createdDate;
    private String updatedDate;
    private String userName;

}
