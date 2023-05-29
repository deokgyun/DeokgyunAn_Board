package com.example.domain.meeting;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeetingRoom {
    private Long meet_no;
    private String meet_name;
    private String meet_info;
    private String create_date;
    private String update_date;
    private int meet_status;
    private String img_origin;
    private String img_change;

}
