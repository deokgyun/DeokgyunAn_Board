package com.example.config;

import com.example.domain.member.Member;
import com.example.mapper.MemberMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);


    @Autowired
    private MemberMapper dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("로그인 ID : " + username);
        Member users = dao.getUserId(username);

        if (users == null) {
            logger.info("계정이 없다");
            throw new UsernameNotFoundException("username " + username + " not found");
        }

        Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(users.getM_auth()));
        UserDetails user = new User(username, users.getM_pwd(), roles);

        return user;
    }
}
