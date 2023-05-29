package com.example.domain.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {

    private Long userNo;
    private String userId;
    private String userPassword;
    private String userImg;
    private String userName;
    private int userDept;
    private int userJob;
    private String userState;
    private String userAuth;
    private String userLasttime;
    private String createdDate;
    private String updatedDate;
}
