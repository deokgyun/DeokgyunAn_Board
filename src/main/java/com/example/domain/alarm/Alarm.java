package com.example.domain.alarm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alarm {
    private Long al_no;
    private String al_type;
    private String create_date;
    private String check_date;
    private String al_check;
    private Long trg_m_no;
    private Long act_m_no;
}
