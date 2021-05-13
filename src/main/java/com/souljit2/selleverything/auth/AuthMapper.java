package com.souljit2.selleverything.auth;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    public void signUp(MemberDTO memberDTO);
    public MemberDTO signIn(SignInRequestDTO signInRequestDTO);

}
