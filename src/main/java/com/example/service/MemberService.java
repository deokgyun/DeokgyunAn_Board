package com.example.service;

import com.example.domain.member.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {


    Member getUserId(String userid);

    void saveMember(Member member);


}
