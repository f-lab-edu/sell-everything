package com.souljit2.selleverything.service;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;

public interface AuthService {

    public void signUp(MemberDTO newMemberInfo);

    public void signIn(SignInRequestDTO signInInfo);

    public int getRequestMemberId();

}
