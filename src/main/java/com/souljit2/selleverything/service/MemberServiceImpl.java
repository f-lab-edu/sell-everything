package com.souljit2.selleverything.service;

import com.souljit2.selleverything.mapper.MemberMapper;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
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
