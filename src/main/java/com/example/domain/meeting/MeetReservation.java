package com.example.domain.meeting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetReservation {
    private Long rev_no;
    private String rev_date;
    private String rev_start;
    private String rev_end;
    private String rev_content;
    private int rev_status;
    private String create_date;
    private Long meet_no;
    private Long m_no;

}
