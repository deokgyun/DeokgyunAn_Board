package com.example.domain.chat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private Long msg_no;
    private String msg_content;
    private String create_date;
    private int msg_status;
    private Long m_no;
    private Long chat_no;
}
