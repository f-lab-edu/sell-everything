package com.souljit2.selleverything.service;

import com.souljit2.selleverything.member.MemberDTO;

import javax.servlet.http.HttpSession;

public interface SessionService {

    public void setMemberSession(MemberDTO memberDTO, HttpSession session);

}
