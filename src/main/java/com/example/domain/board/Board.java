package com.example.domain.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Long b_no;
    private String b_type;
    private String b_title;
    private String b_content;
    private int b_views;
    private String create_date;
    private String update_date;
    private String m_name;
    private String dept_name;
    private String job_name;

    private Long m_no;


}
