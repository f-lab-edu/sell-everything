package com.souljit2.selleverything.member;

import javax.servlet.http.HttpSession;

public interface MemberService {
    public void signUp(MemberDTO memberDTO);
    public void signIn(SignInRequestDTO signInRequestDTO, HttpSession session);
}
