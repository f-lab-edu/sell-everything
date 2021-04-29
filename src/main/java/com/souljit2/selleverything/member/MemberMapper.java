package com.souljit2.selleverything.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void signUp(MemberDTO memberDTO);
    public MemberDTO signIn(SignInRequestDTO signInRequestDTO);
}
