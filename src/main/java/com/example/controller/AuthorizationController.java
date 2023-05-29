package com.example.controller;


import com.example.domain.member.Member;
import com.example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {
    private MemberService memberService;

    @Autowired
    public AuthorizationController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("join")
    public String join(Member member){
        memberService.saveMember(member);
        return "redirect:/login";
    }

}
