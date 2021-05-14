package com.souljit2.selleverything.service;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.mapper.MemberMapper;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
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
        MemberDTO memberInfoDTO = memberMapper.getMemberInfo(signInInfo);
        if(memberInfoDTO == null) throw new AuthenticationFailedException();
        boolean isPasswordMatches = BCrypt.checkpw(
                signInInfo.getMemberPassword(),
                memberInfoDTO.getMemberPassword()
        );
        if(!isPasswordMatches)
            throw new AuthenticationFailedException();
        return memberInfoDTO;
    }
}
