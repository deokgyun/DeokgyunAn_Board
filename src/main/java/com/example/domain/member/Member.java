package com.example.domain.member;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {

    private Long m_no;
    private String m_email;
    private String m_pwd;
    private String m_auth;
    private String m_status;
    private String m_phone;
    private String create_date;
    private String update_date;
    private String m_name;
    private int dept_id;
    private int job_id;
}
