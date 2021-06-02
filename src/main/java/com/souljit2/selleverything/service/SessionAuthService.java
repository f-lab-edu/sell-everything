package com.souljit2.selleverything.service;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import javax.servlet.http.HttpSession;

public interface SessionAuthService {

    public void signUp(MemberDTO newMemberInfo);

    public void signIn(SignInRequestDTO signInInfo, HttpSession session);

}
