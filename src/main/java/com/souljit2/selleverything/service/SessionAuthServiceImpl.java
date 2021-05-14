package com.souljit2.selleverything.service;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.mapper.MemberMapper;
import com.souljit2.selleverything.model.SignInRequestDTO;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private MemberMapper memberMapper;
    private MemberService memberService;

    @Override
    public void signUp(MemberDTO memberDTO) {
        String encryptedPassword = BCrypt.hashpw(memberDTO.getMemberPassword(), BCrypt.gensalt());
        memberDTO.setMemberPassword(encryptedPassword);
        memberMapper.insertMember(memberDTO);
    }

    @Override
    public void signIn(SignInRequestDTO signInRequestDTO, HttpSession session) {
        MemberDTO memberInfoDTO = memberMapper.getMemberInfo(signInRequestDTO);
        if(memberInfoDTO == null) throw new AuthenticationFailedException();
        boolean isPasswordMatches = BCrypt.checkpw(
                signInRequestDTO.getMemberPassword(),
                memberInfoDTO.getMemberPassword()
        );
        if(!isPasswordMatches)
            throw new AuthenticationFailedException();
        memberService.setMemberSession(memberInfoDTO, session);
    }
}
