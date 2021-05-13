package com.souljit2.selleverything.service;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.auth.AuthMapper;
import com.souljit2.selleverything.model.SignInRequestDTO;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthMapper authMapper;
    private SessionService sessionService;

    @Override
    public void signUp(MemberDTO memberDTO) {
        String encryptedPassword = BCrypt.hashpw(memberDTO.getMemberPassword(), BCrypt.gensalt());
        memberDTO.setMemberPassword(encryptedPassword);
        authMapper.signUp(memberDTO);
    }

    @Override
    public void signIn(SignInRequestDTO signInRequestDTO, HttpSession session) {
        MemberDTO memberInfoDTO = authMapper.signIn(signInRequestDTO);
        if(memberInfoDTO == null) throw new AuthenticationFailedException();
        boolean isPasswordMatches = BCrypt.checkpw(
                signInRequestDTO.getMemberPassword(),
                memberInfoDTO.getMemberPassword()
        );
        if(!isPasswordMatches)
            throw new AuthenticationFailedException();
        sessionService.setMemberSession(memberInfoDTO, session);
    }
}
