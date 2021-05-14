package com.souljit2.selleverything.service;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;

public interface MemberService {

    public void insertMember(MemberDTO newMemberInfo);
    public MemberDTO getMemberInfo(SignInRequestDTO signInInfo);
}
