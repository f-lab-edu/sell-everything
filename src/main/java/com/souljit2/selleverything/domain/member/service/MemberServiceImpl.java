package com.souljit2.selleverything.domain.member.service;

import com.souljit2.selleverything.domain.member.model.MemberDTO;
import com.souljit2.selleverything.domain.member.mapper.MemberMapper;
import com.souljit2.selleverything.domain.member.model.SignInRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;

    @Override
    public void insertMember(MemberDTO newMemberInfo) {
        memberMapper.insertMember(newMemberInfo);
    }

    @Override
    public MemberDTO getMemberInfo(SignInRequestDTO signInInfo) {
        return memberMapper.getMemberInfo(signInInfo);
    }
}
