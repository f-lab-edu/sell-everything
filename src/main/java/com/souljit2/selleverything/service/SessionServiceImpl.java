package com.souljit2.selleverything.service;

import com.souljit2.selleverything.member.MemberDTO;
import com.souljit2.selleverything.utils.SessionUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class SessionServiceImpl implements SessionService {
    @Override
    public void setMemberSession(MemberDTO memberDTO, HttpSession session) {
        SessionUtils.setMemberSession(session, memberDTO.getId());
    }
}
