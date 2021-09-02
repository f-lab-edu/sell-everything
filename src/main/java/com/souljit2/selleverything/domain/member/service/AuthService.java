package com.souljit2.selleverything.domain.member.service;

import com.souljit2.selleverything.domain.member.model.MemberDTO;
import com.souljit2.selleverything.domain.member.model.SignInRequestDTO;

public interface AuthService {

    public void signUp(MemberDTO newMemberInfo);

    public void signIn(SignInRequestDTO signInInfo);

    public int getRequestMemberId();

}
