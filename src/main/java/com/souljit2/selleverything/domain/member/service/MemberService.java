package com.souljit2.selleverything.domain.member.service;

import com.souljit2.selleverything.domain.member.model.MemberDTO;
import com.souljit2.selleverything.domain.member.model.SignInRequestDTO;

public interface MemberService {

    public void insertMember(MemberDTO newMemberInfo);

    public MemberDTO getMemberInfo(SignInRequestDTO signInInfo);
}
