package com.souljit2.selleverything.service;

import com.souljit2.selleverything.member.MemberDTO;
import com.souljit2.selleverything.member.SignInRequestDTO;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public void signUp(MemberDTO memberDTO);
    public MemberDTO signIn(SignInRequestDTO signInRequestDTO, HttpSession session);
}
