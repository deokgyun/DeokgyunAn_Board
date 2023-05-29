package com.example.service;

import com.example.domain.member.Member;
import com.example.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberMapper dao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberServiceImpl(MemberMapper dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

    public Member getUserId(String userid) {
        return dao.getUserId(userid);
    }


    @Transactional
    public void saveMember(Member member) {
        member.setUserPassword(passwordEncoder.encode(member.getUserPassword()));
        dao.saveMember(member);

    }


}
