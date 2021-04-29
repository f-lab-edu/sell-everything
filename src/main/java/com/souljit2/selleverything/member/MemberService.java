package com.souljit2.selleverything.member;

public interface MemberService {
    public void signUp(MemberDTO memberDTO);
    public MemberDTO signIn(SignInRequestDTO signInRequestDTO);
}
