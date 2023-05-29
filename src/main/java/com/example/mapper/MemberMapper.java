package com.example.mapper;

import com.example.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Member getUserId(String userid);

    void saveMember(Member member);
}
